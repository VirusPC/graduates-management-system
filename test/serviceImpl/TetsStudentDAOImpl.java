package serviceImpl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import service.StudentDAO;
import entity.Pager;
import entity.Project;
import entity.StudentPC;

public class TetsStudentDAOImpl {
	StudentDAO dao=null;
	@Before
	public void before(){
		dao = new StudentDAOImpl();
	}
	
	@Test
	public void testLogin(){
		StudentPC stu = new StudentPC();
		stu.setId("10000");
		stu.setPassword("10000");
		Assert.assertEquals(true, dao.studentLogin(stu));
	}
	@Test
	public void isStudentSelect(){;
		
	}
	
	@Test
	public void testGetProjectById(){
		int i=0;
		Pager pager = dao.getProjectById(1, "10000");
		if(pager==null){
			return;
		}
		List<Project> list = (List<Project>)pager.getList();
		for (Project project : list) {
			System.out.println(project.getPname());
		}
	}
	

}
