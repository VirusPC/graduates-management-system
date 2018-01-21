package entity;

public class Department {
	private Integer did;
	private String dname;
	
	public Department() {
	}
	public Department(String dname) {
		this.did = did;
		this.dname = dname;
	}
	
	public Department(Integer did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
}
