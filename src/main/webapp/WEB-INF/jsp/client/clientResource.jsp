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
	    <script src="<c:url value='/js/gdcommons/clientResource.js'/>"></script>
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
				border-bottom:0px;
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
/************************************************************************************************************/
/************************************************************************************************************/
		ul, li {
			margin: 0;
			padding: 0;
			list-style: none;
			font-size:12px;
		}
		.abgne_tab {
			clear: left;
			/* width: 700px; */
			margin: 10px 0;
			font-size:12px;
		}
		ul.tabs {
			width: 100%;
			height: 32px;
			border-bottom: 1px solid #999;
			border-left: 1px solid #999;
			border-radius:5px 0px 0px 0px ;
			-moz-border-radius:5px 0px 0px 0px;
			-webkit-border-radius:5px 0px 0px 0px;
		}
		ul.tabs li {
			float: left;
			height: 31px;
			line-height: 31px;
			overflow: hidden;
			position: relative;
			margin-bottom: -1px; /* 讓 li 往下移來遮住 ul 的部份 border-bottom */
			border: 1px solid #999;
			border-left: none;
			background: #e1e1e1;
			border-radius:5px 5px 0px 0px;
			-moz-border-radius:5px 5px 0px 0px;
			-webkit-border-radius:5px 5px 0px 0px;
		}
		ul.tabs li a {
			display: block;
			padding: 0 20px;
			color: #000;
			border: 1px solid #fff;
			text-decoration: none;
		}
		ul.tabs li a:hover {
			background: #ccc;
		}
		ul.tabs li.active {
			background: #EEE;
			border-bottom: 1px solid #EEE;
		}
		ul.tabs li.active a:hover {
			background: #fff;
		}
		div.tab_container {
			clear: left;
			width: 100%;
			border: 1px solid #999;
			border-top: none;
			background: #fff;
		}
		div.tab_container .tab_content {
			/* padding: 20px; */
		}
		div.tab_container .tab_content h2 {
			margin: 0 0 20px;
		}
		.tab_r1 {
			border-right:1px solid #c7c7c7;
			padding-left:10px;
			height:30px;
			color:#FFFFFF;
		}
		.tab_r2 {
			padding-left:10px;
			height:30px;
			color:#FFFFFF;
		}
		.tab_r01 {
			border-top:1px solid #c7c7c7;
			border-right:1px solid #c7c7c7;
			padding-left:10px;
			height:24px;
			color:#404040;
			font-family:Arial, Helvetica, sans-serif;
		}
		.tab_r02 {
			border-top:1px solid #c7c7c7;
			padding-left:10px;
			height:24px;
			color:#404040;
			font-family:Arial, Helvetica, sans-serif;
		}
		.resourceTable th {
			border:1px solid #DBDBDB;
			border-bottom:0px;
		}
		#share,#exclusive {
			border-spacing: 0;
			border-collapse: collapse;
		}
		#share td,#exclusive td {
			border:1px solid #DBDBDB;
		}
		#share td .share_detail,#exclusive td .share_detail {
			border-spacing: 0;
			border-collapse: collapse;
			border:0px;
		}
		#share td .share_detail td ,#exclusive td .share_detail td {
			border-right:1px solid #DBDBDB;
			border-bottom:1px solid #DBDBDB;
			border:0px;
			text-align: left;
		}
		</style>
		<script type="text/javascript">
			var contextPath = "<%=request.getContextPath()%>";
			var customerId = "<%=customerId%>";
			
			$(function(){
				// 預設顯示第一個 Tab
				var _showTab = 0;
				var $defaultLi = $('ul.tabs li').eq(_showTab).addClass('active');
				$($defaultLi.find('a').attr('href')).siblings().hide();
				// 當 li 頁籤被點擊時...
				// 若要改成滑鼠移到 li 頁籤就切換時, 把 click 改成 mouseover
				$('ul.tabs li').click(function() {
					// 找出 li 中的超連結 href(#id)
					var $this = $(this),
					_clickTab = $this.find('a').attr('href');
					// 把目前點擊到的 li 頁籤加上 .active
					// 並把兄弟元素中有 .active 的都移除 class
					$this.addClass('active').siblings('.active').removeClass('active');
					// 淡入相對應的內容並隱藏兄弟元素
					$(_clickTab).stop(false, true).fadeIn().siblings().hide();
					return false;
				}).find('a').focus(function(){
					this.blur();
				});
			});
			
			jQuery(document).ready(function() {
				initClientDetail(customerId);
				initClientResource(customerId);
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
					<div class="abgne_tab">
						<ul class="tabs">
							<li class="" onclick="shareResult('share');" style="display: none;">
								<a href="#tab1">共享云</a>
							</li>
							<li class="" onclick="shareResult('exclusive');" style="display: none;">
								<a href="#tab2">专享云</a>
							</li>
							<li class="" onclick="shareResult('storage');" style="display: none;">
								<a href="#tab3">云存储</a>
							</li>
						</ul>
						<div class="tab_container">
							<div id="tab1" class="tab_content" style="display: none;">
								<table class="resourceTable">
									<tr><th style="width:12%;">云平台</th><th style="width:18%;">开通时间</th><th style="width:70%;">资源详情</th></tr>
								</table>
								<table id="share">
									
								</table>
							</div>
							<div id="tab2" class="tab_content" style="display: none;">
								<table class="resourceTable">
									<tr><th style="width:12%;">云平台</th><th style="width:18%;">开通时间</th><th style="width:70%;">资源详情</th></tr>
								</table>
								<table id="exclusive">
									<tr>
										<td style='width:12%;' rowspan='5'><span id='platfrom'>西单云平台</span></td>
										<td style='width:18%;' rowspan='5'><span id='opentime'>2013-07-09 13：42:11</span></td>
										<td>
											<table class='share_detail'>
												<tr><td>ECU：<span id='ecu'>0个</span></td><td>负载均衡：<span id='elb'>0个</span></td></tr>
												<tr><td>存储：<span id='exclusive_storage'></span></td><td>主机保护：<span id='ha'>0个</span></td></tr>
												<tr><td>快照：<span id='snapshot'></span></td><td>防火墙<span id='securitys'>0个</span></td></tr>
												<tr><td>带宽：<span id='bankwidth'></span></td><td>秘钥：<span id='keypairs'>0个</span></td></tr>
												<tr><td>IP总数：<span id='ipcount'></span></td><td></td></tr>
											</table>
										</td>
									</tr>
								</table>
							</div>
							<div id="tab3" class="tab_content" style="display: none;">
								<table class="resourceTable">
									<tr><th style="width:12%;">云平台</th><th style="width:18%;">开通时间</th><th style="width:70%;">资源详情</th></tr>
								</table>
								<table id="storage">
									<tr>
										<td style='width:12%;' rowspan='5'><span id='platfrom'>西单云平台</span></td>
										<td style='width:18%;' rowspan='5'><span id='opentime'>2013-07-09 13：42:11</span></td>
										<td>
											<table id="share_detail">
												<tr><td>ECU：<span id='ecu'>0个</span></td><td>负载均衡：<span id='elb'>0个</span></td></tr>
												<tr><td>存储：<span id='storage_storages'></span></td><td>主机保护：<span id='ha'>0个</span></td></tr>
												<tr><td>快照：<span id='snapshot'></span></td><td>防火墙<span id='securitys'>0个</span></td></tr>
												<tr><td>带宽：<span id='bankwidth'></span></td><td>秘钥：<span id='keypairs'>0个</span></td></tr>
												<tr><td>IP总数：<span id='ipcount'></span></td><td></td></tr>
											</table>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="../footer.jsp"/>
		</div>
	</body>
</html>