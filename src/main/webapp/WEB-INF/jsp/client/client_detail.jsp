<%@ page language="java" pageEncoding="UTF-8"%>
<div class="base_info">
	<div class="titl">基本信息</div>
	<div>
		<table class="client">
			<tr><th>客户名称：</th><td><span id="customerName"></span></td></tr>
			<tr><th>所属行业：</th><td><span id="category"></span></td></tr>
			<tr><th>客户地址：</th><td><span id="address"></span></td></tr>
			<tr><th>邮编：</th><td><span id="postalCode"></span></td></tr>
		</table>
	</div>
</div>
<div class="contact_info">
	<div class="titl">联系人</div>
	<div>
		<table class="client">
			<tr><th>业务联系人：</th><td><span id="business_contact"></span></td></tr>
			<tr><th style="font-weight: normal;">电话：</th><td><span id="business_phone"></span></td></tr>
			<tr><th style="font-weight: normal;">邮箱：</th><td><span id="business_email"></span></td></tr>
			<tr><th>技术联系人：</th><td><span id="technology_contact"></span></td></tr>
			<tr><th style="font-weight: normal;">电话：</th><td><span id="technology_phone"></span></td></tr>
			<tr><th style="font-weight: normal;">邮箱：</th><td><span id="technology_email"></span></td></tr>
		</table>
	</div>
</div>
<div class="title customerMagager" style="display: none;"><img src="<%=request.getContextPath() %>/images/arrows.png"/>客户信息</div>
<div class="base_info customerMagager" style="display: none;">
	<div>
		<table class="client">
			<tr><th>客户经理：</th><td><span id="cName"></span></td><td></td><td></td></tr>
			<tr><th>电话：</th><td><span id="cPhone"></span></td><th>邮箱：</th><td><span id="cEmail"></span></td></tr>
		</table>
	</div>
</div>