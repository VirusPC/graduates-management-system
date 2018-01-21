<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Project" %>
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
    	<from>
    		<table align="center" width="110">
    			<tr><td><textarea cols="70" rows="15" readonly="readonly"><s:iterator value="#session.project.list" var="pro"><s:if test="#pro.pid==#parameters.pid[0]"><s:property value="#pro.pdesc"/></s:if></s:iterator>
				</textarea></td></tr>
    		</table>
    	</from>
  </body>
</html>
