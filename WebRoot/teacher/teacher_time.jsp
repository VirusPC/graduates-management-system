<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Teacher"%>
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
 	<jsp:include page="teacher_menu.jsp"></jsp:include>
   <div >
  	  <form action="teacher/teacher_modifyTime.action" align="center" method="post">
  		<table align="center" width="500px" >
  		<tr>
  		<td >选课和第一阶段开始日期</td>
  		<td ><input type="text" name="time1" value="<s:date  name="#session.teacher.time1" format="yyyy年MM月dd日"/>" class="form-control"></td>
  		</tr>
  		<tr>
  		<td >阶段一截止日期及阶段二开始日期</td>
  		<td ><input type="text" name="time2" value="<s:date  name="#session.teacher.time2" format="yyyy年MM月dd日"/>" class="form-control"></td>
  		</tr>
  		<tr>
  		<td >阶段二截止日期及阶段三开始日期</td>
  		<td ><input type="text" name="time3" value="<s:date  name="#session.teacher.time3" format="yyyy年MM月dd日"/>" class="form-control"></td>
  		</tr>
		<tr>
  		<td >最终截止日期</td>
  		<td ><input type="text" name="end" value="<s:date  name="#session.teacher.end" format="yyyy年MM月dd日"/>" class="form-control"></td>
  		</tr>
    	<tr>
    	<td colspan="2" align="center" ><input type="submit" value="提交"/></td>
    	</tr>
    	</table>
    </form>
    <p align="center"><s:fielderror/>${timeResult}</p>
  </div>
  </body>
</html>
