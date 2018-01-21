package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.StudentDAO;
import db.MyHibernateSessionFactory;
import entity.Bulletin;
import entity.Department;
import entity.Pager;
import entity.Project;
import entity.Specialty;
import entity.StudentInformation;
import entity.StudentPC;
import entity.Teacher;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public StudentPC studentLogin(StudentPC student) {
		Transaction tx = null;
		String hql = "";
		StudentPC student2 = null;
		
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			hql = "from StudentPC where id=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, student.getId());
			query.setParameter(1, student.getPassword());
			student2 = (StudentPC)query.uniqueResult();
			student2.getTeacher().getTime1();
			student2.getProject();
			//student2.setProject(student2.getProject());
			//student2.setTeacher(student2.getTeacher());
			return student2;
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
	public StudentInformation getStudentInformById(String id) {
		Transaction tx = null;
		StudentInformation si = new StudentInformation();
		StudentPC student = null;
		Teacher teacher = null;
		Department dept = null;
		Specialty specialty = null;
		

		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		
		si.setId(id);
		try {
			student = (StudentPC)session.get(StudentPC.class, id);
			if(student!=null){
				si.setName(student.getName());
				si.setGraduation(student.getGraduation());
				teacher = student.getTeacher();
				if(teacher!=null){
					si.setTeacher(teacher.getName());
					specialty = teacher.getSpecialty();
					if(specialty!=null){
						si.setSpecialty(specialty.getSpname());
						dept = specialty.getDepartment();
						if(dept!=null)
							si.setDepartment(dept.getDname());
					}
				}
			}
			return si;
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
	public Pager getProjectById(int currentPage, String id) {
		Pager pager = new Pager();
		StudentPC student  = null;
		Project project = null;
		Teacher teacher;
		Transaction tx = null;
		int maxSize = 8;
		pager.setCurrentPage(currentPage);
		pager.setPageSize(maxSize);
		//pager.setCount(count);
		//pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();		
		try {
			student = (StudentPC)session.get(StudentPC.class, id);
			if(student==null)
				return null;
			project = student.getProject();
			if(project!=null){
				System.out.println(project.getPname());
				List<Project> list = new ArrayList<Project>();
				list.add(project);
				pager.setList(list);
				pager.setCount(1);
				pager.setTotalPage(1);
				return pager;
				//return null;
			}
			teacher = student.getTeacher();
			if(teacher==null)
				return null;
			
			String hql = "from Project where tid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, teacher.getId());
			query.setFirstResult((currentPage-1)*maxSize);
			query.setMaxResults(maxSize);
			List list = query.list();
			pager.setList(list);
			
			String hql2="select count(*) from Project where tid=?";
			Query query2 = session.createQuery(hql2);
			query2.setParameter(0, teacher.getId());
			int count = ((Long)query2.uniqueResult()).intValue();
			pager.setCount(count);
			pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));
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
	
	@Override
	public Pager getBulletinByStudentId(int currentPage,String id) {
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
			hql = "from Stu_Bu_View where id=?";
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
			String hql = "select count(*) from Stu_Bu_View where id=?";
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
	public boolean changePassword(String id, String oldPassword,
			String newPassword) {
		Transaction tx = null;
		StudentPC student = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			student = (StudentPC)session.get(StudentPC.class, id);
			if(student==null)
				return false;
			if(!oldPassword.equals(student.getPassword()))
				return false;
			student.setPassword(newPassword);
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
	public StudentPC selectProject(String id, int pid) {
		Transaction tx = null;
		StudentPC student = null;
		Project project = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			student = (StudentPC)session.get(StudentPC.class, id);
			if(student==null)
				return null;
			project = (Project)session.get(Project.class, pid);
			if(project==null)
				return null;
			student.setProject(project);
			return student;
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
	public Teacher getTeacherByStudentId(String id) {
		Transaction tx = null;
		String hql = "";

		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			hql = "from  Teacher where id=(select teacher from StudentPC where id=?)";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
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
				tx.commit();
				tx = null;
			}
		}
	}

	@Override
	public void deleteProjectById(String id) {
			Transaction tx = null;
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			try {
				StudentPC student = (StudentPC)session.get(StudentPC.class, id);
				if(student==null) return;
				student.setProject(null);			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (tx != null) {
					tx.commit();
					tx = null;
				}
			}		
	}

//	@Override
//	public StudentPC getTimeAndComment(StudentPC student) {
//		Transaction tx = null;
//		StudentPC student2 = null;
//		try {
//			Session session = MyHibernateSessionFactory.getSessionFactory()
//					.getCurrentSession();
//			tx = session.beginTransaction();
//			if(student.getId()==null){
//				return null;
//			}
//			student2 = (StudentPC)session.get(StudentPC.class, student.getId());
//			student2.getProject();
//			student2.getTeacher();
//			tx.commit();// 提交事务
//			return student2;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			if (tx != null) {
//				tx = null;
//			}
//		}
//	}


}
