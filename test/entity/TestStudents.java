package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStudents {

	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction tx = null;
	
	@Before
	public void before(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
	}
	
	@After
	public void after(){
		tx.commit();
		sessionFactory.close();
	}
	
	@Test
	public void testSaveStudents() throws ParseException{
		StudentPC stu = new StudentPC();
		stu.setId("10002");
		stu.setPassword("10002");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2015-7-1");
		stu.setGraduation(date);
		stu.setName("кнт╤ге");
		session.save(stu);
	}
	
	@Test
	public void testGetStudents(){
		StudentPC stu = new StudentPC();
		stu = (StudentPC)session.get(StudentPC.class, "10000");
		System.out.println(stu.getName());
	}
	
	@Test
	public void testUpdateStudents(){
		StudentPC stu = new StudentPC();
		stu = (StudentPC)session.get(StudentPC.class, "10000");
		stu.setName("999");
		session.update(stu);
		System.out.println(stu.getName());
	}
    
	@Test
	public void testTS(){
		addTeacherForStudent("1000","10000");
	}
	
	public void addTeacherForStudent(String t, String s){
		Teacher teacher = (Teacher)session.get(Teacher.class, t);
		StudentPC student = (StudentPC)session.get(StudentPC.class, s);
		student.setTeacher(teacher);
		session.update(student);
	}
}
