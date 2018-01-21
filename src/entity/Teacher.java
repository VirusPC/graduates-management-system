package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Teacher {
	private String id;
	private String name;
	private String password;
	private String tel;
	private String email;
	private Date time1;
	private Date time2;
	private Date time3;
	private Date end;
	private Specialty specialty;
	private Set<Bulletin> bulletins = new HashSet<Bulletin>();
	private Set<Project> projects = new HashSet<Project>();
	
	public Teacher() {
	}
	public Teacher(String id, String name, String password, String tel,
			String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.end = end;
	}
	public Teacher(String id, String name, String password, String tel,
			String email, Date time1, Date time2, Date time3, Date end,
			Specialty specialty, 
			Set<Bulletin> bulletins, Set<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.time1 = time1;
		this.time2 = time2;
		this.time3 = time3;
		this.end = end;
		this.specialty = specialty;
		this.bulletins = bulletins;
		this.projects = projects;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getTime1() {
		return time1;
	}
	public void setTime1(Date time1) {
		this.time1 = time1;
	}
	public Date getTime2() {
		return time2;
	}
	public void setTime2(Date time2) {
		this.time2 = time2;
	}
	public Date getTime3() {
		return time3;
	}
	public void setTime3(Date time3) {
		this.time3 = time3;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	public Set<Bulletin> getBulletins() {
		return bulletins;
	}
	public void setBulletins(Set<Bulletin> bulletins) {
		this.bulletins = bulletins;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
}
