package Models;

public class Categories {
	private int Id;
	private String Name;
	private String Description;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return  Name ;
	}
	
	
}
