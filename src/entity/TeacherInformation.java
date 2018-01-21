package entity;

import java.util.Date;

public class TeacherInformation {
	private String id;
	private String name;
	private String department;
	private String specialty;	
	private Integer studentCount;
	private Integer projectCount;
	private Integer deptid;
	private Integer spid;
	
	public TeacherInformation() {
	}

	public TeacherInformation(String id, String name, String department,
			String specialty, Integer studentCount, Integer projectCount,
			Integer deptid, Integer spid) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.specialty = specialty;
		this.studentCount = studentCount;
		this.projectCount = projectCount;
		this.deptid = deptid;
		this.spid = spid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Integer getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}

	public Integer getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(Integer projectCount) {
		this.projectCount = projectCount;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public Integer getSpid() {
		return spid;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}
	
	
	
}
