<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="entity.Pager" %>
<%@ page import="entity.Specialty" %>
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

  </head>
  
  <body  style="background-image:url(picture/login_bgx.gif); background-size:cover;">
 	<jsp:include page="admin_menu.jsp"></jsp:include>
   	<div >
   	<a href="admin/admin_specialty_modify.jsp">新增专业</a>
		<form align="right" action="admin/admin_querySpecialtysBySpecialtysId.action" method="post">
			<input type="submit" value=""
				style="float:right;height:30x;width:35px;background-image:url(picture/timg.jpg); background-size:cover; border-radius: 0.3rem;">
			<input value="<s:property value="#request.speid2"/>" type="text" name="speid" placeholder="请输入专业号"
				style="height:30px; float:right;   background-clip: padding-box;border: 1px solid #ced4da;border-radius: 0.25rem;">
		</form>
	</div>
   <div >
	<form>
			<table align="center" border="1px"
				class="table table-striped table-bordered table-hover table-condensed">
				<tr>
					<td>专业号</td>
					<td>专业名</td>
					<td>所属系</td>
					<td></td>
					<td></td>
				<s:iterator value="#session.specialtys.list" var="spe">
				<tr>					
					<td><s:property value="#spe.spid"/></td>
					<td><s:property value="#spe.spname"/></td>
					<td><s:property value="#spe.deptname"/></td>
					<td><a href="admin/admin_specialty_modify.jsp?speid=<s:property value="#spe.spid"/>">修改</a></td>
    				<td><a href="admin/admin_deletespecialty.action?speid=<s:property value="#spe.spid"/>">删除</a></td>
				</tr>
				</s:iterator>
				
			</table>
		</form>
  </div>
  <div align="center">
  
  

  	<ul   align="center" >   			
   			<s:if test="#session.specialtys.totalPage>1">				
				<li style="display:inline"><a
					href="admin/admin_querySpecialtysBySpecialtysId.action?currentPage=1&speid=<s:property value="#request.speid2"/>">首页</a></li>&nbsp;				
				<s:if test="#session.specialtys.currentPage!=1">
				<li style="display:inline"><a
					href="admin/admin_querySpecialtysBySpecialtysId.action?currentPage=<s:property value="#session.specialtys.currentPage-1"/>&speid=<s:property value="#request.speid2"/>">&laquo;</a></li>&nbsp;
				</s:if>
				<%
							Pager pager = (Pager)session.getAttribute("specialtys");
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
					href="admin/admin_querySpecialtysBySpecialtysId.action?currentPage=<%=i%>&speid=<s:property value="#request.speid2"/>"><%=i%></a></li>&nbsp;
				<%
					}
				%>
				<s:if test="#session.specialtys.currentPage!=#session.specialtys.totalPage">
				<li style="display:inline"><a
					href="admin/admin_querySpecialtysBySpecialtysId.action?currentPage=<s:property value="#session.specialtys.currentPage+1"/>&speid=<s:property value="#request.speid2"/>">&raquo;</a></li>
				</s:if>
				<li style="display:inline"><a
					href="admin/admin_querySpecialtysBySpecialtysId.action?currentPage=<s:property value="#session.specialtys.totalPage"/>&speid=<s:property value="#request.speid2"/>">尾页</a></li>&nbsp;
			</s:if>  	   	
   </ul>
   </div>
  </body>
</html>
