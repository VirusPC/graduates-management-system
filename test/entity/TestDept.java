package entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class TestDept {
	@Test
	public void testSaveDept(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Department> dept = new ArrayList();
		dept.add(new Department("机械工程学院"));
		dept.add(new Department("电气工程学院"));
		dept.add(new Department("土木建筑工程学院"));
		dept.add(new Department("化学化工学院"));
		dept.add(new Department("环境学院"));
		dept.add(new Department("资源与冶金学院"));
		dept.add(new Department("材料科学与工程学院"));
		dept.add(new Department("轻工与食品工程学院"));
		dept.add(new Department("计算机与电子信息学院"));
		for (Department department : dept) {
			session.save(department);
		}
		tx.commit();
		sessionFactory.close();
	}
}
