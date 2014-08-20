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
	    <script src="<c:url value='/js/jquery-1.8.3.min.js'/>"></script>
	    <script src="<c:url value='/js/gdcommons/clientDtail.js'/>"></script>
	    <script src="<c:url value='/js/zDrag.js'/>"></script>
	    <script src="<c:url value='/js/zDialog.js'/>"></script>
		<style type="text/css">
			
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
					<div class="tit"><h2>客户信息</h2></div>
				</div>
				<div class="data-body">
					<jsp:include page="client_detail.jsp"/>
				</div>
			</div>
			<jsp:include page="../footer.jsp"/>
		</div>
	</body>
</html>