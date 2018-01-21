package serviceImpl;


import java.util.List;

import org.junit.Test;

import entity.Pager;
import entity.Project;
import entity.Specialty;
import junit.framework.Assert;
import service.AdminDAO;
import service.TeacherDAO;

public class TestAdminDAOImpl {

	@Test
	public void testGetProjectsById(){
		TeacherDAO tdao = new TeacherDAOImpl();
		Pager pager=tdao.getProjectsById(1, "1000");
		List list = pager.getList();
		
		for (Project project : (List<Project>)list) {
			System.out.println(project.getPname());
			System.out.println(project.getPdesc());
			System.out.println("**********");
		}
		System.out.println(pager.getCount());
		System.out.println(pager.getPageSize());
		System.out.println(pager.getTotalPage());
		System.out.println(pager.getCount());
	}
	
	@Test
	public void testGetStudentInforms(){
		AdminDAO dao = new AdminDAOImpl();
		Pager pager=dao.getStudentsByStudentId(1, "1000", null);
		List list = pager.getList();
		
//		for (Project project : (List<Project>)list) {
//			System.out.println(project.getPname());
//			System.out.println(project.getPdesc());
//			System.out.println("**********");
//		}
		System.out.println(pager.getCount());
		System.out.println(pager.getPageSize());
		System.out.println(pager.getTotalPage());
		System.out.println(pager.getCount());
	}
	
	@Test
	public void testGetTeachersStudentCount(){
		AdminDAOImpl dao = new AdminDAOImpl();
		//System.out.println(dao.getTeachersStudentCount("1000"));
	}
	
	@Test
	public void testSaveSpecialty(){
		AdminDAOImpl dao = new AdminDAOImpl();
		Specialty sp = new Specialty();
		sp.setSpid(60);
		sp.setSpname("60");
		Assert.assertEquals(true, dao.saveSpecialty("电气工程学院", sp));
	}
	
}
