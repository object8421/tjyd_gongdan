<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page 
import="java.util.*"
import="org.springframework.context.*"
import="org.springframework.context.support.*"
import="com.chinaops.cloud.framework.PrivilegeManager"
import="org.springframework.security.core.context.SecurityContextHolder"
import="com.chinaops.cloud.auth.shared.*"
import="com.chinaops.web.common.entity.EcloudUserDetails"
import="com.chinaops.ecloud.s3.openservices.model.Bucket"
import="com.chinaops.ecloud.s3.openservices.EcloudS3"
import="com.chinaops.ecloud.s3.openservices.EcloudS3Client"
%>
<%
//ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
//PrivilegeManager privilegeManager = (PrivilegeManager) context.getBean("privilegeManager");
//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//User user = new User();
//user.setId(((EcloudUserDetails)principal).getId());        
//List<Privilege> privileges = privilegeManager.getUserPrivileges(user, PrivilegeCategory.ElasticInstance.toString());
//Map<String,List<Privilege>> priviMap = new HashMap<String,List<Privilege>>();
//for(Privilege priv : privileges) {
//	if(!priviMap.containsKey(priv.getGroup())) {
//	    priviMap.put(priv.getGroup(), new ArrayList<Privilege>());
//	}
//	priviMap.get(priv.getGroup()).add(priv);
//}
	String endpoint = "http://192.168.234.123";
	String accessKey = "t6if6LjReQbMJJheXtlRVVLl52rx7awYmPZlA";
	String secretKey = "cCpaqqWpIKgEov3KnH2J7PiI0cqsx5kREorsw";
	EcloudS3 ecloudS3 = new EcloudS3Client(endpoint, accessKey, secretKey);
%>
	<style type="text/css">
		<style>
		body,h1,h2,h3,h4,h5,h6,p,ul,li,dl,dt,dd{padding:0;margin:0;}
		li{list-style:none;}img{border:none;}em{font-style:normal;}
		a{color:#000;text-decoration:none;outline:none;blr:this.onFocus=this.blur();}
		a:hover{color:#000;text-decoration:none;}
		body{font-size:12px;font-family:Arial,Verdana, Helvetica, sans-serif;word-break:break-all;word-wrap:break-word;}
		.clear{height:0;overflow:hidden;clear:both;}
		.UpLayer{ float:right;margin-left:-10px; }
		.UpLayer dl dt{width:45px;position:absolute; z-index:9999;line-height:20px;}
		.UpLayer02{/*border:#ccc 1px solid; border-bottom:none;background:#f1f1f1; margin:-1px 0 0 -1px;*/}
		.UpLayer dl dd{ /*width:80px;*/position:absolute;z-index:9999;border:#ccc 1px solid;padding:5px; line-height:20px; background:#fff; display:none; margin:25px 0 0 -1px;}
		.UpLayer dl dd a{ display:block;border-bottom:#ccc 1px dashed;width:105px;text-align:left;}
	</style>
	<script type="text/javascript">
	var objStr = ".UpLayer";
	function show(){
		$(objStr).each(function(i){
				$($(objStr+" dd")[i]).show();
				$($(objStr+" dt")[i]).addClass("UpLayer02");
		});
	}
	document.onclick = function(){
		$(objStr).each(function(i){
				$($(objStr+" dd")[i]).hide();
				$($(objStr+" dt")[i]).removeClass("UpLayer02");
		});
    }
	</script>
	<div class="menu-title">
		<div class="title">Buckets</div><input id="create_bucket" class="button-menu2" type="button" onclick="javascript:showBucket();" value=""/>
		<div class="UpLayer">
		    <dl>
		        <dt style="line-height:28px;left:100px;" class="up-dt"><a href="javascript:show();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></dt>
		        <dd style="left: 72px; top: 40px;">
		            <a href="javascript:showBucket();" style="border-bottom:0px;"><img src="../css/images/bucket.gif"/>创建Bucket</a>
		            <a href="#"><img src="../css/images/del.gif"/>删除</a>
		            <a href="#"><img src="../css/images/ref.gif"/>刷新</a>
		            <a href="#"><img src="../css/images/change.gif"/>切换S3</a>
		        </dd>
		    </dl>	
		</div>
	</div>
	<div id="menu" class="menu-group">
		<%
		//Bucket [name=aakt2, creationDate=Tue Nov 27 02:37:55 CST 2012, owner=Owner [name=fca6,id=null]]
		List<Bucket> bList = ecloudS3.listBuckets();
		if(null!=bList && !bList.isEmpty()){
			Object bucket_sess = session.getAttribute("bucket_sess");
			String bucket_name = "";
			for (int i = 0; i < bList.size(); i++) {
				Bucket b = bList.get(i);
				if(i==0){
					bucket_name = b.getName();
					// 先判断bucket_sess，为空使用第一个。充当默认		
				}
		 %>
		<div class="left-menuitem" id="menu-<%=i%>">
			<a href="<%=request.getContextPath() %>/bucket/s3-home.htm?bucket_name=<%=b.getName() %>" /><span class="menu-bar-title"><%=b.getName() %></span></a>
		</div>
		<%}%>
		<%
			if(bucket_sess!=null){
				bucket_name = bucket_sess.toString();
			}
		%>
			<br/>
			<input type="hidden" id="all_bucket_name" value="<%=bucket_name %>"  />
		<%}%>
	</div>
	<style>
<!--
.se {
	background:url("../css/images/bucket-index.gif") no-repeat scroll 0 0px #2E6E9E;
	border-radius:5px;
	color:#FF0000;
}
-->
</style>
	<script type="text/javascript">
<!--
	$("#menu-0").addClass("se");
	$("#menu >div").click(function(){
	    $(this).addClass("se").siblings().removeClass("se");
	})
	$(".left-menuitem").live("click", function() {
	  $(this).addClass("se").siblings().removeClass("se");
	});
//-->
</script>
