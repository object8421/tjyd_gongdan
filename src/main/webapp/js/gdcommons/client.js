function init(){
	$("#data_client").html("<tr><td><img src='images/icon/loading2.gif'/></td></tr>");
	var page_no = $("#pageNum").text();
	var filter_name = $("#search_filter_name").val();
//	alert(page_no+" "+page_size +" "+ filter_name);
	$.ajax({
		type : "POST",
		url : contextPath + "/client_list.do",
		data : {pageNum:1,pageSize:5,filterName:filter_name},
		success : function(page) {
			var str = "";
			if(page != null && page.list.length > 0){
				for(var i=0;i<page.list.length;i++){
					str += "<form></form><tr><td width='20%'>"+page.list[i].customerId+"</td>" +
							"<td width='50%' style='text-align:left;padding-left:10px;'>"+page.list[i].customerName+"</td>" +
							"<td width='30%' class='opera'>" +
								"<form action='' name='form"+page.list[i].customerId+"' id='form"+page.list[i].customerId+"' method='POST'>" +
									"[<span onclick='resourceInfo("+page.list[i].customerId+")'>资源概况</span>] [<span onclick='businessList("+page.list[i].customerId+")'>工单列表</span>] [<span onclick='clientDetail("+page.list[i].customerId+")'>查看</span>]" +
									"<input name='customerId' type='hidden' value='"+page.list[i].customerId+"'/>";
								"</form>" +
							"</td></tr>";
				}
			}else{
				str += "<tr><td clospan='4'>没有客户</td></tr>"
			}
			$("#data_client").html(str);
			
			$("#totalNumber").html(page.totalNumber);
			$("#totalPage").html(page.totalPage);
//			$("#search_filter_name").val("");
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

function resourceInfo(customer_id){
	var form = document.getElementById("form"+customer_id);
	form.action = "clientResource.htm";
	form.submit();
}
function businessList(customer_id){
	var form = document.getElementById("form"+customer_id);
	form.action = "clientTicketList.htm";
	form.submit();
}
function clientDetail(customer_id){
	var form = document.getElementById("form"+customer_id);
	form.action = "clientDetail.htm";
	form.submit();
}
