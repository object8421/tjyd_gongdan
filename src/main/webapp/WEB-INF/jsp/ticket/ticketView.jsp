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
	<div class="mainLayout" style="">
		<jsp:include page="../header.jsp"/>
		<div class="body">
		<style type="text/css">
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
				<jsp:include page="../order/orderView.jsp"/>
				<!-- <div class="orders-resource">
					<table id="cloud">
						<tr>
							<th width="10%">资源名称</th><th width="40%">数量</th><th width="25%">价格（元）</th><th width="25%">总计（元）</th>
						</tr>
						<tr>
							<td class="td">计算资源</td><td><div id="res_ecu"></div></td><td><div id="res_ecu_price"></div></td><td rowspan="7" class="sum"><div id="cloud_sum_price"></div></td>
						</tr>
						<tr>
							<td class="td">带宽</td><td><div id="res_bandwidth"></div><td><div id="res_bandwidth_price"></div></td>
						</tr>
						<tr>
							<td class="td">IP</td><td><div id="res_ip"></div></td><td><div id="res_ip_price"></div></td>
						</tr>
						<tr><td class="td">存储</td><td><div id="res_vol"></div></td><td><div id="res_vol_price"></div></td></tr>
						<tr><td class="td">快照</td><td><div id="res_snap"></div></td><td><div id="res_snap_price"></div></td></tr>
						<tr><td class="td">主机保护</td><td><div id="res_ha"></div></td><td><div id="res_ha_price">免费</div></td></tr>
						<tr><td class="td">负载均衡</td><td><div id="res_elb"></div></td><td><div id="res_elb_price">免费</div></td></tr>
					</table>
					<table id="storage">
						<tr>
							<th width="10%">资源名称</th><th width="40%">数量</th><th width="25%">价格（元）</th><th width="25%">总计（元）</th>
						</tr>
						<tr>
							<td class="td">存储</td><td><div id="stor_vol"></div></td><td><div id="stor_vol_price"></div></td><td rowspan="3" class="sum"><div class="sum" id="stor_sum_price"></span></td>
						</tr>
						<tr>
							<td class="td">带宽</td><td><div id="stor_bandwidth"></div><td><div id="stor_bandwidth_price"></div></td>
						</tr>
						<tr>
							<td class="td">IP</td><td><div id="stor_ip"></div></td><td><div id="stor_ip_price"></div></td>
						</tr>
					</table>
				</div> -->
			</div>
		</div>
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>
