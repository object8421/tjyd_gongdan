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
import com.chinaops.web.ydgd.entity.ClientInfo;
import com.chinaops.web.ydgd.utils.JDBCUtils;

/**
 * 客户持久层
 * @author wb
 */
public class ClientDaoImpl  {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	public Page selectClientInfoByName(int pageNo, int pageSize, String fuzzySearchValue) {
		Page page = new Page();
		int total = 0;
		List<ClientInfo> lists = new ArrayList<ClientInfo>();
		int currentPage = (pageNo - 1) * pageSize;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String countSql = "";
			String listSql = "";
			if (fuzzySearchValue.equals("") || fuzzySearchValue == null) {
				listSql = "select * from customer " + " order by id desc limit " + (currentPage) + "," + pageSize + ";";
				countSql = "select count(*) from customer ";
			} else {
				listSql = "select * from customer  where customer_name like '%" + fuzzySearchValue + "%' order by id desc limit " + (currentPage) + "," + pageSize + ";";
				countSql = "select count(*) from customer  where customer_name like '%" + fuzzySearchValue + "%'";
			}

			rs = stmt.executeQuery(countSql);
			while (rs.next()) {
				total = rs.getInt(1);
			}

			rs = stmt.executeQuery(listSql);
			while (rs.next()) {
				ClientInfo clientInfo = new ClientInfo();
				clientInfo.setId(rs.getInt("id"));
				clientInfo.setCustomerId(rs.getString("customer_id"));
				clientInfo.setCustomerName(rs.getString("customer_name"));
				clientInfo.setCustomerAddress(rs.getString("customer_address"));
				clientInfo.setPostalCode(rs.getString("postal_code"));
				clientInfo.setCategory(rs.getString("category"));
				clientInfo.setB_contact(rs.getString("b_contact"));
				clientInfo.setB_phone(rs.getString("b_phone"));
				clientInfo.setB_email(rs.getString("b_email"));
				clientInfo.setT_contact(rs.getString("t_contact"));
				clientInfo.setT_phone(rs.getString("t_phone"));
				clientInfo.setT_email(rs.getString("t_email"));
				clientInfo.setC_contact(rs.getString("c_contact"));
				clientInfo.setC_phone(rs.getString("c_phone"));
				clientInfo.setC_email(rs.getString("c_email"));
				lists.add(clientInfo);
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
			page.setTotalPage(page.getTotalNumber() % pageSize == 0 ? page.getTotalNumber() / pageSize : page.getTotalNumber() / pageSize + 1);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		return page;
	}

	public ClientInfo selectClientBycustomerId(String customerId) {
		ClientInfo clientInfo = new ClientInfo();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from customer where customer_id='"+ customerId+"'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				clientInfo.setId(rs.getInt("id"));
				clientInfo.setCustomerId(rs.getString("customer_id"));
				clientInfo.setCustomerName(rs.getString("customer_name"));
				clientInfo.setCustomerAddress(rs.getString("customer_address"));
				clientInfo.setPostalCode(rs.getString("postal_code"));
				clientInfo.setCategory(rs.getString("category"));
				clientInfo.setB_contact(rs.getString("b_contact"));
				clientInfo.setB_phone(rs.getString("b_phone"));
				clientInfo.setB_email(rs.getString("b_email"));
				clientInfo.setT_contact(rs.getString("t_contact"));
				clientInfo.setT_phone(rs.getString("t_phone"));
				clientInfo.setT_email(rs.getString("t_email"));
				clientInfo.setC_contact(rs.getString("c_contact"));
				clientInfo.setC_phone(rs.getString("c_phone"));
				clientInfo.setC_email(rs.getString("c_email"));
			}
			return clientInfo;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
	}
	
}
