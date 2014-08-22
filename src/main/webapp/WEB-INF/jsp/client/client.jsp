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
		<script type="text/javascript">
			var contextPath = "<%=request.getContextPath()%>";
			jQuery(document).ready(function() {
				var pageNum = 1;
				var pageSize = 10;
				init(pageNum,pageSize);
			});
		</script>
		<jsp:include page="../common-util.jsp"/>
	</head>
	<body>
		<div class="mainLayout" style="">
			<jsp:include page="../header.jsp"/>
			<div class="body">
				<div class="title-button border-all">
					<div class="tit"><h2>客户管理</h2></div>
				</div>
				<div class="btn-bar">
					<div>
						<input type="text" class="input_Login px vm xg1" node-type="text" placeholder="客户名称" id="search_filter_name" />
					</div>
					<div>
						<input type="button" value="查询" onclick="init()" class="mybutton"/>
					</div>
				</div>
				<div class="data-body">
					<table class="header">
						<tr>
							<th width="20%">编号</th>
							<th width="50%" style="text-align:left;">客户名称</th>
							<th width="30%">操作</th>
						</tr>
					</table>
					<table id="data_client" border="0">
						<tr>
							<td><img src="<c:url value='/images/icon/loading2.gif'/>"/></td>
						</tr>
					</table>
					<table class="pager" cellspacing="0" cellpadding="0" width="100%" border="0">
						<tr>
							<th style="text-align:right">
								<span>共<span id="totalNumber"></span>条记录　共<span id="totalPage"></span>页 　当前第<span id="pageNum">1</span>页　 <span id="dept_first" class="a-span" onclick="FirstPage()">首页</span> 　<span id="dept_pre" class="a-span" onclick="PrevPage()">上一页</span>　 <span id="dept_next" class="a-span" onclick="NextPage()">下一页</span>　 <span id="dept_last" class="a-span" onclick="LastPage()">末页</span></span>
							</th>
						</tr>
					</table>
				</div>
			</div>
			<jsp:include page="../footer.jsp"/>
		</div>
	</body>
</html>