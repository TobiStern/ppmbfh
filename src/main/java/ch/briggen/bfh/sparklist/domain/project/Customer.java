package ch.briggen.bfh.sparklist.domain.project;
/**
 * Single customer element 
 * @author Tobias Luethi
 *
 */
public class Customer {
	
	private long id;
	private String name;
	private String firstname;
	private String adress;
	private String phone;
	private String email;
	private String company;
	private String state;
	private String zipCode;
	
	/**
	 * Constructor
	 */
	public Customer() 
	{
		
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param firstname
	 * @param adress
	 * @param phone
	 * @param email
	 * @param company
	 * @param state
	 * @param zipCode
	 */
	public Customer(long id, String name, String firstname, String adress, String phone, String email, String company,
			String state, String zipCode) {
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.company = company;
		this.state = state;
		this.zipCode = zipCode;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * override toString() method
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", firstname=" + firstname + ", adress=" + adress + ", phone="
				+ phone + ", email=" + email + ", company=" + company + ", state=" + state + ", zipCode=" + zipCode
				+ "]";
	}
	
	
}