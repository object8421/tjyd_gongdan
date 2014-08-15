package com.chinaops.web.ydgd.service;
/**
 * China-Ops Inc. All Rights Reserved.
 * Author:liuyajuan
 * 2014/8/12
 */
import java.util.List;

import com.chinaops.web.common.entity.Page;
import com.chinaops.web.ydgd.dao.Impl.TicketDaoImpl;
import com.chinaops.web.ydgd.entity.Ticket;

/**
 * Description:工单
 */
public class TicketService {

   private TicketDaoImpl ticketDaoImpl;

	public TicketDaoImpl getTicketDaoImpl() {
		return ticketDaoImpl;
	}

	public void setTicketDaoImpl(TicketDaoImpl ticketDaoImpl) {
		this.ticketDaoImpl = ticketDaoImpl;
	}

	// 工单按名称查询
	public Page selectTicketByName(int pageNo, int pageSize, String fuzzySearchValue,String customerId) {
		return this.ticketDaoImpl.selectTicketByName(pageNo, pageSize, fuzzySearchValue,customerId);
	}
	//工单按客户编号查询
	public List<Ticket> selectOpenTicketByCustomerId(String customerId ) {
		return this.ticketDaoImpl.selectOpenTicketByCustomerId(customerId);

	}
	//工单按客户编号查询
	public List<Ticket> selectTicketByCustomerId(String customerId ) {
		return this.ticketDaoImpl.selectTicketByCustomerId(customerId);
	
	}
}
