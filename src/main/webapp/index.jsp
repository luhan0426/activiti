<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/index_work.css" type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
</head>
<script type="text/javascript">
  $(function(){
	  $.post(
				"<%=request.getContextPath()%>/findGroup",
				function(obj){
					 for(var i in obj){
						$("#groupId").append("<option class='groupId' value="+obj[i].id+">"+obj[i].name+"</option>");
					 }
				},
				"json"
			  
			  );
     })
     
     function dologin(){
	var groupId= $("#groupId").val();
	 if(groupId==0){
		alert("请选择用户角色!");
		return false;
	 }
	   $.post(
		"<%=request.getContextPath()%>/userLogin",
		{
			userName:$("[name=userName]").val(),
			password:$("[name=password]").val(),
			 groupId:groupId 	
		},
		function(result){
			if(result.success){
				location.href="<%=request.getContextPath()%>/leavelist";
			}else{
				alert(result.errorInfo);
			}
		},
		"json"
	   
	   );
	 
  }
</script>
<body>
<form id="form" action="" method="post">
	<table>
		 <tr>
		  <td>
		  姓名：<input type="text" name="userName">
		  </td>
		 </tr>
		 <tr>
		  <td>
		  密码：<input type="password" name="password">
		  </td>
		 </tr>
		 <tr>
		  <td>
		  角色：<select id="groupId">	
		  	     <option value="0">请选择用户角色</option>
		     </select>
		  </td>
		 </tr>
		 <tr>
		 <td>
		  <input type="button" value="登录" onclick="dologin()">
		 </td>
		 </tr>
	</table>
</form>

</body>
</html>