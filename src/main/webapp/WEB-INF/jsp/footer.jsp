<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<script src="<c:url value='/js/jquery.jqGrid.src.js'/>"></script>
<style type="text/css">
#main-footer {
    bottom: 0;
    height: 47px;
    left: 0;
    position: absolute;
    width: 100%;
    border-top: 1px solid #BBBBBB;
}
.tiny {
    color: #666666;
    font-size: 12px;
    margin-bottom: 0;
    margin-top: 0;
}
.copy_right {
    height: 33px;
    margin-left: 2%;
    margin-right: 2%;
    padding-top: 4px;
    width: 98%;
    position:relative;
    z-index: 0;
}
.bottom-logo {
    float: left;
    text-align: left;
    /* width: 200px; */
    width:10%;
}
.bottom-comanpy-name {
    display: inline;
    /* padding: 0 110px; */
    width:50%;
}
.bottom-right {
    float: right;
    /* width: 370px; */
    width:15%;
}

</style>
<div id="main-footer" style="width:98%">
	<center class="tiny">
		<div class="copy_right" style="display:none">
			<div class="bottom-logo">
				<img border="0" src="<c:url value='/images/footer-logo.png'/>">
			</div>
			<div class="bottom-comanpy-name">中国联通企业云系列产品与服务介绍的最终解释权归中国联通</div>
			<div class="bottom-right">
				<img border="0" src="<c:url value='/images/bottom-right.jpg'/>">
			</div>
		</div>
	</center>
	</div>