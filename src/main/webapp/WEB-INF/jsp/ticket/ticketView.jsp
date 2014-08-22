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
	<script src="<c:url value='/js/gdcommons/clientDtail.js'/>"></script>
	<script src="<c:url value='/js/gdcommons/ticketView.js'/>"></script>
    <script src="<c:url value='/js/zDrag.js'/>"></script>
    <script src="<c:url value='/js/zDialog.js'/>"></script>
    <%
    	String ticketId = request.getParameter("ticketId");
	    String customerId = request.getParameter("customerId");
		String ticketType = request.getParameter("ticketType");
		
    	if((ticketId == null || ticketId.equals("")) && (customerId == null || customerId.equals("")) && (ticketType == null || ticketType.equals(""))){
    %>
    	<script type="text/javascript" charset="utf-8">  
    		window.location.href = "<%=request.getContextPath()%>/login.htm";
    	</script>
    <%
    	}
    %>
	
<%
	Object principal1 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	SysAdminUserDetails user = (SysAdminUserDetails)principal1;
%>
	<script type="text/javascript" charset="utf-8">  
		var contextPath = "<%=request.getContextPath()%>";
		var roleType = "<%=user.getRole() %>";
		var customerId = "<%=customerId%>";
		var ticketId = "<%=ticketId %>";
		jQuery(document).ready(function() {
			$("#client_header").removeClass("selected");
			$("#ticket_header").addClass("selected");
		});
	</script>
	<% 
		if(customerId != null && !customerId.equals("")){
	%>
	    <script src="<c:url value='/js/gdcommons/ticketCustomer.js'/>"></script>
		<script type="text/javascript" charset="utf-8"> 
			jQuery(document).ready(function() {
				$("#ticket_id").text(ticketId);
				$(".customerMagager").show();
				alert(customerId);
				initClientDetail(customerId);
				initTicketDetail(ticketId);
			});
		</script>
	<%
		}else{
	%>
		<script src="<c:url value='/js/gdcommons/ticket.js'/>"></script>
		<script type="text/javascript" charset="utf-8"> 
			var ticketId = "<%=ticketId %>";
			jQuery(document).ready(function() {
				$("#ticket_id").text(ticketId);
				$(".customerMagager").show();
				initClientDetail(customerId);
			});
		</script>
	<%
		}
	%>
	
</head>

<body>
customerId = <%=customerId %> 
	<div class="mainLayout" style="">
		<jsp:include page="../header.jsp"/>
		<div class="body">
		<style type="text/css">
			.ticket-title {
				height:70px;
				clear:both;
				display:hidden;
				background:#DDD;
				margin:0px 15px;
				margin-top:0px;
				padding:0px 10px;
			}
			.ticket-title .ticket-tit {
				border-bottom: 1px dotted #000;
				padding-bottom: 3px;
			}
			.ticket-tit h2 {
				font-weight: normal;
			}
			.ticket-title .ticket-time {
				clear:both;
				width:910px;
			}
			.data-body .ticket-orders { margin:5px 0px; }
			.data-body .ticket-orders table.orders-table { border:0px; }
			.data-body .ticket-orders table.orders-table th { border :0px; text-align: right;font-weight: normal; }
			.data-body .ticket-orders table.orders-table td { border :0px; text-align: left; }
			.data-body .orders-resource table { border:0px; }
			.data-body .orders-resource table th { background:#EDEDED; padding:8px; }
		</style>
			<div class="ticket-title border-all">
			<%
				if(ticketType != "open" && ticketType.equals("open")){
			%>
				<div class="ticket-tit">
					<h2>业务开通【<span id="ticket_id"></span>】</h2>
				</div>
				<div class="ticket-time">
					<div id="" style="float:left;">接收时间：<span id="createTime">2014-08-21</span></div>
					<div style="float:right;">导出资源信息</div>
					<div class="clear"></div>
				</div>
			<%  } else if(ticketType != "modify" && ticketType.equals("modify")){  %>
				<div class="ticket-tit">
					<h2>业务变更【<span id="ticket_id"><%=ticketId %></span>】</h2>
				</div>
				<div class="ticket-time">
					<div id="" style="float:left;">接收时间：<span id="createTime">2014-08-21</span></div>
					<div style="float:right;">导出资源信息</div>
					<div class="clear"></div>
				</div>
			<%  }else if(ticketType != "close" && ticketType.equals("close")){ %>
				<div class="ticket-tit">
					<h2>业务撤销【<span id="ticket_id"><%=ticketId %></span>】</h2>
				</div>
				<div class="ticket-time">
					<div id="" style="float:left;">接收时间：<span id="createTime">2014-08-21</span></div>
					<div style="float:right;">导出资源信息</div>
					<div class="clear"></div>
				</div>
			<%  } %>
			</div>
			<div class="data-body">
				<div class="title" style=""><img src="<c:url value='/images/arrows.png'/>"/>客户信息</div>
				<jsp:include page="../client/client_detail.jsp"/>
				<div class="title" style=""><img src="<c:url value='/images/arrows.png'/>"/>需求信息</div>
				<div class="ticket-orders">
					<table class="orders-table">
						<tr><th width="15%">合同编号：</th><td width="20%"><span id="contractId"></span></td><th width="15%">合同起止时间：</th><td width="45%"><span id="contranctStartEndTime"></span></td></tr>
						<tr>
						<%if(ticketType.equals("open")){ %>
							<th>资源开通时间：</th>
							<td colspan="3"><span id="resourceOpenTime"></span></td>
						<%}else if(ticketType.equals("modify")){ %>
							<th>资源变更时间：</th>
							<td colspan="3"><span id="resourceModifyTime"></span></td>
						<%} %>
						</tr>
						<tr><th>产品类型：</th><td colspan="3"><span id="resourceProductType"></span></td></tr>
						<tr><th>是否做网站：</th><td colspan="3"><input type="radio" name="isWebSite" value="yes"/>是 <input type="radio" name="isWebSite" value="no"/>否</td></tr>
						<tr><th>工单备注：</th><td colspan="3"><span id="remark">涉及资源减少时，客户经理与客户确认客户资源哪些可以释放。在变更工单中注明！<br>客户经理信息变更；IP地址变更说明</span></td></tr>
					</table>
				</div>
				<div class="orders-resource">
					<table>
						<tr>
							<th width="10%">资源名称</th><th width="40%">数量</th><th width="25%">价格（元）</th><th width="25%">总计（元）</th>
						</tr>
						<tr>
							<td>计算资源</td><td><span id="res_ecu"></span></td><td></td><td></td>
						</tr>
						<tr>
							<td></td><td></td><td></td><td></td>
						</tr>
						<tr>
							<td></td><td></td><td></td><td></td>
						</tr>
						<tr><td></td><td></td><td></td><td></td></tr>
						<tr><td></td><td></td><td></td><td></td></tr>
						<tr><td></td><td></td><td></td><td></td></tr>
					</table>
				</div>
			</div>
		</div>
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>
