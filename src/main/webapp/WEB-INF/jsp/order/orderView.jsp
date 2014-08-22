<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<div class="orders-resource">
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
			<td class="td">存储</td><td><div id="stor_vol"></div></td><td><div id="stor_vol_price"></div></td><td rowspan="3" class="sum"><div id="stor_sum_price"></div></td>
		</tr>
		<tr>
			<td class="td">带宽</td><td><div id="stor_bandwidth"></div><td><div id="stor_bandwidth_price"></div></td>
		</tr>
		<tr>
			<td class="td">IP</td><td><div id="stor_ip"></div></td><td><div id="stor_ip_price"></div></td>
		</tr>
	</table>
</div>
