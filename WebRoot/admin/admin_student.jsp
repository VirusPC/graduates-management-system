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
   			<a href="admin/admin_student_modify.jsp">新增学生</a>
		<form align="right" action="admin/admin_queryStudentsByStudentsId.action" method="post">
			<input type="submit" value=""
				style="float:right;height:30x;width:35px;background-image:url(picture/timg.jpg); background-size:cover; border-radius: 0.3rem;">
			<input type="text" name="stuid" placeholder="请输入学号"
				style="height:30px; float:right;   background-clip: padding-box;border: 1px solid #ced4da;border-radius: 0.25rem;">
		</form>
	</div>
	<%-- <div>
	<form><table>
				<tr>
				
				<td>系：</td>
				<td><select name="department">
				<option value=""></option>
	 			<option value="student">学生</option>
	 			</select></td>
	 			
	 			<td>专业：</td>
	 			<td><select name="specialty">
	 			<option value=""></option>
	 			<option value="student">学生</option>	 			
	 			</select></td>
	 			
	 			<td>指导老师：</td>
	 			<td><select name="teacher">
	 			<option value=""></option>
	 			<option value="student">学生</option>	 			
	 			</select></td>
	 			
				</tr>
		</table>
		</form>
	</div>--%>
   <div >
	<form>
			<table align="center" border="1px"
				class="table table-striped table-bordered table-hover table-condensed">
				<tr>
					<td>学号</td>
					<td>姓名</td>
					<td>所在系</td>					
					<td>所在专业</td>
					<td>指导老师</td>
					<td>毕业时间</td>
					<td></td>
					<td></td>
				<s:iterator value="#session.students.list" var="stu">
				<tr>
					<td><s:property value="#stu.id"/></td>
					<td><s:property value="#stu.name"/></td>
					<td><s:property value="#stu.department"/></td>					
					<td><s:property value="#stu.specialty"/></td>
					<td><s:property value="#stu.teacher"/></td>
					<td><s:date name="#stu.graduation" format="yyyy年MM月dd日"/></td>
					<td><a href="admin/admin_student_modify.jsp?stuid=<s:property value="#stu.id"/>">修改</a></td>
    				<td><a href="admin/admin_deleteStudent.action?stuid=<s:property value="#stu.id"/>">删除</a></td>
				</tr>
				</s:iterator>
				
			</table>
		</form>
  </div>
  <div align="center">
  
  
  
  
  	<ul  class="pagination" align="center" style="display:inline;float="left";">     				
   					<s:if test="#session.students.totalPage>1">				
				<li style="display:inline"><a
					href="admin/admin_queryStudentsByStudentsId.action?currentPage=1">首页</a></li>&nbsp;				
				<s:if test="#session.students.currentPage!=1">
				<li style="display:inline"><a
					href="admin/admin_queryStudentsByStudentsId.action?currentPage=<s:property value="#session.students.currentPage-1"/>">&laquo;</a></li>&nbsp;
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
					href="admin/admin_queryStudentsByStudentsId.action?currentPage=<%=i%>"><%=i%></a></li>&nbsp;
				<%
					}
				%>
				<s:if test="#session.students.currentPage!=#session.students.totalPage">
				<li style="display:inline"><a
					href="admin/admin_queryStudentsByStudentsId.action?currentPage=<s:property value="#session.students.currentPage+1"/>">&raquo;</a></li>
				</s:if>
				<li style="display:inline"><a
					href="admin/admin_queryStudentsByStudentsId.action?currentPage=<s:property value="#session.students.totalPage"/>">尾页</a></li>&nbsp;
			</s:if>  	   	
   </dl>
   </div>
  </body>
</html>
