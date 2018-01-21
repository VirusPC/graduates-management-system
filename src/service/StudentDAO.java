package service;

import entity.Department;
import entity.Pager;
import entity.Project;
import entity.Specialty;
import entity.StudentInformation;
import entity.StudentPC;
import entity.Teacher;

public interface StudentDAO {
	public StudentPC studentLogin(StudentPC student);
	public StudentInformation getStudentInformById(String id);
	public Pager getProjectById(int currentPage, String id);
	public Pager getBulletinByStudentId(int currentPage, String id);
	//public Specialty getSpecialtyByTeacherId(String id);
	//public Department getDepBySpecialtyId(String id);
	public boolean changePassword(String id, String oldPassword, String newPassword);
	public StudentPC selectProject(String id, int pid);
	public Teacher getTeacherByStudentId(String id);
	public  void deleteProjectById(String id);
	//public StudentPC getTimeAndComment(StudentPC student);
}
