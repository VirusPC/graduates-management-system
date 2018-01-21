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
 	<jsp:include page="teacher_menu.jsp"></jsp:include>
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
					<td><a href="teacher/teacher_queryStudentsByTeacherId.action?order=id">学号</a></td>
					<td><a href="teacher/teacher_queryStudentsByTeacherId.action?order=grade">分数</a></td>
					<td>姓名</td>
					<td>课题</td>
					<td>阶段一</td>
					<td>阶段二</td>
					<td>阶段三</td>
					
					<td>评阅</td>
				<s:iterator value="#session.students.list" var="stu">
				<tr>
					<td><s:property value="#stu.id"/></td>
					<td><s:if test="#stu.grade!=empty"><s:property value="#stu.grade"/></s:if><s:else>未打分</s:else></td>
					<td><s:property value="#stu.name"/></td>
					<td><s:property value="#stu.project.pname"/></td>
					<td><a href="teacher/teacher_getDocuments.action?period=before&stuid=<s:property value="#stu.id"/>">管理</a></td>
					<td><a href="teacher/teacher_getDocuments.action?period=during&stuid=<s:property value="#stu.id"/>">管理</a></td>
					<td><a href="teacher/teacher_getDocuments.action?period=after&stuid=<s:property value="#stu.id"/>">管理</a></td>					
					<td><a href="teacher/teacher_check.jsp?stuid=<s:property value="#stu.id"/>">评阅</a></td>
				</tr>
				</s:iterator>
			</table>
		</form>
		
		  		<s:if test="#session.students.totalPage>1">				
				<li style="display:inline"><a
					href="teacher/teacher_queryStudentsByTeacherId.action?">首页</a></li>&nbsp;				
				<s:if test="#session.students.currentPage!=1">
				<li style="display:inline"><a
					href="teacher/teacher_queryStudentsByTeacherId.action?currentPage=<s:property value="#session.students.currentPage-1"/>">&laquo;</a></li>&nbsp;
				</s:if>
				<%
							Pager pager = (Pager)session.getAttribute("students");
							int lastPage;
							int firstPage;
							firstPage=pager.getCurrentPage()>3?(pager.getCurrentPage()-2):1;
							if(pager.getTotalPage()-firstPage>4){
							lastPage=firstPage+4;
							}else{
							lastPage=pager.getTotalPage();
							}
							for (int i = firstPage; i <= lastPage; i++) {
				%>
				<li style="display:inline"><a
					href="teacher/teacher_queryStudentsByTeacherId.action?currentPage=<%=i%>"><%=i%></a></li>&nbsp;
				<%
					}
				%>
				<s:if test="#session.students.currentPage!=#session.students.totalPage">
				<li style="display:inline"><a
					href="teacher/teacher_queryStudentsByTeacherId.action?currentPage=<s:property value="#session.students.currentPage+1"/>">&raquo;</a></li>
				</s:if>
				<li style="display:inline"><a
					href="teacher/teacher_queryStudentsByTeacherId.action?currentPage=<s:property value="#session.students.totalPage"/>">尾页</a></li>&nbsp;
			</s:if>
  </div>
  </body>
</html>
