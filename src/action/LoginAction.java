package action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends SuperAction{
	
	public String login(){
		String user = request.getParameter("user");
		System.out.println(user);
		if(user==null)
			return "login_failure";
		else if("admin".equals(user))
			return "admin_login";
		else if("student".equals(user))
			return "student_login";
		else if("teacher".equals(user))
			return "teacher_login";
		return "login_failure";
	}
	
	public String logout(){
		session.removeAttribute("teacher");
		session.removeAttribute("student");
		session.removeAttribute("admin");
//		session.removeAttribute("result");
//		session.removeAttribute("document");
//		session.removeAttribute("bulletin");
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//�û��������벻��Ϊ��
		if(request.getParameter("id")!=null&&request.getParameter("password")!=null){
			if("".equals(request.getParameter("id").trim())){
				this.addFieldError("usernameError", "�˺Ų���Ϊ�գ�");
			}
			if("".equals(request.getParameter("password").trim())){
				this.addFieldError("passwordError", "���벻��Ϊ�գ�");
			}
		}
	}
}
