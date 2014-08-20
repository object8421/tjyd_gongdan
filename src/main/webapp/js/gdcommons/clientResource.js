function initClientResource(){
	$.ajax({
		type : "POST",
		url : contextPath + "/client_product_type_by_customerId.do",
		data : {customerId:customerId},
		success : function(orders) {
			if(orders != null && orders.length > 0){
				for(var i=0;i<orders.length ;i++){//'share','exclusive','storage'
					if(orders[i].productType == "share"){
						$(".abgne_tab .tabs li a[href='#tab1']").parent().show();
					}else if(orders[i].productType == "exclusive"){
						$(".abgne_tab .tabs li a[href='#tab2']").parent().show();
					}else if(orders[i].productType == "storage"){
						$(".abgne_tab .tabs li a[href='#tab3']").parent().show();
					}
				}
			}else{
				$(".abgne_tab").hide();
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
}

function shareResult(productType){
//	alert(customerId+" == "+productType);
	$.ajax({
		type : "POST",
		url : contextPath + "/client_products_by_customerId.do",
		data : {customerId:customerId,productType:productType},
		success : function(orders) {
			if(orders != null && orders.length > 0){
				var str = "";
				for(var i = 0;i<orders.length;i++){
					var obj = orders[i];
					
					var ecu = obj.ecu == null ? 0 : obj.ecu;
					var elb = obj.elb==null?0:orders[i].elb;
					var storage = obj.storage == null ? 0 : obj.storage;
					var ha = obj.ha == null ? 0 : obj.ha;
					var snapshot = obj.snapshot == null ? 0 : obj.snapshot;
					var security = obj.securitys == null ? 0 : obj.securitys;
					var blanWidth = obj.bandWidth == null ? 0 : obj.bandWidth;
					var keypairs = obj.keys == null ? 0 : obj.keys;
					var ipCount = obj.ipCount == null ? 0 : obj.ipCount;
					str += "<tr>"+
							"	<td style='width:12%;'><span>"+obj.cloudPlatform+"</span></td>"+
							"	<td style='width:18%;'><span>"+obj.openTime.substring(0,obj.openTime.length-2)+"</span></td>"+
							"	<td>"+
							"		<table class='share_detail'>"+
							"			<tr><td>ECU：<span>" + ecu + " 个</span></td><td>负载均衡：<span>" + elb + " 个</span></td></tr>"+
							"			<tr><td>存储：<span>" + storage + " GB</span></td><td>主机保护：<span>" + ha +" 个</span></td></tr>"+
							"			<tr><td>快照：<span>" + snapshot + " GB</span></td><td>防火墙：<span>" + security + " 个</span></td></tr>"+
							"			<tr><td>带宽：<span>" + blanWidth + " M</span></td><td>秘钥：<span>" + keypairs + " 个</span></td></tr>"+
							"			<tr><td>IP总数：<span>" + ipCount + " 个</span></td><td></td></tr>" +
							"		</table>"+
							"	</td>"+
							"</tr>";
				}
				$("#"+productType).html(str)
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
}

//function setProductValue(productType,obj){
//	$("#platform").text(obj.cloudPlatform);
//	$("#opentime").text(obj.openTime.substring(0,obj.openTime.length-2));
//	$("#ecu").text(obj.ecu==null?0:obj.ecu+" 个");
//	$("#elb").text(obj.elb==null?0:obj.elb+" 个");
//	$("#"+productType+"_storages").text(obj.storage==null?0:obj.storage+" GB");
//	$("#snapshot").text(obj.snapshot == null ?0:obj.snapshot+" GB");
//	$("#securitys").text(obj.securitys == null ? 0 : obj.securitys + " 个");
//	$("#keys").text(obj.keys == null ? 0 : obj.keys + "个");
//	$("#bankwidth").text(obj.bandWidth == null ? 0 : obj.bandWidth + " M");
//	$("#ipcount").text(obj.ipCount == null ? 0 : obj.ipCount + " 个");
//	$("#").text();
//}