var scrolltotop={
	//startline: 鼠标向下滚动了100px后出现#topcontrol
	//scrollto: 它的值可以是整数，也可以是一个id标记。若为整数（假设为n），则滑动到距离top的n像素处；若为id标记，则滑动到该id标记所在的同等高处
	//scrollduration:滑动的速度
	//fadeduration:#topcontrol这个div的淡入淡出速度，第一个参数为淡入速度，第二个参数为淡出速度
	//controlHTML:控制向上滑动的html源码，默认为<img src="up.png" style="width:48px; height:48px" />，可以自行更改。该处的html代码会被包含在一个id标记为#topcontrol的div中。
	//controlattrs:控制#topcontrol这个div距离右下角的像素距离
	//anchorkeyword:滑动到的id标签
	/*state: isvisible:是否#topcontrol这个div为可见
	shouldvisible:是否#topcontrol这个div该出现
	*/
 
	setting: {startline:100, scrollto: 0, scrollduration:500, fadeduration:[500, 100]},
	controlHTML: "<div style='border:0'><img src='"+contextPath+"/images/top.png'></div>",
	controlattrs: {offsetx:5, offsety:5}, 
	anchorkeyword: '#top', 
 
	state: {isvisible:false, shouldvisible:false},
 
	scrollup:function(){
		if (!this.cssfixedsupport) {
			this.$control.css({opacity:0}) 
		};//点击后隐藏#topcontrol这个div
		var dest=isNaN(this.setting.scrollto)? this.setting.scrollto : parseInt(this.setting.scrollto);
		if (typeof dest=="string" && jQuery('#'+dest).length==1) { //检查若scrollto的值是一个id标记的话
			dest=jQuery('#'+dest).offset().top;
		} else { //检查若scrollto的值是一个整数
			dest=this.setting.scrollto;
		};
		this.$body.animate({scrollTop: dest}, this.setting.scrollduration);
	},
 
	keepfixed:function(){
		//获得浏览器的窗口对象
		var $window=jQuery(window);
		//获得#topcontrol这个div的x轴坐标
		var controlx=$window.scrollLeft() + $window.width() - this.$control.width() - this.controlattrs.offsetx;
		//获得#topcontrol这个div的y轴坐标
		var controly=$window.scrollTop() + $window.height() - this.$control.height() - this.controlattrs.offsety;
		//随着滑动块的滑动#topcontrol这个div跟随着滑动
		this.$control.css({left:controlx+'px', top:controly+'px'});
	},
 
	togglecontrol:function(){
		//当前窗口的滑动块的高度
		var scrolltop=jQuery(window).scrollTop();
		if (!this.cssfixedsupport) {
			this.keepfixed();
		};
		//若设置了startline这个参数，则shouldvisible为true
		this.state.shouldvisible=(scrolltop>=this.setting.startline)? true : false;
		//若shouldvisible为true，且!isvisible为true
		if (this.state.shouldvisible && !this.state.isvisible){
			this.$control.stop().animate({opacity:1}, this.setting.fadeduration[0]);
			this.state.isvisible=true;
		} //若shouldvisible为false，且isvisible为false
		else if (this.state.shouldvisible==false && this.state.isvisible){
			this.$control.stop().animate({opacity:0}, this.setting.fadeduration[1]);
			this.state.isvisible=false;
		}
	},
 
	init:function(){
		jQuery(document).ready(function($){
			var mainobj=scrolltotop;
			var iebrws=document.all;
			mainobj.cssfixedsupport=!iebrws || iebrws && document.compatMode=="CSS1Compat" && window.XMLHttpRequest; //not IE or IE7+ browsers in standards mode
			mainobj.$body=(window.opera)? (document.compatMode=="CSS1Compat"? $('html') : $('body')) : $('html,body');
 
			//包含#topcontrol这个div
			mainobj.$control=$('<div id="topcontrol">'+mainobj.controlHTML+'</div>')
				.css({position:mainobj.cssfixedsupport? 'fixed' : 'absolute', bottom:(mainobj.controlattrs.offsety + 35), right:mainobj.controlattrs.offsetx, opacity:0, cursor:'pointer'})
				.attr({title:'Scroll Back to Top'})
				.click(function(){mainobj.scrollup(); return false;})
				.appendTo('body');
 
			if (document.all && !window.XMLHttpRequest && mainobj.$control.text()!='') {//loose check for IE6 and below, plus whether control contains any text
				mainobj.$control.css({width:mainobj.$control.width()}); //IE6- seems to require an explicit width on a DIV containing text
			};
 
			mainobj.togglecontrol();
 
			//点击控制
			$('a[href="' + mainobj.anchorkeyword +'"]').click(function(){
				mainobj.scrollup();
				return false;
			});
 
			$(window).bind('scroll resize', function(e){
				mainobj.togglecontrol();
			});
		});
	}
};
 
scrolltotop.init();

/**
 * 把status enable_dynamic_password_card is_first_login 解析成文字形式
 *//*
function parseStatusToString(status){
	var s = "";
	if(status == -1){
		s = "关闭";
	}else if(status == 0){
		s = "试用";
	}else if(status == 1){
		s = "启用";
	}else if(status == 2){
		s = "审核中";
	}else{
		s = "暂关";
	}
	return s;
}
function parseCardToString(enable_dynamic_password_card){
	var s = "";
	if(status == 0){
		s = "不启用";
	}else{
		s = "启用";
	}
	return s;
}
function parseFirstToString(is_first_login){
	var s = "";
	if(status == 0){
		s = "否";
	}else{
		s = "是";
	}
	return s;
}
*//**
 * 只能输入数字
 *//*
function keyPressNum(event){
	var eve = event.keyCode;
	if(eve==0)
		eve = event.charCode;
	if((eve <48 ||  eve >57) && eve !=0 && eve!=8){
		event.returnValue=false;
		event.preventDefault();  
	}
}
*//**
 * 强制保留两位小数,不够2位时则补0
 *//*
function changeTwoDecimal_f(x){
	if(x==null || x=="" || x == "undefined")
		return "";
	var f_x = parseFloat(x);
	var f_x = Math.round(x*100)/100;
	var s_x = f_x.toString();
	var pos_decimal = s_x.indexOf('.');
	if (pos_decimal < 0){
		pos_decimal = s_x.length;
		s_x += '.';
	}
	while (s_x.length <= pos_decimal + 2){
		s_x += '0';
	}
	return s_x;
}
*//**
 * 是否为整数
 *//*
function isNum(value){
	reg = /^(-|\+)?\d+$/;
	return (reg.test(value));//整数	
}
*//**
 * 强制保留两位小数,不够2位时则补0
 *//*
function changeTwoDecimal_f(x){
	if(x==null || x=="" || x == "undefined")
		return "";
	var f_x = parseFloat(x);
	var f_x = Math.round(x*100)/100;
	var s_x = f_x.toString();
	var pos_decimal = s_x.indexOf('.');
	if (pos_decimal < 0){
		pos_decimal = s_x.length;
		s_x += '.';
	}
	while (s_x.length <= pos_decimal + 2){
		s_x += '0';
	}
	return s_x;
}
*//**
 * 格式化货币显示
 *//*
	function formatCurrency(num) {
		num = num.toString().replace(/\$|\,/g,'');
	if(isNaN(num))
	 		num = "0";
	 		sign = (num == (num = Math.abs(num)));
	 		num = Math.floor(num*100+0.50000000001);
 		 cents = num%100;
  		num = Math.floor(num/100).toString();
    if(cents<10)
 		cents = "0" + cents;
    for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
  		num = num.substring(0,num.length-(4*i+3))+','+
  		num.substring(num.length-(4*i+3));
			var value = (((sign)?'':'-') + num + '.' + cents);
		return value;
}*/