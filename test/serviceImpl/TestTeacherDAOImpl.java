package serviceImpl;


import java.util.List;

import org.junit.Test;

import service.TeacherDAO;
import entity.Bulletin;
import entity.Pager;
import entity.Project;

public class TestTeacherDAOImpl {

	@Test
	public void testGetBulletinById(){
		TeacherDAO tdao = new TeacherDAOImpl();
		Pager pager=tdao.getBulletinsById(1, "1000");
		List list = pager.getList();
		
		for (Bulletin bulletin : (List<Bulletin>)list) {
			System.out.println(bulletin.getBid());
			System.out.println(bulletin.getBname());
			System.out.println(bulletin.getContent());
			System.out.println("**********");
		}
	}
	
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
	public void testGetStudentsByTeacherId(){
		TeacherDAO tdao = new TeacherDAOImpl();
		Pager pager=tdao.getStudentsByTeacherId(1, "1000","grade");
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
	public void testGetStudentsCount(){
		TeacherDAOImpl tdao = new TeacherDAOImpl();
		System.out.println(tdao.getStudentsCount("1000"));
//		Pager pager=tdao.getProjectsById(1, "1000");
//		List list = pager.getList();
//		
//		for (Project project : (List<Project>)list) {
//			System.out.println(project.getPname());
//			System.out.println(project.getPdesc());
//			System.out.println("**********");
//		}
//		System.out.println(pager.getCount());
//		System.out.println(pager.getPageSize());
//		System.out.println(pager.getTotalPage());
//		System.out.println(pager.getCount());
	}
}
