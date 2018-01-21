package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ModelDriven;

import entity.Admin;
import entity.Pager;
import entity.Specialty;
import entity.SpecialtyInfromation;
import entity.StudentPC;
import entity.Teacher;
import service.AdminDAO;
import serviceImpl.AdminDAOImpl;


public class AdminAction extends SuperAction implements ModelDriven<Admin>  {
	Admin admin = new Admin();
	@SkipValidation
	public String login(){
		AdminDAO dao = new AdminDAOImpl();
		admin.setId(request.getParameter("id"));
		admin.setPassword(request.getParameter("password"));
		admin = dao.adminLogin(admin);
		if(admin!=null){
			session.setAttribute("admin", admin);
			return "admin_login_success";
		}else{
			this.addFieldError("loginError", "账号或密码错误！");
			return "admin_login_failure";
		}
	}
	
	public String queryStudentsByStudentsId(){
		int currentPage;
		String id = null;
		String order = null;
		String currentPageString=request.getParameter("currentPage");
		order = request.getParameter("order");
		if(currentPageString!=null){
			currentPage=Integer.parseInt(currentPageString);
		}else{
			currentPage=1;
		}
			id = request.getParameter("stuid");
			if(id==null){
				id="";
			}
			AdminDAO bdao = new AdminDAOImpl();
			Pager pager = bdao.getStudentsByStudentId(currentPage, id, order);
			session.setAttribute("students", pager);
		return "student_query_success";
	}
	
	public String changePasswordForAdmin(){
		session.removeAttribute("passwordError");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		if(oldPassword==null || newPassword1==null || newPassword2==null){
			return "admin_changePassword_success";
		}
		if(confirmPasswordFormat(oldPassword,newPassword1,newPassword2)){
			String id = ((Admin)session.getAttribute("admin")).getId();
			if(id==null){
				return "admin_changePassword_success";
			}
			AdminDAO dao = new AdminDAOImpl();
			if(dao.changePassword(id, oldPassword, newPassword1)){
				session.setAttribute("passwordError", "修改密码成功");
			}else{
				session.setAttribute("passwordError", "修改密码失败");
			}
		}
		return "admin_changePassword_success";
	}
	
	public boolean confirmPasswordFormat(String oldPassword, String newPassword1, String newPassword2){
		if("".equals(oldPassword.trim())
				||"".equals(newPassword1.trim())
				||"".equals(newPassword2.trim())){
			session.setAttribute("passwordError", "密码不可为空！");
			return false;
		}
		if(newPassword1.equals(oldPassword)){
			session.setAttribute("passwordError", "新旧密码相同！");
			return false;
		}
		if(!newPassword1.equals(newPassword2)){
			session.setAttribute("passwordError", "新密码两次输入不相同！");
			return false;
		}
		return true;
	}
	
	public String deleteStudent(){
		String id = null;
		id = request.getParameter("stuid");
		if(id!=null){
			AdminDAO dao = new AdminDAOImpl();
			dao.deleteStudent(id);
		}
		return "student_delete_success";
	}
	
	public String modifyStudent(){
		System.out.println(request.getParameter("stuid")+request.getParameter("name")+request.getParameter("graduation")+request.getParameter("tid"));
		StudentPC student = new StudentPC();
		String stuid = request.getParameter("stuid");
		String name = request.getParameter("name");
		String graduationString = request.getParameter("graduation");
		String tid = request.getParameter("tid");
		if(!"".equals(stuid)&&!"".equals(name)
				&&!"".equals(graduationString)&&!"".equals(tid)){
			try{
				Integer.parseInt(stuid);
			}catch(Exception e){
				request.setAttribute("updateStudentResult", "账号格式出错");
				return "student_modify_success";
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			Date graduation;
			try {
				graduation = sdf.parse(graduationString);
			} catch (ParseException e) {
				e.printStackTrace();
				request.setAttribute("updateStudentResult", "时间格式出错");
				return "student_modify_success";
			}
			student.setId(stuid);
			student.setName(name);
			student.setGraduation(graduation);
			AdminDAO dao = new AdminDAOImpl();
			if(!dao.updateStudent(student, tid)){
				request.setAttribute("updateStudentResult", "更新失败");
			}else{
				request.setAttribute("updateStudentResult", "更新成功");
			}
		}else{
			request.setAttribute("updateStudentResult", "不能为空");
		}
		return "student_modify_success";
	}
	
	public String addStudent(){
		
		System.out.println(request.getParameter("stuid")+request.getParameter("name")+request.getParameter("graduation")+request.getParameter("tid"));
		StudentPC student = new StudentPC();
		String stuid = request.getParameter("stuid");
		String name = request.getParameter("name");
		String graduationString = request.getParameter("graduation");
		String tid = request.getParameter("tid");
		if(!"".equals(stuid)&&!"".equals(name)
				&&!"".equals(graduationString)&&!"".equals(tid)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			Date graduation;
			try {
				graduation = sdf.parse(graduationString);
			} catch (ParseException e) {
				e.printStackTrace();
				request.setAttribute("updateStudentResult", "格式出错");
				return "student_add_success";
			}
			student.setId(stuid);
			student.setName(name);
			student.setGraduation(graduation);
			AdminDAO dao = new AdminDAOImpl();
			if(!dao.saveStudent(student, tid)){
				request.setAttribute("updateStudentResult", "添加失败");
			}else{
				request.setAttribute("updateStudentResult", "添加成功");
			}
		}else{
			request.setAttribute("updateStudentResult", "不能为空");
		}
		return "student_add_success";
	}
	
	public String queryTeachersByTeachersId(){
		int currentPage;
		String id = null;
		String order = null;
		String currentPageString=request.getParameter("currentPage");
		order = request.getParameter("order");
		if(currentPageString!=null){
			currentPage=Integer.parseInt(currentPageString);
		}else{
			currentPage=1;
		}
			id = request.getParameter("tid");
			if(id==null){
				id="";
			}
			AdminDAO bdao = new AdminDAOImpl();
			Pager pager = bdao.getTeachersByTeacherId(currentPage, id, order);
			session.setAttribute("teachers", pager);
		return "teacher_query_success";
	}
	
	public String deleteTeacher(){
		String id = null;
		id = request.getParameter("tid");
		if(id!=null){
			AdminDAO dao = new AdminDAOImpl();
			try{
			dao.deleteTeacher(id);
			}catch(HibernateException e){
				session.setAttribute("deleteError", "删除失败");
				return "teacher_delete_success";
			}
		}else{
			session.setAttribute("deleteError", "删除失败");
		}
		return "teacher_delete_success";
	}
	
	public String modifyTeacher(){
		System.out.println(request.getParameter("tid")+request.getParameter("name")+request.getParameter("spid")+request.getParameter("tid"));
		Teacher teacher = new Teacher();
		String tid = request.getParameter("tid");
		String name = request.getParameter("name");
		String spid = request.getParameter("spid");
		if(!"".equals(tid)&&!"".equals(name)
				&&!"".equals(spid)){
			teacher.setId(tid);
			teacher.setName(name);
			AdminDAO dao = new AdminDAOImpl();
			if(!dao.updateTeacher(teacher, Integer.parseInt(spid))){
				request.setAttribute("updateTeacherResult", "更新失败");
			}else{
				request.setAttribute("updateTeacherResult", "更新成功");
			}
		}else{
			request.setAttribute("updateTeacherResult", "不能为空");
		}
		return "teacher_modify_success";
	}
	
	public String addTeacher(){
		Teacher teacher = new Teacher();
		String tid = request.getParameter("tid");
		String name = request.getParameter("name");
		String spid = request.getParameter("spid");
		if(!"".equals(tid)&&!"".equals(name)
				&&!"".equals(spid)){
			try{
				Integer.parseInt(tid);
			}catch(Exception e){
				request.setAttribute("updateTeacherResult", "账号格式出错");
				return "teacher_add_success";
			}
			teacher.setId(tid);
			teacher.setName(name);
			AdminDAO dao = new AdminDAOImpl();
			if(!dao.saveTeacher(teacher, Integer.parseInt(spid))){
				request.setAttribute("updateTeacherResult", "更新失败");
			}else{
				request.setAttribute("updateTeacherResult", "更新成功");
			}
		}else{
			request.setAttribute("updateTeacherResult", "不能为空");
		}
		return "teacher_add_success";
	}
	
	public String addSpecialty(){
		Specialty specialty = new Specialty();
		String spid = request.getParameter("spid");
		String deptname = request.getParameter("deptname");
		String spname = request.getParameter("spname");
		if(spid==null||deptname==null||spname==null){
			return "specialty_add_success";
		}
		if(!"".equals(spid.trim())&&!"".equals(deptname.trim())&&!"".equals(spname.trim())){
			try{
				 int sptid = Integer.parseInt(spid);
			}catch(Exception e){
				request.setAttribute("updateDepartmentResult", "账号格式出错");
				return "specialty_add_success";
			}
			specialty.setSpid(Integer.parseInt(spid));
			specialty.setSpname(spname);
			AdminDAO dao = new AdminDAOImpl();
			if(!dao.saveSpecialty(deptname, specialty)){
				request.setAttribute("updateDepartmentResult", "更新失败");
			}else{
				request.setAttribute("updateDepartmentResult", "更新成功");
			}
		}else{
				request.setAttribute("updateDepartmentResult", "不能为空");
		}
		return "specialty_add_success";
	}
	
	public String queryDepartmentsByDepartmentsId(){
		int currentPage;
		String deptid = null;
		String order = null;
		String currentPageString=request.getParameter("currentPage");
		order = request.getParameter("order");
		if(currentPageString!=null){
			currentPage=Integer.parseInt(currentPageString);
		}else{
			currentPage=1;
		}
		deptid = request.getParameter("deptid");
		if(deptid!=null){
			try{
				Integer.parseInt(deptid);
			}catch(Exception e){}
		}
		else{
			deptid="";
		}
		AdminDAO dao = new AdminDAOImpl();
		Pager pager = dao.getDepartmentsByDepartmentId(currentPage, deptid, order);
		session.setAttribute("departments", pager);
		return "department_query_success";
	}
	
	public String querySpecialtysBySpecialtysId(){
		int currentPage;
		String speid = null;
		String order = null;
		String currentPageString=request.getParameter("currentPage");
		order = request.getParameter("order");
		if(currentPageString!=null){
			currentPage=Integer.parseInt(currentPageString);
		}else{
			currentPage=1;
		}
		speid = request.getParameter("speid");
		if(speid!=null){
			try{
				Integer.parseInt(speid);
			}catch(Exception e){}
			request.setAttribute("speid2", speid);
		}
		else{
			speid="";
		}
		AdminDAO dao = new AdminDAOImpl();
		Pager pager = dao.getSpecialtysBySpecialtyId(currentPage, speid, order);
		List<SpecialtyInfromation> list = (List<SpecialtyInfromation>)pager.getList();
		for (SpecialtyInfromation spInfo : list) {
			System.out.println(spInfo.getDeptid()+"++++++++"+spInfo.getDeptname());
		}
		session.setAttribute("specialtys", pager);
		return "specialty_query_success";
	}
	
	public String deleteDepartment(){
		String idString = null;
		idString = request.getParameter("deptid");
		if(idString!=null){
			if(!"".equals(idString.trim())){
				Integer id = null;				
				try{
					id = Integer.parseInt(idString);
				}catch(Exception e){
					return "department_delete_success";
				}
				AdminDAO dao = new AdminDAOImpl();
				dao.deleteDepartment(id);
			}
		}
		return "department_delete_success";
	}
	
	public String deletespecialty(){
		String idString = null;
		idString = request.getParameter("speid");
		System.out.println(idString);
		if(idString!=null){
			if(!"".equals(idString.trim())){
				Integer id = null;				
				try{
					id = Integer.parseInt(idString);
				}catch(Exception e){
					return "specialty_delete_success";
				}
				AdminDAO dao = new AdminDAOImpl();
				dao.deleteSpecialty(id);
			}
		}
		return "specialty_delete_success";
	}
	
	public String addDepartment(){
		String deptidString = request.getParameter("deptid");
		String deptname = request.getParameter("deptname");
		if(deptidString==null||deptname==null){
			return "department_add_success";
		}
		if(!"".equals(deptidString.trim())&&!"".equals(deptname.trim())){
			Integer deptid = null;			
			try{
				deptid = Integer.parseInt(deptidString);
			}catch(Exception e){
				request.setAttribute("updateDepartmentResult", "系号必须为数字");
				return "department_add_success";
			}
			AdminDAO dao = new AdminDAOImpl();
			if(!dao.saveDepartment(deptid, deptname)){
				request.setAttribute("updateDepartmentResult", "更新失败");
			}else{
				request.setAttribute("updateDepartmentResult", "更新成功");
			}
		}else{
			request.setAttribute("updateDepartmentResult", "不能为空");
		}
		return "department_add_success";
	}
	
	public String modifyDepartment(){
		String deptidString = request.getParameter("deptid");
		String deptname = request.getParameter("deptname");
		if(deptidString==null||deptname==null)
			return "department_modify_success";
		if(!"".equals(deptidString.trim())&&!"".equals(deptname.trim())){
			Integer deptid = null;
			
			try{
				deptid = Integer.parseInt(deptidString);
			}catch(Exception e){
				request.setAttribute("updateDepartmentResult", "系号必须为数字");
			}
			AdminDAO dao = new AdminDAOImpl();
			if(!dao.updateDepartment(deptid, deptname)){
				request.setAttribute("updateDepartmentResult", "更新失败");
			}else{
				request.setAttribute("updateDepartmentResult", "更新成功");
			}
		}else{
			request.setAttribute("updateDepartmentResult", "不能为空");
		}
		return "department_modify_success";
	}
	
	public String modifySpecialty(){
		String spidString = request.getParameter("spid");
		String deptname = request.getParameter("deptname");
		String spname = request.getParameter("spname");
		if(spidString==null||deptname==null || spname == null)
			return "specialty_modify_success";
		if(!"".equals(spidString.trim())&&!"".equals(deptname.trim())&&!"".equals(spname.trim())){
			Integer spid = null;
			
			try{
				spid = Integer.parseInt(spidString);
			}catch(Exception e){
				request.setAttribute("updateDepartmentResult", "专业号必须为数字");
			}
			Specialty specialty = new Specialty();
			specialty.setSpid(spid);
			specialty.setSpname(spname);
			AdminDAO dao = new AdminDAOImpl();
			if(!dao.updateSpecialty(deptname,specialty)){
				request.setAttribute("updateDepartmentResult", "更新失败");
			}else{
				request.setAttribute("updateDepartmentResult", "更新成功");
			}
		}else{
			request.setAttribute("updateDepartmentResult", "不能为空");
		}
		return "specialty_modify_success";
	}
	
	@SkipValidation
	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return this.admin;
	}
	
	@Override
	public void validate() {
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin==null)
			this.addFieldError("", "");
	}
}
