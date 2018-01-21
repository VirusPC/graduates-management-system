<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
   <div >
    <form action="admin/admin_changePasswordForAdmin.action" method="post">
  	<table align="center" width="500px">
  		<tr>
 	  		<td >原密码：</td>
  			<td><input type="password" size="30" name="oldPassword" class="form-control"></td>
 		
  		<tr>
  			<td>新密码：</td>
  			<td><input type="password" size="30" name="newPassword1" class="form-control"></td>
  		</tr>
  		 <tr>
  			<td>新密码确认：</td>
  			<td><input type="password" size="30" name="newPassword2" class="form-control"></td>
  		</tr>
  		 <tr>
  			<td colspan="2" align="center"><input type="submit" value="确认" class="btn btn-default"></td>
  		</tr>
  	</table>
  	</form>
  	<p align="center">${passwordError}</p>
  </div>
  </body>
</html>
