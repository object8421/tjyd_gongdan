/*
 * jqMultiColSelect  a multiple column list box.
 * @author Harley Ren.
 */

( function($,undefined) {

	$.widget("ui.jqMultiColSelect", {

		options : {
			onItemSelected : null,
			valueCol : 2, // The column to be used to display value for the textbox
			hideCol : -1
		},

		_create : function() {
			var obj = this.element;
			if ($.browser.msie){
				obj.before("<div><input type='text' id='mltsel' style='width:161px;' value='' readonly='readonly'><input id='mltselbtn' type='image' src='"+ this.options.buttonImage+"' style='position:absolute;/* margin-top:1px; */clear:both;'/></div>");
				obj.css("background","#fff");
				obj.css("position","absolute");
				obj.css("z-index","2000");
			}else{
				obj.before("<div><input type='text' class='mltsel' style='width:161px;' value='' readonly='readonly'><input id='mltselbtn' type='image' src='"+ this.options.buttonImage+"' style='position:absolute'/></div>");
				obj.css("background","#fff");
				obj.css("position","absolute");
				obj.css("z-index","2000");
			}
			obj.css("border","1px solid");
//			设置文本框内的值及样式
			//obj.prev().find("input[type='text']").css("text-align","center");
			obj.prev().find("input[type='text']").val('----请选择主机类型----');
//			源代码
//			obj.prev().find("input[type='text']").val(obj.find("tr[title='def']").find("td:eq(" + this.options.valueCol + ")").text());


			if (obj.find('table').width() < obj.prev().find("input[type='text']").width()){
				obj.width("340px");//obj.prev().find("input[type='text']").width());
			}

			obj.find("th").each(function(){
				$(this).css("text-align","left");
				$(this).css("padding-right","0px");
			});

			if(this.options.hideCol != -1) {
				var colIdx = this.options.hideCol;
				obj.find("tr").each(function(){
					$(this).find("th:eq(" + colIdx + ")").css("display","none");
				});
			}

			this._value = "";

			this.rebind();

			obj.prev().find("input[type='text']").click(function(){
//				点击文本框显示Div图层信息，并设置文本框样式
				//$(this).css("text-align","left");
				obj.show();
			});

			obj.prev().find("input[type='image']").click(function(){
//				点击图片显示Div图层信息，并设置文本框样式
				//$(this).css("text-align","left");
				obj.show();
			});
		},


		/* public methods. */
		getText : function () {
			return this.element.prev().find("input[type='text']").val();
		},

		setText : function(text) {
			this.element.prev().find("input[type='text']").val(text);
		},

		getValue : function () {
			return this._value;
		},


		/** rebind click event to tr */
		rebind : function () {
			var multiColSelect = this;
			var obj = this.element;

			obj.find('tr').hover(function(){
				$(this).css("background-color","#0055aa");
				$(this).css("color","#fff");
			},function(){
				$(this).css("background-color","#fff");
				$(this).css("color","#000");
			});

			obj.find("tr").each(function(){
				$(this).find("td:eq(" + multiColSelect.options.hideCol + ")").css("display","none");

			});

			obj.find("td").each(function(){
				$(this).css("padding-right","10px");
			});

			if(this.options.hideCol != -1) {
				obj.find("tr").each( function() {
					$(this).find("td:eq(" + multiColSelect.options.hideCol + ")").css("display","none");
				});
			}

			obj.find('tr').click(function(){
				obj.prev().find("input[type='text']").val($(this).find("td:eq(" + multiColSelect.options.valueCol + ")").text());
				var data = [];
				var tds = $(this).find("td").each(function(index,elem) {
					//console.log($(this).text());
					data.push($(this).text());
				});

				/*
				if($.isFunction(options.onItemSelected)) {
					if(!options.onItemSelected.call(this,$(data))) {
						return false;
					}
				}
				*/
				multiColSelect._value = $(this).find("td:eq(" + multiColSelect.options.valueCol + ")").text();
				multiColSelect._trigger('onItemSelected',null,{data:data});

				obj.hide();
			});
		},
	});

})(jQuery);