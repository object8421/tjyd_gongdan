function suiteShare(o){
	var suite = new Object();
	if(o == '套餐1'){
		suite.ecu = '0.5';
		suite.price = '134';
		suite.volume = '25';
	}else if(o == '套餐2'){
		suite.ecu = '1';
		suite.price = '260';
		suite.volume = '50';
	}else if(o == '套餐3'){
		suite.ecu = '1.5';
		suite.price = '378';
		suite.volume = '75';
	}else if(o == '套餐4'){
		suite.ecu = '2';
		suite.price = '489';
		suite.volume = '100';
	}else if(o == '套餐5'){
		suite.ecu = '3 ';
		suite.price = '713';
		suite.volume = '150';
	}else if(o == '套餐6'){
		suite.ecu = '4 ';
		suite.price = '923';
		suite.volume = '200';
	}else if(o == '套餐7'){
		suite.ecu = '6 ';
		suite.price = '1344';
		suite.volume = '300';
	}else if(o == '套餐8'){
		suite.ecu = '8 ';
		suite.price = '1739';
		suite.volume = '400';
	}else if(o == '套餐9'){
		suite.ecu = '12 ';
		suite.price = '2522';
		suite.volume = '600';
	}else if(o == '套餐10'){
		suite.ecu = '16 ';
		suite.price = '3279 ';
		suite.volume = '800';
	}
	return suite;
}
function suiteExclusive(o){
	var suite = new Object();
	if(o == '套餐1'){
		suite.ecu = '32';
		suite.price = '6365';
		suite.volume = '1600';
	}else if(o == '套餐2'){
		suite.ecu = '64';
		suite.price = '12360';
		suite.volume = '3200';
	}else if(o == '套餐3'){
		suite.ecu = '256';
		suite.price = '49600';
		suite.volume = '12800';
	}else {
		suite.ecu = '定制';
		suite.price = '194元/ECU';
		suite.volume = '';
	}
	return suite;
}

function initTicketDetail(ticketId){
	$.ajax({
		type : "POST",
		url : contextPath + "/ticket_get_ticket_detail.json",
		data : {ticketId:ticketId},
		success : function(ticket) {
			var receiveTime = ticket.receiveTime;
			var orders = ticket.order;
			$("#createTime").text(receiveTime.split(" ")[0]);
			var start = orders.contractSignedDate;
			var end = orders.contractExpiredDate;
			$("#contractId").text(orders.contractId);
			$("#contranctStartEndTime").text(start.split(" ")[0].replace(/-/g, "/") + " —— " + end.split(" ")[0].replace(/-/g, "/"));
			var product_type = orders.productType;
			var productType = "";
			if(product_type == 'share'){
				productType = "共享云";
				$("#storage").hide();
				$("#cloud").show();
				var suite = suiteShare(orders.suite);
				showResouce(suite,orders);
				
				
			}else if(product_type == 'exclusive'){
				productType = "专享云";
				$("#storage").hide();
				$("#cloud").show();
				var suite = suiteExclusive(orders.suite);
				showResouce(suite,orders);
			}else if(product_type == 'storage'){
				productType = "云存储";
				$("#storage").show();
				$("#cloud").hide();
				showStroge(orders);
			}
			$("#resourceProductType").text(productType);
			if(orders.openTime != '' && orders.openTime != null){
				$("#resourceOpenTime").text(orders.openTime.split(" ")[0]);
			}
			if(orders.modifyTime != '' && orders.modifyTime != null){
				$("#resourceModifyTime").text(orders.modifyTime.split(" ")[0]);
			}
			var isWebsite = orders.forWebsite;
			$("input[type=radio][value="+isWebsite+"][name='isWebSite']").attr("checked",'checked');
			$("input[type=radio][name='isWebSite']").attr("disabled","disabled"); 

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

function showResouce(suite,orders){
	$("#res_ecu").text(suite.ecu + " 个ECU").append("<span style='border:1px solid #AAA; border-radius:3px; -moz-border-radius:3px; -webkit-border-radius:3px; padding:2px 4px;margin-left:5px;'>"+orders.suite+"</span>");
	$("#res_ecu_price").text(suite.price + " 元/月");
	var bandwidth = orders.bandwidth;
	var bandwidthPrice = "";
	$("#res_bandwidth").text(bandwidth + " Mbps");
	if(1==bandwidth || bandwidth==2 || bandwidth == 5){
		bandwidthPrice = 136;
	}else if(bandwidth ==10 || bandwidth==20 ||bandwidth ==50){
		bandwidthPrice = 132;
	}else if(bandwidth == 100){
		bandwidthPrice = 128;
	}
	$("#res_bandwidth_price").text(bandwidth*bandwidthPrice + " 元/月");
	
	$("#res_ip").text(orders.ipCount + " 个");
	$("#res_ip_price").text(orders.ipCount*30 + " 元/月");
	
	var vol = orders.storage==null || orders.storage=="" ? '0':orders.storage;
	var volPrice = "";
	if(vol < 1000){
		volPrice = 5*vol/10;
	}else if(vol >= 1000){
		volPrice = 500*vol/1000;
	}
	$("#res_vol").html(parseInt(vol)+parseInt(suite.volume) + " GB <span style='color:red'>[ 含购买存储："+vol+" GB]</span>");
	$("#res_vol_price").text(volPrice + " 元/月");
	
	var snap = orders.snapshot==null || orders.snapshot=="" ? '0':orders.snapshot;
	var snapPrice = "";
	if(snap < 1000){
		snapPrice = 5*snap/10;
	}else if(snap >= 1000){
		snapPrice = 500*snap/1000;
	}
	$("#res_snap").text(snap + " GB");
	$("#res_snap_price").text(snapPrice + " 元/月");
	
	var ha = orders.ha == null || orders.ha == "" ? '0' : orders.ha;
	$("#res_ha").text(ha + " 个");
	var elb = orders.elb == null || orders.elb == "" ? '0' : orders.elb;
	$("#res_elb").text(elb + " 个");
	var sumPrice = parseInt(suite.price) + bandwidth*bandwidthPrice + orders.ipCount*30 + volPrice + snapPrice;
	$("#cloud_sum_price").text(sumPrice + " 元/月");
}

function showStroge(orders){
	var vol = orders.storage==null || orders.storage=="" ? '0':orders.storage;
	var volPrice = "";
	if(vol < 1000){
		volPrice = 5*vol/10;
	}else if(vol >= 1000){
		volPrice = 500*vol/1000;
	}
	$("#stor_vol").html(parseInt(vol) + " GB <span style='color:#999'>[ 规格：以10G为单位采购 ]</span>");
	$("#stor_vol_price").text(volPrice + " 元/月");
	
	var bandwidth = orders.bandwidth;
	var bandwidthPrice = "";
	$("#stor_bandwidth").text(bandwidth + " Mbps");
	if(1==bandwidth || bandwidth==2 || bandwidth == 5){
		bandwidthPrice = 136;
	}else if(bandwidth ==10 || bandwidth==20 ||bandwidth ==50){
		bandwidthPrice = 132;
	}else if(bandwidth == 100){
		bandwidthPrice = 128;
	}
	$("#stor_bandwidth_price").text(bandwidth*bandwidthPrice + " 元/月");
	
	$("#stor_ip").text(orders.ipCount + " 个");
	$("#stor_ip_price").text(orders.ipCount*30 + " 元/月");
	var sumPrice = bandwidth*bandwidthPrice + orders.ipCount*30 + volPrice;
	$("#stor_sum_price").text(sumPrice + " 元/月");
}