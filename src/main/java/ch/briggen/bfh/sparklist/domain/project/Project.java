package ch.briggen.bfh.sparklist.domain.project;
import java.util.Date;
/**
 * Single project element
 * @author Tobias Luethi
 *
 */
public class Project {
	
	private long id;
	private String name;
	private String owner;
	private String status;
	private String projectPhase;
	private int budget;
	private int plannedValue;
	private int actualCost;
	private int earnedValue;
	private String milestone;
	private Date startDate;
	private Date endDate;
	private String teamMember;
	private String stakeholder;
	private String risks;
	private String description;
	private String portfolio;
	private String customer;
	
	/**
	 * Constructor
	 */
	public Project()
	{		
	}
	
	/**
	 *  Constructor
	 * @param id
	 * @param name
	 * @param owner
	 * @param status
	 * @param projectPhase
	 * @param budget
	 * @param plannedValue
	 * @param actualCost
	 * @param earnedValue
	 * @param milestone
	 * @param startDate
	 * @param endDate
	 * @param teamMember
	 * @param stakeholder
	 * @param risks
	 * @param description
	 * @param portfolio
	 * @param customer
	 */
	public Project(long id, String name, String owner, String status, String projectPhase, int budget, int plannedValue,
			int actualCost, int earnedValue, String milestone, Date startDate, Date endDate, String stakeholder, String description, String portfolio, String customer) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.status = status;
		this.projectPhase = projectPhase;
		this.budget = budget;
		this.plannedValue = plannedValue;
		this.actualCost = actualCost;
		this.earnedValue = earnedValue;
		this.milestone = milestone;
		this.startDate = startDate;
		this.endDate = endDate;
		//this.teamMember = teamMember;
		this.stakeholder = stakeholder;
		//this.risks = risks;
		this.description = description;
		this.portfolio = portfolio;
		this.customer = customer;
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
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the state
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setState(String status) {
		this.status = status;
	}
	/**
	 * @return the projectPhase
	 */
	public String getProjectPhase() {
		return projectPhase;
	}
	/**
	 * @param projectPhase the projectPhase to set
	 */
	public void setProjectPhase(String projectPhase) {
		this.projectPhase = projectPhase;
	}
	/**
	 * @return the budget
	 */
	public int getBudget() {
		return budget;
	}
	/**
	 * @param budget the budget to set
	 */
	public void setBudget(int budget) {
		this.budget = budget;
	}
	/**
	 * @return the plannedValue
	 */
	public int getPlannedValue() {
		return plannedValue;
	}
	/**
	 * @param plannedValue the plannedValue to set
	 */
	public void setPlannedValue(int plannedValue) {
		this.plannedValue = plannedValue;
	}
	/**
	 * @return the actualCost
	 */
	public int getActualCost() {
		return actualCost;
	}
	/**
	 * @param actualCost the actualCost to set
	 */
	public void setActualCost(int actualCost) {
		this.actualCost = actualCost;
	}
	/**
	 * @return the earnedValue
	 */
	public int getEarnedValue() {
		return earnedValue;
	}
	/**
	 * @param earnedValue the earnedValue to set
	 */
	public void setEarnedValue(int earnedValue) {
		this.earnedValue = earnedValue;
	}
	/**
	 * @return the milestone
	 */
	public String getMilestone() {
		return milestone;
	}
	/**
	 * @param milestone the milestone to set
	 */
	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the teamMember
	 */
	public String getTeamMember() {
		return teamMember;
	}
	/**
	 * @param teamMember the teamMember to set
	 */
	public void setTeamMember(String teamMember) {
		this.teamMember = teamMember;
	}
	/**
	 * @return the stakeholder
	 */
	public String getStakeholder() {
		return stakeholder;
	}
	/**
	 * @param stakeholder the stakeholder to set
	 */
	public void setStakeholder(String stakeholder) {
		this.stakeholder = stakeholder;
	}
	/**
	 * @return the risks
	 */
	public String getRisks() {
		return risks;
	}
	/**
	 * @param risks the risks to set
	 */
	public void setRisks(String risks) {
		this.risks = risks;
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
	 * @return the portfolio
	 */
	public String getPortfolio() {
		return portfolio;
	}
	/**
	 * @param portfolio the portfolio to set
	 */
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	/**
	 * Override toString() method
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", owner=" + owner + ", status=" + status + ", projectPhase="
				+ projectPhase + ", budget=" + budget + ", plannedValue=" + plannedValue + ", actualCost=" + actualCost
				+ ", earnedValue=" + earnedValue + ", milestone=" + milestone + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", teamMember=" + teamMember + ", stakeholder=" + stakeholder + ", risks="
				+ risks + ", description=" + description + "]";
	}
}