<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!doctype html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
 
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/CloudConsole.css">
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/MainLayout.css">
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/ecloud.css">
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/help.css">
<script type="text/javascript" src="<%=contextPath%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
</script>
<script type="text/javascript" src="<%=contextPath%>/js/scrolltopcontrol.js"></script>

<title>移动公共云服务支持与帮助</title>
<style type="text/css">
.copy_right{
    height: 33px;
    margin-left: 2%;
    margin-right: 2%;
    padding-top:4px;
    width: 98%;
}
.bottom-logo {
	float: left;
	width: 20%;
    /* text-align: left; */
}

.bottom-comanpy-name {
    padding: 0px;
	display: inline;
}

.bottom-right {
	float: right;
	width: 20%;
}

</style>
</head>
<body>
	<div id="main-header" class="main-header-chinaunicom">
		<div class="header-table">
			<div class="header-logo">
				<a href="#">
					<img src="<%=contextPath%>/images/header-logo.png">
				</a>
			</div>
			<div class="section_links">
			</div>
		</div>
	</div>
	<div class="body" style="overflow:hidden;overflow: hidden; margin-top: 70px;padding-bottom:30px;min-height:0px;">
		<div class="faq_box">
			<div class="help_left" style="position: fixed;height:478px;">
				<!-- 导航 begin -->
				<div class="faq_class">
					<ul style="font-size:12px;">
						<li style="font-weight: bold;">
							服务支持与帮助
						</li>
					 
						<li>
							<a href="#General" style="color: #4C76A0;" class="link2">一般性问题</a><span
								class="faq_class_number">(15)</span>
						</li>
						<li>
							<a href="#Fee" style="color: #4C76A0;" class="link2">收费</a><span
								class="faq_class_number">(6)</span>
						</li>
					
						<li>
							<a href="#Platform_architecture_information" style="color: #4C76A0;" class="link2">平台架构信息</a><span
								class="faq_class_number">(4)</span>
						</li>
						<li>
							<a href="#Security" style="color: #4C76A0;" class="link2">安全</a><span
								class="faq_class_number">(3)</span>
					 	</li>
						<li>
							<a href="#Elastic_IP" style="color: #4C76A0;" class="link2">弹性 IP</a><span
								class="faq_class_number">(5)</span>
						</li>
						<li>
							<a href="#Easy_to_enjoy_cloud_storage" style="color: #4C76A0;" class="link2">移动云存储</a><span
								class="faq_class_number">(8)</span>
						</li>
						<li>
							<a href="#Easy_to_enjoy_cloud_monitoring" style="color: #4C76A0;" class="link2">移动云监控</a><span
								class="faq_class_number">(5)</span>
						</li>
						<li>
							<a href="#The_Windows_and_the_third_party_software" style="color: #4C76A0;" class="link2">Windows 和第三方软件</a><span
								class="faq_class_number">(5)</span>
						</li>
						<li>
							<a href="#Class_of_service_and_technical_support" style="color: #4C76A0;" class="link2">服务等级和技术支持</a><span
								class="faq_class_number">(2)</span>
						</li>
						<li>
							<a href="#Cloud_computing_related_consulting" style="color: #4C76A0;" class="link2">专享云</a><span
								class="faq_class_number">(6)</span>
						</li>
					</ul>
				</div>
				<!-- 导航 end -->
				<div class="spacer"></div>
				<div
					style="background-color: #EEE; -moz-border-radius: 6px; -webkit-border-radius: 6px; padding:10px 20px; width: 180px">
					<div style="font-weight: bold; color: #333;">
						更多问题？
					</div>
				<!-- -->
					<div style="margin-top: 0px; color: #666; line-height: 15px;">
						如果在这里找不到答案，请
						<a href="mailto:support@china-ops.com" class="link2">点此提交在线反馈</a>，我们通常会在1个工作日内答复您。
					</div>
					<div style="font-weight: bold; color: #333; margin-top: 15px;">
						在线客服
					</div>
					<div style="margin-top: 10px; color: #666; line-height: 10px;">
						<a target=blank href=tencent://message/?uin=2630156008&Site=北京中联润通信息技术有限公司&Menu=yes><img border="0" SRC=http://wpa.qq.com/pa?p=1:2630156008:2 alt="点击这里给我发消息"></a>
						<a target=blank href=tencent://message/?uin=2403188819&Site=北京中联润通信息技术有限公司&Menu=yes><img border="0" SRC=http://wpa.qq.com/pa?p=1:2403188819:2 alt="点击这里给我发消息"></a>
					</div>
					<div style="margin-top: 5px; color: #666; line-height: 10px;">
						<a target=blank href=tencent://message/?uin=1953136966&Site=北京中联润通信息技术有限公司&Menu=yes><img border="0" SRC=http://wpa.qq.com/pa?p=1:1953136966:2 alt="点击这里给我发消息"></a>
						<a target=blank href=tencent://message/?uin=2427953277&Site=北京中联润通信息技术有限公司&Menu=yes><img border="0" SRC=http://wpa.qq.com/pa?p=1:2427953277:2 alt="点击这里给我发消息"></a>
					</div>
				</div>
			</div>

			<div class="faq_body" style="position: relative;left:241px;">

				<div style="margin-bottom: 30px;">
				</div>

				<div class="help_nav">
					<div class="help_nav_title">
						服务支持与帮助
					</div>
				<!--  -->
					<ol>
						<li>
							<h2><a name="General" style="color: #4C76A0;">一般性问题</a></h2>
							<ul>
								<li><a href="#What_is_easy_to_enjoy_cloud_platform">什么是移动云平台？</a></li>
								<li><a href="#What_can_I_do_with_Amazon_EC2">移动云平台可以用来做什么？</a></li>
								<li><a href="#How_to_start_using_the_cloud_platform_easy_to_enjoy">如何开始使用移动云平台？</a></li>
								<li><a href="#Why_do_I_need_to_submit_my_business_license_and_certification_information_registered_easy_to_enjoy_cloud">注册移动云时为什么需要提交我的企业营业执照等认证信息？</a></li>
								<li><a href="#Easy_to_enjoy_the_cloud_user_name_is_why_my_mailbox">移动云的用户名为什么可以使用我的邮箱信息？</a></li>
								<li><a href="#Enterprise_users_can_now_get_unprecedented_advantages_which">企业用户现在可以获得哪些前所未有的优势？</a></li>
								<li><a href="#How_to_run_the_system_easy_to_enjoy_cloud_platform">如何在移动云平台中运行系统？</a></li>
								<li><a href="#The_host_comes_easy_to_enjoy_cloud_system_partition_and_easy_to_enjoy_cloud_platform_storage_services_what_their_difference">移动云的主机自带的系统分区和移动云平台的存储服务有什么关系，他们的区别又是什么？</a></li>
								<li><a href="#How_fast_the_system_can_run">系统可以多快开始运行？</a></li>
								<li><a href="#How_easy_to_enjoy_the_cloud_platform_load_and_store_customers_customized_system">如何在移动云平台加载和存储客户定制化的系统？</a></li>
								<li><a href="#How_do_I_access_my_host_system">如何访问我的主机系统？</a></li>
								<li><a href="#I_can_run_the_number_of_hosts_in_the_cloud_platform_easy_to_enjoy">我可以在移动云平台中运行多少个主机？</a></li>
								<li><a href="#I_can_fast_expanding_capacity">我能够多快扩展容量？</a></li>
								<li><a href="#Which_operating_system_environment">支持哪些操作系统环境？</a></li>
								<li><a href="#What_is_the_difference_between_this_service_and_ordinary_hosting_services">此服务与普通托管服务有何不同？</a></li>
							</ul>
						</li>
						<li>
							<h2><a name="Fee" style="color: #4C76A0;">收费</a></h2>
							<ul>
								<li><a href="#How_much_does_it_cost_easy_to_enjoy_cloud_platform">使用移动云平台如何收费？</a></li>
								<li><a href="#How_to_calculate_easily_shared_cloud_platform_billing_cycle">移动云平台的账单周期怎么计算？</a></li>
								<li><a href="#Easy_to_enjoy_the_cloud_platform_if_you_need_additional_resources_how_to_billing">移动云平台如果需要追加资源，应该如何计费？</a></li>
								<li><a href="#Easy_to_enjoy_the_network_of_cloud_platforms_is_how_to_calculate_fees">移动云平台的网络收费是如何计算的？</a></li>
								<li><a href="#If_I_were_two_instances_in_different_areas_how_the_data_transmission_charges">如果我在不同的地区内有两个实例，那么数据传输如何收费？</a></li>
								<li><a href="#How_to_payment_and_invoicing">如何缴费和开具发票？</a></li>
							</ul>
						</li>
					
						<li>
							<h2><a name="Platform_architecture_information" style="color: #4C76A0;">平台架构信息</a></h2>
							<ul>
								<li><a href="#The_client_application_is_run_on_the_types_of_hardware">客户的应用程序是在哪类硬件上运行？</a></li>
								<li><a href="#How_do_I_choose_the_right_type_of_host">我如何选择正确的主机类型？</a></li>
								<li><a href="#What_is_the_ECU_unit_of_Why_introduce_this_unit">什么是“ECU计算单位”，为什么要引入此单位？</a></li>
								<li><a href="#Easy_to_enjoy_cloud_platform_can_support_a_user_comes_with_special_safety_equipment_or_other_server_storage_hardware">移动云平台能否支持用户自带的特殊安全设备或其他服务器存储硬件？</a></li>
							</ul>
						</li>
						<li>
							<h2><a name="Security" style="color: #4C76A0;">安全</a></h2>
							<ul>
								<li><a href="#How_do_I_prevent_other_people_from_viewing_my_systems">如何防止他人查看我的系统？</a></li>
								<li><a href="#Key_after_downloading_if_you_can_not_find_it_can_again_download_it">密钥下载之后，如果找不到了，还能再次下载么？</a></li>
								<li><a href="#How_to_limit_the_cloud_host_only_allows_access_from_a_designated_place">如何限制云主机只允许从指定的地点访问？</a></li>
							</ul>
						</li>
						<li>
							<h2><a name="Elastic_IP" style="color: #4C76A0;">弹性 IP</a></h2>
							<ul>
								<li><a href="#Why_each_host_with_an_elastic_IP_address">为什么每个主机配备1个弹性IP地址？</a></li>
								<li><a href="#Why_is_my_Elastic_IP_address_after_the_initial_startup_of_the_host_is_not_the_same_as_creating_specify_the_IP_address_of_the_host">为什么我的弹性 IP 地址在主机初次启动后与创建主机的指定IP地址不一样？</a></li>
								<li><a href="#Whether_each_running_instance_an_elastic_IP_address">是否每个运行的实例都需要一个弹性 IP 地址？</a></li>
								<li><a href="#How_long_it_takes_another_elastic_IP_address_to_a_host_computer_running_associated">给一台运行中的主机关联另一个弹性 IP 地址需要多长时间？</a></li>
								<li><a href="#Elastic_IP_addresses_to_configure_reverse_DNS_records">是否可以为弹性 IP 地址配置反向 DNS 记录？</a></li>
							</ul>
						</li>
						<li>
							<h2><a name="Easy_to_enjoy_cloud_storage" style="color: #4C76A0;">移动云存储</a></h2>
							<ul>
								<li><a href="#Data_within_the_host_system_to_terminate_what_would_happen">系统终止时主机内的数据会发生什么情况？</a></li>
								<li><a href="#Easy_to_enjoy_cloud_storage_to_give_customers_what_kind_of_performance">移动云存储能给客户带来什么样的性能？</a></li>
								<li><a href="#Whether_to_support_multiple_hosts_to_access_a_mounted_storage">是否支持多个主机访问一个挂载存储？</a></li>
								<li><a href="#Do_you_need_to_uninstall_the_storage_can_take_a_snapshot">是否需要卸载存储才能拍摄快照？是否需要完成快照后才能重新使用存储？</a></li>
								<li><a href="#Snapshot_ability_to_repeatedly_create_storage">快照能否多次创建存储？恢复后的存储内容恢复时间点是什么？</a></li>
								<li><a href="#Whether_to_provide_encryption_for_storage_and_snapshot">是否为存储和快照提供加密？</a></li>
								<li><a href="#Easy_to_enjoy_cloud_snapshot_How_much_does_it_cost">使用移动云的快照时如何收费？</a></li>
								<li><a href="#Whether_I_easily_enjoy_cloud_storage_snapshot_can_be_shared_with_other_departments_or_companies">我的移动云存储快照能否共享给其他部门或者公司？</a></li>
							</ul>
						</li>
						<li>
							<h2><a name="Easy_to_enjoy_cloud_monitoring" style="color: #4C76A0;">移动云监控</a></h2>								
							<ul>
								<li><a href="#The_minimum_time_interval_granularity_easy_to_enjoy_the_cloud_platform_monitoring_receiving_and_aggregating_data_is_how_much">移动云平台监控接收和聚合数据的最小时间间隔粒度是多少？</a></li>
								<li><a href="#Easy_to_enjoy_cloud_monitoring_platform_support_what_operating_system">移动云监控平台支持哪些操作系统？</a></li>
								<li><a href="#Easy_to_enjoy_cloud_monitoring_when_in_force_will_save_the_data_of_how_long">移动云的监控什么时候生效，会保存多长时间的数据？</a></li>
								<li><a href="#What_is_easy_to_enjoy_cloud_monitoring_content">移动云的监控内容是什么？</a></li>
								<li><a href="#Easy_to_enjoy_the_cloud_monitoring_service_fees">移动云监控服务是否为收费项目？</a></li>
							</ul>
						</li>
						<li>
							<h2><a name="The_Windows_and_the_third_party_software" style="color: #4C76A0;">Windows 和第三方软件</a></h2>
							<ul>
								<li><a href="#It_is_possible_to_existing_Windows_Server_license_for_easy_at_cloud_platform_host">是否可以将现有的 Windows Server 许可用于移动云平台的主机？</a></li>
								<li><a href="#What_can_I_software_license_into_Windows_environment">我可以将什么软件许可带入 Windows 环境？</a></li>
								<li><a href="#Windows_remote_login_can_change_the_display_resolution">Windows 的远程登录后能否更改显示分辨率？</a> </li>
								<li><a href="#Windows_host_is_able_to_install_antivirus_software_and_firewall">Windows 主机是否可以自行安装杀毒软件和防火墙？</a></li>
								<li><a href="#Buy_Windows_host_whether_can_use_directly_but_also_need_to_install_and_configure_it">购买Windows主机后，是否可以直接使用，还需要安装和配置么？</a></li>
							</ul>
						</li>
						<li>
							<h2><a name="Class_of_service_and_technical_support" style="color: #4C76A0;">服务等级和技术支持</a></h2>
							<ul>
								<li><a href="#Easy_to_enjoy_cloud_service_level_agreement_what_sort_of_guarantees_are_there">移动云服务等级协议有什么保证？</a></li>
								<li><a href="#How_to_judge_easily_enjoy_cloud_platform_service_to_SLA_service_standards">如何判断移动云平台的服务达到了SLA 服务标准？</a> </li>
							</ul>
						</li>
						<li>
							<h2><a name="Cloud_computing_related_consulting" style="color: #4C76A0;">专享云</a></h2>
							<ul>
								<li><a href="#Exclusive_cloud_refers_to_the_concept_of_private_cloud">专享云指的是私有云的概念吗？即计算、存储物理硬件是单独为我公司使用，不和其他人共享吗？（</a></li>
								<li><a href="#Micro_exclusive_cloud_host_pool_What_is_the_concept">微型专享云主机池是什么概念？是否有服务器集群功能？例如它包含16ECU，可能为4台物理服务器，如果其中一台坏了，计算任务是否会自动转移到其他物理服务器？</a></li>
								<li><a href="#The_the_micro_the_exclusive_cloud_host_pool_whether_only_the_virtual_hardware_server">微型专享云主机池是否仅以虚拟硬件服务器的方式提供？还是会加载操作系统？如加挂操作系统？为何种？（MS Windows, Unix, Linux）操作系统的许可证类型、数量，是否有额外费用？</a></li>
								<li><a href="#Provide_free_firewall_manufacturers_models_hardware_and_software_version_number">免费提供的防火墙的具体厂家、型号、软硬件版本号？大致安全策略？</a></li>
								<li><a href="#In_addition_to_the_monitoring_service_provided_free_of_charge_the_Division_I_own_remote_monitoring_operating_a_virtual_server">除了免费提供的监控服务外，我司是否可以自行远程监控、操作虚拟服务器？</a></li>
								<li><a href="#Unicom_online_introduction_there_is_a_cloud_products_customized_exclusive_easy_to_enjoy_cloud_solutions">在移动网上的介绍中，还有一种云产品“定制化专享移动云解决方案”。针对有专用设备要求、需要建设复杂网络结构、对带宽有较高要求、需要与用户自由系统整合的高端用户提供服务。如果我司需要，现在可否提供？如可提供，如何操作？是否有计费架构？</a></li>
							</ul>
						</li>
					</ol>
					<div class="hr">
						<h2>一般性问题</h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name="What_is_easy_to_enjoy_cloud_platform"></a><div>问：什么是移动云平台？</div></p>
								<p>移动云平台是北京移动于2012年正式面向企业用户的一个云计算（基础设施服务类型）资源租赁服务平台。客户可以通过移动云平台自由的创建属于自己的数据中心基础资源，这包括：标准的服务器、可扩展的存储空间和定制的网络带宽，用来运行客户的对外发布的应用系统，办公网络和开发环境等等。该服务可以帮助客户大大降低建设系统的时间、人力投入。</p>
								<p><a name="What_can_I_do_with_Amazon_EC2"></a><div>问：移动云平台可以用来做什么？</div></p>
								<p>客户可以通过移动云平台提供的计算、存储和网络资源自由的组合，并在其上运行客户的绝大多数应用软件和各类网站，为开发公司提供测试和开发环境，为中小企业提供办公网络环境，为科研单位提供演算服务器，为视频提供编码服务器等。因为移动云平台管理和获取资源是通过一个基于web浏览器实施的，所以计算、存储和网络这样的资源可以在短短几分钟内就准备好，大大提高了随时变化的资源需求的响应效率。而只需要按租赁的资源缴纳相应的月租费就可以了。从而大大提供平台搭建的经济性。</p>
								<p><a name="How_to_start_using_the_cloud_platform_easy_to_enjoy"></a><div>问：如何开始使用移动云平台？</div></p>
								<p>首先您需要申购移动云平台，申购的渠道有两种种，一种联络移动的销售人员，还有一种是拨打移动的移动云服务热线（400-1060608）申购。</p>
								 <p><a name="Why_do_I_need_to_submit_my_business_license_and_certification_information_registered_easy_to_enjoy_cloud"></a><div>问：注册移动云时为什么需要提交我的企业营业执照等认证信息？</div></p>
								<p>目前移动云只为企业用户提供资源租赁服务。申购的时候，如果您的应用是需要备案的对外发布的类似网站的应用，那您需要准备好备案信息，如果是不需要对外发布的类似开发测试环境的需求，您只需要准备好企业的基本资质信息就可以了。</p>
								<p><a name="Easy_to_enjoy_the_cloud_user_name_is_why_my_mailbox"></a><div>问：移动云的用户名为什么可以使用我的邮箱信息？</div></p>
								<p>移动云平台可以使用客户的常用自有邮箱作为用户名，是为了方便将移动云的服务通告能够快速有效的通过客户常用的邮箱告知客户，也便于用户记忆。</p>
								<p><a name="Enterprise_users_can_now_get_unprecedented_advantages_which"></a><div>问：企业用户现在可以获得哪些前所未有的优势？</div></p>
								<p>企业用户常常遇到需要资本购置大量的计算资源，确保企业的业务发展需求，又或者面对一个新兴的业务拓展。移动云平台可以让企业的IT管理人员利用移动云平台自有的大规模优势，不需要大量投入。现在，企业的IT管理人员知道无论其业务变得多么不确定，都可以通过相对过去更经济而简单的方式来确保具有满足业务需求的计算容量，因此他们可以尽情创新。</p>
								<p>此服务的“弹性”本质可以让企业IT管理人员即时进行扩展，满足其流量或需求峰值。当计算需求意外改变时（增加或缩小），移动云平台可以即时作出响应，这意味着企业IT人员可以在任意给定时间点上对使用多少资源进行控制。相反，传统的托管服务通常在固定的时间段内提供固定数量的资源，这就意味着当用量快速变化、不可预测或已知会在不同的时间间隔遭遇大峰值时，用户轻松响应的能力受限。</p>
								<p><a name="How_to_run_the_system_easy_to_enjoy_cloud_platform"></a><div>问：如何在移动云平台中运行系统？</div></p>
								<p>一旦客户获得了移动云自服务账户之后，便可通过系统内置的常用的系统模板启动您的云主机。在自服务系统中，有一个启动主机的向导，客户可以按照这个向导，一步一步的提交主机的具体要求，如主机配置几核CPU、多大内存，用的什么网络策略，主机的命名等等。提交后，几分钟就可以拿到一台云主机了。</p>
								<p><a name="#The_host_comes_easy_to_enjoy_cloud_system_partition_and_easy_to_enjoy_cloud_platform_storage_services_what_their_difference"></a><div>问：移动云的主机自带的系统分区和移动云平台的存储服务有什么关系，他们的区别又是什么？</div></p>
								<p>启动移动云主机时，主机自带一个启动分区用于运行主机的操作系统（windows或linux），同时客户也可以在移动云自服务界面的存储服务中创建一个单个不大于500GB的存储空间，然后绑定到指定的主机上，就可以完成对主机存储空间的扩展。如果客户停止了主机，那么主机的系统分区会处于闲置的状态，同时挂载在这台主机的存储也会处于闲置状态，客户只要重新启动主机后，之前挂载的存储则会重新挂载到主机上，如果主机的系统是windows系统，则需要在系统中的设备管理器中重新扫瞄，才能看到这个系统分区以外的其他分区，但之前其他分区的文件系统和数据会自动保留，停止主机之前的状态。所有分区都可以在闲置的时候被其他运行的主机挂载，并读写里边的数据。有的时候，这也是转移数据的便捷的一个方式。</p>
								<p><a name="How_fast_the_system_can_run"></a><div>问：系统可以多快开始运行？</div></p>
								<p>从自服务系统中选择配置并点击启动一个台主机到主机变成运行状态并可以远程访问，用时通常不到 5 分钟。这一时间由多个因素决定，包括：系统模板的大小以及多久前您启动过该系统模板。首次启动的系统模板可能需要稍长时间才能启动，通常首次被使用的系统模板启动不超过30分钟。</p>
								<p><a name="How_easy_to_enjoy_the_cloud_platform_load_and_store_customers_customized_system"></a><div>问：如何在移动云平台加载和存储客户定制化的系统？</div></p>
								<p>移动云平台暂不提供系统模板的自助定制化，需要客户将定制化的系统需求以书面的形式告知移动云客户服务邮件（yidongyun@139.com ），由移动云平台的系统研发人员，进行定制化配置和测试，待测试后会通知客户，客户就可以在自己的自服务管理界面中，看到定制化的系统模板了。</p>
								<p><a name="How_do_I_access_my_host_system"></a><div>问：如何访问我的主机系统？</div></p>
								<p>在移动云平台自服务界面的云主机页面，选择要访问的主机，然后选择”云主机登录”，系统会通过一个弹出框，告知访问这个主机的方式和参数。</p>
								<p><a name="I_can_run_the_number_of_hosts_in_the_cloud_platform_easy_to_enjoy"></a><div>问：我可以在移动云平台中运行多少个主机？</div></p>
								<p>在申购移动云平台的时候，需要客户提交希望使用的月资源上线范围，而只要不超过这个上限范围，用户可以按需启动主机，最小的主机规格为1核/1G内存，最大的单个主机规格为8核/32G内存。例如，客户成功申购了200个核、400G内存，那么就可以启动200台最小规格的主机，或者可以启动25台最大规格的主机。</p>
								<p><a name="I_can_fast_expanding_capacity"></a><div>问：我能够多快扩展容量？</div></p>
								<p>移动云平台提供真正的弹性计算环境。有了移动云平台，您可以在几分钟（而不是几小时或几天）内增加或减少容量。您可以同时启动一个、数百个，甚至数千个服务器。需要更多主机时，您只需要访问基于浏览器的移动云自服务界面，通常将在几分钟内设置您的新主机。</p>
								<p><a name="Which_operating_system_environment"></a><div>问：支持哪些操作系统环境？</div></p>
								<p>移动云平台目前支持许多种操作系统，其中包括 RedHat Linux、Windows Server、Fedora、Debian、Cent OS。我们正在设法在未来版本中提供更多种类的操作系统环境。</p>
								<p><a name="What_is_the_difference_between_this_service_and_ordinary_hosting_services"></a><div>问：此服务与普通托管服务有何不同？</div></p>
								<p>传统的托管服务通常针对固定的时间段提供预先配置的资源，成本也是预先确定的。移动云平台与其他产品截然不同，它给企业IT管理人员带来了灵活性、控制力和大幅成本节约，可以让他们将移动云视作其企业独享的数据中心，同时充分享受移动云强大基础设施的优势。</p>
								<p>当计算需求意外改变时（增加或缩小），移动云平台可以即时作出响应，这意味着企业IT管理人员可以在任意给定时间点上对使用多少资源进行控制。相反，传统的托管服务通常在固定的时间段内提供固定数量的资源，这就意味着当用量快速变化、不可预测或已知会在不同的时间间隔遭遇大峰值时，用户轻松响应的能力受限。</p>
								<p>其次，许多托管服务无法让用户完全控制所提供的计算资源。使用移动云平台时，开发人员不仅可以选择随时启动或关闭主机，而且还能根据其需求对主机配置进行全面自定义，并随时进行更改。许多托管服务更适合于具有相似系统要求的用户组，因而只提供有限的更改能力。</p>
								<p>最后，有了移动云平台，企业IT管理人员享受一大好处，即仅需支付其实际资源消耗的费用，而且费用极低。大多数托管服务要求用户预先支付固定的费用，而不管其计算能力的实际用量，这就可能造成用户为避免无法在短时间内快速增长资源而超额购买资源。</p>
							</dl>
						</div>
					<!--
						<div class="no-underline">
							<p style="text-align:right;">
								<a href="#top">
									<span class="orangedk bold txt110">↑</span>
									页首
								</a>
							</p>
						</div>
					-->
					</div>
					<div class="hr">
						<h2>费用</h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name="How_much_does_it_cost_easy_to_enjoy_cloud_platform"></a><div>问：使用移动云平台如何收费？</div></p>
								<p>移动云平台支持两种付费方式；第一种按月租赁资源用量付费。定价依据为月上限资源。收费的项目主要包括，主机的月租赁费用，带宽的月租赁费用、存储空间的租赁费用、同时还有增值服务，如主机保护、负载均衡等费用。第二种方式为预付费方式，可以选择其中的一种方式进行付费。</p>
								<p>有关移动云平台的定价信息，请联系移动云平台销售人员。</p>	
								<p><a name="How_to_calculate_easily_shared_cloud_platform_billing_cycle"></a><div>问：移动云平台的账单周期怎么计算？</div></p>
								<p>从用户获得移动云平台的账号后，到下一个自然月的当日，即为一个移动云平台的使用月，移动云平台是按照月来提供资源租赁服务的。</p>
								<p><a name="Easy_to_enjoy_the_cloud_platform_if_you_need_additional_resources_how_to_billing"></a><div>问：移动云平台如果需要追加资源，应该如何计费？</div></p>
								<p>如果客户在一个移动云账单周期内，提出希望能扩充移动云上限资源，以获取更多的资源，可以联络自己的客户代表，在成功提交增加资源的需求后，平台会在3～5个工作日调拨资源，调拨资源的快慢与资源所在机房的资源储备有关。如果遇到机房资源在做平台资源扩充维护阶段，时间会长一些。</p>
								<p><a name="Easy_to_enjoy_the_network_of_cloud_platforms_is_how_to_calculate_fees"></a><div>问：移动云平台的网络收费是如何计算的？</div></p>
								<p>移动云平台的网络租赁是依据带宽收费的，不论每月数据流量多少，只要不超过预定带宽，就固定收取带宽费用，带宽主要分两种：一种是千兆共享带宽，另外一种是定制独享带宽，独享带宽10M为最小带宽，没有上限。</p>
								<p><a name="If_I_were_two_instances_in_different_areas_how_the_data_transmission_charges"></a><div>问：如果我在不同的地区内有两个实例，那么数据传输如何收费？</div></p>
								<p>各个不同地区的主机之间的数据传输，会占用各自地区的带宽，只收取各自地区的带宽费用。</p>
								<p><a name="How_to_payment_and_invoicing"></a><div>问：如何缴费和开具发票？</div></p>
								<p>目前移动云平台的申购可以找移动的指定销售代表，但是缴费需要去移动指定的营业厅缴费，目前西单电报大楼营业厅可以收缴移动云平台的费用。然后营业厅柜台服务人员会协助客户开具发票。</p>
							</dl>
						</div>
					</div>
					<div class="hr">
						<h2>平台架构信息</h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name="The_client_application_is_run_on_the_types_of_hardware"></a><div>问：客户的应用程序是在哪类硬件上运行？</div></p>
								<p>客户的应用程序将在虚拟计算机上执行，我们称之为“云主机”。有多种主机类型可供选择，因而可选择内存、CPU和实例存储的配置，使其最适合您的应用程序。</p>
								<p><a name="cpu-type"></a>移动云主机类型及其适用性如下：</p>
								<p>
								<style>
									.cpu-type-myclass {
										border-collapse: collapse;
										border-spacing: 0px;
										
									}
									.cpu-type-myclass th {
										background: #DDD;
										border:1px solid #AAA;
										padding:8px;
									}
									.cpu-type-myclass td {
										border:1px solid #AAA;
										padding:3px 15px;
									}
								</style>
									<table class="cpu-type-myclass" style="margin:0px auto;width:334px;">
										<tr><th>主机名称</th><th>CPU</th><th>内存</th></tr>
										<tr><td>通用A型</td><td>1个CPU</td><td>1G</td></tr>
										<tr><td>通用B型</td><td>1个CPU</td><td>2G</td></tr>
										<tr><td>通用C型</td><td>1个CPU</td><td>4G</td></tr>
										<tr><td>标准A型</td><td>2个CPU</td><td>2G</td></tr>
										<tr><td>标准B型</td><td>2个CPU</td><td>4G</td></tr>
										<tr><td>标准C型</td><td>2个CPU</td><td>8G</td></tr>
										<tr><td>计算A型</td><td>4个CPU</td><td>4G</td></tr>
										<tr><td>计算B型</td><td>4个CPU</td><td>8G</td></tr>
										<tr><td>计算C型</td><td>4个CPU</td><td>16G</td></tr>
										<tr><td>超大CPU A型</td><td>8个CPU</td><td>8G</td></tr>
										<tr><td>超大CPU B型</td><td>8个CPU</td><td>16G</td></tr>
										<tr><td>超大CPU C型</td><td>8个CPU</td><td>32G</td></tr>
									</table>
								</p>
								<p><a name="How_do_I_choose_the_right_type_of_host"></a><div>问：我如何选择正确的主机类型？</div></p>
								<p>移动云平台的主机可选配置分为8种，具体8种配置请访问移动云主机类型(此链接指到移动云网站的主机类型)详细信息页面，从0.25核／0.5G内存～8核／16G内存分别是：微型云主机、微型标准云主机、通用小型云主机、计算中型云主机、通用大型云主机、计算超大型云主机和计算超大型云主机。这些主机的计算和存储是分布结构的，即在不改变已存数据的前提下，用户只需要做一个关开主机的几分钟的操作，就可以在云资源上限范围内，对主机的CPU和内存配置进行随意的升级和缩减，因此建议在不确定客户企业应用对那一款云主机更匹配时，可以选择由小启动，再根据业务负载逐级升级的方式，这样可以最大的化的提高单位资源的利用率，好在一定的云资源范围内，运行更多的主机，承载更多的应用需求。在选择主机规格类型时，应当就资源使用率方面考量您的应用程序特点，选择最佳的主机系列和大小。</p>
								<p><a name="What_is_the_ECU_unit_of_Why_introduce_this_unit"></a><div>问：什么是“ECU计算单位”，为什么要引入此单位？</div></p>
								<p>云计算集中部署的计算、存储和网络资源，然后根据客户的需求将这个集中的资源池切分交付的资源租赁服务模式，从根本上改变了企业IT管理人员对 CPU、内存、硬盘、网络等资源的惯性思维。企业IT管理人员不再需要购买或租用特定的处理器并用上数月或数年，而是以固定时间周期为单位租用容量。由于移动云平台是在商用硬件基础上构建的，随着时间推移，可能会有多种不同类型的物理硬件为移动云平台的主机提供支持。我们的目标是提供一致的CPU、内存的衡量单位，无论实际的底层硬件是什么。</p>
								<p>移动云平台通过多种衡量标准，为每个主机提供一致且可预计的标准计算能力。为了便于企业IT管理人员可以在不同的主机配置规格之间比较计算的能力，我们定义了移动云平台的ECU计算单位。一个ECU计算单位提供相当于一个 2.4 GHz 2011 Xeon 处理器5620配合2011最高性能内存2G的综合计算能力。</p>
								<p>有关更多详细信息，请参阅移动云<a href="#cpu-type">主机类型</a>(此链接指到移动云网站的主机类型)详细信息页面。</p>
								<p><a name="Easy_to_enjoy_cloud_platform_can_support_a_user_comes_with_special_safety_equipment_or_other_server_storage_hardware"></a><div>问：移动云平台能否支持用户自带的特殊安全设备或其他服务器存储硬件？</div></p>
								<p>可以，移动云主机可以允许用户自带硬件，用户只需要向客户代表提出正式的书面申请，明确告知自带硬件设施的参数和用途，移动云平台系统管理员一旦审核通过后，就可以投放到移动云平台的机房内，一旦配置成功，用户就可以通过自服务界面管理基于用户自带服务器和存储的虚拟化资源。此项服务仅面对2010年以后生产的服务器和存储设备。</p>
							</dl>
						</div>
					</div>
					<div class="hr">
						<h2>安全</h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name="How_do_I_prevent_other_people_from_viewing_my_systems"></a><div>问：如何防止他人查看我的系统？</div></p>
								<p>客户在移动云平台完全可以掌控自己的系统的可见性。移动云平台自服务平台的所有权限是独立的，部门和部门之间、客户公司和其他客户公司之间都是不可见的，同时移动云平台提供了网络虚拟防火墙，支持用户随时修改网络端口的访问策略，这其中包括可以控制访问主机的IP来源范围，杜绝互联网的恶意探测。</p>
								<p><a name="Key_after_downloading_if_you_can_not_find_it_can_again_download_it"></a><div>问：密钥下载之后，如果找不到了，还能再次下载么？</div></p>
								<p>不能，为了安全起见密钥只有在创建的时候才能下载，如果丢失的话，需要重新创建一个新的密钥，如果希望访问这个密钥关联的主机，而这个主机只有密钥访问的方式开放，那么就需要重新启动一台新的主机。</p>
								<p><a name="How_to_limit_the_cloud_host_only_allows_access_from_a_designated_place"></a><div>问：如何限制云主机只允许从指定的地点访问？</div></p>
								<p>进入中国移动企业云服务平台；</p>
								<p>在云主机列表中查看云主机所使用的网络虚拟防火墙名称；</p>
								<p>在网络虚拟防火墙详情页面查看限制云主机的22端口情况；</p>
								<p>通过网址（<a href="http://www.ip138.com" target="_blank">www.ip138.com</a>）查询指定地点出口IP，将此IP添加到22端口“来源允许范围IP”处。</p>
							</dl>
						</div>
					</div>						
					<div class="hr">
						<h2>弹性 IP</h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name="Why_each_host_with_an_elastic_IP_address"></a><div>问：为什么每个主机配备1个弹性IP地址？</div></p>
								<p>默认情况下，所有主机只使用 1 个弹性 IP 地址。如果您需要 2 个以上弹性 IP 地址，我们要求您申请可定制化的专享云服务来提高您的限制。我们会请您全面考虑您的使用情况后再下结论，帮助我们了解您对额外地址的需求。</p>
								<p><a name="Why_is_my_Elastic_IP_address_after_the_initial_startup_of_the_host_is_not_the_same_as_creating_specify_the_IP_address_of_the_host"></a><div>问：为什么我的弹性 IP 地址在主机初次启动后与创建主机的指定IP地址不一样？</div></p>
								<p>主机在由停止到正在运行的过程中，或新创建的启动过程中，会暂时用到一个随机的弹性IP，只要主机变成正在运行的状态，客户指定的IP地址就会生效，只需要刷新页面，指定的IP就会显示。</p>
								<p><a name="Whether_each_running_instance_an_elastic_IP_address"></a><div>问：是否每个运行的主机都需要一个弹性 IP 地址？</div></p>
								<p>如果是共享云，一个主机只配备一个弹性IP，如果申购的是专享云，并非所有主机都需要弹性 IP 地址。可以不需要弹性IP，也可以配置2个以上的弹性IP。共享云主机环境下，每个主机只有一个标准网卡，可配置一个 Internet 可路由公有 IP 地址。此公有地址唯一关联至该主机，直到主机停止或终止，或者替换为其他弹性 IP 地址。而专享云为了满足相对定制化程度较高和带宽能力需求较大的应用：计算集群、后端服务如数据库、缓存代理服务器或视频等都是通常不需要弹性 IP 地址或需要多个弹性IP的应用程序的例子。</p>
								<p><a name="How_long_it_takes_another_elastic_IP_address_to_a_host_computer_running_associated"></a><div>问：给一台运行中的主机关联另一个弹性 IP 地址需要多长时间？</div></p>
								<p>目前，从移动云平台种，如果是共享云，则即关联即生效，如果是定制化网络的独享云，因为划分给客户的可用IP地址都是已经全网发布过，因此的时间也会很快，通常几分钟的时间。</p>
								<p><a name="Elastic_IP_addresses_to_configure_reverse_DNS_records"></a><div>问：是否可以为弹性IP地址配置反向DNS记录？</div></p>
								<p>可以。您可以将需求以书面的形式告知移动云客户服务邮箱（yidongyun@139.com ），配置弹性IP地址的反向DNS记录。请注意，在我们能够创建反向DNS记录前，必须存在指向该弹性IP地址的对应正向DNS记录。</p>
							</dl>
						</div>
					</div>
					<div class="hr">
						<h2>移动云存储</h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name="Data_within_the_host_system_to_terminate_what_would_happen"></a><div>系统终止时主机内的数据会发生什么情况？</div></p>
								<p>存储在移动云存储上的数据将独立于主机的生命周期保留下来。也就是说，即使主机处于关机、停止、终止等非运行状态，存储的数据都会随存储永久保存，除非客户在移动云自服务管理界面将主机销毁（释放主机启动分区）或删除存储。</p>
								<p><a name="Easy_to_enjoy_cloud_storage_to_give_customers_what_kind_of_performance"></a><div>移动云存储能给客户带来什么样的性能？</div></p>
								<p>移动云存储的性能基准测试的结果是平均75MB／秒的存取，满足绝大多数应用对存储读写性能的需求。</p>
								<p><a name="Whether_to_support_multiple_hosts_to_access_a_mounted_storage"></a><div>是否支持多个主机访问一个挂载存储？</div></p>
								<p>虽然可以将多个存储连接到单个主机，目前不支持将多个主机连接到单个存储。</p>
								<p><a name="Do_you_need_to_uninstall_the_storage_can_take_a_snapshot"></a><div>是否需要卸载存储才能拍摄快照？是否需要完成快照后才能重新使用存储？</div></p>
								<p>否，可以在存储连接主机和使用期间实时拍摄快照。不过，快照只能保存已写入 移动云主机存储上的数据，可能不包含应用程序或操作系统已在本地缓存的数据。为了确保能为主机挂载的存储获得一致的快照，我们建议先彻底地断开存储和主机的连接，再发出快照命令，然后重新连接存储到主机。对于用作系统启动分区的启动存储，我们建议先关闭主机，以便能拍摄完整的快照。</p>
								<p><a name="Snapshot_ability_to_repeatedly_create_storage"></a><div>快照能否多次创建存储？恢复后的存储内容恢复时间点是什么？</div></p>
								<p>每个快照都可以不限次数的创建恢复存储，只要在被分配的存储空间上限范围内。快照恢复后的存储内容时间点是客户成功发出快照指令的存储的数据时间点，在创建快照时的操作系统和应用程序的运行在内存中的缓存信息不会被保存。</p>
								<p><a name="Whether_to_provide_encryption_for_storage_and_snapshot"></a><div>是否为存储和快照提供加密？</div></p>
								<p>否。如果加密对您而言很重要，我们建议您在存储上运行加密的文件系统。</p>
								<p><a name="Easy_to_enjoy_cloud_snapshot_How_much_does_it_cost"></a><div>使用移动云的快照时如何收费？</div></p>
								<p>移动云的快照的收费方式和价格和移动云的云主机存储是一样的。</p>
								<p><a name="Whether_I_easily_enjoy_cloud_storage_snapshot_can_be_shared_with_other_departments_or_companies"></a><div>我的移动云存储快照能否共享给其他部门或者公司？</div></p>
								<p>移动云平台的快照和存储对于其他部门或公司是不可见的。</p>
							</dl>
						</div>
					</div>
					<div class="hr">
						<h2>移动云监控</h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name="The_minimum_time_interval_granularity_easy_to_enjoy_the_cloud_platform_monitoring_receiving_and_aggregating_data_is_how_much"></a><div>问：移动云平台监控接收和聚合数据的最小时间间隔粒度是多少？</div></p>
								<p>以 5 分钟为间隔接收和聚合指标。</p>
								<p><a name="Easy_to_enjoy_cloud_monitoring_platform_support_what_operating_system"></a><div>问：移动云监控平台支持哪些操作系统？</div></p>
								<p>移动云平台监控为所有移动云的主机接收和提供指标，应该适用于移动云平台目前支持的所有操作系统。</p>
								<p><a name="Easy_to_enjoy_cloud_monitoring_when_in_force_will_save_the_data_of_how_long"></a><div>问：移动云的监控什么时候生效，会保存多长时间的数据？</div></p>
								<p>主机只要处于运行的状态，移动云主机的监控就会产生数据并显示出来，如果主机处于非运行的状态，监控不会产生数据，监控的历史记录显示到最近2周的数据。</p>
								<p><a name="What_is_easy_to_enjoy_cloud_monitoring_content"></a><div>问：移动云的监控内容是什么？</div></p>
								<p>移动云监控云主机的基本指标，包括CPU的平均负载、网络的进出流量和磁盘的读写平均负载。</p>
								<p><a name="Easy_to_enjoy_the_cloud_monitoring_service_fees"></a><div>问：移动云监控服务是否为收费项目？</div></p>
								<p>是免费的，移动云的自服务界面中的监控服务是附赠的免费项目。</p>
							</dl>
						</div>
					</div>
					<div class="hr">
						<h2>Windows 和第三方软件</h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name="It_is_possible_to_existing_Windows_Server_license_for_easy_at_cloud_platform_host"></a><div>问：是否可以将现有的 Windows Server 许可用于移动云平台的主机？</div></p>
								<p>不可以。Microsoft Windows Server 许可当前不支持在移动云主机或任何其他云环境中使用您现有的 Windows 许可。我们建议客户与 Microsoft 客户代表联络，以了解有哪些许可方案可以选择。</p>
								<p><a name="What_can_I_software_license_into_Windows_environment"></a><div>问：我可以将什么软件许可带入 Windows 环境？</div></p>
								<p>具体的软件许可条款因供应商而异。因此，我们建议您查看软件供应商的许可条款，以确定您现有的许可是否授权在移动云平台中使用。</p>
								<p><a name="Windows_remote_login_can_change_the_display_resolution"></a><div>问：Windows 的远程登录后能否更改显示分辨率？</div></p>
								<p>不可以，远程登录windows桌面以后，windows桌面的分辨率就固定了，如果希望更改远程桌面的分辨率，可以尝试使用本地远程桌面连接程序的显示选项设置连接后的windows服务器在本地电脑上显示的分辨率。</p>
								<p><a name="Windows_host_is_able_to_install_antivirus_software_and_firewall"></a><div>问：Windows 主机是否可以自行安装杀毒软件和防火墙？</div></p>
								<p>可以，但要视杀毒软件和防火墙等安全软件的许可条款，移动云平台提供网络端口的访问控制（功能可见移动云自服务管理界面中的网络虚拟防火墙），这在一定程度上避免不需要开放的端口因为没有限制而被恶意扫描并攻击，但无法确保开放的端口是安全可靠，开放的端口就取决于开放的端口相应服务程序的稳定性和安全性，因此我们建议用户考虑在windows主机上安装杀毒和防火墙软件。</p>
								<p><a name="Buy_Windows_host_whether_can_use_directly_but_also_need_to_install_and_configure_it"></a><div>问：购买Windows主机后，是否可以直接使用，还需要安装和配置么？</div></p>
								<p>需要，目前移动云平台提供的windows主机只有标准的windows基本环境，不包含任何第三方软件，交付客户的时候，只有一个远程桌面的口令，客户需要根据自己的业务需求远程登录到windows主机上，安装和配置自己的应用，如果发生主机无法远程桌面可以联络移动云平台的客服。</p>
							</dl>
						</div>
					</div>
					<div class="hr">
						<h2>服务等级和技术支持</h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name="Easy_to_enjoy_cloud_service_level_agreement_what_sort_of_guarantees_are_there"></a><div>问：移动云服务等级协议有什么保证？</div></p>
								<p>移动云平台的SLA保证在一个地区中连续 365 天期限内服务可用性达到 99.9%。</p>
								<p><a name="How_to_judge_easily_enjoy_cloud_platform_service_to_SLA_service_standards"></a><div>问：如何判断移动云平台的服务达到了SLA 服务标准？</div></p>
								<p>如果客户租赁的云平台内的资源在连续 365 天期限内测得的资源可用性累计总时长不低于365天服务总时长的99.9%，则视为达到服务标准。不可用状态的原因只限定于是因为云平台自身故障原因造成的。因主机配置不当或第三方软件问题导致的资源不可用，移动云平台可以提供分析和解决问题的辅助工作。</p>
							</dl>
						</div>
					</div>
					<div class="hr">
						<h2>专享云</h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name="Exclusive_cloud_refers_to_the_concept_of_private_cloud"></a><div>问：专享云指的是私有云的概念吗？即计算、存储物理硬件是单独为我公司使用，不和其他人共享吗？</div></p>
								<p>是的,计算、存储物理硬件是单独为贵公司使用，不和其他人共享。北京移动专享云可以被理解成是一款基于公有云的私有云。用户无需自己投入硬件设备，无需自建机房，只需要按需按月支付使用费即可。为您节约初期投入成本，后期备品备件成本以及运维成本。</p>
								<p><a name="Micro_exclusive_cloud_host_pool_What_is_the_concept"></a><div>问：微型专享云主机池是什么概念？是否有服务器集群功能？例如它包含16ECU，可能为4台物理服务器，如果其中一台坏了，计算任务是否会自动转移到其他物理服务器？</div></p>
								<p>微型专享云主机池是包含16个标准计算单元，1个标准计算单元的计算能力等于一颗2011年的Intel E5620处理器单核配合2G内存的计算能力。我们的计算和存储的搭建是基于大规模的集群环境，如果某一台物理节点发生故障，计算任务会由其他计算节点承担，不会对您的业务产生任何影响。</p>
								<p><a name="The_the_micro_the_exclusive_cloud_host_pool_whether_only_the_virtual_hardware_server"></a><div>问：微型专享云主机池是否仅以虚拟硬件服务器的方式提供？还是会加载操作系统？如加挂操作系统？为何种？（MS Windows, Unix, Linux）操作系统的许可证类型、数量，是否有额外费用？</div></p>
								<p>每一台云主机都可以根据您的需求安装不同的操作系统，对于开源的免费操作系统我们免费提供，如Centos。对于需要授权的操作系统，例如Windows 2008 Server，我们可以为您提供未激活版本的操作系统镜像，由您来自行激活。</p>
								<p><a name="Provide_free_firewall_manufacturers_models_hardware_and_software_version_number"></a><div>问：免费提供的防火墙的具体厂家、型号、软硬件版本号？大致安全策略？</div></p>
								<p>免费的防火墙是网络软防火墙，只针对共享云的产品提供服务。防火墙默认策略是关闭所有端口的访问。专享云我们可以提供物理的硬防火墙，具体厂家、型号、软硬件版本号需要根据您的需求确定，不一样的需求所产生的租用费用也不一样。</p>
								<p><a name="In_addition_to_the_monitoring_service_provided_free_of_charge_the_Division_I_own_remote_monitoring_operating_a_virtual_server"></a><div>问：除了免费提供的监控服务外，我司是否可以自行远程监控、操作虚拟服务器？</div></p>
								<p>可以，我们有一支训练有素，业务精良的7x24小时监控团队，时时刻刻保证您主机的安全。同时您可以通过北京移动移动云自服务平台对您的云主机进行CPU使用率，磁盘I/O读写，和网络流量的监控。</p>
								<p><a name="Unicom_online_introduction_there_is_a_cloud_products_customized_exclusive_easy_to_enjoy_cloud_solutions"></a><div>问：在移动网上的介绍中，还有一种云产品“定制化专享移动云解决方案”。针对有专用设备要求、需要建设复杂网络结构、对带宽有较高要求、需要与用户自由系统整合的高端用户提供服务。如果我司需要，现在可否提供？如可提供，如何操作？是否有计费架构？</div></p>
								<p>可以提供，您可以和您的客户经理提出您的需求，我们会安排专业的售前技术支持人员和您解除，根据您的需求为您量身制定解决方案。通常情况下定制化专享移动云解决方案不收费。</p>
							</dl>
						</div>
					</div>
					<div class="hr">
						<h2></h2>
						<div class="faqContent">
							<dl class="faq">
								<p><a name=""></a><div></div></p>
								<p></p>
								<p><a name=""></a><div></div></p>
								<p></p>
								<p><a name=""></a><div></div></p>
								<p></p>
							</dl>
						</div>
						<!--
						<div class="no-underline">
							<p style="text-align:right;">
								<a href="#top">
									<span class="orangedk bold txt110">↑</span>
									页首
								</a>
							</p>
						</div>
						-->
					</div>
				</div>
			</div>
			<div class="spacer"></div>
		</div>
	</div>
</div>
<div id="main-footer" style="position: static;">
	<center class="tiny">
		<div class="copy_right" style="overflow:hidden; border-top:1px dashed #CCC;padding-top:20px;display: none;">
			<div class="bottom-logo" style="width:20%;">
				<img border="0" src="<%=contextPath%>/images/liantong-littlelogo.png">
			</div>
			<div class="bottom-comanpy-name" style="width:50%;">中国移动企业云系列产品与服务介绍的最终解释权归中国移动</div>
			<div class="bottom-right" style="width:25%;display: none;">
				<img border="0" src="<%=contextPath%>/images/bottom-right.jpg">
			</div>
		</div>
	</center>
</div>
</body>
</html>
