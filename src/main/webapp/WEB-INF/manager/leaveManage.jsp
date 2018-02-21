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
	$(function(){
		$("#ckall").click(function(){
			if(this.checked){
				$(".ck").attr("checked",true);
			}else{
				$(".ck").attr("checked",false);
			}
			
		})
		
	});
	function toadd(){
		location.href="<%=request.getContextPath()%>/toadd"
		
	}
	function del(id){
		if(confirm("确认删除?")){
		     $.post(
		    	    	"<%=request.getContextPath()%>/delete",
		    	    	{id:id},
		    	    	function(obj){
		    	    		if(obj){
		    	    			alert("删除成功");
		    	  location.href="<%=request.getContextPath()%>/leavelist";
		    	    		}else{
		    	    			alert("删除失败");
		    	    		}
		    	    	},
		    	    	"json"
		    	       );	
		}
  
	}
	function tj(id,state){
		 if(state==1){
			 alert("申请已提交审核中....")
			 return false;
		 }
		
		 $.post(
		"<%=request.getContextPath()%>/startApply",
		{id:id},
		function(obj){
			if(obj){
				alert("请假申请提交成功，目前审核中，请耐心等待！");
		 location.href="<%=request.getContextPath()%>/leavelist";
			}else{
				alert("请假申请提交失败")
			}
		},"json"
		 );
	}
	
</script>
<body>
<div  style="height: 78px;background-color: #E0ECFF">
 <table style="padding: 5px;" width="100%">
 	<tr>
 	
 		<td valign="bottom" align="right" width="50%">
 			<font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${currentMemberShip.user.id }(${currentMemberShip.user.firstName }${currentMemberShip.user.lastName })【${currentMemberShip.group.name}】</font>
 		</td>
 	</tr>
 </table>
</div>
  <input type="button" value="新增请假单" onclick="toadd()">
   <a href="<%=request.getContextPath()%>/task/daibanManager?userId=${currentMemberShip.user.id }"><input type="button" value="代办理任务"></a> 
   <a href="<%=request.getContextPath()%>/task/yibanManager"><input type="button" value="已办理任务"></a> 
	<table>
		<tr>
	
			<td><input type="checkbox" id="ckall"></td>
			<td>编号</td>
			<td>请假人名</td>
			<td>请假日期</td>
			<td>请假天数</td>
			<td>请假原因</td>
			<td>审核状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${leavelist}" var="l" varStatus="o">
			<tr>
				<td><input type="checkbox" class="ck"></td>
				<td>${o.index+1}</td>
				<td>${l.name}</td>
				<td>${l.leaveDate}</td>
				<td>${l.leaveDays}</td>
				<td>${l.leaveReason}</td>
				<td>
				 <c:if test="${l.state==0}">初始录入</c:if>
				 <c:if test="${l.state==1}">审核中</c:if>
				 <c:if test="${l.state==2}">申请成功</c:if>
				 <c:if test="${l.state==3}">申请不通过</c:if>
				</td>
				<td>
				  <input type="button" value="提交申请" id="button" onclick="tj('${l.id}','${l.state}')">
				  <input type="button" value="删除" onclick="del(${l.id})">
				</td>
			</tr>

		</c:forEach>
      <tr>
        <td colspan="11">
             共${listCount}条   ${pageCount}/${page}页
          ${first}
          ${prev}
          ${next}
          ${last}
        </td>
      </tr>
	</table>
   	

</body>
</html>