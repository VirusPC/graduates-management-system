<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="UTF-8"%>
   <%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <base href="<%=basePath%>">
    
    <title>学生信息管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" 

content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	    <style type="text/css">
    
        .center{
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            -o-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
    </style>
  </head>
  
  <body style="background-image:url(picture/login_bgx.jpg); background-position:top;background-repeat:no-repeat;">
  <br/>

 <div  style="background-color:rgba(255, 255, 255, 0.5);"  align="center" class="center">
     <h2 align="center" style="font-family:微软雅黑 ;font-style:oblique;">学生毕业设计管理系统&nbsp;</h2> 
 
    <form action="login.action" method="post" >
    <table  style="line-height:30px; border-collapse:separate; " cellspacing="20px" >
    <tr><td >账号：</td><td><input type="text" name="id" class="form-control"  ></td></tr>
    <tr><td>密码：</td><td><input type="password" name="password" class="form-control" ></td></tr>
    <tr>
    <!-- 
    <td colspan="2" align="right"><input type="radio" name="isRemember" id="method" checked="checked"/>教师登录
    <input type="radio" name="isRemember" id="method"/>毕业生登录</td>
	 -->
	 <td colspan="2" align="center"><label>登录用户</label>
	 	<select name="user">
	 		<option value="student">学生</option>
	 		<option value="teacher">老师</option>
	 		<option value="admin">管理员</option>
	 	</select>
	 </td> 
    </tr>
    <tr><td  align="center" colspan="2"><input type="submit" value="登录"  class="btn btn-default"></td></tr>
    </table>
    </form>

 <h6 align="center" style="font-family:微软雅黑 ;font-style:nomal; color:red"><s:fielderror/> </h6>  
 </div>
  </body>
</html>
