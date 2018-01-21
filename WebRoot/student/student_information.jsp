<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
 	<jsp:include page="student_menu.jsp"></jsp:include>
   <div >
  	<form >
  	<table align="center" width="500px" >
  	  	<tr>
  			<td>学号</td>
  			<td><input type="text" size="30" name="id" readonly="readonly" value="<s:property value="#session.stuInfo.id"/>" class="form-control"></td>
  		</tr>
  		<tr>
 	  		<td >姓名</td>
  			<td><input type="text" size="30" name="name" class="form-control" value="<s:property value="#session.stuInfo.name"/>" readonly="readonly"></td>
  		</tr>
  		<tr>
 	  		<td >院系</td>
  			<td><input type="text" size="30" name="name" class="form-control" value="<s:property value="#session.stuInfo.department"/>" readonly="readonly"></td>
  		</tr>
  		<tr>
 	  		<td >专业</td>
  			<td><input type="text" size="30" name="name" class="form-control" value="<s:property value="#session.stuInfo.specialty"/>" readonly="readonly"></td>
  		</tr>
		<tr>
 	  		<td >毕业时间</td>
  			<td><input type="text" size="30" name="name" class="form-control" value="<s:date  name="#session.stuInfo.graduation" format="yyyy年MM月dd日"/>" readonly="readonly"></td>
  		</tr>	 			
  		<tr>
  			<td>指导老师</td>
  			<td><input type="text" size="30" name=major class="form-control" value="<s:property value="#session.stuInfo.teacher"/>" readonly="readonly"></td>
  		</tr>
  	</table>
  	</form>
  </div>
  </body>
</html>
