<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>中国联通企业云服务平台-inn</title>
    
	<style type="text/css">
/* css for easycloud  */
* {
	margin: 0 auto 0 auto;
	padding: 0;
	border: 0;
}

body {
	margin: 0 auto;
	text-align: center;
}

.container {
	width: 1003px;
	height: 100%;
	border: 0;
	margin: 0 auto;
	text-align: left;
}

.input_Login {
	width: 100px;
	height: 15px;
	border: 1px solid #C3D9FF;
	background: #ffffff;
	padding: 2px 0 0 3px;
}

/*top*/
.top {
	width: 1003px;
	height: 65px;
	background: url("images/top-bg.jpg") repeat-x;
}

.top_logo {
	float: left;
	width: 445px;
	height: 76px;
	text-align: left;
	margin: 10px auto 0 auto;
	padding: 5px 0 0 0;
}

.top_logo2 {
	float: left;
	width: 445px;
	height: 65px;
}

.top_wo_logo {
	float: right;
}

.top_line {
	float: none;
	width: 800px;
	height: 3px;
	background: url(images/huxian.jpg) repeat-y #F3F3F3;
}

/*main*/
.main {
	width: 1003px;
	height: 429px;
	background: url("images/center-bg.jpg") repeat-x;
	padding: 0 0 0 0;
	font-family: "宋体";
	position: relative;
}

.main_left {
	float: left;
	width: 45%;
	height: 428px;
	padding: 10px 0;
}

.left_text {
	width: 395px;
	height: 40px;
	padding: 20px 0 0 0;
}

.left_title {
	width: 395px;
	height: 25px;
	font-size: 16px;
	color: #3F3F3F;
	font-weight: bold;
	padding: 12px 0 0 3px;
}

.left_content {
	width: 395px;
	height: 60px;
	font-size: 13px;
	color: #6F7374;
	background: url(../images/xiaodian.jpg) repeat-y 13px 1px;
	line-height: 20px;
	padding: 1px 0 0 23px;
}

.left_pic {
	margin: 50px auto;
	width: 230px;
}

.right_center {
	background: url("images/login-bg.png") no-repeat;
	float: right;
	width: 550px;
	height: 350px;
	margin: 50px 0 0 ;
}

.login-form {
	margin: 108px auto;
}

.main_right {
	float: right;
	width: 335px;
	height: 350px;
}

.right_top {
	width: 335px;
	height: auto;
	padding: 20px 0 0 0;
}
/*
.right_center{width:335px;height:160px;background:url(../images/kuang02.jpg) repeat-y;font-size:14px;color:#6F7374;}
.right_user{float:left;width:255px;height:38px;padding:5% 0 0 45px;}
*/
.right_user,.right_name,.error-msg {
	width: 288px;
	margin: 5px auto;
}

.right_user input,.right_name input {width: 180px;}

.right_button {
	width: 120px;
	height: 45px;
	padding: 2% 0 0 190px;
}

.right_bottom {
	width: 335px;
	height: auto;
}

/*footer*/
.footer {
	width: 1003px;
	height: 50px;
	background: url("images/bottom-bg.jpg") repeat-x;
	font-size: 12px;
	line-height: 20px;
}

.copy_right {
    float: left;
    padding-top: 5px;
    width:390px;
    position: absolute;
}

.bottom-logo {
	float: left;
	width: 74px;
}

.bottom-comanpy-name {
	float: right;
	text-align: left;
	width: 300px;
	margin: 10px 0 10 0;
}
.hotline {float: right; margin: 15px;}

.bottom-center{width:100px;}

</style>
	
	
	<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/combo?3.1.1/build/cssreset/reset-min.css&3.1.1/build/cssfonts/fonts-min.css&3.1.1/build/cssbase/base-min.css">
	
	
<!--
	<script src="js/yui/build/yui/yui-min.js"></script>
-->
	<script src="http://yui.yahooapis.com/3.5.1/build/yui/yui-min.js"></script>
<!--
<script src="http://yui.yahooapis.com/3.1.1/build/yui/yui-min.js" type="text/javascript" charset="utf-8"></script>                                                                   
-->

<script type="text/javascript" charset="utf-8">                                                                                                                 
YUI().use('event', 'yui2-dragdrop', 'yui2-datatable', 'yui2-datasource', function (Y) {

    var YAHOO = Y.YUI2;
    
    YAHOO.example.XHR_JSON = function() {
        var formatUrl = function(elCell, oRecord, oColumn, sData) {
            elCell.innerHTML = "<a href='" + oRecord.getData("ClickUrl") + "' target='_blank'>" + sData + "</a>";
        };
        
        var formatRating = function(elCell, oRecord, oColumn, sData) {
            elCell.innerHTML = (sData === null) ? "N/A" : YAHOO.util.Number.format(sData);
        };

        var myColumnDefs = [
            {key:"Title", label:"Name", sortable:true, formatter:formatUrl},
            {key:"Phone"},
            {key:"City"},
            {key:"Rating.AverageRating", label:"Rating", formatter:formatRating, sortable:true}
        ];

        var myDataSource = new YAHOO.util.DataSource("assets/php/ylocal_proxy.php?");
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSON;
        myDataSource.connXhrMode = "queueRequests";
        myDataSource.responseSchema = {
            resultsList: "ResultSet.Result",
            fields: ["Title","Phone","City",{key:"Rating.AverageRating",parser:"number"},"ClickUrl"]
        };

        var myDataTable = new YAHOO.widget.DataTable("json", myColumnDefs,
                myDataSource, {initialRequest:"query=pizza&zip=94089&results=10&output=json"});

        var mySuccessHandler = function() {
            this.set("sortedBy", null);
            this.onDataReturnAppendRows.apply(this,arguments);
        };
        var myFailureHandler = function() {
            this.showTableMessage(YAHOO.widget.DataTable.MSG_ERROR, YAHOO.widget.DataTable.CLASS_ERROR);
            this.onDataReturnAppendRows.apply(this,arguments);
        };
        var callbackObj = {
            success : mySuccessHandler,
            failure : myFailureHandler,
            scope : myDataTable
        };
        
        myDataSource.sendRequest("query=mexican&zip=94089&results=10&output=json",
                callbackObj);

        myDataSource.sendRequest("query=chinese&zip=94089&results=10&output=json",
                callbackObj);
                
        return {
            oDS: myDataSource,
            oDT: myDataTable
        };
    }();
    
    
    
    YAHOO.example.XHR_JSON = function() {
        var formatUrl = function(elCell, oRecord, oColumn, sData) {
            elCell.innerHTML = "<a href='" + oRecord.getData("ClickUrl") + "' target='_blank'>" + sData + "</a>";
        };
        
        var formatRating = function(elCell, oRecord, oColumn, sData) {
            elCell.innerHTML = (sData === null) ? "N/A" : YAHOO.util.Number.format(sData);
        };

        var myColumnDefs = [
            {key:"Title", label:"Name", sortable:true, formatter:formatUrl},
            {key:"Phone"},
            {key:"City"},
            {key:"Rating.AverageRating", label:"Rating", formatter:formatRating, sortable:true}
        ];

        var myDataSource = new YAHOO.util.DataSource("assets/php/ylocal_proxy.php?");
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSON;
        myDataSource.connXhrMode = "queueRequests";
        myDataSource.responseSchema = {
            resultsList: "ResultSet.Result",
            fields: ["Title","Phone","City",{key:"Rating.AverageRating",parser:"number"},"ClickUrl"]
        };

        var myDataTable = new YAHOO.widget.DataTable("instance_table", myColumnDefs,
                myDataSource, {initialRequest:"query=pizza&zip=94089&results=10&output=json"});

        var mySuccessHandler = function() {
            this.set("sortedBy", null);
            this.onDataReturnAppendRows.apply(this,arguments);
        };
        var myFailureHandler = function() {
            this.showTableMessage(YAHOO.widget.DataTable.MSG_ERROR, YAHOO.widget.DataTable.CLASS_ERROR);
            this.onDataReturnAppendRows.apply(this,arguments);
        };
        var callbackObj = {
            success : mySuccessHandler,
            failure : myFailureHandler,
            scope : myDataTable
        };
        
        myDataSource.sendRequest("query=mexican&zip=94089&results=10&output=json",
                callbackObj);

        myDataSource.sendRequest("query=chinese&zip=94089&results=10&output=json",
                callbackObj);
        
        
        return {
            oDS: myDataSource,
            oDT: myDataTable
        };
    }();

});
</script>


</head>
<body class="yui-skin-sam">

<!-- body begin -->

<div class="container">
	<div id="instance_table" class="instance_table"/>
</div>
<!-- body end -->

</body>
</html>
