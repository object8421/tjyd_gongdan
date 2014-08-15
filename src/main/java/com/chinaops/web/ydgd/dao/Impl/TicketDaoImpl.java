package com.chinaops.web.ydgd.dao.Impl;

/**
 * China-Ops Inc. All Rights Reserved.
 * Author:liuyajuan
 * 2014/8/12
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chinaops.web.common.entity.Page;
import com.chinaops.web.ydgd.entity.Ticket;
import com.chinaops.web.ydgd.utils.JDBCUtils;
import com.mysql.jdbc.PreparedStatement;

/**
 * 工单信息
 * 
 * @author liu
 */
public class TicketDaoImpl {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement  ptmt =null;

	public Page selectTicketByName(int pageNo, int pageSize,
			String fuzzySearchValue,String customerId) {
		Page page = new Page();
		int total = 0;
		List<Ticket> lists = new ArrayList<Ticket>();
		int currentPage = (pageNo - 1) * pageSize;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String countSql = "";
			String listSql = "";
			if (fuzzySearchValue.equals("") || fuzzySearchValue == null) {
				listSql = "select ticket.* ,customer.customer_name from ticket join customer on ticket.customer_id=customer.customer_id "
						+"where customer.customer_id= '"+customerId
						+"'"
						+ " order by id desc limit " + (currentPage) + ","
						+ pageSize + ";";
				countSql = "select count(*) from ticket join customer on ticket.customer_id=customer.customer_id "
						+"where customer.customer_id= '"+customerId
						+"'"
						;
								
			} else {
				listSql = "select ticket.* ,customer.customer_name from ticket join customer on ticket.customer_id=customer.customer_id ";
				listSql +="where customer.customer_id= '"+customerId+"'";
				listSql += "and customer.customer_name like '%" + fuzzySearchValue
						+ "%'";
				listSql += " order by id desc limit " + (currentPage) + ","
						+ pageSize + ";";
				countSql = "select count(*) from ticket join customer on ticket.customer_id=customer.customer_id ";
				countSql += "where customer.customer_id= '"+customerId+"'";
				countSql += " and customer.customer_name like '%" + fuzzySearchValue
						+ "%'";
			}
			//countSql="select count(*) from ticket join customer on ticket.customer_id=customer.customer_id and  "+" customer.customer_name like '%" + fuzzySearchValue
				//	+ "%'";
			rs = stmt.executeQuery(countSql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
			rs = stmt.executeQuery(listSql);
			while (rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setId(rs.getInt("id"));
				ticket.setTicketId(rs.getString("ticket_id"));
				ticket.setCustomerId(rs.getString("customer_id"));
				ticket.setTicket_type(rs.getString("ticket_type"));
				ticket.setTicketState(rs.getString("ticket_state"));
				ticket.setReceiveTime(rs.getTimestamp("receive_time"));
				ticket.setIsUse(rs.getInt("is_use"));
				ticket.setRemark(rs.getString("remark"));
				ticket.setSendTime(rs.getTimestamp("send_time"));
				ticket.setCustomerName(rs.getString("customer_name"));
				lists.add(ticket);
			}

			// 总记录数
			page.setTotalNumber(total);
			// 当前页
			page.setCurrentPage(pageNo);
			//按多少条记录进行分页
			page.setPageSize(pageSize);
			// 分页的数据
			page.setList(lists);
			// 总页数
			page.setTotalPage(page.getTotalNumber() % pageSize == 0 ? page
					.getTotalNumber() / pageSize : page.getTotalNumber()
					/ pageSize + 1);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		return page;
	}
	public List<Ticket> selectOpenTicketByCustomerId(String customerId) {
		List<Ticket> lists = new ArrayList<Ticket>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String listSql = "";
			listSql = "select * from ticket where customer_id= '"+customerId+"' and ticket_type='open'";
			rs = stmt.executeQuery(listSql);
			while (rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setId(rs.getInt("id"));
				ticket.setTicketId(rs.getString("ticket_id"));
				ticket.setCustomerId(rs.getString("customer_id"));
				ticket.setTicket_type(rs.getString("ticket_type"));
				ticket.setTicketState(rs.getString("ticket_state"));
				ticket.setReceiveTime(rs.getTimestamp("receive_time"));
				ticket.setIsUse(rs.getInt("is_use"));
				ticket.setRemark(rs.getString("remark"));
				ticket.setSendTime(rs.getTimestamp("send_time"));
				lists.add(ticket);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		return lists;
	}
	public List<Ticket> selectTicketByCustomerId(String customerId) {
		List<Ticket> lists = new ArrayList<Ticket>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String listSql = "";
			listSql = "select * from ticket where customer_id= '"+customerId+"'";
			rs = stmt.executeQuery(listSql);
			while (rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setId(rs.getInt("id"));
				ticket.setTicketId(rs.getString("ticket_id"));
				ticket.setCustomerId(rs.getString("customer_id"));
				ticket.setTicket_type(rs.getString("ticket_type"));
				ticket.setTicketState(rs.getString("ticket_state"));
				ticket.setReceiveTime(rs.getTimestamp("receive_time"));
				ticket.setIsUse(rs.getInt("is_use"));
				ticket.setRemark(rs.getString("remark"));
				ticket.setSendTime(rs.getTimestamp("send_time"));
				lists.add(ticket);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		return lists;
	}
}
