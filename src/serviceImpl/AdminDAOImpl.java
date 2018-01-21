package serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.AdminDAO;
import db.MyHibernateSessionFactory;
import entity.Admin;
import entity.Bulletin;
import entity.Department;
import entity.Pager;
import entity.Project;
import entity.Specialty;
import entity.SpecialtyInfromation;
import entity.StudentInformation;
import entity.StudentPC;
import entity.Teacher;
import entity.TeacherInformation;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public Admin adminLogin(Admin admin) {
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Admin where id=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, admin.getId());
			query.setParameter(1, admin.getPassword());
			List list = query.list();
			tx.commit();// 提交事务
			if (list.size() == 1) {
				return (Admin)(list.get(0));
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

//	@Override
//	public Pager getStudentInforms(String id, String deptid, String spid,
//			String tid, Integer currentPage) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Override
//	public Pager getStudentInforms(String id, String deptid,String spid,String tid,Integer currentPage) {
//		Transaction tx = null;
//		StudentInformation si = new StudentInformation();
//		StudentPC student = null;
//		
//		Pager pager = new Pager();
//		int maxSize = 8;
//		
//		pager.setPageSize(maxSize);
//		pager.setCurrentPage(currentPage);
//
//		StringBuffer sb = new StringBuffer("from StudentInformation");
//		if(id!=null) sb.append(" where id="+id);
//		if(dept!=null){
//			if(sb.indexOf("where")==-1)
//				sb.append(" where");
//			else
//				sb.append(" and");
//			sb.append(" department="+department);
//		}
//		if(specialty!=null){
//			sb.append("and specialty="+specialty);
//		}
//		if(teacher!=null){
//			sb.append("and teacher="+teacher);
//		}
//		
//		String hql = sb.toString();
//		System.out.println(hql);
//		
//		int count = getStudentInformationsCount(hql); 
//		pager.setCount(count);
//		pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));
//
//		Session session = MyHibernateSessionFactory.getSessionFactory()
//				.getCurrentSession();
//		tx = session.beginTransaction();
//		
//
//		try {
//			Query query = session.createQuery(hql);
//			query.setFirstResult((currentPage-1)*maxSize);
//			query.setMaxResults(maxSize);
//			List list = query.list();
//			if(list.size()>0){
//				pager.setList(list);
//				return pager;
//			}else{
//				return null;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			if (tx != null) {
//				tx.commit();
//				tx = null;
//			}
//		}
//	}
//		
//	public Integer getStudentInformationsCount(String hql){
//		Transaction tx = null;
//		int count = 0;
//		Session session = MyHibernateSessionFactory.getSessionFactory()
//				.getCurrentSession();
//		tx = session.beginTransaction();
//		try {
//			String hql2 = "select count(*) "+hql;
//			Query query = session.createQuery(hql2);
//			count=((Long)query.uniqueResult()).intValue();
//			return count;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return count;
//		} finally {
//			if (tx != null) {
//				tx.commit();
//				tx = null;
//			}
//		}
//	}
//	
//	@Override
//	public Pager getStudentInforms(String id) {
//		Transaction tx = null;
//		StudentInformation si = new StudentInformation();
//		StudentPC student = null;
//		
//		Pager pager = new Pager();
//		int maxSize = 8;
//		
//		pager.setPageSize(maxSize);
//		pager.setCurrentPage(currentPage);
//
//		StringBuffer sb = new StringBuffer("from StudentInformation");
//		if(id!=null) sb.append(" where id="+id);
//		if(dept!=null){
//			if(sb.indexOf("where")==-1)
//				sb.append(" where");
//			else
//				sb.append(" and");
//			sb.append(" department="+department);
//		}
//		if(specialty!=null){
//			sb.append("and specialty="+specialty);
//		}
//		if(teacher!=null){
//			sb.append("and teacher="+teacher);
//		}
//		
//		String hql = sb.toString();
//		System.out.println(hql);
//		
//		int count = getStudentInformationsCount(hql); 
//		pager.setCount(count);
//		pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));
//
//		Session session = MyHibernateSessionFactory.getSessionFactory()
//				.getCurrentSession();
//		tx = session.beginTransaction();
//		
//
//		try {
//			Query query = session.createQuery(hql);
//			query.setFirstResult((currentPage-1)*maxSize);
//			query.setMaxResults(maxSize);
//			List list = query.list();
//			if(list.size()>0){
//				pager.setList(list);
//				return pager;
//			}else{
//				return null;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			if (tx != null) {
//				tx.commit();
//				tx = null;
//			}
//		}
//	}
	
	@Override
	public boolean changePassword(String id, String oldPassword,
			String newPassword) {
		Transaction tx = null;
		Admin admin = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			admin = (Admin)session.get(Admin.class, id);
			if(admin==null)
				return false;
			if(!oldPassword.equals(admin.getPassword()))
				return false;
			admin.setPassword(newPassword);
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
	
public Pager getStudentsByStudentId(int currentPage,String id,String order) {
		
		Pager pager = new Pager();
		Transaction tx = null;
		int count = getStudentsCount(id);
		int maxSize = 8;
		String hql = "";
		pager.setCurrentPage(currentPage);
		pager.setPageSize(maxSize);
		pager.setCount(count);
		pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));

		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			//hql = "select  new StudentInformation(stu.id, stu.name,dept.dname,sp.spname,stu.graduation,stu.teacher ) from StudentPC stu,Teacher t,Department dept,Specialty sp where id like '%"+id+"%' and t.id=stu.teacher and t.specialty = sp.spid and sp.department = dept.id";
			hql="from StudentPC where id like'%"+id+"%'";
			if(order!=null){
				hql=hql+" order by "+order;
			}
			Query query = session.createQuery(hql);
			query.setFirstResult((currentPage-1)*maxSize);
			query.setMaxResults(maxSize);
			List<StudentPC> list = query.list();
			List<StudentInformation> list2 = new ArrayList();
			if(list.size()>0){
				for (StudentPC stu : list) {
					StudentInformation info = new StudentInformation();
					info.setId(stu.getId());
					info.setName(stu.getName());
					info.setGraduation(stu.getGraduation());
					if(stu.getTeacher()!=null){
						info.setTeacher(stu.getTeacher().getName());
						info.setTid(stu.getTeacher().getId());
						if(stu.getTeacher().getSpecialty()!=null){
							info.setSpecialty(stu.getTeacher().getSpecialty().getSpname());
							info.setDepartment(stu.getTeacher().getSpecialty().getDepartment().getDname());
						}
					}
					list2.add(info);
				}
				pager.setList(list2);
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
			String hql = "select count(*) from StudentPC where id like '%"+id+"%'";
			Query query = session.createQuery(hql);
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
	public void deleteStudent(String id) {
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			StudentPC student = (StudentPC)session.get(StudentPC.class, id);
			if(student==null) return;
			session.delete(student);			
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
	public boolean saveStudent(StudentPC student, String tid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		StudentPC student2 = null;
		Teacher teacher = null;
		try {
			student2 = (StudentPC)session.get(StudentPC.class, student.getId());
			teacher = (Teacher)session.get(Teacher.class, tid);
			if(teacher==null){
				return false;
			}
			if(student2==null){
				student.setTeacher(teacher);
				session.merge(student);
			}else{
				return false;
			}
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
	public boolean updateStudent(StudentPC student, String tid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		StudentPC student2 = null;
		Teacher teacher = null;
		try {
			student2 = (StudentPC)session.get(StudentPC.class, student.getId());
			teacher = (Teacher)session.get(Teacher.class, tid);
			if(teacher==null){
				return false;
			}
			if(student2==null){
				return false;
			}else{
				System.out.println("student2!=null");
				if(student2.getTeacher().getId()!=tid){
					student.setTeacher(teacher);
					session.merge(student);
				}else{
					student2.setName(student.getName());
					student2.setGraduation(student.getGraduation());
					student2.setTeacher(teacher);
				}
			}
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
	
public Pager getTeachersByTeacherId(int currentPage,String id,String order){
		
		Pager pager = new Pager();
		Transaction tx = null;
		
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();


		try {		
			int count = getTeachersCount(id,session);
			int maxSize = 8;
			String hql = "";
			pager.setCurrentPage(currentPage);
			pager.setPageSize(maxSize);
			pager.setCount(count);
			pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));
			
			
			//hql = "select  new StudentInformation(stu.id, stu.name,dept.dname,sp.spname,stu.graduation,stu.teacher ) from StudentPC stu,Teacher t,Department dept,Specialty sp where id like '%"+id+"%' and t.id=stu.teacher and t.specialty = sp.spid and sp.department = dept.id";
			hql="from Teacher where id like'%"+id+"%'";
			if(order!=null){
				hql=hql+" order by "+order;
			}
			Query query = session.createQuery(hql);
			query.setFirstResult((currentPage-1)*maxSize);
			query.setMaxResults(maxSize);
			List<Teacher> list = query.list();
			List<TeacherInformation> list2 = new ArrayList();
			if(list.size()>0){
				for (Teacher teacher : list) {
					TeacherInformation info = new TeacherInformation();
					info.setId(teacher.getId());
					info.setName(teacher.getName());
					info.setProjectCount(teacher.getProjects().size());
					if(teacher.getSpecialty()!=null){
						info.setSpid(teacher.getSpecialty().getSpid());
						info.setSpecialty(teacher.getSpecialty().getSpname());
						info.setDepartment(teacher.getSpecialty().getDepartment().getDname());
						info.setDeptid(teacher.getSpecialty().getDepartment().getDid());
					}
					info.setStudentCount(getTeachersStudentCount(teacher.getId(),session));
					list2.add(info);
				}
				pager.setList(list2);
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

	public int getTeachersCount(String id, Session session){
		int count = 0;
		try {
			String hql = "select count(*) from Teacher where id like '%"+id+"%'";
			Query query = session.createQuery(hql);
			count=((Long)query.uniqueResult()).intValue();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		} 
	}
	
	public int getTeachersStudentCount(String id, Session session){
		int count = 0;
		try {
			String hql = "select count(*) from StudentPC where teacher.id ="+id;
			Query query = session.createQuery(hql);
			count=((Long)query.uniqueResult()).intValue();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		} 
	}

	
	@Override
	public void deleteTeacher(String id) {
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			Teacher teacher= (Teacher)session.get(Teacher.class, id);
			if(teacher==null) return;
			if(haveStudents(id,session)) return;
			session.delete(teacher);
			Set<Bulletin> bulletins =  teacher.getBulletins();			
			for (Bulletin bulletin : bulletins) {
				session.delete(bulletin);
			}
			Set<Project> projects =  teacher.getProjects();
			for (Project project : projects) {
				session.delete(project);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}
	
	public void deleteSpecialty(Integer spid) {
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			Specialty specialty= (Specialty)session.get(Specialty.class, spid);
			if(specialty==null) return;
			session.delete(specialty);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx != null) {
				tx.commit();
				tx = null;
			}
		}
	}
	
	public boolean haveStudents(String id, Session session){
		int count = 0;
		try {
			String hql = "select count(*) from StudentPC where teacher ="+id+"";
			Query query = session.createQuery(hql);
			count=((Long)query.uniqueResult()).intValue();
			if(count!=0) return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	
	@Override
	public boolean saveTeacher(Teacher teacher, Integer spid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		Teacher teacher2 = null;
		Specialty specialty = null;
		try {
			specialty = (Specialty)session.get(Specialty.class, spid);
			if(specialty==null){
				return false;
			}
			teacher2 = (Teacher)session.get(Teacher.class, teacher.getId());
			if(teacher2==null){
				teacher.setSpecialty(specialty);;
				session.merge(teacher);
			}else{
				return false;
			}
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
	
	@SuppressWarnings("null")
	public boolean saveSpecialty(String dname,Specialty specialty ) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		Specialty specialty2 = null;
		Department department = null;
		try {
			String hql = "from Department where dname='"+dname+"'";
			Query query = session.createQuery(hql);			
			department = (Department)query.uniqueResult();
			if(department==null){
				return false;
			}
			specialty2 = (Specialty)session.get(Specialty.class, specialty.getSpid());
			if(specialty2==null){
				specialty.setDepartment(department);
				session.save(specialty);
			}else{
				return false;
			}
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
	public boolean updateTeacher(Teacher teacher, Integer spid){
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		Teacher teacher2 = null;
		Specialty specialty = null;
		try {
			specialty = (Specialty)session.get(Specialty.class, spid);
			if(specialty==null){
				return false;
			}
			teacher2 = (Teacher)session.get(Teacher.class, teacher.getId());
			if(teacher2==null){
				return false;
			}else{
				if(teacher2.getSpecialty().getSpid()!=spid){
					teacher2.setSpecialty(specialty);
					session.merge(teacher2);
				}else{
					teacher2.setName(teacher.getName());
				}
			}
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
	
	public boolean updateSpecialty(String dname,Specialty Specialty){
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		Department department = null;
		Specialty specialty2 = null;
		try {
			String hql = "from Department where dname='"+dname+"'";
			Query query = session.createQuery(hql);			
			department = (Department)query.uniqueResult();
			if(department==null){
				return false;
			}
			specialty2 = (Specialty)session.get(Specialty.class, Specialty.getSpid());
			if(specialty2==null){
				return false;
			}else{
				if(!specialty2.getDepartment().getDname().equals(dname)){
					specialty2.setDepartment(department);
					specialty2.setSpname(Specialty.getSpname());
					session.merge(specialty2);
				}else{
					specialty2.setSpname(Specialty.getSpname());
				}
			}
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
	public Pager getDepartmentsByDepartmentId(int currentPage,String id,String order){
		
		Pager pager = new Pager();
		Transaction tx = null;
		
		int maxSize = 8;
		String hql = "";
		pager.setCurrentPage(currentPage);
		pager.setPageSize(maxSize);
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			int count = getDepartmentsCount(id,session);
			hql="from Department where id like'%"+id+"%'";
			if(order!=null){
				hql=hql+" order by "+order;
			}			
			Query query = session.createQuery(hql);
			query.setFirstResult((currentPage-1)*maxSize);
			query.setMaxResults(maxSize);
			List<Department> list = query.list();
			pager.setList(list);
			pager.setCount(count);
			pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));
			return pager;
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
	
	public Pager getSpecialtysBySpecialtyId(int currentPage,String id,String order){
		Pager pager = new Pager();
		Transaction tx = null;
		
		int maxSize = 8;
		String hql = "";
		pager.setCurrentPage(currentPage);
		pager.setPageSize(maxSize);
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			int count = getSpecialtysCount(id,session);
			hql="from Specialty where id like'%"+id+"%'";
			if(order!=null){
				hql=hql+" order by "+order;
			}			
			Query query = session.createQuery(hql);
			query.setFirstResult((currentPage-1)*maxSize);
			query.setMaxResults(maxSize);
			List<Specialty> list = query.list();
			List<SpecialtyInfromation> list2 = new ArrayList<SpecialtyInfromation>();
			if(list.size()>0){
				for (Specialty specialty : list) {
					SpecialtyInfromation info = new SpecialtyInfromation();
					info.setSpid(specialty.getSpid());
					info.setSpname(specialty.getSpname());
					if(specialty.getDepartment()!= null){
						info.setDeptid(specialty.getDepartment().getDid());
						info.setDeptname(specialty.getDepartment().getDname());
					}
					list2.add(info);					
				}
			}
			
			for (SpecialtyInfromation spInfo : list2) {
				System.out.println(spInfo.getDeptid()+"------"+spInfo.getDeptname());
			}
			pager.setList(list2);
			pager.setCount(count);
			pager.setTotalPage((int)Math.ceil((double)count/(double)maxSize));
			return pager;
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
	

	
	public int getDepartmentsCount(String id, Session session){
		int count = 0;
		try {
			String hql = "select count(*) from Department where id like'%"+id+"%'";
			Query query = session.createQuery(hql);
			count=((Long)query.uniqueResult()).intValue();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		} 
	}
	
	@Override
	public void deleteDepartment(Integer id) {
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		try {
			Department dept = (Department)session.get(Department.class, id);
			if(dept==null) return;
			session.delete(dept);			
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
	public boolean saveDepartment(Integer did, String dname) {
		System.out.println(did+dname);
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		Department department = null;
		try {
			department = (Department)session.get(Department.class, did);
			if(department==null){
				department = new Department();
				department.setDid(did);
				department.setDname(dname);
				session.save(department);
			}else{
				return false;
			}
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
	public boolean updateDepartment(Integer did, String dname) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = MyHibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		tx = session.beginTransaction();
		Department department = null;
		try {
			department = (Department)session.get(Department.class, did);
			if(department!=null){
				department.setDid(did);
				department.setDname(dname);
			}else{
				return false;
			}
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
	
	
	public int getSpecialtysCount(String spid, Session session){
		int count = 0;
		try {
			String hql = "select count(*) from Specialty where id like'%"+spid+"%'";
			Query query = session.createQuery(hql);
			count=((Long)query.uniqueResult()).intValue();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		} 
}

}
