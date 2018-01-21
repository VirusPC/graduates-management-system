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
  		<td width="200px">阶段</td>
  		<td width="200px">截止日期</td>
  		<td width="150px">状态</td>
  		<td width="150px">文件管理</td>
  		</tr>
  	  	<tr>
  			<td>开题报告</td>
  			<td><s:date name="#session.student.teacher.time2" format="yyyy-MM-dd"/></td>  						
  			<td>
  			<s:if test="#session.student.teacher.time1==empty||#session.student.teacher.time1.getTime()>#session.now.getTime()">未开始</s:if>
  			<s:elseif test="#session.student.teacher.time2.getTime()>#session.now.getTime()">进行中</s:elseif>
  			<s:else>已结束</s:else>
  			</td> 				
  			<td><s:if test="#session.now.getTime()>#session.student.teacher.time1.getTime()"><a href="student/student_getDocuments.action?period=before">管理</a></s:if></td>
  		</tr>
  		<tr>
 	  		<td >中期检查表格</td>
 	  		<td><s:date name="#session.student.teacher.time3" format="yyyy-MM-dd"/></td>
  			<td>
  			<s:if test="#session.student.teacher.time2==empty||#session.student.teacher.time2.getTime()>#session.now.getTime()">未开始</s:if>
  			<s:elseif test="#session.student.teacher.time3.getTime()>#session.now.getTime()">进行中</s:elseif>
  			<s:else>已结束</s:else>
			</td>
  			<td><s:if test="#session.now.getTime()>#session.student.teacher.time2.getTime()"><a href="student/student_getDocuments.action?period=during">管理</a></s:if></td>
  		</tr>
  		<tr>
 	  		<td >毕业设计终稿</td>
 	  		<td><s:date name="#session.student.teacher.end" format="yyyy-MM-dd"/></td>
  			<td><s:if test="#session.student.teacher.time3==empty||#session.student.teacher.time3.getTime()>#session.now.getTime()">未开始</s:if>
  			<s:elseif test="#session.student.teacher.end.getTime()>#session.now.getTime()">进行中</s:elseif>
  			<s:else>已结束</s:else>
  			</td>
  			<td><s:if test="#session.now.getTime()>#session.student.teacher.time3.getTime()"><a href="student/student_getDocuments.action?period=after">管理</a></s:if></td>
  		</tr>
  		<tr><td colspan="4" align="center"><a href="student/student_comment.jsp">查看老师评语与分数</a></td></tr>
  	</table>
  	</form>
  	${getTimeError }
  	<%session.removeAttribute("getTimeError"); %>
	</div>
  </body>



	
</html>
