package com.chinaops.web.ydgd.service;
/**
 * China-Ops Inc. All Rights Reserved.
 * Author:liuyajuan
 * 2014/8/12
 */
import java.util.List;

import com.chinaops.web.common.entity.Page;
import com.chinaops.web.ydgd.dao.Impl.OrderDaoImpl;
import com.chinaops.web.ydgd.dao.Impl.TicketDaoImpl;
import com.chinaops.web.ydgd.entity.Order;
import com.chinaops.web.ydgd.entity.Ticket;

/**
 * Description:定单
 */
public class OrderService {

   private OrderDaoImpl orderDaoImpl;

	public OrderDaoImpl getOrderDaoImpl() {
		return orderDaoImpl;
	}

	public void setOrderDaoImpl(OrderDaoImpl orderDaoImpl) {
		this.orderDaoImpl = orderDaoImpl;
	}


	//查询某个客户的产品类型
	public List<Order> selectProductType(String ticketIdS ) {
		return this.orderDaoImpl.selectProductType(ticketIdS);

	}
	//查询某个客户某个产品的订单信息
	public List<Order> selectOrderByProductType(String ticketIdS,String productType){
		return this.orderDaoImpl.selectOrderByProductType(ticketIdS, productType);

	}
}
