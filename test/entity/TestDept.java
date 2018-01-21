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
		dept.add(new Department("��е����ѧԺ"));
		dept.add(new Department("��������ѧԺ"));
		dept.add(new Department("��ľ��������ѧԺ"));
		dept.add(new Department("��ѧ����ѧԺ"));
		dept.add(new Department("����ѧԺ"));
		dept.add(new Department("��Դ��ұ��ѧԺ"));
		dept.add(new Department("���Ͽ�ѧ�빤��ѧԺ"));
		dept.add(new Department("�Ṥ��ʳƷ����ѧԺ"));
		dept.add(new Department("������������ϢѧԺ"));
		for (Department department : dept) {
			session.save(department);
		}
		tx.commit();
		sessionFactory.close();
	}
}
