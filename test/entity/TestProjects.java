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
		projects.add(new Project("图书管理系统","图书管理(1)图书分类管理;(2)图书信息管理;(3)图书查询"));
		projects.add(new Project("书店管理系统","书店管理系统是适合于中小型书店,书城销售的最佳管理软件。 可进行图书登记、 查找、编辑。 会员登记功能：\r\n 记录了会员的日常必备的联系项目， 软件会自动统计出会员的总数。销售管理：记录一天所售出的图书量，并记录您当天的销售额。统计功能：软件会统计出图书的总数,总价格,会员的总数,销售图书数量,销售额等必备数据供管理员查看。"));
		projects.add(new Project("学生成绩管理系统","能进行不同班级各科成绩的录入、编辑、插入、删除、查询、统计，能进行成绩的排序。"));
		projects.add(new Project("家庭理财管理系统","应用于家庭财务管理的软件，能够记账，汇总，查询，能对账目进行分析，计算出各种支出收入的比例。"));
		projects.add(new Project("学校收费管理系统","适用于初级中学、 高级中学及大中专学校的收费管理。"));
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
		session.update(new Project(2,"书店管理系统","书店管理系统是适合于中小型书店,书城销售的最佳管理软件。 可进行图书登记、 查找、编辑。 会员登记功能：\r\n 记录了会员的日常必备的联系项目， 软件会自动统计出会员的总数。销售管理：记录一天所售出的图书量，并记录您当天的销售额。统计功能：软件会统计出图书的总数,总价格,会员的总数,销售图书数量,销售额等必备数据供管理员查看。"));
		Project project = (Project)session.get(Project.class, 2);
		System.out.println(project.getPdesc());
	}
}
