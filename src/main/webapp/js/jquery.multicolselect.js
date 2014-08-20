(function($){
	$.fn.multicolselect = function(action) {

		var obj = $(this);
		obj.hide();

		var defaults = {
			buttonImage:"selectbutton.gif",  // Image to be used for the button
			valueCol:2,                   // The column to be used to display value for the textbox
			hideCol:0
		};

		var options = $.extend(defaults, action);

		return this.each(function() {

			// Method calling logic
            if (!action || action === 'init' || typeof action === 'object') {
                _init();
            } else if (action === 'rebind') {
				_rebind();
				return true;
            } else {
                $.error( 'Method ' +  action + ' does not exist' );
            }

			function _init() {
				if ($.browser.msie){
					obj.before("<div><input type='text' id='mltsel' value='' readonly='readonly'><input id='mltselbtn' type='image' src='"+options.buttonImage+"' style='position:absolute;margin-top:1px;clear:both;'/></div>");
					obj.css("background","#fff");
					obj.css("position","absolute");
					obj.css("z-index","2000");
				}else{
					obj.before("<div><input type='text' class='mltsel' value='' readonly='readonly'><input id='mltselbtn' type='image' src='"+options.buttonImage+"' style='position:absolute'/></div>");
					obj.css("background","#fff");
					obj.css("position","absolute");
					obj.css("z-index","2000");
				}

				obj.css("border","1px solid");
				obj.prev().find("input[type='text']").val(obj.find("tr[title='def']").find("td:eq("+options.valueCol+")").text());


				if (obj.find('table').width() < obj.prev().find("input[type='text']").width()){
					obj.width(obj.prev().find("input[type='text']").width());
				}



				obj.find("th").each(function(){
					$(this).css("text-align","left");
					$(this).css("padding-right","10px");
				});


				obj.find("tr").each(function(){
					//$(this).find("td:eq("+options.hideCol+")").css("display","none");
					$(this).find("th:eq("+options.hideCol+")").css("display","none");
				});

				_rebind();

				obj.prev().find("input[type='text']").click(function(){
					obj.show();
				});

				obj.prev().find("input[type='image']").click(function(){
					obj.show();
				});
			}


			/** rebind click event to tr */
			function _rebind() {
				obj.find('tr').hover(function(){
					$(this).css("background-color","#0055aa");
					$(this).css("color","#fff");
				},function(){
					$(this).css("background-color","#fff");
					$(this).css("color","#000");
				});

				obj.find("tr").each(function(){
					$(this).find("td:eq("+options.hideCol+")").css("display","none");

				});

				obj.find("td").each(function(){
					$(this).css("padding-right","10px");
				});

				obj.find("tr").each(function(){
					$(this).find("td:eq("+options.hideCol+")").css("display","none");
					//$(this).find("th:eq("+options.hideCol+")").css("display","none");
				});

				obj.find('tr').click(function(){
					obj.prev().find("input[type='text']").val($(this).find("td:eq("+options.valueCol+")").text());
					var data = [];
					var tds = $(this).find("td").each(function(index,elem) {
						//console.log($(this).text());
						data.push($(this).text());
					});

					if($.isFunction(options.onItemSelected)) {
						if(!options.onItemSelected.call(this,$(data))) {
							return false;
						}
					}

					obj.hide();
				});
			}

		});

	};


})(jQuery);
