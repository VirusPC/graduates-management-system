<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Teacher" %>
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
 	<jsp:include page="student_menu.jsp"></jsp:include>
   <div >
  	<form >
  	<table align="center" width="500px" >
  	  	<tr>
  			<td>教职工号</td>
  			<td><input type="text" size="30" name="id" readonly="readonly" value='<s:property value="#session.student.teacher.id"/>' class="form-control"></td>
  		</tr>
  		<tr>
 	  		<td >姓名</td>
  			<td><input type="text" size="30" name="name" class="form-control" value='<s:property value="#session.student.teacher.name"/>' readonly="readonly"></td>
  		</tr>
  		<tr>
 	  		<td >联系电话</td>
  			<td><input type="text" size="30" name="name" class="form-control" value='<s:property value="#session.student.teacher.tel"/>' readonly="readonly"></td>
  		</tr>
  		<tr>
 	  		<td >电子邮箱</td>
  			<td><input type="text" size="30" name="name" class="form-control" value='<s:property value="#session.student.teacher.email"/>' readonly="readonly"></td>
  		</tr>
  	</table>
  	</form>
  </div>
  </body>
</html>
