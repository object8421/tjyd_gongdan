<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<%
	String customerId = request.getParameter("customerId");
	if(customerId == null){
%>
	<script type="text/javascript">
		window.location.href = "<%=request.getContextPath()%>/login.htm";
	</script>
<%
	}
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <title>天津移动工单平台</title>
	   	<link rel="stylesheet" type="text/css" href="<c:url value='/css/gd/base.css'/>" />
	   	<link rel="stylesheet" type="text/css" href="<c:url value='/css/gd/dialog.css'/>" />
	    <script src="<c:url value='/js/jquery-1.8.3.min.js'/>"></script>
	    <script src="<c:url value='/js/gdcommons/clientDtail.js'/>"></script>
	    <script src="<c:url value='/js/zDrag.js'/>"></script>
	    <script src="<c:url value='/js/zDialog.js'/>"></script>
		<style type="text/css">
			.base_info ,.contact_info {
				margin:10px;
			}
			.Tabs {
				height:30px;
				line-height: 30px;
			}
			.Tabs ul {
				list-style: none;
				padding:0px;
				margin:0px;
			}
			.Tabs ul li:FIRST-CHILD {
				margin-left:0px;
			}
			.Tabs ul li {
				padding:0 10px;
				border-radius:5px 5px 0px 0px;
				display: inline-block;
				border:1px solid #DDD;
				margin:-2px;
			}
			.selected_tab {
				background: #F2F2F2;
			}
			.data-body table.resource {
				background: #F2F2F2;
			}
			.data-body table.resource th {
				text-align: left;
				margin-top:-1px;
				padding:4px 0px;
			}
		</style>
		<script type="text/javascript">
			var contextPath = "<%=request.getContextPath()%>";
			var customerId = "<%=customerId%>";
			jQuery(document).ready(function() {
				initClientDetail(customerId);
			});
		</script>
		<jsp:include page="../common-util.jsp"/>
	</head>
	<body>
		
		<div class="mainLayout" style="">
			<jsp:include page="../header.jsp"/>
			<div class="body">
				<div class="title-button border-all">
					<div class="tit"><h2>资源概况</h2></div>
					<div class="btn"><input type="button" class="mybutton" value="打 印"/><input type="button" class="mybutton" value="导出Excel"/></div>
				</div>
				
				<div class="data-body">
					<div class="title" style=""><img src="<c:url value='/images/arrows.png'/>"/>客户信息</div>
					<jsp:include page="client_detail.jsp"/>
					<div class="Tabs" style="height:400px;">
						<div>
							<ul>
								<li id="share_tab" class="selected_tab">共享云</li>
								<li id="exclusive_tab" class="">专享云</li>
								<li id="storage_tab" class="">云存储</li>
							</ul>
						</div>
						<div>
							<table class="resource">
								<tr><th>云平台</th><th>开通时间</th><th>资源详情</th></tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>