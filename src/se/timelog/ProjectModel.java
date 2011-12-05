package se.timelog;

public class ProjectModel {
	
	private String name = "";
	private String budget = "";
	private String estimated_time = "";
	private String customer = "";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getEstimated_time() {
		return estimated_time;
	}
	public void setEstimated_time(String estimated_time) {
		this.estimated_time = estimated_time;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
}
