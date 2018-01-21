package service;

import entity.Admin;
import entity.Pager;
import entity.Specialty;
import entity.StudentPC;
import entity.Teacher;

public interface AdminDAO {
	public Admin adminLogin(Admin admin);
	public boolean changePassword(String id, String oldPassword, String newPassword);
	public Pager getStudentsByStudentId(int currentPage,String id,String order);
	public void deleteStudent(String id);
	public boolean saveStudent(StudentPC student, String tid);
	public boolean updateStudent(StudentPC student, String tid);
	
	public Pager getTeachersByTeacherId(int currentPage,String id,String order);
	public void deleteTeacher(String id);
	public boolean saveTeacher(Teacher teacher, Integer spid);
	public boolean updateTeacher(Teacher teacher, Integer spid);
	
	public Pager getDepartmentsByDepartmentId(int currentPage,String deptid,String order);
	public void deleteDepartment(Integer did);
	public boolean saveDepartment(Integer did, String dname);
	public boolean updateDepartment(Integer did, String dname);
	
	
	public Pager getSpecialtysBySpecialtyId(int currentPage,String spid,String order);
	public void deleteSpecialty(Integer spid);
	public boolean updateSpecialty(String dname, Specialty specialty);
	public boolean saveSpecialty(String deptname, Specialty specialty);
}