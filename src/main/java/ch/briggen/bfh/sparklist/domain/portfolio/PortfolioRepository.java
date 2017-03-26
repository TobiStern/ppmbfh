/**
 * 
 */
package ch.briggen.bfh.sparklist.domain.portfolio;

import static ch.briggen.bfh.sparklist.domain.JdbcRepositoryHelper.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.Config;
import ch.briggen.bfh.sparklist.domain.RepositoryException;

/**
 * @author Tenud 
 *
 */
public class PortfolioRepository {
	
private final Logger log = LoggerFactory.getLogger(PortfolioRepository.class);
	
	Config c = new Config();

	/**
	 * Get all portfolios in DB
	 * @return Collection of all portfolios
	 */
	public Collection<Portfolio> getAll()  {
		log.trace("getAll");
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Portfolio");
			ResultSet rs = stmt.executeQuery();
			return mapPortfolio(rs);		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving all portfolios. ";
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
	}

	/**
	 * Gets all portfolios with given name
	 * @param name
	 * @return Collection with name "name"
	 */
	public Collection<Portfolio> getByName(String name) {
		log.trace("getByName " + name);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Portfolio WHERE NAME=?");
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			return mapPortfolio(rs);		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving portfolio by name " + name;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
			
	}

	/**
	 * Gets the portfolio with the given ID
	 * @param id id of the portfolio
	 * @return Portfolio or NULL
	 */
	public Portfolio getById(long id) {
		log.trace("getById " + id);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Portfolio WHERE pk_idPortfolio=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			return mapPortfolio(rs).iterator().next();		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving portfolio by id " + id;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
					
	}

	/**
	 * Updates the given portfolio in DB
	 * @param p
	 */
	public void update(Portfolio p) {
		log.trace("update " + p);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("UPDATE Portfolio SET NAME=?, DESCRIPTION=?, STATUS=?, fk_idConfig=? WHERE pk_idPortfolio=?");
			stmt.setString(1, p.getName());
			stmt.setString(2, p.getDescription());
			stmt.setString(3, p.getStatus());
			stmt.setInt(4, c.getId());
			stmt.setLong(5, p.getId());
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			String msg = "SQL error while updating portfolio " + p;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}
		
	}

	/**
	 * Delete portfolio with the given ID
	 * @param id Portfolio ID
	 */
	public void delete(long id) {
		log.trace("delete " + id);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Portfolio WHERE pk_idPortfolio=?");
			stmt.setLong(1, id);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			String msg = "SQL error while deleteing portfolio by id " + id;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
					

	}

	/**
	 * Saves the given Portfolio in DB
	 * @param p new Portfolio
	 * @return Returns the new ID of the created portfolio
	 */
	public long insert(Portfolio p) {
		
		log.trace("insert " + p);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Portfolio (Name, Description, Status, fk_idConfig) values (?,?,?,?)");
			stmt.setString(1, p.getName());
			stmt.setString(2, p.getDescription());
			stmt.setString(3, p.getStatus());
			stmt.setInt(4, c.getId());
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			Long id = key.getLong(1);
			return id;
		}
		catch(SQLException e)
		{
			String msg = "SQL error while adding portfolio " + p;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}

	}
	
	/**
	 * Helper to convert the results to portfolio-objects. 
	 * @author Tenud Chris
	 * @throws SQLException 
	 *
	 */
	private static Collection<Portfolio> mapPortfolio(ResultSet rs) throws SQLException 
	{
		LinkedList<Portfolio> list = new LinkedList<Portfolio>();
		while(rs.next())
		{
			Portfolio p = new Portfolio(rs.getLong("pk_idPortfolio"),rs.getString("Name"),rs.getString("Description"),rs.getString("Status"),rs.getInt("fk_idconfig"));
			list.add(p);
		}
		return list;
	}

}
