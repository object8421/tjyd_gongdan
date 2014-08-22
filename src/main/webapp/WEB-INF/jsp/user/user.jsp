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
	    <script src="<c:url value='/js/gdcommons/user.js'/>"></script>
	    <script src="<c:url value='/js/zDrag.js'/>"></script>
	    <script src="<c:url value='/js/zDialog.js'/>"></script>
		<style type="text/css">
			
		</style>
		<script type="text/javascript">
			var contextPath = "<%=request.getContextPath()%>";
			jQuery(document).ready(function() {
				initUserList();
			});
		</script>
	</head>
	<body>
		<div class="mainLayout" style="">
			<jsp:include page="../header.jsp"/>
			<div class="body">
				<div class="title-button border-all">
					<div class="tit"><h2>角色管理</h2></div>
					<div class="btn"><input class="mybutton" style="width:60px;" onclick="createrUser()" value="创建用户"/></div>
				</div>
				<div class="btn-bar">
					<div>
						<select id="search_role_type"><!--  onchange="init()"  -->
							<option value="">全部</option>
							<option value="cfm">资源管理员</option>
							<option value="user">业务管理员</option>
						</select>
					</div>
					<div>
						<input type="text" class="input_Login px vm xg1" node-type="text" placeholder="真实姓名" id="search_filter_name"/>
					</div>
					<div>
						<input type="button" value="查询" onclick="init()" class="mybutton"  style="width:60px;"/>
					</div>
				</div>
				<div class="data-body">
					<table class="header">
						<tr>
							<th width="20%">真实姓名</th>
							<th width="20%">所属角色</th>
							<th width="30%">用户名</th>
							<th width="30%">操作</th>
						</tr>
					</table>
					<table id="data_user">
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
		
		<div id="createUserDialog" class="Dialog" style="display: none;">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#666666">
				<tr>
					<td width="80" align="right">真实姓名：</td>
					<td><input type="text" id="user_name" /></td>
					<td class="msg-css"><!-- 创建后不可修改 --></td>
				</tr>
				<tr>
					<td align="right">所属角色：</td>
					<td>
						<select id="role_type">
							 <option value="cfm">资源管理员</option>
							 <option value="user">业务管理员</option>
						</select>
					</td>
					<td class="msg-css"></td>
				</tr>
				<tr>
					<td width="80" align="right">用户名：</td>
					<td><input type="text" id="login_name" /></td>
					<td class="msg-css">创建后不可修改，只能包含字母、数字</td>
				</tr>
				<tr>
					<td align="right">密　码：</td>
					<td><input type="password" id="password"  /></td>
					<td class="msg-css"></td>
				</tr>
				<tr>
					<td align="right">确认密码：</td>
					<td><input type="password" id="cfm_password"  /></td>
					<td class="msg-css"></td>
				</tr>
				<tr>
					<td colspan="3" bgcolor="#FFF" align="center"><span id="span_error" style="color:red;">&nbsp;</span></td>
				</tr>
			</table>
		</div>
		<div id="modifyUserDialog" class="Dialog" style="display: none;">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#666666">
				<tr>
					<td width="80" align="right">真实姓名：</td>
					<td><input type="text" id="user_name"/></td>
				</tr>
				<tr>
					<td align="right">所属角色：</td>
					<td>
						<select id="role_type">
							 <option value="cfm">资源管理员</option>
							 <option value="user">业务管理员</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="80" align="right">用户名：</td>
					<td><span id="login_name"></span><span id="old_password" style="display: none;"></span></td>
				</tr>
				<tr>
					<td width="80" align="right">修改密码：</td>
					<td><input type="checkbox" id="isModPassword" onclick="changeCheckBox()"/></td>
				</tr>
				<tr class="isModPassword">
					<td align="right">密　码：</td>
					<td><input type="password" id="password" /></td>
				</tr>
				<tr class="isModPassword">
					<td align="right">确认密码：</td>
					<td><input type="password" id="cfm_password"  /></td>
				</tr>
				<tr>
					<td colspan="3" bgcolor="#FFF" align="center"><span id="span_error" style="color:red;">&nbsp;</span></td>
				</tr>
			</table>
		</div>
	</body>
</html>