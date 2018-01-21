<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.StudentPC"%>
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
	<p class="text-warning" style="float:right"><s:property value="#session.student.name"/></p>
	<p class="text-info" style="float:right">欢迎您，学生</p>
	<br>
	<hr color="green">
		<a href="student/student_queryBulletinByStudentId.action">公告</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<% session.setAttribute("now", new Date()); %>
		<s:if test="#session.now.getTime()>#session.student.teacher.time1.getTime()">
		<a href="student/student_queryProjectByStudentId.action?currentPage=1">毕业设计选择</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>
		<s:if test="#session.student.project!=null">
		<a href="student/student_getTime.action">个人毕业设计管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>
		<a href="student/student_queryStudentByStudentId.action">个人信息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="student/student_getTeacher.action">指导老师信息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="student/student_modify_password.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="logout.action">退出登录</a> <br />
		<hr color="green">
	</div>

</body>
</html>
