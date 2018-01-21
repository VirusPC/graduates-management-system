package entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class TestProjects {
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
	public void testSaveProject(){
		List<Project> projects = new ArrayList();
		projects.add(new Project("ͼ�����ϵͳ","ͼ�����(1)ͼ��������;(2)ͼ����Ϣ����;(3)ͼ���ѯ"));
		projects.add(new Project("������ϵͳ","������ϵͳ���ʺ�����С�����,������۵���ѹ�������� �ɽ���ͼ��Ǽǡ� ���ҡ��༭�� ��Ա�Ǽǹ��ܣ�\r\n ��¼�˻�Ա���ճ��ر�����ϵ��Ŀ�� ������Զ�ͳ�Ƴ���Ա�����������۹�����¼һ�����۳���ͼ����������¼����������۶ͳ�ƹ��ܣ������ͳ�Ƴ�ͼ�������,�ܼ۸�,��Ա������,����ͼ������,���۶�ȱر����ݹ�����Ա�鿴��"));
		projects.add(new Project("ѧ���ɼ�����ϵͳ","�ܽ��в�ͬ�༶���Ƴɼ���¼�롢�༭�����롢ɾ������ѯ��ͳ�ƣ��ܽ��гɼ�������"));
		projects.add(new Project("��ͥ��ƹ���ϵͳ","Ӧ���ڼ�ͥ��������������ܹ����ˣ����ܣ���ѯ���ܶ���Ŀ���з��������������֧������ı�����"));
		projects.add(new Project("ѧУ�շѹ���ϵͳ","�����ڳ�����ѧ�� �߼���ѧ������רѧУ���շѹ���"));
		for (Project project : projects) {
			session.save(project);
		}
	}
	
	@Test
	public void testGetProject(){
		Project project = (Project)session.get(Project.class, 2);
		System.out.println(project.getPdesc());
	}
	
	@Test
	public void testUpdateProject(){
		session.update(new Project(2,"������ϵͳ","������ϵͳ���ʺ�����С�����,������۵���ѹ�������� �ɽ���ͼ��Ǽǡ� ���ҡ��༭�� ��Ա�Ǽǹ��ܣ�\r\n ��¼�˻�Ա���ճ��ر�����ϵ��Ŀ�� ������Զ�ͳ�Ƴ���Ա�����������۹�����¼һ�����۳���ͼ����������¼����������۶ͳ�ƹ��ܣ������ͳ�Ƴ�ͼ�������,�ܼ۸�,��Ա������,����ͼ������,���۶�ȱر����ݹ�����Ա�鿴��"));
		Project project = (Project)session.get(Project.class, 2);
		System.out.println(project.getPdesc());
	}
}
