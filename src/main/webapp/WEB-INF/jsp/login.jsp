<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>天津移动工单平台</title>
<script src="<c:url value='/js/jquery-1.8.3.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/gd/login.css'/>" />
<style type="text/css">
</style>

<script type="text/javascript">
	jQuery(document).ready(function() {
		$(".error-msg").attr("style", "visibility:");
	});

	function submited() {
		if (window.event.keyCode == 13) {
			//window.event.keyCode=9;//模拟Tab键   
			//if (validate()) {
				//　当按下"回车键"时执行Submit事件   
				document.form1.submit();
			//}
		}
	}
	/**
	 * 换张图片
	 */
	function changeImg() {
		var imgSrc = document.getElementById("imgObj");
		var src = imgSrc.src;
		imgSrc.src = chgUrl(src);
		$("#j_captcha").focus();
	}
	//时间戳
	//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		url = "<c:url value='/captcha'/>" + "?timestamp=" + timestamp;
		return url;
	}
</script>
</head>
<body class="yui3-skin-sam">

	<!-- body begin -->

	<div class="container">
		<form method="post" action="<c:url value='/j_spring_security_check'/>">
			<!--top -->
			<div class="top">

				<div class="top_logo2">
					<img src="images/logo_bac.png" border="0">
				</div>
				<div class="top_wo_logo"></div>

			</div>

			<!-- main-->
			<div class="main">
				<div class="main_left">
					<div class="left_pic">
						<img src="images/serve-text.png" width="229" height="272"
							border="0">
					</div>
				</div>

				<!-- login form -->
				<div class="right_center">
					<div class="login-form">
						<div class="error-msg">
							<c:out
								value="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}" />
						</div>

						<div class="right_user">

							<span>用户名</span> <span> <input name="j_username"
								id="j_username" style="height: 22px;" type="text"
								class="input_Login px vm xg1" node-type="text"
								placeholder="请输入用户名"
								/* onblur="if(this.value == ''){this.value = '请输入用户名';this.className = 'input_Login px vm xg1';};"
								onfocus="if(this.value == '请输入用户名'){this.value = '';this.className = 'input_Login px vm';}"
								value="请输入用户名" id="j_username" style="height:22px;"
								*/ type="text"></span>
						</div>
						<!-- onblur="validateUserName();" -->
						<div class="right_name" style="position: relative;">
							<span>密　码</span> <input name='j_password' id='j_password'
								autocomplete="off" node-type="password" placeholder="请输入密码"
								style='height: 22px;' type='password' class='input_Login'>
							<!--[if IE]>   
<span id="prompt" style="position: absolute; top:5px; left:61px;font-size:80%;" class='px vm xg1'>请输入密码</span>
<![endif]-->
							<script type="text/javascript">
								$("#prompt").click(function() {
									$(this).hide();
									$("#j_password").focus();
								});
								$("input[name=j_password]").focus(function() {
									$("#prompt").hide();
								});
								$("input[name=j_password]").blur(function() {
									if ($(this).val() == "") {
										$("#prompt").show();
									}
								});
							</script>
						</div>
						<div class="right_captcha">
							<span>验证码</span> <span><input name="j_captcha"
								id="j_captcha" style="height: 22px; width: 40px;" type="text"
								class="input_Login" maxlength="4" /></span> <img id="imgObj"
								title="点击更换数字" src="<c:url value='/captcha'/>"
								onclick="changeImg()"
								style="cursor: pointer; height: 26px; width: 75px; position: absolute; padding-left: 5px;" />
							<a href="javascript:changeImg();"
								style="margin-left: 90px; font-size: 14px;">看不清楚？</a>
						</div>

						<div class="right_button">
							<a href="#null"><input name="ButtonLogin" id="ButtonLogin"
								src="images/login-button.jpg" type="image" border="0" width="79"
								height="29"
								onclick="javascript:$('.error-msg').attr('style','visibility:hidden');submited();"></a>
						</div>
					</div>
				</div>
				<!-- end of login form -->
			</div>
			<!--footer -->
			<jsp:include page="footer.jsp"/>
			<%-- <div class="footer">
				<div class="copy_right">
					<div class="bottom-logo" style="display: none">
						<img src="<c:url value='images/footer.png'/>" border="0" />
					</div>
				</div>
			</div> --%>
		</form>
	</div>
	<!-- body end -->

</body>
</html>
