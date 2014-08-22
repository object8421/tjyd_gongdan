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

/**
 * 工单信息
 * 
 * @author liu
 */
public class TicketDaoImpl {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
//	private PreparedStatement  ptmt =null;

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
				ticket.setTicketType(rs.getString("ticket_type"));
				ticket.setTicketState(rs.getString("ticket_state"));
				if(rs.getTimestamp("receive_time") != null){
					String receiveTime = rs.getTimestamp("receive_time").toString();
					ticket.setReceiveTime(receiveTime.substring(0,receiveTime.length()-2));
				}
				ticket.setIsUse(rs.getInt("is_use"));
				ticket.setRemark(rs.getString("remark"));
				if(rs.getTimestamp("send_time") != null){
					String sendTime = rs.getTimestamp("send_time").toString();
					ticket.setSendTime(sendTime.substring(0,sendTime.length()-2));
				}
				ticket.setCustomerName(rs.getString("customer_name"));
				ticket.setIsModify(rs.getInt("is_modify"));
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
				ticket.setTicketType(rs.getString("ticket_type"));
				ticket.setTicketState(rs.getString("ticket_state"));
				if(rs.getTimestamp("receive_time") != null){
					String receiveTime = rs.getTimestamp("receive_time").toString();
					ticket.setReceiveTime(receiveTime.substring(0,receiveTime.length()-2));
				}
				ticket.setIsUse(rs.getInt("is_use"));
				ticket.setRemark(rs.getString("remark"));
				if(rs.getTimestamp("send_time") != null){
					String sendTime = rs.getTimestamp("send_time").toString();
					ticket.setSendTime(sendTime.substring(0,sendTime.length()-2));
				}
				ticket.setIsModify(rs.getInt("is_modify"));
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
				ticket.setTicketType(rs.getString("ticket_type"));
				ticket.setTicketState(rs.getString("ticket_state"));
				if(rs.getTimestamp("receive_time") != null){
					String receiveTime = rs.getTimestamp("receive_time").toString();
					ticket.setReceiveTime(receiveTime.substring(0,receiveTime.length()-2));
				}
				ticket.setIsUse(rs.getInt("is_use"));
				ticket.setRemark(rs.getString("remark"));
				if(rs.getTimestamp("send_time") != null){
					String sendTime = rs.getTimestamp("send_time").toString();
					ticket.setSendTime(sendTime.substring(0,sendTime.length()-2));
				}
				ticket.setIsModify(rs.getInt("is_modify"));
				lists.add(ticket);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		return lists;
	}
	public Page getTicketPageByCustomerId(int pageNo, int pageSize, String ticketType, String customerId){
		Page page = new Page();
	    int total = 0;
	    int  currentPage = (pageNo - 1) * pageSize;
	    List<Ticket> lists = new ArrayList<Ticket>();
	    String where = "";
	    String sql = "select c.customer_name ,t.* from ticket t left join customer c on t.customer_id = c.customer_id ";
	    String sqlCount = "select count(*) from ticket t left join customer c on t.customer_id = c.customer_id ";
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			if(ticketType != null && !ticketType.equals("")){
				where += " where t.ticket_type = '" + ticketType +"' and c.customer_id = '"+ customerId +"' ";
			}else{
				where += " where c.customer_id = '"+ customerId +"' ";
			}
			
			sql += where + " " +  "order by t.ticket_id limit " + (currentPage) + "," + pageSize + ";";
			sqlCount += where;
			System.out.println("sql = "+sql +"\nsqlCount="+sqlCount);
			rs = stmt.executeQuery(sqlCount);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setId(rs.getInt("id"));
				ticket.setTicketId(rs.getString("ticket_id"));
				ticket.setCustomerId(rs.getString("customer_id"));
				ticket.setTicketType(rs.getString("ticket_type"));
				ticket.setTicketState(rs.getString("ticket_state"));
				if(rs.getTimestamp("receive_time") != null){
					String receiveTime = rs.getTimestamp("receive_time").toString();
					ticket.setReceiveTime(receiveTime.substring(0,receiveTime.length()-2));
				}
				ticket.setIsUse(rs.getInt("is_use"));
				ticket.setRemark(rs.getString("remark"));
				if(rs.getTimestamp("send_time") != null){
					String sendTime = rs.getTimestamp("send_time").toString();
					ticket.setSendTime(sendTime.substring(0,sendTime.length()-2));
				}
				ticket.setCustomerName(rs.getString("customer_name"));
				ticket.setIsModify(rs.getInt("is_modify"));
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
			page.setTotalPage(page.getTotalNumber() % pageSize == 0 ? page.getTotalNumber() / pageSize : page.getTotalNumber()/pageSize + 1);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		return page;
	}
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param ticketType
	 * @param searchValue(customerName)
	 * @return
	 */
	public Page getTicketPage(int pageNo, int pageSize, String ticketType, String searchValue) {
		Page page = new Page();
	    List<Ticket> lists = new ArrayList<Ticket>();
	    int  currentPage = (pageNo - 1) * pageSize;
	    int total = 0;
	    String where = "";
	    String sql = "select c.customer_name ,t.* from ticket t left join customer c on t.customer_id = c.customer_id ";
	    String sqlCount = "select count(*) from ticket t left join customer c on t.customer_id = c.customer_id ";
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			if(ticketType != null && !ticketType.equals("")){
				if(searchValue != null && !searchValue.equals("")){
					where += " where t.ticket_type = '" + ticketType +"' and c.customer_name like '%"+ searchValue +"%' ";
				}else {
					where += " where t.ticket_type = '" + ticketType +"' ";
				}
			}else{
				if(searchValue != null && !searchValue.equals("")){
					where += " where c.customer_name like '%"+ searchValue +"%' ";
				}
			}
			
			sql += where + " " +  "order by t.ticket_id limit " + (currentPage) + "," + pageSize + ";";
			sqlCount += where;
			System.out.println("sql = "+sql +"\nsqlCount="+sqlCount);
			rs = stmt.executeQuery(sqlCount);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setId(rs.getInt("id"));
				ticket.setTicketId(rs.getString("ticket_id"));
				ticket.setCustomerId(rs.getString("customer_id"));
				ticket.setTicketType(rs.getString("ticket_type"));
				ticket.setTicketState(rs.getString("ticket_state"));
				if(rs.getTimestamp("receive_time") != null){
					String receiveTime = rs.getTimestamp("receive_time").toString();
					ticket.setReceiveTime(receiveTime.substring(0,receiveTime.length()-2));
				}
				ticket.setIsUse(rs.getInt("is_use"));
				ticket.setRemark(rs.getString("remark"));
				if(rs.getTimestamp("send_time") != null){
					String sendTime = rs.getTimestamp("send_time").toString();
					ticket.setSendTime(sendTime.substring(0,sendTime.length()-2));
				}
				ticket.setCustomerName(rs.getString("customer_name"));
				ticket.setIsModify(rs.getInt("is_modify"));
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
			page.setTotalPage(page.getTotalNumber() % pageSize == 0 ? page.getTotalNumber() / pageSize : page.getTotalNumber()/pageSize + 1);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		return page;
	}
	public Ticket getTicketByTicketId(String ticketId) {
		Ticket ticket = new Ticket();
		String sql = "select * from ticket where ticket_id = '" + ticketId + "';";
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ticket.setId(rs.getInt("id"));
				ticket.setTicketId(rs.getString("ticket_id"));
				ticket.setCustomerId(rs.getString("customer_id"));
				ticket.setTicketType(rs.getString("ticket_type"));
				ticket.setTicketState(rs.getString("ticket_state"));
				if(rs.getTimestamp("receive_time") != null){
					String receiveTime = rs.getTimestamp("receive_time").toString();
					ticket.setReceiveTime(receiveTime.substring(0,receiveTime.length()-2));
				}
				ticket.setIsUse(rs.getInt("is_use"));
				ticket.setRemark(rs.getString("remark"));
				if(rs.getTimestamp("send_time") != null){
					String sendTime = rs.getTimestamp("send_time").toString();
					ticket.setSendTime(sendTime.substring(0,sendTime.length()-2));
				}
				ticket.setIsModify(rs.getInt("is_modify"));
			}
			return ticket;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
	}
}
