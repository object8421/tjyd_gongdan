function initClientDetail(customerId){
	$.ajax({
		type : "POST",
		url : contextPath + "/client_by_customerId.do",
		data : {customerId:customerId},
		success : function(result) {
			$("#customerName").text(result.customerName);
			$("#category").text(result.category);
			$("#address").text(result.customerAddress);
			$("#postalCode").text(result.postalCode);
			$("#business_contact").text(result.b_contact);
			$("#business_phone").text(result.b_phone);
			$("#business_email").text(result.b_email);
			$("#technology_contact").text(result.t_contact);
			$("#technology_phone").text(result.t_phone);
			$("#technology_email").text(result.t_email);
			$("#cName").text(result.c_contact);
			$("#cPhone").text(result.c_phone);
			$("#cEmail").text(result.c_email);
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

