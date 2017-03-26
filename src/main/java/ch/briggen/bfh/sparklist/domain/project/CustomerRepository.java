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
/**
 * Repository for customers. 
 * DB operations for the customer class
 * @author Tobias Luethi
 *
 */
public class CustomerRepository {
	
	private final Logger log = LoggerFactory.getLogger(CustomerRepository.class);
	/**
	 * get all customer elements
	 * @return Collection of customers
	 */
	public Collection<Customer> getAll()  {
		log.trace("getAll");
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select * from customer");
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
	 * return collection of customers with the same name
	 * @param name
	 * @return Collection of customer with the name "name"
	 */
	public Collection<Customer> getByName(String name) {
		log.trace("getByName " + name);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select * from customer where name=?");
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			return mapItems(rs);		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving customer by name " + name;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
			
	}
	/**
	 * return customer by id
	 * @param id id of the customer
	 * @return customer or null
	 */
	public Customer getById(long id) {
		log.trace("getById " + id);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("select * from customer where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			return mapItems(rs).iterator().next();		
		}
		catch(SQLException e)
		{
			String msg = "SQL error while retreiving customer by id " + id;
			log.error(msg, e);
			throw new RepositoryException(msg);
		}
					
	}
	/**
	 * update customer element
	 * @param customer
	 */
	public void update(Customer customer) {
		log.trace("save " + customer);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("update customer set "
																	+ "name=?, "
																	+ "firstname=?, "
																	+ "adress=?, "
																	+ "phone=?, "
																	+ "email=?, "
																	+ "company=?, "
																	+ "state=?, "
																	+ "zip code=?");			
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getFirstname());
			stmt.setString(3, customer.getAdress());
			stmt.setString(4, customer.getPhone());
			stmt.setString(5, customer.getEmail());
			stmt.setString(6, customer.getCompany());
			stmt.setString(7, customer.getState());
			stmt.setString(8, customer.getZipCode());	
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			String msg = "SQL error while updating item " + customer;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}
		
	}
	/**
	 * delete customer elements
	 * @param id customer id
	 */
	public void delete(long id) {
		log.trace("delete " + id);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("delete from customer where id=?");
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
	 * save customer into the database
	 * @param customer customer class
	 * @return id id of the customer db entry
	 */
	public long insert(Customer customer) {
		
		log.trace("insert " + customer);
		//Integer id = jdbc.queryForObject("select IDENTITY();", Integer.class);
		
		try(Connection conn = getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("insert into customer ("
															+ "name, "
															+ "firstname, "
															+ "adress, "
															+ "phone, "
															+ "email, "
															+ "company, "
															+ "state, "
															+ "zip code) values (?,?,?,?,?,?,?,?)"
														);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getFirstname());
			stmt.setString(3, customer.getAdress());
			stmt.setString(4, customer.getPhone());
			stmt.setString(5, customer.getEmail());
			stmt.setString(6, customer.getCompany());
			stmt.setString(7, customer.getState());
			stmt.setString(8, customer.getZipCode());			
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			Long id = key.getLong(1);
			
			return id;
		}
		catch(SQLException e)
		{
			String msg = "SQL error while updating item " + customer;
			log.error(msg , e);
			throw new RepositoryException(msg);
		}
	}
	
	/**
	 * Helper to convert sql return in customer class
	 * @author Tobias Luethi
	 * @throws SQLException 
	 *
	 */
	private static Collection<Customer> mapItems(ResultSet rs) throws SQLException 
	{
		LinkedList<Customer> list = new LinkedList<Customer>();
		
		while(rs.next())
		{
			Customer customer = new Customer(rs.getLong("id"),
									rs.getString("name"),
									rs.getString("firstname"),
									rs.getString("adress"),
									rs.getString("phone"),
									rs.getString("email"),
									rs.getString("company"),
									rs.getString("state"),
									rs.getString("zipcode")
								);
			list.add(customer);
		}
		return list;
	}
}