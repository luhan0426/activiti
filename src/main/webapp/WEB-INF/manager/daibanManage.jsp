<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工请假流程系统-主页面</title>
<%
	// 权限验证
	if(session.getAttribute("currentMemberShip")==null){
		response.sendRedirect("index.jsp");
		return;
	}
%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/index_work.css" type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
		
</head>
<script type="text/javascript">
	
	
</script>
<body>
	<table>
	<tr>
 		<td>任务ID</td>
 		<td>任务名称</td>
 		<td>创建时间</td>
 		<td>操作</td>
 	</tr>
 	<c:forEach items="${MyTaskList}" var="d">
 	  <tr>
 	    <td>${d.id}</td>
 	    <td>${d.name}</td>
 	    <td>${d.createTime}</td>
 	    <td>
 	      <input type="button" value="办理任务" onclick="banli()"> 
 	    </td>
 	  </tr>
 	
 	</c:forEach>
	</table>
   	

</body>
</html>