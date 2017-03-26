package ch.briggen.bfh.sparklist.domain.portfolio;


public class Portfolio {
	
	private long id;
	private String name;
	private String description;
	private String status;
	private int fk_config;
	
	
	/**
	 * Defaultkonstruktor für die Verwendung in einem Controller
	 */
	public Portfolio()
	{
	}

	/**
	 * @param id 
	 * @param name
	 * @param description
	 * @param status
	 * @param fk_config
	 */
	public Portfolio(long id, String name, String description, String status, int fk_config) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.fk_config = fk_config;
	}


	/**
	 * @return the fk_config
	 */
	public int getFk_config() {
		return fk_config;
	}

	/**
	 * @param fk_config the fk_config to set
	 */
	public void setFk_config(int fk_config) {
		this.fk_config = fk_config;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @Override
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "portfolio [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", fk_config=" + fk_config + "]";
	}

};

	
	