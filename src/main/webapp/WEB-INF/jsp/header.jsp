<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page 
	import="com.chinaops.web.common.entity.SysAdminUserDetails"
	import="org.springframework.security.core.context.SecurityContextHolder"
%>
<%@ page language="java" pageEncoding="UTF-8"%>
<style>
.showPassword {
	background:#FFF;
	color:#000;
	border:1px solid #DDD;
	border-bottom:0px;
	border-radius:5px 5px 0px 0px;
	margin:-1px -1px 0px -1px;
}
.user_name {
	padding:0px 5px;
	cursor: pointer;
	position: relative;
	color:#FFFF99;
	z-index: 2;
}
.layoutPassword {
    background: none repeat scroll 0 0 #FFFFFF;
    border: 1px solid #DDD;
    border-radius: 0 5px 5px 5px;
    color: #000000;
    height: 30px;
    left: 976px;
    position: absolute;
    top: 109px;
    width: 100px;
    z-index: 1;
}
.layoutPassword:hover {
	color:blue;
}
ul {
	list-style: none;
	margin: 0;
	padding: 0;
}
ul li {
	list-style: none outside none;
    padding: 0 20px;
	line-height: 30px;
	text-align: center;
	cursor: pointer;
}
.modifyPasswordDialog {
	padding:10px;
}
.modifyPasswordDialog table {
	width:100%;
	border:0px solid #000;
}
.modifyPasswordDialog table th {
	padding:2px;
	text-align: right;
	font-weight: normal;
}
.modifyPasswordDialog table td {
	padding:2px;
}
.modifyPasswordDialog .msg-error {
	color:#666;
}
.up {
	color:#2F6DB3;
}
</style>
<%
	Object principal1 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	SysAdminUserDetails user = (SysAdminUserDetails)principal1;
	String roleName = "";
	if(user != null){
		if(user.getRole().equals("cfm")){
			roleName = "资源管理员";
		}else if(user.getRole().equals("user")){
			roleName = "业务管理员";
		}else if(user.getRole().equals("sys")){
			roleName = "系统管理员";
		}
	}
%>
<script type="text/javascript" charset="utf-8"> 
	jQuery(document).ready(function() {
		$("#header_user_name").click(function(){
			if($(".layoutPassword").css("display") == "block"){
				$(this).removeClass("showPassword");
				$(this).children("img").attr("src","<c:url value='/images/header_down.png'/>");
				$(this).removeClass("up");
			}else{
				$(this).addClass("showPassword");
				$(this).children("img").attr("src","<c:url value='/images/header_up.png'/>");
				$(this).addClass("up");
			}
			$(".layoutPassword").css({
				left:$(this).position().left-1+"px",
				top: $(this).position().top+39
			});
			$(".layoutPassword").toggle();
		});
		
		$("#modifyPassword").click(function(){
			$(".layoutPassword").css('display','none'); 
			$("#header_user_name").children("img").attr("src","<c:url value='/images/header_down.png'/>");
			$("#header_user_name").removeClass("showPassword");
			
			$("#userName").text("<%=user.getUsername() %>");
			$("#loginName").text("<%=user.getLoginName() %>");
			var diag = new Dialog();
			diag.Width = 560;
			diag.Height = 200;
			diag.Title = "修改密码";
			diag.InvokeElementId="modifyPasswordDialog";
			diag.OKEvent = function(){
				var id = $("#mod_id").val();
				var old_pass = $("#mod_pass").val();
				var mod_old_password = $("#mod_old_password").val();
				var mod_new_password = $("#mod_new_password").val();
				var mod_cfm_new_password = $("#mod_cfm_new_password").val();
				if(mod_old_password == ""){
					alert("旧密码不能为空！");
					return ;
				}
				if(mod_new_password == ""){
					alert("新密码不能为空！");
					return ;
				}
				if(mod_cfm_new_password == ""){
					alert("确认密码不能为空！");
					return ;
				}
				if(mod_new_password.length < 6 || mod_new_password.length > 14){
					alert("密码在6-14位之间！");
					return ;
				}
				if(old_pass != mod_old_password){
					alert("旧密码错误！")
					return ;
				}
				if(mod_new_password != mod_cfm_new_password){
					alert("新密码与确认密码不一致！");
					return ;
				}
				$.ajax({
					type : "POST",
					url : contextPath + "/updateUserPassword_update_ajax.do",
					data : {id:id,password:mod_new_password},
					success : function(result) {
						if(result == "1"){
							diag.close();
							window.location.href = contextPath + "/login.htm";
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						if (XMLHttpRequest.status == 403 && errorThrown == "Forbidden") {
							window.location.reload();
						} else {
							console.log(textStatus.error + "" + errorThrown);
						}
					},
					dataType : "json"
				});
			};//点击确定后调用的方法
			diag.show();
		});
	});
</script>

<div class="yd-gongdan-logo"> </div>
<div class="banner-nav"> 
	<div class="banner-left">
	<%
		if(user.getRole().equals("cfm") || user.getRole().equals("user")){
	%>
		<div id="ticket_header" class="ticket"><a href="<c:url value='/ticket.htm'/>">工单管理</a></div>
		<div id="client_header" class="client selected"><a href="<c:url value='/client.htm'/>">客户管理</a></div>
	<% 
		}else{ 
	%>
		<div class="user selected"><a href="<c:url value='/user.htm'/>">角色管理</a></div>
	<%
		} 
	%>
	</div>
	<div class="banner-right" style="">
		<div>欢迎&nbsp;&nbsp;<%=roleName %> &nbsp;&nbsp; </div>
		<div style="" id="header_user_name" class="user_name">
			<%=user.getUsername() %><img src="<c:url value='/images/header_down.png'/>"/>
		</div> &nbsp;&nbsp;
		<ul class="layoutPassword" style="display: none;"><li id="modifyPassword">修改密码</li></ul>
		<div class="banner-layout"><a href="<c:url value='/j_spring_security_logout'/>"><img style="padding-top:10px;" src="<c:url value='/images/layout.png'/>"/> 退出</a></div>
	</div>
</div>
<div id="modifyPasswordDialog" class="modifyPasswordDialog" style="display: none;">
	<input type="hidden" id="mod_id" value="<%=user.getId() %>"/>
	<input type="hidden" id="mod_pass" value="<%=user.getPassword() %>"/>
	<table>
		<tr><th style="width:15%;">姓名：</th><td style="width:25%;"><span id="userName"></span></td><td style="width:60%;"></td></tr>
		<tr><th>用户名：</th><td><span id="loginName"></span></td><td></td></tr>
		<tr><th>旧密码：</th><td><input type="password" id="mod_old_password"/></td><td><span id="mod_old_password_span_error" class="msg-error">为了确保是您本人操作，需要再次核对帐号密码</span></td></tr>
		<tr><th>新密码：</th><td><input type="password" id="mod_new_password"/></td><td><span id="mod_new_password_span_error" class="msg-error">密码长度6~14位，由字母、数字、符号组成，区分大小写</span></td></tr>
		<tr><th>确认密码：</th><td><input type="password" id="mod_cfm_new_password"/></td><td><span id="mod_cfm_new_password_span_error" class="msg-error">请再次输入新密码</span></td></tr>
	</table>
</div>