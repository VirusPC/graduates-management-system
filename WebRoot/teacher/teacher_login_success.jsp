<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Pager" %>
<%@ page import="entity.Bulletin" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_login_success.jsp' starting page</title>
     <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
  	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-image:url(picture/login_bgx.gif); background-size:cover;">
  <jsp:include page="teacher_menu.jsp"></jsp:include>
   	  	<div align="center"></div>
 <div style="text-align:center;" align="center">
 <div style="display:inline-block;">
<div style="float:left">
		<a href="teacher/teacher_bulletin.jsp">新增公告</a><br/><br/>
  	  	<form action="" align="center" width="110" style="display: inline; ">
  		<table >
  		
  		<tr><td colspan="2"> 		
    	<textarea  readonly="readonly" cols="100" rows="12"><s:iterator value="#session.bulletin.list" var="bu"><s:if test="#parameters.bid[0]==#bu.bid"><s:property value="#bu.content"/></s:if></s:iterator><s:if test="#parameters.bid==empty"><s:property value="#session.bulletin.list[0].content"/></s:if></textarea> 
    	</td></tr>
    	
    	<tr>
    	<s:iterator value="#session.bulletin.list" var="bu"><s:if test="#parameters.bid[0]==#bu.bid">
    	<tr><td colspan="2">&nbsp</td></tr>
    	<td align="center">
    	<a href="teacher/teacher_bulletin.jsp?bid=<s:property value="#bu.bid"/>">修改</a>
    	</td>
    	<td align="center">
    	<a href="teacher/teacher_deleteBulletin.action?bid=<s:property value="#bu.bid"/>">删除</a>
    	</td>
    	</s:if></s:iterator>
    	</tr>
    	</table>
    	</form>
   </div> 	
  	<div style="float:left;margin-left:50">
  	<dl  align="center" style="display:inline;float="left";">
  	<br/><br/>
  	<s:iterator value="#session.bulletin.list" var="bu"><li> <a id="bu" href="teacher/teacher_login_success.jsp?bid=<s:property value="#bu.bid"/>"/><s:property value="#bu.bname"/></a></br>&nbsp; </li></s:iterator>
   
   				
   					<s:if test="#session.bulletin.totalPage>1">				
				<li style="display:inline"><a
					href="teacher/teacher_queryBulletinsByTeacherId.action?currentPage=1">首页</a></li>&nbsp;				
				<s:if test="#session.bulletin.currentPage!=1">
				<li style="display:inline"><a
					href="teacher/teacher_queryBulletinsByTeacherId.action?currentPage=<s:property value="#session.bulletin.currentPage-1"/>">&laquo;</a></li>&nbsp;
				</s:if>
				<%
							Pager pager = (Pager)session.getAttribute("bulletin");
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
					href="teacher/teacher_queryBulletinsByTeacherId.action?currentPage=<%=i%>"><%=i%></a></li>&nbsp;
				<%
					}
				%>
				<s:if test="#session.bulletin.currentPage!=#session.bulletin.totalPage">
				<li style="display:inline"><a
					href="teacher/teacher_queryBulletinsByTeacherId.action?currentPage=<s:property value="#session.bulletin.currentPage+1"/>">&raquo;</a></li>
				</s:if>
				<li style="display:inline"><a
					href="teacher/teacher_queryBulletinsByTeacherId.action?currentPage=<s:property value="#session.bulletin.totalPage"/>">尾页</a></li>&nbsp;
			</s:if>
   	
   	
   </dl>
   </div>
   </div>	
</div>
  </body>
 

</html>
