package entity;

import java.util.Date;

public class StudentPC {
	private String id;
	private String name;
	private Date graduation;
	private String password;
	private Integer grade;
	private String comment;
	private Teacher teacher;
	private Project project;
	
	
	public StudentPC() {
	}
	public StudentPC(String id, String name, Date graduation,
			String password, Integer grade, String comment) {
		this.id = id;
		this.name = name;
		this.graduation = graduation;
		this.password = password;
		this.grade = grade;
		this.comment = comment;
	}
	public StudentPC(String id, String name, Date graduation,
			String spassword) {
		this.id = id;
		this.name = name;
		this.graduation = graduation;
		this.password = password;
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
	public Date getGraduation() {
		return graduation;
	}
	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	@Override
	public String toString() {
		return "StudentPC [id=" + id + ", name=" + name + ", graduation="
				+ graduation + ", password=" + password+ "]";
	}

	
}
