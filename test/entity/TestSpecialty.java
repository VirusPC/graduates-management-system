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

public class TestSpecialty {
	
	@Test
	public void testSaveSpecialty(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Specialty> specialty = new ArrayList();
		Department dept = (Department)session.get(Department.class, 1);
		//specialty.add(new Specialty("��е��", new Department(1,"��е����ѧԺ")));
		specialty.add(new Specialty("��Դ�붯������", dept));
		specialty.add(new Specialty("��е������켰���Զ���", dept));
		dept = (Department)session.get(Department.class, 2);
		specialty.add(new Specialty("�������̼����Զ���",dept));
		specialty.add(new Specialty("�Զ���",dept));
		dept = (Department)session.get(Department.class, 3);
		specialty.add(new Specialty("��ľ����",dept));
		specialty.add(new Specialty("ˮ��ˮ�繤��",dept));
		specialty.add(new Specialty("����ѧ",dept));
		specialty.add(new Specialty("����滮",dept));
		dept = (Department)session.get(Department.class, 4);
		specialty.add(new Specialty("��ѧ",dept));
		specialty.add(new Specialty("Ӧ�û�ѧ",dept));
		specialty.add(new Specialty("��ѧ�����빤��",dept));
		specialty.add(new Specialty("��Դ��ѧ����",dept));
		dept = (Department)session.get(Department.class, 5);
		specialty.add(new Specialty("��������",dept));
		dept = (Department)session.get(Department.class, 6);
		specialty.add(new Specialty("������Դ����",dept));
		specialty.add(new Specialty("��ȫ����",dept));
		dept = (Department)session.get(Department.class, 7);
		specialty.add(new Specialty("������",dept));
		dept = (Department)session.get(Department.class, 8);
		specialty.add(new Specialty("�Ṥ��",dept));
		specialty.add(new Specialty("ʳƷ��ѧ�빤����",dept));
		dept = (Department)session.get(Department.class, 9);
		specialty.add(new Specialty("�������",dept));
		specialty.add(new Specialty("������Ϣ��",dept));

		for (Specialty sp: specialty) {
			session.save(sp);
		}
		tx.commit();
		sessionFactory.close();
	}
}
