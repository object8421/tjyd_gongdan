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
import com.chinaops.web.ydgd.entity.ClientInfo;
import com.chinaops.web.ydgd.service.ClientService;
import com.chinaops.web.ydgd.service.TicketService;



/**
 * Description:
 * ticket
 */
@Controller
public class TicketController {
	private static final Log  log=LogFactory.getLog(TicketController.class);
	private TicketService ticketService;
	
	@Autowired
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	@RequestMapping("/ticket.htm")
	public String clientPageShow( HttpServletRequest request, HttpServletResponse response){
		return "ticket/ticket";
	}
	//根据客户名称进行模糊查询
	@RequestMapping(value = "/selectTicketByName.do", method = RequestMethod.GET)
	public @ResponseBody
	Page selectTicketByName(@RequestParam String stringPageNum, @RequestParam String stringPageSize, @RequestParam String fuzzySearchValue,@RequestParam String customerId) {
		int pageNo = Integer.parseInt(stringPageNum);
		int pageSize = Integer.parseInt(stringPageSize);
		if (pageNo <= 1) {
			pageNo = 1;
		}
		Page p = ticketService.selectTicketByName(pageNo, pageSize, fuzzySearchValue,customerId);
		// System.out.println(p.getList());
		return p;
	}

}	
