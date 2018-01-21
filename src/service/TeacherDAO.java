package service;

import entity.Bulletin;
import entity.Pager;
import entity.Project;
import entity.Teacher;

public interface TeacherDAO {
	public Teacher teacherLogin(Teacher teacher);
	public boolean changePassword(String id, String oldPassword, String newPassword);
	public Pager getBulletinsById(int currentPage,String id);
	public void saveOrUpdateBulletin(Bulletin bulletin, Teacher teacher);
	public void deleteBulletin(Integer id);
	public Pager getProjectsById(int currentPage,String id);
	public void saveOrUpdateProject(Project project, Teacher teacher);
	public void deleteProject(Integer id);
	public Teacher setTime(Teacher teacher);
	public Pager getStudentsByTeacherId(int currentPage,String id,String order);
	public Pager getStudentByTeacherId(int currentPage,String id,String stuid);
	public Teacher updateTeacherInformation(Teacher teacher);
	public void check(String stuid, Integer grade, String comment);
}
