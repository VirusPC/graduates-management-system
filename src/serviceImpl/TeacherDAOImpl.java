package serviceImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.TeacherDAO;
import db.MyHibernateSessionFactory;
import entity.Bulletin;
import entity.Pager;
import entity.Project;
import entity.StudentPC;
import entity.Teacher;

public class TeacherDAOImpl implements TeacherDAO {

	@Override
	public Teacher teacherLogin(Teacher teacher) {
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		String hql = "";
		try {
			hql = "from  Teacher where id=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, teacher.getId());
			query.setParameter(1, teacher.getPassword());
			List list = query.list();			
			if (list.size() == 1) {
				return (Teacher)(list.get(0));
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {			
			if (tx != null) {
				tx.commit();// 提交事务
				tx = null;
			}
		}
	}
	
	@Override
	public boolean changePassword(String id, String oldPassword,
			String newPassword) {
		Transaction tx = null;
		Teacher teacher = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			teacher = (Teacher)session.get(Teacher.class, id);
			if(teacher==null)
				return false;
			if(!oldPassword.equals(teacher.getPassword()))
				return false;
			teacher.setPassword(newPassword);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}

	@Override
	public Pager getBulletinsById(int currentPage,String id) {
		Pager pager = new Pager();
		Transaction tx = null;
		int count = getBulletinCount(id);
		int maxSize = 5;
		String hql = "";
		pager.setCurrentPage(currentPage);
		pager.setPageSize(maxSize);
		pager.setCount(count);
		pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));

		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			hql = "from Bulletin where tid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			query.setFirstResult((currentPage-1)*maxSize);
			query.setMaxResults(maxSize);
			List list = query.list();
			if(list.size()>0){
				pager.setList(list);
				return pager;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}

	public int getBulletinCount(String id){
		Transaction tx = null;
		int count = 0;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			String hql = "select count(*) from Bulletin where tid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			count=((Long)query.uniqueResult()).intValue();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}
	
	

	@Override
	public void deleteBulletin(Integer id) {
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			Bulletin bulletin = (Bulletin)session.get(Bulletin.class, id);
			if(bulletin==null) return;
			session.delete(bulletin);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}

	@Override
	public void saveOrUpdateBulletin(Bulletin bulletin, Teacher teacher) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		Teacher teacher2 = null;
		try {
			teacher2 = (Teacher)session.get(Teacher.class, teacher.getId());
			teacher2.getBulletins().add(bulletin);
			if(bulletin.getBid()!=null)
				session.merge(bulletin);
			else
				session.save(bulletin);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}
	
	@Override
	public Pager getProjectsById(int currentPage,String id) {
		Pager pager = new Pager();
		Transaction tx = null;
		int count = getProjectsCount(id);
		int maxSize = 5;
		String hql = "";
		pager.setCurrentPage(currentPage);
		pager.setPageSize(maxSize);
		pager.setCount(count);
		pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));

		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			hql = "from Project where tid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			query.setFirstResult((currentPage-1)*maxSize);
			query.setMaxResults(maxSize);
			List list = query.list();

			if(list.size()>0){
				pager.setList(list);
				return pager;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}
	
	public int getProjectsCount(String id){
		Transaction tx = null;
		int count = 0;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			String hql = "select count(*) from Project where tid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			count=((Long)query.uniqueResult()).intValue();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}

	@Override
	public void deleteProject(Integer id) {
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			Project project = (Project)session.get(Project.class, id);
			if(project==null) return;
			session.delete(project);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}

	@Override
	public void saveOrUpdateProject(Project project, Teacher teacher) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		Teacher teacher2 = null;
		try {
			teacher2 = (Teacher)session.get(Teacher.class, teacher.getId());
			teacher2.getProjects().add(project);
			if(project.getPid()!=null)
				session.merge(project);
			else
				session.save(project);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}
	
	@Override
	public Pager getStudentsByTeacherId(int currentPage,String id,String order) {
		
		Pager pager = new Pager();
		Transaction tx = null;
		int count = getStudentsCount(id);
		int maxSize = 5;
		String hql = "";
		pager.setCurrentPage(currentPage);
		pager.setPageSize(maxSize);
		pager.setCount(count);
		pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));

		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			hql = "from StudentPC where teacher.id=?";
			if(order!=null){
				hql=hql+" order by "+order;
			}
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			query.setFirstResult((currentPage-1)*maxSize);
			query.setMaxResults(maxSize);
			List list = query.list();
			if(list.size()>0){
				for (StudentPC student : (List<StudentPC>)list) {
					System.out.println(student.getProject());
				}
				pager.setList(list);
				return pager;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}
	
	@Override
	public Pager getStudentByTeacherId(int currentPage,String id,String stuid) {
		
		Pager pager = new Pager();
		Transaction tx = null;
		int count = getStudentsCount(id);
		int maxSize = 5;
		String hql = "";
		pager.setCurrentPage(currentPage);
		pager.setPageSize(maxSize);
		pager.setCount(count);
		pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));

		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			hql = "from StudentPC where teacher.id=? and id like '%"+stuid+"%'";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			query.setFirstResult((currentPage-1)*maxSize);
			query.setMaxResults(maxSize);
			List list = query.list();
			if(list.size()>0){
				for (StudentPC student : (List<StudentPC>)list) {
					System.out.println(student.getProject());
				}
				pager.setList(list);
				return pager;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}
	
	public int getStudentsCount(String id){
		Transaction tx = null;
		int count = 0;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			String hql = "select count(*) from StudentPC where teacher.id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			count=((Long)query.uniqueResult()).intValue();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}


	@Override
	public Teacher updateTeacherInformation(Teacher teacher) {
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		String hql = "";
		try {
			hql = "from  Teacher where id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, teacher.getId());
			Teacher teacher2 = (Teacher)query.uniqueResult();			
			if (teacher2!=null) {
				teacher2.setEmail(teacher.getEmail());
				teacher2.setTel(teacher.getTel());
				return teacher2;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {			
			if (tx != null) {
				tx.commit();// 提交事务
				tx = null;
			}
		}
	}
	
	@Override
	public Teacher setTime(Teacher teacher) {
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		String hql = "";
		try {
			hql = "from  Teacher where id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, teacher.getId());
			Teacher teacher2 = (Teacher)query.uniqueResult();			
			if (teacher2!=null) {
				teacher2.setTime1(teacher.getTime1());
				teacher2.setTime2(teacher.getTime2());
				teacher2.setTime3(teacher.getTime3());
				teacher2.setEnd(teacher.getEnd());
				return teacher2;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {			
			if (tx != null) {
				tx.commit();// 提交事务
				tx = null;
			}
		}
	}

	@Override
	public void check(String stuid, Integer grade, String comment) {
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		String hql = "";
		try {
			hql = "from  StudentPC where id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, stuid);
			StudentPC student = (StudentPC)query.uniqueResult();			
			if (student!=null) {
				student.setComment(comment);
				student.setGrade(grade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			if (tx != null) {
				tx.commit();// 提交事务
				tx = null;
			}
		}
		
	}

}
