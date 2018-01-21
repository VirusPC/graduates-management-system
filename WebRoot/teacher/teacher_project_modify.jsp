<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Pager" %>
<%@ page import="entity.Project" %>
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
 	
 	    <s:iterator value="#session.projects.list" var="pro">
    	<s:if test="#parameters.pid[0]==#pro.pid">
    	<s:set name="pid" value="#pro.pid" scope="session"/>   	
    	<s:set name="project" value="#pro"/>
    	</s:if>
    	</s:iterator>
 	
   <div >
  	  <form action="teacher/teacher_modifyProject.action" align="center" method="post">
  		<table align="center">
  		<tr><td align="center">标题</td></tr>
  		<tr><td align="center"><input type="text" name="pname" value="<s:property value="#project.pname"/>" /></td></tr>
  		<tr><td align="center">描述</td></tr>
  		<tr><td align="center">
  		<textarea  name="pdesc" cols="100" rows="10"><s:property value="#project.pdesc"/></textarea>
  		</td></tr>
    	<tr>
    	<td colspan="2" align="center"><input type="submit" value="提交" class="btn btn-default"/></td>
    	</tr>
    	</table>
    </form>
  </div>
  </body>
</html>
