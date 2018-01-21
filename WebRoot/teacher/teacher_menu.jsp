<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Teacher"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>毕业设计管理系统</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="jquery/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	
</script>

</head>
<body>
	<br />
	<h2 align="center">欢迎来到毕业设计管理系统</h2>
	<script type="text/javascript">
		var date = new Date();
		var week = [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" ];
		document.write((date.getMonth() + 1) + "月" + date.getDate() + "日"
				+ "&nbsp;&nbsp;" + week[date.getDay()]);
	</script>
	<p class="text-info" style="float:right">!&nbsp;&nbsp;&nbsp;</p>
	<p class="text-warning" style="float:right"><s:property value="#session.teacher.name"/></p>
	<p class="text-info" style="float:right">欢迎您，老师</p>
	<br>
	<hr color="green">
		<a href="teacher/teacher_queryBulletinsByTeacherId.action?bid=1">公告管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="teacher/teacher_queryProjectsByTeacherId.action">毕业设计管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="teacher/teacher_queryStudentsByTeacherId.action?id=1">学生设计管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="teacher/teacher_information.jsp">个人信息管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="teacher/teacher_modify_password.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="login.jsp">退出登录</a> <br />
		<hr color="green">
	</div>

</body>
</html>
