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
import com.chinaops.web.ydgd.entity.Customer;
import com.chinaops.web.ydgd.entity.Order;
import com.chinaops.web.ydgd.entity.User;
import com.chinaops.web.ydgd.service.CustomerService;
import com.chinaops.web.ydgd.service.OrderService;



/**
 * Description:
 * client
 */
@Controller
public class CustomerController {
	
	@SuppressWarnings("unused")
	private static final Log  log = LogFactory.getLog(CustomerController.class);
	
	private CustomerService customerService;
	
	private OrderService orderService;
	
//	private TicketService ticketService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
//	@Autowired
//	public void setTicketService(TicketService ticketService) {
//		this.ticketService = ticketService;
//	}


	@RequestMapping("/client.htm")
	public String clientPageShow(HttpServletRequest request, HttpServletResponse response){
		return "client/client";
	}
	/**
	 * 获得客户列表，分页查询、根据客户名称模糊查询
	 * @param pageNum
	 * @param pageSize
	 * @param filterName
	 * @param request
	 * @return
	 */
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
		Page p = customerService.selectClientInfoByName(pageNo, pageSizes, filterName);
		Page pages = new Page();
		if(p!=null){
			@SuppressWarnings("unchecked")
			List<Customer> customers = (List<Customer>)p.getList();
			List<Customer> newList = new ArrayList<Customer>();
			if(customers != null && customers.size()>0){
				for(int i=0;i<customers.size();i++){
					Customer c = new Customer();
					c = customers.get(i);
					c.setUser(user);
					newList.add(c);
				}
			}
			pages = p;
			pages.setList(newList);
		}
		return pages;
	}
   
	/**
	 * 根据客户ID查询客户基本信息
	 * @param customerId
	 * @return
	 */
	@RequestMapping(value = "/client_by_customerId.do", method = RequestMethod.POST)
	public @ResponseBody Customer getClientBycustomerId(@RequestParam String customerId) {
       Customer  customer=customerService.selectClientBycustomerId(customerId);
		return customer;
	}
	/**
	 * 跳转到指定客户资源详情页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/clientResource.htm")
	public String client_get_resource_by_customer_id(HttpServletRequest request, HttpServletResponse response){
		System.out.println(request.getParameter("customerId"));
		return "client/clientResource";
	}
	/**
	 * 跳转到指定客户的详情页面
	 * @param request
	 * @param response
	 * @return
	 */
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
	
	/**
	 * 根据客户ID和产品类型(共享云、专享云、云存储)获得工单列表
	 * @param customerId
	 * @param productType
	 * @return
	 */
	@RequestMapping(value = "/client_products_by_customerId.do", method = RequestMethod.POST)
	public @ResponseBody List<Order> getProductsByCustomerIdAndProductType(@RequestParam String customerId,@RequestParam String productType) {
		//查询属于某一个客户的开通工单
		return orderService.selectOrderByProductType(customerId,productType);
	}
	/**
	 * @deprecated 跳转到客户工单列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/clientTicketList.htm")
	public String client_get_business_by_customer_id(HttpServletRequest request, HttpServletResponse response){
		return "client/clientTicketList";
	}
}	
