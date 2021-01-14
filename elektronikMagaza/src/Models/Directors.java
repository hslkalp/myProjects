package Models;

public class Directors {
	private int Id;
	private String Name;
	private String LastName;
	private int Department_id;
	private String logindId;
	public String getName() {
		return Name;
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
	public int getDepartment_id() {
		return Department_id;
	}
	public void setDepartment_id(int department_id) {
		Department_id = department_id;
	}
	public String getLogindId() {
		return logindId;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	
}
