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

import com.chinaops.web.ydgd.entity.Order;
import com.chinaops.web.ydgd.utils.JDBCUtils;

/**
 * 订单信息
 * 
 * @author liu
 */
public class OrderDaoImpl {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public List<Order> selectProductType(String ticketIdS) {
		List<Order> lists = new ArrayList<Order>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String listSql = "";
			listSql = "select * from orders  where ticket_id in ("+ticketIdS+") group by product_type";
			rs = stmt.executeQuery(listSql);
			while (rs.next()) {
	            Order order =new Order();
	            order.setProductType(rs.getString("product_type"));
			    lists.add(order);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		return lists;
	}
	
	public List<Order> selectOrderByProductType(String ticketIdS,String productType) {
		List<Order> lists = new ArrayList<Order>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String listSql = "";
			listSql = "select * from orders  where ticket_id in ("+ticketIdS+")and product_type='"+productType+"' ORDER BY cloud_platform";
			rs = stmt.executeQuery(listSql);
			while (rs.next()) {
	            Order order =new Order();
	            order.setId(rs.getInt("id"));
	            order.setTicketId(rs.getString("ticket_id"));
	            order.setContractId(rs.getString("contract_id"));
	            if(rs.getTimestamp("contract_signed_date") != null){
	            	String contractSignedDate = rs.getTimestamp("contract_signed_date").toString();
	            	order.setContractSignedDate(contractSignedDate.substring(0, contractSignedDate.length()-2));
	            }
	            if(rs.getTimestamp("contract_expired_date") != null){
	            	String contractExpiredDate = rs.getTimestamp("contract_expired_date").toString();
	            	order.setContractExpiredDate(contractExpiredDate.substring(0, contractExpiredDate.length()-2));
	            }
	            order.setAvailableAt(rs.getString("available_at"));
	            order.setProductType(rs.getString("product_type"));
	            order.setForWebsite(rs.getString("is_website"));
	            order.setOpenPorts(rs.getString("open_ports"));
	            order.setPortsNeedToOpen(rs.getString("ports_need_to_open"));
	            order.setSuite(rs.getString("suite"));
	            order.setDiscount(rs.getString("discount"));
	            order.setBandwidth(rs.getString("band_width"));
	            order.setIp(rs.getString("ip"));
	            order.setIpCount(rs.getString("ip_count"));	
	            order.setEcu(rs.getString("ecu"));
	            order.setStorage(rs.getString("storage"));
	            order.setSnapshot(rs.getString("snapshot"));
	            order.setKeys(rs.getString("keys"));
	            order.setSecuritys(rs.getString("securitys"));
	            order.setHa(rs.getString("ha"));
	            order.setElb(rs.getString("elb"));
	            order.setFilingNo(rs.getString("filing_no"));
	            order.setFilingIp(rs.getString("filing_ip"));
	            order.setFilingDomain(rs.getString("filing_domain"));
	            order.setRemark(rs.getString("remark"));
	            order.setIsFeesOwed(rs.getString("is_fees_owed"));
	            if(rs.getTimestamp("open_time") != null){
	            	String openTime = rs.getTimestamp("open_time").toString();
	            	order.setOpenTime(openTime.substring(0, openTime.length()-2));
	            }
	            if(rs.getTimestamp("modify_time") != null){
	            	String modifyTime = rs.getTimestamp("modify_time").toString();
	            	order.setModifyTime(modifyTime.substring(0, modifyTime.length()-2));
	            }
	            if(rs.getTimestamp("close_time") != null){
	            	String closeTime = rs.getTimestamp("close_time").toString();
	            	order.setCloseTime(closeTime.substring(0, closeTime.length()-2));
	            }
	            if(rs.getTimestamp("close_time") != null){
	            	String resetTime = rs.getTimestamp("reset_time").toString();
	            	order.setResetTime(resetTime.substring(0, resetTime.length()-2));
	            }
	            order.setReason(rs.getString("reason"));
	            order.setDetailedReason(rs.getString("detailed_reason"));
	            order.setLoginUrl(rs.getString("login_url"));
	            order.setCloudPlatform(rs.getString("cloud_platform"));
	            order.setLoginUsername(rs.getString("login_username"));
	            order.setLoginPassword(rs.getString("login_password"));
			    lists.add(order);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		return lists;
	}

	public Order getOrderByTicketId(String ticketId) {
		Order order =new Order();
		String sql = "select * from orders where ticket_id='"+ticketId+"';";
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
	            order.setId(rs.getInt("id"));
	            order.setTicketId(rs.getString("ticket_id"));
	            order.setContractId(rs.getString("contract_id"));
	            if(rs.getTimestamp("contract_signed_date") != null){
	            	String contractSignedDate = rs.getTimestamp("contract_signed_date").toString();
	            	order.setContractSignedDate(contractSignedDate.substring(0, contractSignedDate.length()-2));
	            }
	            if(rs.getTimestamp("contract_expired_date") != null){
	            	String contractExpiredDate = rs.getTimestamp("contract_expired_date").toString();
	            	order.setContractExpiredDate(contractExpiredDate.substring(0, contractExpiredDate.length()-2));
	            }
	            order.setAvailableAt(rs.getString("available_at"));
	            order.setProductType(rs.getString("product_type"));
	            order.setForWebsite(rs.getString("is_website"));
	            order.setOpenPorts(rs.getString("open_ports"));
	            order.setPortsNeedToOpen(rs.getString("ports_need_to_open"));
	            order.setSuite(rs.getString("suite"));
	            order.setDiscount(rs.getString("discount"));
	            order.setBandwidth(rs.getString("band_width"));
	            order.setIp(rs.getString("ip"));
	            order.setIpCount(rs.getString("ip_count"));	
	            order.setEcu(rs.getString("ecu"));
	            order.setStorage(rs.getString("storage"));
	            order.setSnapshot(rs.getString("snapshot"));
	            order.setKeys(rs.getString("keys"));
	            order.setSecuritys(rs.getString("securitys"));
	            order.setHa(rs.getString("ha"));
	            order.setElb(rs.getString("elb"));
	            order.setFilingNo(rs.getString("filing_no"));
	            order.setFilingIp(rs.getString("filing_ip"));
	            order.setFilingDomain(rs.getString("filing_domain"));
	            order.setRemark(rs.getString("remark"));
	            order.setIsFeesOwed(rs.getString("is_fees_owed"));
	            if(rs.getTimestamp("open_time") != null){
	            	String openTime = rs.getTimestamp("open_time").toString();
	            	order.setOpenTime(openTime.substring(0, openTime.length()-2));
	            }
	            if(rs.getTimestamp("modify_time") != null){
	            	String modifyTime = rs.getTimestamp("modify_time").toString();
	            	order.setModifyTime(modifyTime.substring(0, modifyTime.length()-2));
	            }
	            if(rs.getTimestamp("close_time") != null){
	            	String closeTime = rs.getTimestamp("close_time").toString();
	            	order.setCloseTime(closeTime.substring(0, closeTime.length()-2));
	            }
	            if(rs.getTimestamp("close_time") != null){
	            	String resetTime = rs.getTimestamp("reset_time").toString();
	            	order.setResetTime(resetTime.substring(0, resetTime.length()-2));
	            }
	            order.setReason(rs.getString("reason"));
	            order.setDetailedReason(rs.getString("detailed_reason"));
	            order.setLoginUrl(rs.getString("login_url"));
	            order.setCloudPlatform(rs.getString("cloud_platform"));
	            order.setLoginUsername(rs.getString("login_username"));
	            order.setLoginPassword(rs.getString("login_password"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		return order;
	}
	
}
