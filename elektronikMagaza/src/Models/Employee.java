package Models;

public class Employee {
	private int Id;
	private String Name;
	private String LastName;
	private String loginId;
	private int Department_id;
	private int Director_id;
	public String getName() {
		return Name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public int getDepartment_id() {
		return Department_id;
	}
	public void setDepartment_id(int department_id) {
		Department_id = department_id;
	}
	public int getDirector_id() {
		return Director_id;
	}
	public void setDirector_id(int director_id) {
		Director_id = director_id;
	}
	
	
	
}
