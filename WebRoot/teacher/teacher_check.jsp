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
  <jsp:include page="teacher_menu.jsp"></jsp:include>
  		
  		<s:iterator value="#session.students.list" var="stu">
    	<s:if test="#parameters.stuid[0]==#stu.id">   	
    	<s:set name="student" value="#stu"/>
    	</s:if>
    	</s:iterator>
  		
  		<form action="teacher/teacher_check.action?stuid=<s:property value="#student.id"/>" align="center" method="post">
  		<table align="center">
  		
  		   	<tr>
    	<td align="center">分数</td>
    	</tr>
    	<tr>
    	<td align="center"><input type="input" name="grade" value="<s:property value="#student.grade"/>"></td>
    	</tr>
  		<tr>
  		<td align="center">评语</td>    	
  		</tr>
    	<tr>
    	<td><textarea  name="comment" cols="100" rows="10"><s:property value="#student.comment"/></textarea></td>
    	</tr>
 	    <tr>
    	<td colspan="2" align="center"><input type="submit" value="提交"/></td>
    	</tr>
    	</table>
    	</form>
  </body>
</html>
