var page_size = 10;
function initUserList(){
	$("#data_user").html("<tr><td><img src='images/icon/loading2.gif'/></td></tr>");
	var page_no = $("#pageNum").text()
	var filter_name = $("#search_filter_name").val();
	var role_type = $("#search_role_type").val();
	$.ajax({
		type : "POST",
		url : contextPath + "/user_list.do",
		data : {pageNum:page_no,pageSize:page_size,filterName:filter_name,roleType:role_type},
		success : function(page) {
			var str = "";
			if(page != null && page.list.length > 0){
				for(var i=0;i<page.list.length;i++){
					var roleType = "";
					var role_type = page.list[i].role_type;
					if(page.list[i].role_type =="cfm"){
	                	roleType = "资源管理员";
	                }else if(page.list[i].role_type == "user"){
	                	roleType = "业务管理员";
					}else if(page.list[i].role_type == "sys"){
						roleType = "系统管理员";
					}
					str += "<tr><td width='20%'>"+page.list[i].user_name+"</td>" +
							"<td width='20%'>"+roleType+"</td>" +
							"<td width='30%'>"+page.list[i].login_name+"</td>" +
							"<td width='30%' class='opera'>";
							if(role_type != 'sys'){
								str += "[<span onclick='modifyUser("+page.list[i].id+")'>编辑</span>] [<span onclick='deleteUser("+page.list[i].id+")'>删除</span>]";
							}
							"</td></tr>";
				}
			}else{
				str += "<tr><td clospan='4'>没有用户</td></tr>"
			}
			$("#data_user").html(str);
			
			$("#totalNumber").text(page.totalNumber);
			$("#totalPage").text(page.totalPage);
//			$("#search_filter_name").val("");
//			$("#search_role_type").val("");
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

function createrUser(){
	$("#createUserDialog #span_error").text("");
	var diag = new Dialog();
	diag.Width = 460;
	diag.Height = 250;
	diag.Title = "创建用户";
	diag.InvokeElementId="createUserDialog";
	diag.OKEvent = function(){
		var username = $("#createUserDialog #user_name").val();
		var loginname = $("#createUserDialog #login_name").val();
		var roletype = $("#createUserDialog #role_type").val();
		var password = $("#createUserDialog #password").val();
		var cfmpassword = $("#createUserDialog #cfm_password").val();
		if(valid()){
			$.ajax({
				type : "POST",
				url : contextPath + "/user_add.do",
				data : {userName:username,loginName:loginname,password:password,roleType:roletype},
				success : function(result) {
					if(result == "1"){
						diag.close();
						init();
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
	};//点击确定后调用的方法
	diag.show();
}

function modifyUser(id){
	$("#modifyUserDialog #span_error").text("");
	if(id!=""){
		$.ajax({
			type : "POST",
			url : contextPath + "/user_beforeUpdate.do",
			data : {id:id},
			success : function(user) {
				if(user != null){
					$("#modifyUserDialog #user_name").val(user.user_name);
					$("#modifyUserDialog #login_name").text(user.login_name);
					$("#modifyUserDialog #role_type").get(0).value = user.role_type;
					$("#modifyUserDialog #old_password").text(user.password);
					var diag = new Dialog();
					diag.Width = 360;
					diag.Height = 250;
					diag.Title = "修改用户";
					diag.InvokeElementId = "modifyUserDialog";
					diag.OKEvent = function(){
						var username = $("#modifyUserDialog #user_name").val();
						var roletype = $("#modifyUserDialog #role_type").val();
						var password = $("#modifyUserDialog #old_password").text();
						var password2 = $("#modifyUserDialog #password").val();
						if($("#modifyUserDialog #isModPassword").attr('checked')==undefined){
							if(valid2(0)){
								$.ajax({
									type : "POST",
									url : contextPath + "/user_update.do",
									data : {id:id,userName:username,password:password,roleType:roletype},
									success : function(result) {
										if(result == "1"){
											diag.close();
											init();
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
						}else{
							if(valid2(1)){
								$.ajax({
									type : "POST",
									url : contextPath + "/user_update.do",
									data : {id:id,userName:username,password:password2,roleType:roletype},
									success : function(result) {
										if(result == "1"){
											diag.close();
											init();
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
						}
					};//点击确定后调用的方法
					diag.show();
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
	
}

function searchUser(){
	
}

function changeCheckBox(){
	if($("#modifyUserDialog #isModPassword").attr('checked')==undefined){
		$(".isModPassword").hide();
	}else{
		$(".isModPassword").show();
	}
}

function valid(){
	var username = $("#createUserDialog #user_name").val();
	var loginname = $("#createUserDialog #login_name").val();
	var roletype = $("#createUserDialog #role_type").val();
	var password = $("#createUserDialog #password").val();
	var cfmpassword = $("#createUserDialog #cfm_password").val();
	if(username == ""){
		$("#createUserDialog #span_error").text("真实姓名不能为空 !");
		return false;
	}
	if(loginname == ""){
		$("#createUserDialog #span_error").text("用户名不能为空 !");
		return false;
	}else if(checkValue(loginname)){
		$("#createUserDialog #span_error").text("用户名只能包含字母和数字 !");
		return false;
	}else{
		$("#createUserDialog #span_error").text("");
	}
	if(password == null){
		$("#createUserDialog #span_error").text("密码不能为空 !");
		return false;
	}else if(password.length < 6){
		$("#createUserDialog #span_error").text("密码不能小于6位 !");
		return false;
	}
	if(cfmpassword == null){
		$("#createUserDialog #span_error").text("确认密码不能为空 !");
		return false;
	}else if(cfmpassword.length < 6){
		$("#createUserDialog #span_error").text("确认密码不能小于6位 !");
		return false;
	}
	if(password != cfmpassword){
		$("#createUserDialog #span_error").text("两次输入的密码不一致 !");
		return false;
	}
	return true;
}
function valid2(ret){
	var username = $("#modifyUserDialog #user_name").val();
	var roletype = $("#modifyUserDialog #role_type").val();
	var password = $("#modifyUserDialog #password").val();
	var cfmpassword = $("#modifyUserDialog #cfm_password").val();
	
	if(username == ""){
		$("#modifyUserDialog #span_error").text("真实姓名不能为空 !");
		return false;
	}
	if(ret != 0){
		alert(password +" "+password.length +" "+cfmpassword);
		if(password == null){
			$("#modifyUserDialog #span_error").text("密码不能为空 !");
			return false;
		}else if(password.length < 6){
			$("#modifyUserDialog #span_error").text("密码不能小于6位 !");
			return false;
		}
		if(cfmpassword == null){
			$("#modifyUserDialog #span_error").text("确认密码不能为空 !");
			return false;
		}else if(cfmpassword.length < 6){
			$("#modifyUserDialog #span_error").text("确认密码不能小于6位 !");
			return false;
		}
		if(password != cfmpassword){
			$("#modifyUserDialog #span_error").text("两次输入的密码不一致 !");
			return false;
		}
	}
	return true;
}

function deleteUser(id){
	if(id!="" && id!=null){
		Dialog.confirm('警告：您确认要该用户吗？',function(){
			$.ajax({
				type : "POST",
				url : contextPath + "/user_delete.do",
				data : {id:id},
				success : function(result) {
					if(result == "1"){
						init();
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
		});
		
	}
}


//上一页
function PrevPage(){
	var pageNum = $("#pageNum").text();
	if(pageNum!=1){
		$("#pageNum").text(parseInt(pageNum)-1);
		initUserList();
	}
}
//下一页
function NextPage(){
	var pageNum = $("#pageNum").text();
	var totalPage = $("#totalPage").text();
	if(pageNum!=totalPage){
		$("#pageNum").text(parseInt(pageNum)+1);
		initUserList();
	}
}
//首页
function FirstPage(){
	$("#pageNum").text(1);
	initUserList();
}
//末页
function LastPage(){
	var totalPage = $("#totalPage").text();
	$("#pageNum").text(totalPage);
	initUserList();
}