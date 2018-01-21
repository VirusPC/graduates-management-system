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

public class TetsBulletins {
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
	public void testSaveBulletins(){
		List<Bulletin> list = new ArrayList();
		//list.add(new Bulletin("这是公告2，请大家仔细阅读"));
		//list.add(new Bulletin("这是公告3，请大家仔细阅读"));
		//list.add(new Bulletin("这是公告4，请大家仔细阅读"));
		for (Bulletin bulletin : list) {
			session.save(bulletin);
		}		
	}
	

}
