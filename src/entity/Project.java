package entity;

public class Project {
	private Integer pid;
	private String pname;
	String pdesc;
	
	public Project() {
	}
	public Project(String pname, String pdesc) {
		this.pname = pname;
		this.pdesc = pdesc;
	}
	public Project(Integer pid, String pname, String pdesc) {
		this.pid = pid;
		this.pname = pname;
		this.pdesc = pdesc;
	}
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
}
