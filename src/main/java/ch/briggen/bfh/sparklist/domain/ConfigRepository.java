/**
 * 
 */
package ch.briggen.bfh.sparklist.domain;

import static ch.briggen.bfh.sparklist.domain.JdbcRepositoryHelper.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.portfolio.PortfolioRepository;

/**
 * @author Tenud 
 *
 */
public class ConfigRepository {
	
private final Logger log = LoggerFactory.getLogger(PortfolioRepository.class);

	/**
	 * Gets the config with the given ID
	 * @param id id of the config
	 * @return config or NULL
	 */
	public Config getById(int id) {
		log.trace("getById " + id);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PPM.Configuration WHERE pk_idConfiguration=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			return mapConfig(rs).iterator().next();		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving config by id " + id;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
					
	}

	/**
	 * Updates the given config in DB
	 * @param p
	 */
	public void update(Config c) {
		log.trace("update " + c);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("UPDATE PPM.Config SET Companyname=?, Adress=?, ZIP-Code=?, State=?, Licencekey=?, ExpiryDate=? WHERE pk_idConfiguration=?");
			stmt.setString(1, c.getCompanyName());
			stmt.setString(2, c.getAdress());
			stmt.setString(3, c.getZipCode());
			stmt.setString(4, c.getState());
			stmt.setString(5, c.getLicenceKey());
			stmt.setDate(6, c.getExpiryDate());
			stmt.setInt(7, c.getId());
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			String msg = "SQL error while updating configuration " + c;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}
		
	}

	/**
	 * Delete config with the given ID
	 * @param id Config ID
	 */
	public void delete(int id) {
		log.trace("delete " + id);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM PPM.Configuration WHERE pk_idConfiguration=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			String msg = "SQL error while deleteing configuration by id " + id;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
					

	}

	/**
	 * Saves the given Configuration in DB
	 * @param c new Configuration
	 * @return Returns the new ID of the created configuration
	 */
	public long insert(Config c) {
		
		log.trace("insert " + c);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO PPM.Configuration (Companyname, Adress, ZIP-Code, State, Licencekey, ExpiryDate) values (?,?,?,?,?,?)");
			stmt.setString(1, c.getCompanyName());
			stmt.setString(2, c.getAdress());
			stmt.setString(3, c.getZipCode());
			stmt.setString(4, c.getState());
			stmt.setString(5, c.getLicenceKey());
			stmt.setDate(6, c.getExpiryDate());
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			Integer id = key.getInt(1);
			return id;
		}
		catch(SQLException e)
		{
			String msg = "SQL error while adding configuration " + c;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}

	}
	
	/**
	 * Helper to convert the results to config-objects. 
	 * @author Tenud Chris
	 * @throws SQLException 
	 *
	 */
	private static Collection<Config> mapConfig(ResultSet rs) throws SQLException 
	{
		LinkedList<Config> list = new LinkedList<Config>();
		while(rs.next())
		{
			Config c = new Config(rs.getInt("pk_idConfiguration"),rs.getString("Companyname"),rs.getString("Adress"),rs.getString("ZIP-Code"),rs.getString("State"),rs.getString("Licencekey"),rs.getDate("ExpiryDate"));
			list.add(c);
		}
		return list;
	}

}
