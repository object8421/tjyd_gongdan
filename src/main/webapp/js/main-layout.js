var myLayout;
function initLayout (centerPaneResizeCallback) {

	// this layout could be created with NO OPTIONS - but showing some here just as a sample...
	// myLayout = $('body').layout(); -- syntax with No Options
	myLayout = $('#root-panel' ).layout({

		//	reference only - these options are NOT required because 'true' is the default
		closable:					true	// pane can open & close
		,	resizable:					true	// when open, pane can be resized
		,	slidable:					true	// when closed, pane can 'slide' open over other panes - closes on mouse-out
		,	livePaneResizing:			true

		//	some resizing/toggling settings
		,	north__slidable:			false	// OVERRIDE the pane-default of 'slidable=true'
		,	north__togglerLength_closed: '100%'	// toggle-button is full-width of resizer-bar
		,	north__spacing_closed:		20		// big resizer-bar when open (zero height)
		,	south__resizable:			false	// OVERRIDE the pane-default of 'resizable=true'
		,	south__spacing_open:		0		// no resizer-bar when open (zero height)
		,	south__spacing_closed:		20		// big resizer-bar when open (zero height)

		//	some pane-size settings
		,	west__minSize:				100
		,	east__size:					300
		,	east__minSize:				200
		,	east__maxSize:				.5 // 50% of layout width
		,	center__minWidth:			100
		,	center__onresize: centerPaneResizeCallback

		//	some pane animation settings
		,	west__animatePaneSizing:	false
		,	west__fxSpeed_size:			"fast"	// 'fast' animation when resizing west-pane
		,	west__fxSpeed_open:			1000	// 1-second animation when opening west-pane
		,	west__fxSettings_open:		{ easing: "easeOutBounce" } // 'bounce' effect when opening
		,	west__fxName_close:			"none"	// NO animation when closing west-pane
//		,	west__showOverflowOnHover:	true
		,	west__showOverflowOnHover:	false
		,	south: {
			side:"bottom",
			maxSize:				300,
			initClosed:true
		}
		//,south__spacing_open:false

		//	enable showOverflow on west-pane so CSS popups will overlap north pane

		//	enable state management
		,	stateManagement__enabled:	true // automatic cookie load & save enabled by default

		,	showDebugMessages:			true // log and/or display messages from debugging & testing code
	});
	//myLayout.addOpenBtn( "#tbarOpenSouth", "south" )
	//myLayout.addCloseBtn( "#tbarCloseSouth", "south" )
}


function initNestedLayout (centerPaneResizeCallback) {

	// this layout could be created with NO OPTIONS - but showing some here just as a sample...
	// myLayout = $('body').layout(); -- syntax with No Options
	myLayout = $('#root-panel' ).layout({

		//	reference only - these options are NOT required because 'true' is the default
		closable:					true	// pane can open & close
		,	resizable:					true	// when open, pane can be resized
		,	slidable:					true	// when closed, pane can 'slide' open over other panes - closes on mouse-out
		,	livePaneResizing:			true

		//	some resizing/toggling settings
		,	north__slidable:			false	// OVERRIDE the pane-default of 'slidable=true'
		,	north__togglerLength_closed: '100%'	// toggle-button is full-width of resizer-bar
		,	north__spacing_closed:		20		// big resizer-bar when open (zero height)
		,	south__resizable:			false	// OVERRIDE the pane-default of 'resizable=true'
		,	south__spacing_open:		0		// no resizer-bar when open (zero height)
		,	south__spacing_closed:		20		// big resizer-bar when open (zero height)

		//	some pane-size settings
		,	west__minSize:				100
		,   west__closable:             true  // 停用隐藏左侧列表的pane
		,   west__resizable:			true  // 停用改变左侧列表pane的大小
		,	east__size:					300
		,	east__minSize:				200
		,	east__maxSize:				.5 // 50% of layout width


		//	some pane animation settings
		,	west__animatePaneSizing:	false
		,	west__fxSpeed_size:			"fast"	// 'fast' animation when resizing west-pane
		,	west__fxSpeed_open:			1000	// 1-second animation when opening west-pane
		,	west__fxSettings_open:		{ easing: "easeOutBounce" } // 'bounce' effect when opening
		,	west__fxName_close:			"none"	// NO animation when closing west-pane
//		,	west__showOverflowOnHover:	true
		,	west__showOverflowOnHover:	false
		,	south: {
			side:"bottom",
			maxSize:				300,
			initClosed:true
		}

		//Center pane.
		, 	center__childOptions: {
			center__paneSelector:	".middle-center"
			,	south__paneSelector:		".middle-south"
			,	south__size:				100
			,	spacing_open:			8  // ALL panes
			,	spacing_closed:			12 // ALL panes

			,	center__onresize: centerPaneResizeCallback
			,   triggerEventsOnLoad: true
			// INNER-LAYOUT (child of middle-center-pane)

		}
		,	center__minWidth:			100
		//,	center__onresize: centerPaneResizeCallback

		//,south__spacing_open:false

		//	enable showOverflow on west-pane so CSS popups will overlap north pane

		//	enable state management
		,	stateManagement__enabled:	true // automatic cookie load & save enabled by default

		,	showDebugMessages:			true // log and/or display messages from debugging & testing code
	});
	//myLayout.addOpenBtn( "#tbarOpenSouth", "south" )
	//myLayout.addCloseBtn( "#tbarCloseSouth", "south" )
}
