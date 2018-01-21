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
	
	 	<s:iterator value="#session.teachers.list" var="tea">
    	<s:if test="#parameters.tid[0]==#tea.id">	
    	<s:set name="teacher" value="#tea"/>
    	</s:if>
    	</s:iterator>
	
   <div >
	<form  id="f" method="post">
			<table align="center" >
				<tr><td>工号：</td><td><input id="tid" name="tid" type="text" value="<s:property value="#teacher.id"/>" class="form-control"></td></tr>

		<script>
		var form = document.getElementById("f");
		var input = document.getElementById("tid");
		var id = input.value;
		if(id!=""){
		form.action="admin/admin_modifyTeacher.action";
		input.setAttribute("readonly", "readonly");
		}else{
		form.action="admin/admin_addTeacher.action";
		}
		

		//document.write(id);
	</script>
				<tr><td>姓名：</td><td><input name="name" type="text" value="<s:property value="#teacher.name"/>" class="form-control"></td></tr>
	 			<tr><td>专业编号：</td><td><input name="spid" type="text" value="<s:property value="#teacher.spid"/>"   class="form-control"></td></tr>
				<tr><td colspan="2" align="center"><input type="submit" value="提交" class="btn btn-default"></td></tr>
			</table>
		</form>
  </div>
  <p align="center">${updateTeacherResult}</p>
  </body>
</html>
