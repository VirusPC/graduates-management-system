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
		//specialty.add(new Specialty("机械类", new Department(1,"机械工程学院")));
		specialty.add(new Specialty("能源与动力工程", dept));
		specialty.add(new Specialty("机械设计制造及其自动化", dept));
		dept = (Department)session.get(Department.class, 2);
		specialty.add(new Specialty("电气工程及其自动化",dept));
		specialty.add(new Specialty("自动化",dept));
		dept = (Department)session.get(Department.class, 3);
		specialty.add(new Specialty("土木工程",dept));
		specialty.add(new Specialty("水利水电工程",dept));
		specialty.add(new Specialty("建筑学",dept));
		specialty.add(new Specialty("城乡规划",dept));
		dept = (Department)session.get(Department.class, 4);
		specialty.add(new Specialty("化学",dept));
		specialty.add(new Specialty("应用化学",dept));
		specialty.add(new Specialty("化学工程与工艺",dept));
		specialty.add(new Specialty("能源化学工程",dept));
		dept = (Department)session.get(Department.class, 5);
		specialty.add(new Specialty("环境工程",dept));
		dept = (Department)session.get(Department.class, 6);
		specialty.add(new Specialty("矿物资源工程",dept));
		specialty.add(new Specialty("安全工程",dept));
		dept = (Department)session.get(Department.class, 7);
		specialty.add(new Specialty("材料类",dept));
		dept = (Department)session.get(Department.class, 8);
		specialty.add(new Specialty("轻工类",dept));
		specialty.add(new Specialty("食品科学与工程类",dept));
		dept = (Department)session.get(Department.class, 9);
		specialty.add(new Specialty("计算机类",dept));
		specialty.add(new Specialty("电子信息类",dept));

		for (Specialty sp: specialty) {
			session.save(sp);
		}
		tx.commit();
		sessionFactory.close();
	}
}
