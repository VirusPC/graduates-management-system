package entity;

import java.util.Date;

public class StudentInformation {
	private String id;
	private String name;
	private String department;
	private String specialty;
	private Date graduation;
	private String teacher;
	private String tid;
	
	public StudentInformation() {
		super();
	}
	public StudentInformation(String id, String name, String department,
			String specialty, Date graduation, String teacher, String tid) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.specialty = specialty;
		this.graduation = graduation;
		this.teacher = teacher;
		this.tid = tid;
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
	public Date getGraduation() {
		return graduation;
	}
	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	
}
