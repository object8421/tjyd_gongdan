package com.chinaops.web.ydgd.controller;
/**
 * China-Ops Inc. All Rights Reserved.
 * Author:liuyajuan
 * 2014/8/12
 */
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaops.web.common.entity.Page;
import com.chinaops.web.common.entity.SysAdminUserDetails;
import com.chinaops.web.ydgd.entity.ClientInfo;
import com.chinaops.web.ydgd.entity.Order;
import com.chinaops.web.ydgd.entity.Ticket;
import com.chinaops.web.ydgd.entity.User;
import com.chinaops.web.ydgd.service.ClientService;
import com.chinaops.web.ydgd.service.OrderService;
import com.chinaops.web.ydgd.service.TicketService;



/**
 * Description:
 * client
 */
@Controller
public class ClientController {
	private static final Log  log=LogFactory.getLog(ClientController.class);
	
	private ClientService clientService;
	private OrderService orderService;
	private TicketService ticketService;
	
	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@Autowired
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}


	@RequestMapping("/client.htm")
	public String clientPageShow(HttpServletRequest request, HttpServletResponse response){
		return "client/client";
	}
	//根据客户名称进行模糊查询
	@RequestMapping(value = "/client_list.do", method = RequestMethod.POST)
	public @ResponseBody Page clientList(@RequestParam String pageNum,@RequestParam String pageSize,String filterName,String roleType,HttpServletRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		SysAdminUserDetails currentUser = (SysAdminUserDetails) principal;
		User user = SysAdminUserDetails.toUser(currentUser);
		
		int pageNo = Integer.parseInt(pageNum);
		int pageSizes = Integer.parseInt(pageSize);
		if (pageNo <= 1) {
		   pageNo = 1;
		}
		Page p = clientService.selectClientInfoByName(pageNo, pageSizes, filterName);
		Page pages = new Page();
		if(p!=null){
			@SuppressWarnings("unchecked")
			List<ClientInfo> clientInfos = (List<ClientInfo>)p.getList();
			List<ClientInfo> newList = new ArrayList<ClientInfo>();
			if(clientInfos != null && clientInfos.size()>0){
				for(int i=0;i<clientInfos.size();i++){
					ClientInfo c = new ClientInfo();
					c = clientInfos.get(i);
					c.setUser(user);
					newList.add(c);
				}
			}
			pages = p;
			pages.setList(newList);
		}
		return pages;
	}
   //查询客户基本信息
	/**
	 * 显示和桌面关联的用户
	 */
	@RequestMapping(value = "/client_by_customerId.do", method = RequestMethod.POST)
	public @ResponseBody ClientInfo getClientBycustomerId(@RequestParam String customerId) {
       ClientInfo  clientInfo=clientService.selectClientBycustomerId(customerId);
		return clientInfo;
	}
	
	@RequestMapping("/clientResource.htm")
	public String client_get_resource_by_customer_id(HttpServletRequest request, HttpServletResponse response){
		System.out.println(request.getParameter("customerId"));
		return "client/clientResource";
	}
	@RequestMapping("/clientDetail.htm")
	public String client_get_detail_by_customer_id(HttpServletRequest request, HttpServletResponse response){
		return "client/clientDetail";
	}
	
	/**
	 * 查询一个客户订购的产品类型
	 */

	@RequestMapping(value = "/client_product_type_by_customerId.do", method = RequestMethod.POST)
	public @ResponseBody List<Order> getProductByCustomerId(@RequestParam String customerId) {
		//查询属于某一个客户的开通工单
		return orderService.selectProductType(customerId);
	}
	@RequestMapping(value = "/client_products_by_customerId.do", method = RequestMethod.POST)
	public @ResponseBody List<Order> getProductsByCustomerIdAndProductType(@RequestParam String customerId,@RequestParam String productType) {
		//查询属于某一个客户的开通工单
		return orderService.selectOrderByProductType(customerId,productType);
	}
	
	@RequestMapping("/clientTicketList.htm")
	public String client_get_business_by_customer_id(HttpServletRequest request, HttpServletResponse response){
		System.out.println(request.getParameter("customerId"));
		return "client/clientTicketList";
	}
}	
