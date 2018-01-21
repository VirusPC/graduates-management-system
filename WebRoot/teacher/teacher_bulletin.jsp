<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Pager" %>
<%@ page import="entity.Bulletin" %>
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
    	<s:iterator value="#session.bulletin.list" var="bu">
    	<s:if test="#parameters.bid[0]==#bu.bid">
    	<s:set name="bid" value="#bu.bid" scope="session"/>   	
    	<s:set name="bn" value="#bu"/>
    	</s:if>
    	</s:iterator>
    	 
    	 
    	 
    	<form action="teacher/teacher_modifyBulletin.action" method="post" align="center" width="110">
  		<table align="center">
  		<tr><td align="center">标题</td></tr>
  		<tr><td align="center"><input type="text" name="bname" value="<s:property value="#bn.bname"/>"/></td><tr>
  		<tr><td align="center">内容</td></tr>
  		<tr><td> 		
    	<textarea name="content" cols="100" rows="10"><s:property value="#bn.content"/></textarea>
    	</td></tr>
    	<tr><td align="center">
    	<input type="submit" value="提交" class="btn btn-default">
    	</td></tr>
    	</table>
    	</form>
  </body>
</html>
