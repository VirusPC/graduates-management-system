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
   <jsp:include page="student_menu.jsp"></jsp:include>
  	<div>
  	  	<form >
  	<table align="center" border="1px"
				class="table table-striped table-bordered table-hover table-condensed">
  		<tr>
  		<td width="300px">文件名</td>
  		<td width="100px"></td>
  		<td width="100px"></td>
  		</tr>
  	  	<s:iterator value="#session.documents" var="document">
  	  	<tr>
  			<td><s:property value="#document.name"/></td>
  			<td><a href="student/student_skipToDownload.action?period=<s:property value="#parameters.period[0]"/>&filename=<s:property value="#document.name"/>">下载</a></td>  										
  			<td><a href="student/student_deleteDocument.action?period=<s:property value="#parameters.period[0]"/>&filename=<s:property value="#document.name"/>">删除</a></td>
  		</tr>
  		</s:iterator> 	
  		</table>
  		</form>
  		
  			
  	<%if(!"".equals(request.getParameter("period").trim())&&request.getParameter("period")!=null){
  	System.out.println("@@@@@"+request.getParameter("period"));
  	if(session.getAttribute(request.getParameter("period"))!=null){
  	Date date=(Date)session.getAttribute(request.getParameter("period")); 
  	System.out.println(date.getTime());
  	if(date.getTime()>new Date().getTime()){
  	//session.setAttribute("period", request.getParameter("period"));
  	%>
  	 
  	<form action="student/student_skipToUpload.action?period=<s:property value="#parameters.period[0]"/>" method="post" enctype="multipart/form-data" >
  		<table align="center">
  		<tr><td colspan="3" align="center">
  	<s:if test="5>#session.documents.size()">
  		<input type="file" name="upload"  />
  		<input type="submit" value="提交"> 
  	</s:if>
	<s:elseif test="#session.documents.size()>4">
  	<p align="center">已达到文件最大数量限制</p>
  	</s:elseif>
  	</td></tr>
  	</table>
  	</form>
  	<%}}} %>
  	<p align="center"><s:property value="#session.result"/></p>
  	<s:if test="#session.result != empty">
  		<%session.removeAttribute("result"); %>
  	</s:if>
  	

	</div>
  </body>



	
</html>
