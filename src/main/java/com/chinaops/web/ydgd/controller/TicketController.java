package com.chinaops.web.ydgd.controller;

/**
 * China-Ops Inc. All Rights Reserved.
 * Author:liuyajuan
 * 2014/8/12
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaops.web.common.entity.Page;
import com.chinaops.web.ydgd.entity.Order;
import com.chinaops.web.ydgd.entity.Ticket;
import com.chinaops.web.ydgd.service.OrderService;
import com.chinaops.web.ydgd.service.TicketService;

/**
 * Description: ticket
 */
@Controller
public class TicketController {
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(TicketController.class);
	
	private TicketService ticketService;
	
	private OrderService orderService;
	
	@Autowired
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("/ticket.htm")
	public String clientPageShow(HttpServletRequest request, HttpServletResponse response) {
		return "ticket/ticket";
	}

	// 根据customerId查询指定客户的工单（根据工单类型条件过滤）
	@RequestMapping(value = "/ticket_get_list_by_customer_id.do", method = RequestMethod.POST)
	public @ResponseBody
	Page selectTicketByName(@RequestParam String stringPageNum, @RequestParam String stringPageSize, @RequestParam String ticketType, @RequestParam String customerId) {
		int pageNo = Integer.parseInt(stringPageNum);
		int pageSize = Integer.parseInt(stringPageSize);
		if (pageNo <= 1) {
			pageNo = 1;
		}
		Page page = ticketService.getTicketPageByCustomerId(pageNo, pageSize, ticketType, customerId);
		return page;
	}

	// 查询所有工单（根据工单类型或customerName条件过滤）
	@RequestMapping(value = "/ticket_get_ticket_List.do", method = RequestMethod.POST)
	public @ResponseBody
	Page getTicketPage(@RequestParam String stringPageNum, @RequestParam String stringPageSize, @RequestParam String ticketType, @RequestParam String searchValue) {
		int pageNo = Integer.parseInt(stringPageNum);
		int pageSize = Integer.parseInt(stringPageSize);
		if (pageNo <= 1) {
			pageNo = 1;
		}
		Page page = ticketService.getTicketPage(pageNo, pageSize, ticketType, searchValue);
		return page;
	}

	@RequestMapping("/ticketView.htm")
	public String view_get_ticket_by_customer_id_and_ticket_id(HttpServletRequest request, HttpServletResponse response){
		return "ticket/ticketView";
	}
	
	@RequestMapping(value = "/ticket_get_ticket_detail.json", method = RequestMethod.POST)
	public @ResponseBody Ticket getTicketDetail(@RequestParam String ticketId,HttpServletRequest request, HttpServletResponse response){
		Ticket ticket = ticketService.getTicketByTicketId(ticketId);
		Order order = orderService.getOrderByTicketId(ticketId);
		ticket.setOrder(order);
		return ticket;
	}
}
