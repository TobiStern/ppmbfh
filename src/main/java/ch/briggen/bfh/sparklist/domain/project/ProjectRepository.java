package ch.briggen.bfh.sparklist.domain.project;
import static ch.briggen.bfh.sparklist.domain.JdbcRepositoryHelper.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.briggen.bfh.sparklist.domain.RepositoryException;
import ch.briggen.bfh.sparklist.domain.portfolio.PortfolioRepository;
/**
 * Repository for projects. 
 * DB operations for the project class
 * @author Tobias Luethi
 *
 */
public class ProjectRepository {
	
	private final Logger log = LoggerFactory.getLogger(ProjectRepository.class);
	private PortfolioRepository ppRepository = new PortfolioRepository();
	private CustomerRepository customerRepository = new CustomerRepository();
	/**
	 * get all project elements
	 * @return Collection of projects
	 */
	public Collection<Project> getAll()  {
		log.trace("getAll");
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select * from Project");
			ResultSet rs = stmt.executeQuery();
			return mapItems(rs);		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving all items. ";
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
	}
	/**
	 * return collection of projects with the same name
	 * @param name
	 * @return Collection of project with the name "name"
	 */
	public Collection<Project> getByName(String name) {
		log.trace("getByName " + name);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select * from Project where name=?");
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			return mapItems(rs);		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving project by name " + name;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
			
	}
	/**
	 * return project by id
	 * @param id id of the project
	 * @return project or null
	 */
	public Project getById(long id) {
		log.trace("getById " + id);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select * from Project where pk_idProjekt=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			return mapItems(rs).iterator().next();		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving project by id " + id;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
					
	}
	/**
	 * update project element
	 * @param project
	 */
	public void update(Project project) {
		log.trace("save " + project);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("update Project set "
																	+ "name=?, "
																	+ "owner=?, "
																	+ "status=?, "
																	+ "projectphasae=?, "
																	+ "budget=?, "
																	+ "planned value=?, "
																	+ "earned value=?, "
																	+ "actual cost=?, "
																	+ "milestone=?,"
																	+ "startdate=?,"
																	+ "enddate=?,"
																	+ "stakeholder=?,"
																	+ "description=?,"
																	+ "milestone=?,"
																	+ "fk_customer=?,"
																	+ "fk_portfolio=?,"
																	+ "where id=?");			
			stmt.setString(1, project.getName());
			stmt.setString(2, project.getOwner());
			stmt.setString(3, project.getStatus());
			stmt.setString(4, project.getProjectPhase());
			stmt.setInt(5, project.getBudget());
			stmt.setInt(6, project.getPlannedValue());
			stmt.setInt(7, project.getActualCost());
			stmt.setInt(8, project.getEarnedValue());
			stmt.setString(9, project.getMilestone());
			stmt.setDate(10, (java.sql.Date) project.getStartDate());
			stmt.setDate(11, (java.sql.Date) project.getEndDate());
			stmt.setString(12, project.getStakeholder());
			stmt.setString(13, project.getDescription());
			stmt.setInt(14, (int) customerRepository.getByName(project.getCustomer()).iterator().next().getId());
			stmt.setInt(15, (int) ppRepository.getByName(project.getPortfolio()).iterator().next().getId());
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			String msg = "SQL error while updating item " + project;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}
		
	}
	/**
	 * delete project elements
	 * @param id project id
	 */
	public void delete(long id) {
		log.trace("delete " + id);
		
		try(Connection conn = getConnection())
		{
			//todo: delete relations/relating object that are now longer needed
			PreparedStatement stmt = conn.prepareStatement("delete from Project where pk_idProjekt=?");
			stmt.setLong(1, id);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			String msg = "SQL error while deleteing items by id " + id;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
					
	}
	/**
	 * save project into the database
	 * @param project project class
	 * @return id id of the project db entry
	 */
	public long insert(Project project) {
		
		log.trace("insert " + project);
		//Integer id = jdbc.queryForObject("select IDENTITY();", Integer.class);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("insert into Project ("
															+ "name, "
															+ "owner, "
															+ "status, "
															+ "projectphase, "
															+ "budget, "
															+ "planned value, "
															+ "actual cost, "
															+ "earned value, "
															+ "milestones, "
															+ "startdate, "
															+ "enddate, "
															+ "stakeholder, "
															+ "description, "
															+ "fk_customer, "
															+ "fk_portfolio) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
														);
			stmt.setString(1, project.getName());
			stmt.setString(2, project.getOwner());
			stmt.setString(3, project.getStatus());
			stmt.setString(4, project.getProjectPhase());
			stmt.setInt(5, project.getBudget());
			stmt.setInt(6, project.getPlannedValue());
			stmt.setInt(7, project.getActualCost());
			stmt.setInt(8, project.getEarnedValue());
			stmt.setString(9, project.getMilestone());
			stmt.setDate(10, (java.sql.Date) project.getStartDate());
			stmt.setDate(11, (java.sql.Date) project.getEndDate());
			stmt.setString(12, project.getStakeholder());
			stmt.setString(13, project.getDescription());
			stmt.setInt(14, (int) customerRepository.getByName(project.getCustomer()).iterator().next().getId());
			stmt.setInt(15, (int) ppRepository.getByName(project.getPortfolio()).iterator().next().getId());
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			Long id = key.getLong(1);
			
			return id;
		}
		catch(SQLException e)
		{
			String msg = "SQL error while updating item " + project;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}
	}
	
	/**
	 * Helper to convert sql return in project class
	 * @author Tobias Luethi
	 * @throws SQLException 
	 *
	 */
	private static Collection<Project> mapItems(ResultSet rs) throws SQLException 
	{
		LinkedList<Project> list = new LinkedList<Project>();
		
		while(rs.next())
		{
			Project project = new Project(rs.getLong("pk_idProjekt"),
									rs.getString("name"),
									rs.getString("owner"),
									rs.getString("status"),
									rs.getString("projectphase"),
									rs.getInt("budget"),
									rs.getInt("plannedvalue"),
									rs.getInt("actualcost"),
									rs.getInt("earnedvalue"),
									rs.getString("milestones"),
									rs.getDate("startdate"),
									rs.getDate("enddate"),
									rs.getString("stakeholder"),
									rs.getString("description"),
									rs.getString("fk_portfolio"),
									rs.getString("fk_customer")
								);
			list.add(project);
		}
		return list;
	}
}