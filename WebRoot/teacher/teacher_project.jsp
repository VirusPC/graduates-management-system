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
  	<div align="right"><a href="teacher/teacher_project_modify.jsp">新增毕业设计</a></div>
  	<div align="right"><a href="teacher/teacher_time.jsp">设置截止日期</a></div>
	</div>
	<div>
    	<form action="" method="post">
    		<table align="center" border="1px"
				class="table table-striped table-bordered table-hover table-condensed">   		
    			<tr><td>毕业设计编号</td><td>毕业设计题目</td><td></td><td></td></tr>
    			<s:iterator value="#session.projects.list" var="pro">
    			<tr>
    				<td><s:property value="#pro.pid"/></td>
    				<td><a href="teacher/teacher_project_more.jsp?pid=<s:property value="#pro.pid"/>"><s:property value="#pro.pname"/></a></td>
    				<td><a href="teacher/teacher_project_modify.jsp?pid=<s:property value="#pro.pid"/>">修改</a></td>
    				<td><a href="teacher/teacher_deleteProject.action?pid=<s:property value="#pro.pid"/>">删除</a></td>
    			</tr>
    			</s:iterator>
    		</table>
    	</form>
    </div>	
    	
 <div align="center">
  	<dl  align="center" style="display:inline;float="left";">     				
   					<s:if test="#session.projects.totalPage>1">				
				<li style="display:inline"><a
					href="teacher/teacher_queryProjectsByTeacherId.action?currentPage=1">首页</a></li>&nbsp;				
				<s:if test="#session.projects.currentPage!=1">
				<li style="display:inline"><a
					href="teacher/teacher_queryProjectsByTeacherId.action?currentPage=<s:property value="#session.projects.currentPage-1"/>">&laquo;</a></li>&nbsp;
				</s:if>
				<%
							Pager pager = (Pager)session.getAttribute("projects");
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
					href="teacher/teacher_queryProjectsByTeacherId.action?currentPage=<%=i%>"><%=i%></a></li>&nbsp;
				<%
					}
				%>
				<s:if test="#session.projects.currentPage!=#session.projects.totalPage">
				<li style="display:inline"><a
					href="teacher/teacher_queryProjectsByTeacherId.action?currentPage=<s:property value="#session.projects.currentPage+1"/>">&raquo;</a></li>
				</s:if>
				<li style="display:inline"><a
					href="teacher/teacher_queryProjectsByTeacherId.action?currentPage=<s:property value="#session.projects.totalPage"/>">尾页</a></li>&nbsp;
			</s:if>  	   	
   </dl>
   </div>
  </body>



	
</html>
