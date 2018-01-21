package action;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.TeacherDAO;
import serviceImpl.TeacherDAOImpl;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import entity.Bulletin;
import entity.Document;
import entity.Pager;
import entity.Project;
import entity.StudentPC;
import entity.Teacher;

public class TeacherAction extends SuperAction implements ModelDriven<Teacher>  {
	Teacher teacher = new Teacher();
	
	@SkipValidation
	public String login(){
		TeacherDAO sdao = new TeacherDAOImpl();
		teacher = sdao.teacherLogin(teacher);
		if(teacher!=null){
			session.setAttribute("teacher", teacher);
			return "teacher_login_success";
		}else{
			this.addFieldError("loginError", "账号或密码错误！");
			return "teacher_login_failure";
		}
	}
	
	public String queryBulletinsByTeacherId(){
		int currentPage;
		String id = null;
		Teacher teacher = null;
		String currentPageString=request.getParameter("currentPage");
		if(currentPageString!=null){
			currentPage=Integer.parseInt(currentPageString);
		}else{
			currentPage=1;
		}
		teacher=(Teacher)session.getAttribute("teacher");
		if(teacher!=null){
			id = teacher.getId();
			TeacherDAO bdao = new TeacherDAOImpl();
			Pager pager = bdao.getBulletinsById(currentPage, id);
			session.setAttribute("bulletin", pager);
		}
		return "bulletin_query_success";
	}
	
	public String deleteBulletin(){
		Integer id;
		if(request.getParameter("bid")!=null){
			id = Integer.parseInt(request.getParameter("bid"));
			TeacherDAO dao = new TeacherDAOImpl();
			dao.deleteBulletin(id);
		}
		return "bulletin_delete_success";
	}
	
	public String modifyBulletin(){
		Integer id;
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		Bulletin bulletin = new Bulletin();
		if(request.getParameter("bname")!=null&&request.getParameter("content")!=null
				&&!"".equals(request.getParameter("bname"))&&!"".equals(request.getParameter("content"))){
			System.out.println(session.getAttribute("bid")+request.getParameter("bname")+request.getParameter("content"));
			if(session.getAttribute("bid")!=null){
				bulletin.setBid((Integer)session.getAttribute("bid"));
				session.removeAttribute("bid");
			}
			bulletin.setBname(request.getParameter("bname"));
			bulletin.setContent(request.getParameter("content"));
			//id = Integer.parseInt(request.getParameter("bid"));
			TeacherDAO dao = new TeacherDAOImpl();
			dao.saveOrUpdateBulletin(bulletin, teacher);
		}
		return "bulletin_modify_success";
	}
	
	public String queryProjectsByTeacherId(){
		int currentPage;
		String id = null;
		Teacher teacher = null;
		String currentPageString=request.getParameter("currentPage");
		if(currentPageString!=null){
			currentPage=Integer.parseInt(currentPageString);
		}else{
			currentPage=1;
		}
		teacher=(Teacher)session.getAttribute("teacher");
		if(teacher!=null){
			id = teacher.getId();
			TeacherDAO bdao = new TeacherDAOImpl();
			Pager pager = bdao.getProjectsById(currentPage, id);
			session.setAttribute("projects", pager);
		}
		return "project_query_success";
	}
	
	public String deleteProject(){
		Integer id;
		if(request.getParameter("pid")!=null){
			id = Integer.parseInt(request.getParameter("pid"));
			TeacherDAO dao = new TeacherDAOImpl();
			dao.deleteProject(id);
		}
		return "project_delete_success";
	}
	
	public String modifyProject(){
		System.out.println(session.getAttribute("pid")+request.getParameter("pname")+request.getParameter("pdesc"));
		Integer id;
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		Project project = new Project();
		if(request.getParameter("pname")!=null&&request.getParameter("pdesc")!=null
				&&!"".equals(request.getParameter("pname"))&&!"".equals(request.getParameter("pdesc"))){
			System.out.println(session.getAttribute("pid")+request.getParameter("pname")+request.getParameter("pdesc"));
			if(session.getAttribute("pid")!=null){
				project.setPid((Integer)session.getAttribute("pid"));
				session.removeAttribute("pid");
			}
			project.setPname(request.getParameter("pname"));
			project.setPdesc(request.getParameter("pdesc"));
			TeacherDAO dao = new TeacherDAOImpl();
			dao.saveOrUpdateProject(project, teacher);
		}
		return "project_modify_success";
	}
	
	public String queryStudentsByTeacherId(){
		int currentPage;
		String id = null;
		Teacher teacher = null;
		String order = null;
		String currentPageString=request.getParameter("currentPage");
		order = request.getParameter("order");
		if(currentPageString!=null){
			currentPage=Integer.parseInt(currentPageString);
		}else{
			currentPage=1;
		}
		teacher=(Teacher)session.getAttribute("teacher");
		if(teacher!=null){
			id = teacher.getId();
			TeacherDAO bdao = new TeacherDAOImpl();
			Pager pager = bdao.getStudentsByTeacherId(currentPage, id, order);
			session.setAttribute("students", pager);
		}
		return "student_query_success";
	}
	
	public String queryStudentByTeacherId(){
		int currentPage;
		String id = null;
		Teacher teacher = null;
		String currentPageString=request.getParameter("currentPage");		
		if(currentPageString!=null){
			currentPage=Integer.parseInt(currentPageString);
		}else{
			currentPage=1;
		}
		String stuid = request.getParameter("stuid");
		teacher=(Teacher)session.getAttribute("teacher");
		if(teacher!=null){
			id = teacher.getId();
			TeacherDAO bdao = new TeacherDAOImpl();
			Pager pager = bdao.getStudentByTeacherId(currentPage, id, stuid);
			session.setAttribute("students", pager);
		}
		return "student_query_success";
	}
	
	public String changePasswordForTeacher(){
		session.removeAttribute("passwordError");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		if(oldPassword==null || newPassword1==null || newPassword2==null){
			return "teacher_changePassword_success";
		}
		if(confirmPasswordFormat(oldPassword,newPassword1,newPassword2)){
			String id = ((Teacher)session.getAttribute("teacher")).getId();
			if(id==null){
				return "teacher_changePassword_success";
			}
			TeacherDAO dao = new TeacherDAOImpl();
			if(dao.changePassword(id, oldPassword, newPassword1)){
				session.setAttribute("passwordError", "修改密码成功");
			}else{
				session.setAttribute("passwordError", "修改密码失败");
			}
		}
		return "teacher_changePassword_success";
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
	
	public String modifyTeacherInformation(){
		String id = ((Teacher)session.getAttribute("teacher")).getId();
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		if(id!=null&&email!=null&&tel!=null){
			Teacher teacher = new Teacher();
			teacher.setId(id);
			teacher.setEmail(email);
			teacher.setTel(tel);
			TeacherDAO dao = new TeacherDAOImpl();
			teacher =dao.updateTeacherInformation(teacher);
			if(teacher!=null){
				System.out.println("teacher information not null");
				session.setAttribute("teacher", teacher);
			}
		}
		return "teacher_information_update_success";
	}
	
	public String modifyTime(){
		String id = ((Teacher)session.getAttribute("teacher")).getId();
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		String time3 = request.getParameter("time3");
		String end = request.getParameter("end");
		if(id!=null&&time1!=null&&time2!=null&&time3!=null&&end!=null){
			Teacher teacher = new Teacher();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			teacher.setId(id);
			try {
			teacher.setTime1(sdf.parse(time1));
			teacher.setTime2(sdf.parse(time2));
			teacher.setTime3(sdf.parse(time3));
			teacher.setEnd(sdf.parse(end));
			} catch (ParseException e) {
				request.setAttribute("timeResult", "格式出错");
				return "teacher_time_update_success";
			}
			
			TeacherDAO dao = new TeacherDAOImpl();
			teacher =dao.setTime(teacher);
			if(teacher!=null){
				request.setAttribute("timeResult", "修改成功");
				session.setAttribute("teacher", teacher);
			}else{
				request.setAttribute("timeResult", "修改失败");
			}
		}else{
			request.setAttribute("timeResult", "修改失败");
		}
		return "teacher_time_update_success";
	}
	
	public String check(){
		String gradeString = request.getParameter("grade");
		String comment = request.getParameter("comment");
		String stuid = request.getParameter("stuid");
		if(gradeString!=null&&comment!=null&&stuid!=null){
			Integer grade = Integer.parseInt(gradeString);
			TeacherDAO dao = new TeacherDAOImpl();
			dao.check(stuid, grade, comment);
		}else{
			request.setAttribute("checkResult", "修改失败");
		}
		return "teacher_check_success";
	}
	
	public String getDocuments(){
		List<Document> documents = new ArrayList();
		String stuid = null;
		String period = null;
		stuid = request.getParameter("stuid");
		period = request.getParameter("period");
		if(stuid!=null&&period!=null){
			String path = application.getRealPath("/resource/student/"+stuid+"/"+period);
			System.out.println("path:@@@"+path);
			File file = new File(path);
			if(!file.exists()){
				file.mkdirs();
			}else{
				String[] documentNames = file.list();
				for (String documentName : documentNames) {
					documents.add(new Document(path,documentName,"/student/"+stuid+"/"+period));
				}
			}
		}
		session.setAttribute("documents", documents);
		return "document";
	}
	
	public String skipToDownload(){
		if(request.getParameter("userPath")==null||request.getParameter("filename")==null){
			return "download_error";
		}
		request.setAttribute("userPath", request.getParameter("userPath"));
		System.out.println(request.getAttribute("userPath"));
		return "skipToDownload";
	}
	
	
	@SkipValidation
	@Override
	public Teacher getModel() {
		// TODO Auto-generated method stub
		return this.teacher;
	}
	
//	@InputConfig(methodName="input2")   
	@Override
	public void validate() {
		teacher = (Teacher)session.getAttribute("teacher");
		if(teacher==null)
			this.addFieldError("acerror", "");
	}
}
