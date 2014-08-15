<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   	<meta charset="utf-8">
    <title>天津移动工单平台</title>
   	<link rel="stylesheet" type="text/css" href="<c:url value='/css/gd/base.css'/>" />
   	<link rel="stylesheet" type="text/css" href="<c:url value='/css/gd/dialog.css'/>" />
    <script src="<c:url value='/js/jquery-1.8.3.min.js'/>"></script>
    <script src="<c:url value='/js/gdcommons/client.js'/>"></script>
    <script src="<c:url value='/js/zDrag.js'/>"></script>
    <script src="<c:url value='/js/zDialog.js'/>"></script>
    
	<style type="text/css">

	</style>

	<% String customerId = request.getParameter("customerId"); %>
	<script type="text/javascript" charset="utf-8">  
		jQuery(document).ready(function() {
			$("#client_header").removeClass("selected");
			$("#ticket_header").addClass("selected");
		});
	</script>
</head>

<body>
	<div class="mainLayout" style="">
		<jsp:include page="../header.jsp"/>
		<div class="body">
			<div class="title-button border-all">
				<div class="tit">工单列表</div>
			</div>
		</div>
	</div>
</body>
</html>
