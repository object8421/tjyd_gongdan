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
import com.chinaops.web.ydgd.entity.Customer;
import com.chinaops.web.ydgd.utils.JDBCUtils;

/**
 * 客户持久层
 * @author wb
 */
public class CustomerDaoImpl  {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	public Page selectClientInfoByName(int pageNo, int pageSize, String fuzzySearchValue) {
		Page page = new Page();
		int total = 0;
		List<Customer> lists = new ArrayList<Customer>();
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
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerAddress(rs.getString("customer_address"));
				customer.setPostalCode(rs.getString("postal_code"));
				customer.setCategory(rs.getString("category"));
				customer.setB_contact(rs.getString("b_contact"));
				customer.setB_phone(rs.getString("b_phone"));
				customer.setB_email(rs.getString("b_email"));
				customer.setT_contact(rs.getString("t_contact"));
				customer.setT_phone(rs.getString("t_phone"));
				customer.setT_email(rs.getString("t_email"));
				customer.setC_contact(rs.getString("c_contact"));
				customer.setC_phone(rs.getString("c_phone"));
				customer.setC_email(rs.getString("c_email"));
				lists.add(customer);
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

	public Customer selectClientBycustomerId(String customerId) {
		Customer customer = new Customer();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from customer where customer_id='"+ customerId+"'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				customer.setId(rs.getInt("id"));
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerAddress(rs.getString("customer_address"));
				customer.setPostalCode(rs.getString("postal_code"));
				customer.setCategory(rs.getString("category"));
				customer.setB_contact(rs.getString("b_contact"));
				customer.setB_phone(rs.getString("b_phone"));
				customer.setB_email(rs.getString("b_email"));
				customer.setT_contact(rs.getString("t_contact"));
				customer.setT_phone(rs.getString("t_phone"));
				customer.setT_email(rs.getString("t_email"));
				customer.setC_contact(rs.getString("c_contact"));
				customer.setC_phone(rs.getString("c_phone"));
				customer.setC_email(rs.getString("c_email"));
			}
			return customer;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
	}
	
}
