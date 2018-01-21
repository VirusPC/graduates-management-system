<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Project" %>
<%@ page import="entity.StudentPC" %>
<%@ page import="entity.Pager" %>
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
	</div>
    	<form  id="f"  method="post">
    		<table align="center" border="1px"
				class="table table-striped table-bordered table-hover table-condensed">   		
    			<tr><td>毕业设计编号</td><td>毕业设计题目</td><td></td></tr>
    
    				<s:iterator value="#session.project.list" var="pro">
    				<tr>
    				<td><s:property value="#pro.pid"/></td>
    				<td><a href="student/student_project_more.jsp?pid=<s:property value="#pro.pid"/>"><s:property value="#pro.pname"/></a></td>   			
    				<td><input type="radio" name="select" value="<s:property value="#pro.pid"/>"></td>
    				</tr>
    			</s:iterator>
    			
   	
 <s:if test="#session.project.totalPage>1">
   			<tr><td colspan="3" align="center">				
				<li style="display:inline"><a
					href="student/student_queryProjectByStudentId.action?currentPage=1">首页</a></li>&nbsp;				
				<s:if test="#session.project.currentPage!=1">
				<li style="display:inline"><a
					href="student/student_queryProjectByStudentId.action?currentPage=<s:property value="#session.project.currentPage-1"/>">&laquo;</a></li>&nbsp;
				</s:if>
				<%
							Pager pager = (Pager)session.getAttribute("project");
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
					href="student/student_queryProjectByStudentId.action?currentPage=<%=i%>"><%=i%></a></li>&nbsp;
				<%
					}
				%>
				<s:if test="#session.project.currentPage!=#session.project.totalPage">
				<li style="display:inline"><a
					href="student/student_queryProjectByStudentId.action?currentPage=<s:property value="#session.project.currentPage+1"/>">&raquo;</a></li>
				</s:if>
				<li style="display:inline"><a
					href="student/student_queryProjectByStudentId.action?currentPage=<s:property value="#session.project.totalPage"/>">尾页</a></li>&nbsp;
			</td></tr>
			</s:if>
  
    			
    			
    			<s:if test="#session.student.project==null">
    				<tr><td colspan="3" align="center"><input type="button" value="确认选择" onclick="selectProject();" class="btn btn-default"></td></tr>
    			</s:if>
    			<% session.setAttribute("now", new Date()); %>
    			<s:elseif test="#session.student.teacher.end.getTime()>#session.now.getTime()">
    			<tr><td colspan="3" align="center" ><input  type="button" value="退选" onclick="deleteProject();" class="btn btn-default"></td></tr>
    			</s:elseif>
    		</table>
    	</form>
    	<p align="center">${selectError}</p>
    	<%session.removeAttribute("selectError"); %>

  
  
  
  </body>
  
<script>
var form = document.getElementById("f");
function selectProject()
{
form.action = "student/student_selectProject";
form.submit();
}
function deleteProject()
{
form.action = "student/student_deleteProject";
form.submit();
}
</script>


	
</html>
