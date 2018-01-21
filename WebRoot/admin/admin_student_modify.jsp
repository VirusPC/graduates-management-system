<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Pager" %>
<%@ page import="entity.StudentPC" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <base href="<%=basePath%>">
    
    <title>学生信息管理系统——管理学生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


  </head>
  
  <body  style="background-image:url(picture/login_bgx.gif); background-size:cover;">
 	<jsp:include page="admin_menu.jsp"></jsp:include>
	
	 	<s:iterator value="#session.students.list" var="stu">
    	<s:if test="#parameters.stuid[0]==#stu.id">	
    	<s:set name="student" value="#stu"/>
    	</s:if>
    	</s:iterator>
	
   <div >
	<form  id="f" method="post">
			<table align="center" >
				<tr><td>学号：</td><td><input id="stuid" name="stuid" type="text" value="<s:property value="#student.id"/>" class="form-control"></td></tr>

		<script>
		var form = document.getElementById("f");
		var input = document.getElementById("stuid");
		var id = input.value;
		if(id!=""){
		form.action="admin/admin_modifyStudent.action";
		input.setAttribute("readonly", "readonly");
		}else{
		form.action="admin/admin_addStudent.action";
		}
		</script>
				<tr><td>姓名：</td><td><input name="name" type="text" value="<s:property value="#student.name"/>" class="form-control"></td></tr>
				<%-- <tr><td>系：</td><td><select name="department">
				<option value=""></option>
	 			<option value="student">学生</option>
	 			</select></td></tr>
				<tr><td>专业：</td><td><select name="specialty">
	 			<option value=""></option>
	 			<option value="student">学生</option>	 			
	 			</select></td></tr>--%>
	 			<tr><td>毕业时间：</td><td><input name="graduation" type="text" value="<s:date  name="#student.graduation" format="yyyy年MM月dd日"/>"  placeholder="xxxx年xx月xx日" class="form-control"></td></tr>
				<tr><td>指导老师教职工号：</td><td><input name="tid" type="text" value="<s:property value="#student.tid"/>" class="form-control"></td></tr>				
				<tr><td colspan="2" align="center"><input type="submit" value="提交" class="btn btn-default"></td></tr>
			</table>
		</form>
  </div>
  <p align="center">${updateStudentResult}</p>
  </body>
</html>
