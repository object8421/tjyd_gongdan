<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var page_size = 10;
	
	/* 显示列表项   */
	 jQuery(document).ready(function() {	
		
	 });
	
	//上一页
	function PrevPage(){
		var pageNum = $("#pageNum").text();
		if(pageNum!=1){
			$("#pageNum").text(parseInt(pageNum)-1);
			init();
		}
	}
	//下一页
	function NextPage(){
		var pageNum = $("#pageNum").text();
		var totalPage = $("#totalPage").text();
		if(pageNum!=totalPage){
			$("#pageNum").text(parseInt(pageNum)+1);
			init();
		}
	}
	//首页
	function FirstPage(){
		$("#pageNum").text(1);
		init();
	}
	//末页
	function LastPage(){
		var totalPage = $("#totalPage").text();
		$("#pageNum").text(totalPage);
		init();
	}
		// 禁用鼠标右键
		/* function norightclick(e){
			if (window.Event){
				// 判断IE版本
				if(!navigator.appVersion.match(/8./i)=='8.')	{
					if (e.which == 2 || e.which == 3)
						return false;
				}
			}else if (event.button == 2 || event.button == 3){
				event.cancelBubble = true
				event.returnValue = false;
				return false;
			}
		} 
		function nocontextmenu(event){
			event.cancelBubble = true
			event.returnValue = false;
			return false;
		} 
		document.oncontextmenu = nocontextmenu; // for IE5+
		document.onmousedown = norightclick; // for all others
	 */	
		
		/**
		 * 取得Radio的值
		 */
		function getRadioValue(radioname){
			return $("input[name="+radioname+"]:checked").val();
		}
		
		function getCookies(key,value){
			if(value!=null){
				setCookie(key,value);			
			}else{
				value =  getCookie(key);
			}
			if(value==null || value=="null"){
				return "";
			}else{
				return value;
			}
		}
		/*开始： cookies*/
		//设置COOKIE
		function setCookie(name,value,expires,path,domain,secure) {
			if(expires==null){
				expires = 36500;
			}
			var expDays = expires*24*60*60*1000;
			var expDate = new Date();
			expDate.setTime(expDate.getTime()+expDays);
			var expString = ((expires==null) ? "" : (";expires="+expDate.toGMTString()));
			var pathString = ((path==null) ? "" : (";path="+path));
			var domainString = ((domain==null) ? "" : (";domain="+domain));
			var secureString = ((secure==true) ? ";secure" : "" );
			document.cookie = name + "=" + escape(value) + expString + pathString + domainString + secureString;
		}
		//获取指定名称的cookie值：
		function getCookie(name) {
			var result = null;
			var myCookie = document.cookie + ";";
			var searchName = name + "=";
			var startOfCookie = myCookie.indexOf(searchName);
			var endOfCookie;
			if (startOfCookie != -1) {
				startOfCookie += searchName.length;
				endOfCookie = myCookie.indexOf(";",startOfCookie);
				result = unescape(myCookie.substring(startOfCookie, endOfCookie));
			}
			return result;
		}
		//删除指定名称的cookie：
		function delCookie(name) {
			var ThreeDays=3*24*60*60*1000;
			var expDate = new Date();
			expDate.setTime(expDate.getTime()-ThreeDays);
			document.cookie=name+"=;expires="+expDate.toGMTString();
		}
		/*结束： cookies*/
		
	
	/**
	 *判断输入是否只是数字
	 **/
	function checkNum(value){
		var patrn=/^[0-9]*$/;   ///^[1-9]\\d*|0$/; 
		if (!patrn.exec(value)) 
			return true ;
		return false ;
	}
		
	//只能输入字母、数字、下划线、中划线、中文。
	function checkInput(value){
		var reg = /^[A-Za-z0-9_-\u554A-\u9C52]+$/; //\u4e00-\u9fa5 中文。
		if (!reg.test(value)){
			return true;
		}
		return false;
	}
	//只能输入字母、数字、下划线、中划线
	function checkValue(value){
		var reg = /^[A-Za-z0-9_-]+$/; 
		if (!reg.test(value)){
			return true;
		}
		return false;
	}
	
	function htmlEncode(value){
		var str;
	 	if(value.contains("<") || value.contains(">") || value.contains('"')){
	 		str = value.replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll('"',"&quot;"); 			
	 		return str;
	 	}else if(value.contains("&lt;") || value.contains("&gt;") || value.contains("&quot;")) {
	 		str = value.replaceAll("&lt;","&amp;lt;").replaceAll("&gt;","&amp;gt;").replaceAll("&quot;","&amp;quot;"); 			
	 		return str;
	 	}else{
	 		return value;	
	 	}
	}
		
</script>
