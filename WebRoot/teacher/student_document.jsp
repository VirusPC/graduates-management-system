<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Document" %>
<%@ page import="entity.StudentPC" %>
<%@ page import="entity.Teacher" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_login_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
    <body
	style="background-image:url(picture/login_bgx.gif); background-size:cover;">
   <jsp:include page="teacher_menu.jsp"></jsp:include>
  	<div>
  	  	<form >
  	<table align="center" border="1px"
				class="table table-striped table-bordered table-hover table-condensed">
  		<tr>
  		<td width="300px">文件名</td>
  		<td width="100px"></td>
  		</tr>
  	  	<s:iterator value="#session.documents" var="document">
  	  	<tr>
  			<td><s:property value="#document.name"/></td>
  			<td><a href="teacher/teacher_skipToDownload.action?userPath=<s:property value="#document.simplePath"/>&filename=<s:property value="#document.name"/>">下载</a></td>  										
  		</tr>
  		</s:iterator> 	
  		</table>
  		</form> 					
  	<p align="center">${result}</p>
  	<s:if test="#session.result != empty">
  		<%session.removeAttribute("result"); %>
  	</s:if>
  	

	</div>
  </body>



	
</html>
