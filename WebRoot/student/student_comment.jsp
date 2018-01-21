<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Teacher" %>
<%@ page import="entity.StudentPC" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_login_success.jsp' starting page</title>
     <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
  	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-image:url(picture/login_bgx.gif); background-size:cover;">
  <jsp:include page="student_menu.jsp"></jsp:include>
    	<form action="" align="center" width="110">
  		<table align="center"> 
  		<tr><td align="center">分数:<s:property value="#session.student.grade"/></td></tr>		
    	<tr><td ><textarea readonly="readonly"  cols="100" rows="10"><s:property value="#session.student.comment"/></textarea>
    	</td></tr>
    	</table>
    	</form>
  </body>
</html>
