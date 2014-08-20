	//清空表单信息
	function clearForm(id) {
		$("#"+id+"_dialog input[type='text']").each(function(index,node) {
			$(this).val("");
		});
		$("#"+id+"_dialog textarea").each(function(index,node) {
			$(this).val("");
		});
		$("#"+id+"_dialog input[type='hidden']").each(function(index,node) {
			$(this).val("");
		});
		$("#"+id+"_dialog input[type='password']").each(function(index,node) {
			$(this).val("");
		});
		$("#"+id+"_msg").empty();
		$(".error-msg").empty();
	}
	//显示异常信息
	function showErrorMsg(err,content){
		 var errorList = $('#'+err);
		 errorList.empty();
		 if(content!="")
			 errorList.show().append(content);
	}
	///^[\u4E00-\u9FA5\uF900-\uFA2Da-zA-Z0-9]{1}[\u4E00-\u9FA5\uF900-\uFA2Da-zA-Z0-9\._\-]{0,253}$/
	//判读只能输入中文
	function china(value){
		if(/[\u4e00-\u9fa5]/i.test(value))
    		return true;
    	return false;
	}
	/**
     * 只能输入数字和.
     */
    function keyPressCheck(event){
    	var eve = event.keyCode;
    	if(eve==0)
    		eve = event.charCode;
    	
		if((eve <48 ||  eve >57) && eve !=0 && eve!=46 && eve!=8){
			event.returnValue=false;
			event.preventDefault();  
		}
    }
    //只能位数字
    function numPressCheck(event){
    	var eve = event.keyCode;
    	if(eve==0)
    		eve = event.charCode;
    	
		if(eve <48 ||  eve >57){
			event.returnValue=false;
			event.preventDefault();  
		}
    }
	/**
	 * 判断IP是否符合格式
	 */
	function ipChk(IPStr){
		var exp=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
	    var reg = IPStr.match(exp);
	    if(reg==null){
	        return false;
	    }
	    else{
	        return true;
	    }
	}
	//参数返回空
	function convretStr(obj){
		if(obj==null || obj =="" || obj == "undefined" || obj=="0" || obj=="null"){
			return "";
		}
		return obj;
	}
	//文件名称校验
	function isWindowNaming(str){
		str = String(str);
		var reg = "\\/:\\*\"<>^（）￥%&|?+!";
		if(str=="")
			return true;
		for (var i = 0; i < str.length; i++) {
		    if(reg.indexOf(str.charAt(i)) >= 0)
				return false;
		}
		return true;
	}
	//是否包含
	String.prototype.contains = function(substr){
		return contains(this,substr,true);
	}
	/**
	 *string:原始字符串
	 *substr:子字符串
	 *isIgnoreCase:忽略大小写
	 */
	function contains (str,substr,isIgnoreCase){
		if(isIgnoreCase){
			str=str.toLowerCase();
			substr=substr.toLowerCase();
		}
		//alert(substr + " " + str);
		var startChar=substr.substring(0,1);
		var strLen=substr.length;
		for(var j=0;j<str.length-strLen+1;j++){
			if(str.charAt(j)==startChar){//如果匹配起始字符,开始查找
				if(str.substring(j,j+strLen)==substr){//如果从j开始的字符与str匹配，那ok
					return true;
				}   
			}
		}
		return false;
	}
	/** 
	 * 替换字符串
	 * reallyDo ：被替换
	 * replaceWith ：替换
	 * ignoreCase ：是否忽略大小写
	 */
	String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {   
		if (!RegExp.prototype.isPrototypeOf(reallyDo)) {   
			return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);   
		} else {   
			return this.replace(reallyDo, replaceWith);   
		}   
	}
	//判断结束字符串
	String.prototype.endsWith = function(suffix) { return this.indexOf(suffix, this.length - suffix.length) !== -1; };
	Date.prototype.format = function(format)
    {
        var o = {
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(),    //day
        "h+" : this.getHours(),   //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
        "S" : this.getMilliseconds() //millisecond
        }
        if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
        (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)if(new RegExp("("+ k +")").test(format))
        format = format.replace(RegExp.$1,
        RegExp.$1.length==1 ? o[k] :
        ("00"+ o[k]).substr((""+ o[k]).length));
        return format;
    }
	//or function endsWith(str, suffix) { return str.indexOf(suffix, str.length - suffix.length) !== -1; }
	
	//不能输入中文(主要是输入密码的验证。)
	function validateText(value) {
	    var reg = /[\u4E00-\u9FA5]/g;	
	    if(reg.test(value)){	     
	      return false;
	    }else {
	      return true;
	   }
	}