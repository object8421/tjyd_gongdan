<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page 
	import="com.chinaops.web.common.entity.SysAdminUserDetails"
	import="org.springframework.security.core.context.SecurityContextHolder"
%>
<%@ page language="java" pageEncoding="UTF-8"%>
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
<div style="height:60px;background:green;"> </div>
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
	<div class="banner-right" style=""><div>欢迎&nbsp;&nbsp;<%=roleName %> &nbsp;&nbsp; <%=user.getUsername() %> &nbsp;&nbsp;<a href="<c:url value='/j_spring_security_logout'/>"><img src="<c:url value='/images/layout.png'/>"/> 退出</a></div></div>
</div>