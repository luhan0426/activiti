<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加请假人员</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/index_work.css" type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
</head>
<script type="text/javascript">
 function add(){
	 var name=$("[name=name]").val();
	 var leaveDate=$("[name=leaveDate]").val();
	 var leaveDays=$("[name=leaveDays]").val();
	 var leaveReason=$("[name=leaveReason]").val();
	 $.post(
	  "<%=request.getContextPath()%>/add",
	   {
		  name:name,
		  leaveDate:leaveDate,
		  leaveDays:leaveDays,
		  leaveReason:leaveReason
		  
	   },
	function(obj){
		if(obj){
			alert("添加成功");
			location.href="<%=request.getContextPath()%>/leavelist";
		}else{
			alert("添加失败")
			location.href="<%=request.getContextPath()%>/toadd";
		}
		
	},
	"json"
	 
	 );
 }
</script>
<body>
	<table>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>请假日期</td>
			<td><input type="text" name="leaveDate" onclick="WdatePicker()">
			</td>
		</tr>
		<tr>
			<td>请假天数</td>
			<td><input type="text" name="leaveDays"></td>
		</tr>
		
		<tr>
		 
			<td>请假原因</td>
			<td>
			<textarea rows="" cols="" name="leaveReason"></textarea>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="button" value="添加" onclick="add()"></td>
		</tr>
	</table>
</body>
</html>