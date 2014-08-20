var pageSize = 10;
function initTicketListCustomer(){
	$("#data_ticket").html("<tr><td><img src='images/icon/loading2.gif'/></td></tr>");
	var page_no = $("#pageNum").text();
	var filter_name = $("#search_filter_name").val();
	var ticket_type = $("#search_ticket_type").val();
	$.ajax({
		type : "POST",
		url : contextPath + "/ticket_get_list_by_customer_id.do",
		data : {stringPageNum:page_no,stringPageSize:pageSize,ticketType:ticket_type,customerId:customerId},
		success : function(page) {
			var str = "";
			if(page != null && page.list.length > 0){
				for(var i=0;i<page.list.length;i++){
					var ticketType = "";
					var ticket_type = page.list[i].ticket_type;
					if(ticket_type =="open"){
	                	ticketType = "开通工单";
	                }else if(ticket_type == "modify"){
	                	ticketType = "变更工单";
					}else if(ticket_type == "close"){
						ticketType = "关闭工单";
					}else if(ticket_type == "stop"){
						ticketType = "暂关工单";
					}else if(ticket_type == "reset"){
						ticketType = "恢复工单";
					}
					str += "<tr><td width='15%'>"+page.list[i].ticketId+"</td>" +
							"<td width='30%'>"+page.list[i].customerName+"</td>" +
							"<td width='15%'>"+ticketType+"</td>" +
							"<td width='15%'>"+page.list[i].receiveTime+"</td>" +
							"<td width='25%' class='opera'>";
							if(roleType == 'cfm'){
								str += "[<span onclick='modifyUser("+page.list[i].id+")'>编辑</span>] [<span onclick='deleteUser("+page.list[i].id+")'>查看</span>]";
							}else if(roleType == 'user'){
								str += "[<span onclick='deleteUser("+page.list[i].id+")'>查看</span>]";
							}
							"</td></tr>";
				}
			}else{
				str += "<tr><td clospan='4'>没有工单</td></tr>"
			}
			$("#data_ticket").html(str);
			
			$("#totalNumber").text(page.totalNumber);
			$("#totalPage").text(page.totalPage);
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

//上一页
function PrevPage(){
	var pageNum = $("#pageNum").text();
	if(pageNum!=1){
		$("#pageNum").text(parseInt(pageNum)-1);
		initTicketList();
	}
}
//下一页
function NextPage(){
	var pageNum = $("#pageNum").text();
	var totalPage = $("#totalPage").text();
//	alert(pageNum +" , "+totalPage);
	if(pageNum != totalPage){
		$("#pageNum").text(parseInt(pageNum)+1);
		initTicketListCustomer();
	}
}
//首页
function FirstPage(){
	$("#pageNum").text(1);
	initTicketListCustomer();
}
//末页
function LastPage(){
	var totalPage = $("#totalPage").text();
	$("#pageNum").text(totalPage);
	initTicketListCustomer();
}