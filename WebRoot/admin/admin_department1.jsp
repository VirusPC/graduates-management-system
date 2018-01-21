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
 	<jsp:include page="admin_menu.jsp"></jsp:include>
   	<div>
		<form align="right" action="teacher/teacher_queryStudentByTeacherId.action" method="post">
			<input type="submit" value=""
				style="float:right;height:30x;width:35px;background-image:url(picture/timg.jpg); background-size:cover; border-radius: 0.3rem;">
			<input type="text" name="stuid" placeholder="请输入学号"
				style="height:30px; float:right;   background-clip: padding-box;border: 1px solid #ced4da;border-radius: 0.25rem;">
		</form>
		<br />
		<br />
	</div>
   <div >
	<form>
			<table align="center" border="1px"
				class="table table-striped table-bordered table-hover table-condensed">
				
				<tr>
					<td>系号</td>
					<td>系名</td>					
					<td>修改</td>
					<td>删除</td>
				<tr>
					<td><s:property value="#department.id"/></td>
					<td>科学系</td>
					<td>修改</td>
					<td>删除</td>
				</tr>
				
			</table>
		</form>
  </div>
  </body>
</html>
