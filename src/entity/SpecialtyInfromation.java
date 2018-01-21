package entity;

public class SpecialtyInfromation {
	private Integer spid;
	private String spname;
	private String deptname;
	private Integer deptid;
	
	public SpecialtyInfromation() {
		
	}
	public  SpecialtyInfromation(String spname,Integer spid,String dname,Integer did) {
		this.spname = spname;
		this.spid = spid;
		this.deptname = dname;
		this.deptid = did;
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
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	
}
