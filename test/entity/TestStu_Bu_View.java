package entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStu_Bu_View {
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
	public void testQuery(){
		//List<Stu_Bu_View> list = (List<Stu_Bu_View>)session.createQuery("from Stu_Bu_View");	
		Stu_Bu_View sbv = (Stu_Bu_View)session.get(Stu_Bu_View.class, 1);
		System.out.println(sbv.getContent());
	}
	

}
