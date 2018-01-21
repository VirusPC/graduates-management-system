package entity;

public class Specialty {
	private Integer spid;
	private String spname;
	private Department department;
	
	public Specialty() {
	}
	public Specialty(String spname, Department department) {
		this.spname = spname;
		this.department = department;
	}
	public Integer getSpid() {
		return spid;
	}
	public void setSpid(Integer spid) {
		this.spid = spid;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
