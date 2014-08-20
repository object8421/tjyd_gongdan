<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page 
	import="com.chinaops.web.common.entity.SysAdminUserDetails"
	import="org.springframework.security.core.context.SecurityContextHolder"
%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   	<meta charset="utf-8">
    <title>天津移动工单平台</title>
   	<link rel="stylesheet" type="text/css" href="<c:url value='/css/gd/base.css'/>" />
   	<link rel="stylesheet" type="text/css" href="<c:url value='/css/gd/dialog.css'/>" />
    <script src="<c:url value='/js/jquery-1.8.3.min.js'/>"></script>

    <script src="<c:url value='/js/zDrag.js'/>"></script>
    <script src="<c:url value='/js/zDialog.js'/>"></script>
    
	<style type="text/css">

	</style>
<%
	Object principal1 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	SysAdminUserDetails user = (SysAdminUserDetails)principal1;
%>
	<script type="text/javascript" charset="utf-8">  
		var contextPath = "<%=request.getContextPath()%>";
		var roleType = "<%=user.getRole() %>";
		jQuery(document).ready(function() {
			$("#client_header").removeClass("selected");
			$("#ticket_header").addClass("selected");
		});
	</script>
	<% 
		String customerId = request.getParameter("customerId");
		if(customerId != null){
	%>
	    <script src="<c:url value='/js/gdcommons/ticketCustomer.js'/>"></script>
		<script type="text/javascript" charset="utf-8"> 
			var customerId = "<%=customerId%>";
			jQuery(document).ready(function() {
				initTicketListCustomer();
			});
		</script>
	<%
		}else{
	%>
		<script src="<c:url value='/js/gdcommons/ticket.js'/>"></script>
		<script type="text/javascript" charset="utf-8"> 
			jQuery(document).ready(function() {
				initTicketList();
			});
		</script>
	<%
		}
	%>
	
</head>

<body>
	<div class="mainLayout" style="">
		<jsp:include page="../header.jsp"/>
		<div class="body">
			<div class="title-button border-all">
			<%
				if(customerId != null){
			%>
				<div class="tit"><h2>工单列表</h2></div>
			<%  } else {  %>
				<div class="tit"><h2>工单管理</h2></div>
			<%  } %>
			</div>
			<div class="btn-bar">
				<div>
					<select id="search_ticket_type"><!--  onchange="init()"  -->
						<option value="">全部</option>
						<option value="open">开通工单</option>
						<option value="modify">变更工单</option>
						<option value="close">关闭工单</option>
						<option value="stop">暂停工单</option>
						<option value="reset">恢复工单</option>
					</select>
				</div>
			<% if(customerId == null || customerId.equals("")){ %>
				<div>
					<input type="text" class="input_Login px vm xg1" node-type="text" placeholder="客户名称" id="search_filter_name"/>
				</div>
				<div>
					<input type="button" value="查询" onclick="initTicketList()" class="mybutton"  style="width:60px;"/>
				</div>
			<%}else{ %>
				<div>
					<input type="button" value="查询" onclick="initTicketListCustomer()" class="mybutton"  style="width:60px;"/>
				</div>
			<%} %>
			</div>
			<div class="data-body">
				<table>
					<tr>
						<th width="15%">工单号</th>
						<th width="30%">客户名称</th>
						<th width="15%">工单类型</th>
						<th width="15%">接收时间</th>
						<th width="25%">操作</th>
					</tr>
				</table>
				<table id="data_ticket">
					<tr>
						<td><img src="<c:url value='/images/icon/loading2.gif'/>"/></td>
					</tr>
				</table>
				<table class="pager" cellspacing="0" cellpadding="0" width="100%" style="background:#EEE;" border="0">
					<tr>
						<td style="text-align:right">
							<span>共<span id="totalNumber"></span>条记录　共<span id="totalPage"></span>页 　当前第<span id="pageNum">1</span>页　 <span id="dept_first" class="a-span" onclick="FirstPage()">首页</span> 　<span id="dept_pre" class="a-span" onclick="PrevPage()">上一页</span>　 <span id="dept_next" class="a-span" onclick="NextPage()">下一页</span>　 <span id="dept_last" class="a-span" onclick="LastPage()">末页</span></span>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>
