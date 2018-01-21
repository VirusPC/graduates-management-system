package action;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.StudentDAO;
import serviceImpl.StudentDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Department;
import entity.Document;
import entity.Pager;
import entity.Project;
import entity.StudentInformation;
import entity.StudentPC;
import entity.Teacher;

public class StudentAction extends SuperAction implements ModelDriven<StudentPC>  {
	StudentPC student = new StudentPC();
	
	@SkipValidation
	public String login(){
		StudentDAO sdao = new StudentDAOImpl();
		StudentPC student2 = sdao.studentLogin(student);
		if(student2!=null){
			session.setAttribute("student", student2);
			return "student_login_success";
		}else{
			this.addFieldError("loginError", "账号或密码错误！");
			return "student_login_failure";
		}
	}
	
	public String getTeacher(){
		StudentDAO sdao = new StudentDAOImpl();
		StudentPC student = null;
		Teacher teacher = null;
		student = (StudentPC)session.getAttribute("student");		
		if(student!=null)
			teacher = sdao.getTeacherByStudentId(student.getId());
		if(teacher!=null){
			student.setTeacher(teacher);
			session.setAttribute("student", student);
		}else{
			this.addFieldError("loginError", "账号或密码错误！");
		}
		return "teacher_query_success";
	}
	
	public String getTime(){
		session.setAttribute("now", new Date());
		StudentDAO sdao = new StudentDAOImpl();
		StudentPC student = null;
		Teacher teacher = null;
		student = (StudentPC)session.getAttribute("student");		
		if(student!=null)
			teacher = sdao.getTeacherByStudentId(student.getId());
		if(teacher!=null){
			student.setTeacher(teacher);
			session.setAttribute("student", student);
			if(teacher.getTime2()!=null)
				session.setAttribute("before", student.getTeacher().getTime2());
			if(teacher.getTime3()!=null)	
				session.setAttribute("during", student.getTeacher().getTime3());
			if(teacher.getEnd()!=null)	
				session.setAttribute("after", student.getTeacher().getEnd());

		}else{
			this.addFieldError("getTimeError", "获取错误！");
		}
		return "time_query_success";
	}
//	public String getComment(){
//		StudentDAO sdao = new StudentDAOImpl();
//		StudentPC student = null;
//		student = (StudentPC)session.getAttribute("student");
//		student=sdao.getTimeAndComment(student);
//		if(student!=null){
//			session.setAttribute("student", student);
//		}else{
//			this.addFieldError("getCommentError", "获取错误！");
//		}
//		return "time_query_success";
//	}
	
	public String queryBulletinByStudentId(){
		int currentPage;
		String id = null;
		StudentPC student = null;
		String currentPageString=request.getParameter("currentPage");
		if(currentPageString!=null){
			currentPage=Integer.parseInt(currentPageString);
		}else{
			currentPage=1;
		}
		student=(StudentPC)session.getAttribute("student");
		if(student!=null){
			id = student.getId();
			StudentDAO bdao = new StudentDAOImpl();
			Pager pager = bdao.getBulletinByStudentId(currentPage, id);
			session.setAttribute("bulletin", pager);
		}
		
		return "query_bulletin_success";
	}
	
	public String queryProjectByStudentId(){
		int currentPage;
		String id = null;
		StudentPC student = null;
		String currentPageString=request.getParameter("currentPage");
		if(currentPageString!=null){
			currentPage=Integer.parseInt(currentPageString);
		}else{
			currentPage = 1;
		}
			student=(StudentPC)session.getAttribute("student");
			if(student!=null){
				id = student.getId();
				StudentDAO bdao = new StudentDAOImpl();
				student.setTeacher(bdao.getTeacherByStudentId(id));
				session.setAttribute("student", student);
				Pager pager = bdao.getProjectById(currentPage, id);
				System.out.println(((Project)(pager.getList().get(0))).getPname());
				session.setAttribute("project", pager);
			}
		
		return "query_project_success";
	}

	public String queryStudentByStudentId(){
		StudentInformation si = null;
		Department department = null;
		if(session.getAttribute("student")==null)
			return "student_query_success";
		String id = null;
		id = ((StudentPC)session.getAttribute("student")).getId();
		if(id==null){
			return "student_query_success";
		}
		StudentDAO sdao = new StudentDAOImpl();
		si = sdao.getStudentInformById(id);
		if(si!=null){
			session.setAttribute("stuInfo", si);
			
		}
		return "student_query_success";
	}
	
	public String changePasswordForStudent(){
		session.removeAttribute("passwordError");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		if(oldPassword==null || newPassword1==null || newPassword2==null){
			return "student_changePassword_success";
		}
		if(confirmPasswordFormat(oldPassword,newPassword1,newPassword2)){
			String id = ((StudentPC)session.getAttribute("student")).getId();
			if(id==null){
				return "student_changePassword_success";
			}
			StudentDAO sdao = new StudentDAOImpl();
			if(sdao.changePassword(id, oldPassword, newPassword1)){
				session.setAttribute("passwordError", "修改密码成功");
			}else{
				session.setAttribute("passwordError", "修改密码失败");
			}
		}
		return "student_changePassword_success";
	}
	
	public String selectProject(){
		int select;
		String selectString=request.getParameter("select");
		if(selectString==null)
			return "student_selectProject_success";
		select = Integer.parseInt(selectString);
		StudentPC student = null;
		StudentDAO sdao = new StudentDAOImpl();
		student = (StudentPC)session.getAttribute("student");
		if(student==null){
			return "student_selectProject_success";
		}
		String id = student.getId();
		student = sdao.selectProject(id, select);
		if(student!=null){
			session.setAttribute("student", student);
		}else{
			session.setAttribute("selectError", "选课出错");
		}
		return "student_selectProject_success";
	}
	
	public String deleteProject(){
		StudentPC student = (StudentPC)session.getAttribute("student");
		System.out.println(student.getTeacher()==null);
		StudentDAO dao = new StudentDAOImpl();
		dao.deleteProjectById(student.getId());
		student.setProject(null);
		session.setAttribute("student", student);
		System.out.println(student.getTeacher().getTime1());
		System.out.println(student.getTeacher().getTime2());
		System.out.println(student.getTeacher().getTime3());
		System.out.println(student.getTeacher().getEnd());
		return "student_deleteProject_success";
	}
	
	public String getDocuments(){
		List<Document> documents = new ArrayList();
		StudentPC student=null;
		student = (StudentPC)session.getAttribute("student");
		if(student!=null&&request.getParameter("period")!=null){

			String path = application.getRealPath("/resource/student/"+student.getId()+"/"+request.getParameter("period"));
			System.out.println("path:@@@"+path);
			File file = new File(path);
			if(!file.exists()){
				file.mkdirs();
			}else{
				String[] documentNames = file.list();
				for (String documentName : documentNames) {
					documents.add(new Document(path,documentName));
				}
			}
		}
		session.setAttribute("documents", documents);
		return "document";
	}
	
	public String deleteDocument(){
		request.setAttribute("period", request.getParameter("period"));
		session.removeAttribute("result");
		StudentPC student=null;
		student = (StudentPC)session.getAttribute("student");
		if(student!=null&&request.getParameter("period")!=null&&request.getParameter("filename")!=null){
			String path = application.getRealPath("/resource/student/"+student.getId()+"/"+request.getParameter("period")+"/"+request.getParameter("filename"));
			System.out.println("path:@@@"+path);
			File file = new File(path);
			if(!file.exists()){
				session.setAttribute("result", "删除失败");
			}else{
				file.delete();
			}
		}
		return "delete_success";
	}
	
	public String skipToUpload(){
		session.removeAttribute("result");
		StudentPC student;
		//request.Parameter("period",request.getParameter("period"));
		if(session.getAttribute("student")==null||request.getParameter("period")==null){
			session.setAttribute("result", "上传失败");
			return "document";
		}
		student = (StudentPC)session.getAttribute("student");
		request.setAttribute("userPath", "/student/"+student.getId()+"/"+request.getParameter("period"));
		System.out.println(request.getAttribute("userPath"));
		return "skipToUpload";
	}
	
	public String skipToDownload(){
		session.removeAttribute("result");
		StudentPC student;
		if(session.getAttribute("student")==null||request.getParameter("period")==null){
			session.setAttribute("result", "下载失败");
			return "document";
		}
		student = (StudentPC)session.getAttribute("student");
		request.setAttribute("userPath", "/student/"+student.getId()+"/"+request.getParameter("period"));
		System.out.println("userPath"+request.getAttribute("userPath"));
		return "skipToDownload";
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
	
	
	@SkipValidation
	@Override
	public StudentPC getModel() {
		// TODO Auto-generated method stub
		return this.student;
	}
	
	@Override
	public void validate() {
		StudentPC student = (StudentPC)session.getAttribute("student");
		if(student==null)
			this.addFieldError("acerror", "");
	}
	
}
