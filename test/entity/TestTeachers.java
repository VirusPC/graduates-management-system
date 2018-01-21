package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTeachers {

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
	public void testSaveTeachers(){
		Teacher teacher = new Teacher("1000","张三丰","1000","15777771000","1000@163.com");
		session.save(teacher);
	}
	
	@Test
	public void testUpdateTeachers(){
		Teacher teacher = new Teacher("1000","张三丰","1000","15777771000","1000@163.com");
		session.update(teacher);
	}
}
