/**
 * 
 */
package ch.briggen.bfh.sparklist.domain;

import java.sql.Date;

/**
 * @author Tenud
 *
 */
public class Config {
	
	private int id;
	private String companyName;
	private String adress;
	private String zipCode;
	private String state;
	private String licenceKey;
	private Date expiryDate;
	
	public Config() {
		
	}
	
	
	/**
	 * @param id
	 * @param companyName
	 * @param adress
	 * @param zipCode
	 * @param state
	 * @param licenceKey
	 * @param ExpiryDate
	 */
	public Config(int id, String companyName, String adress, String zipCode, String state, String licenceKey,
			Date ExpiryDate) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.adress = adress;
		this.zipCode = zipCode;
		this.state = state;
		this.licenceKey = licenceKey;
		this.expiryDate = ExpiryDate;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	 * @return the licenceKey
	 */
	public String getLicenceKey() {
		return licenceKey;
	}
	/**
	 * @param licenceKey the licenceKey to set
	 */
	public void setLicenceKey(String licenceKey) {
		this.licenceKey = licenceKey;
	}
	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	/** 
	 * @Override
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Config [id=" + id + ", companyName=" + companyName + ", adress=" + adress + ", zipCode=" + zipCode
				+ ", state=" + state + ", licenceKey=" + licenceKey + ", expiryDate=" + expiryDate + "]";
	}
	
	
	
	
}
