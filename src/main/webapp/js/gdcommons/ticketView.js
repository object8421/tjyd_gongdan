

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
			}else if(product_type == 'exclusive'){
				productType = "专享云";
			}else if(product_type == 'storage'){
				productType = "云存储";
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