/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.entity;

/**
 * 
 * @author liu
 */
public class ClientInfo {
	// ========================== Attributes ============================
	private int id;
	// 客户编号
	private String customerId;
	// 客户名称
	private String customerName;
	// 客户地址
	private String customerAddress;
	// 客户邮编
	private String postalCode;
	// 客户所属行业
	private String category;
	// 业务联系人
	private String b_contact;
	// 业务联系电话
	private String b_phone;
	// 业务联系人邮箱
	private String b_email;
	// 技术联系人
	private String t_contact;
	// 技术联系人电话
	private String t_phone;
	// t_email
	private String t_email;
	// 客户经理名称
	private String c_contact;
	// 客户经理电话
	private String c_phone;
	// 客户经理邮箱
	private String c_email;

	//存储登陆用户的信息
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getB_contact() {
		return b_contact;
	}

	public void setB_contact(String b_contact) {
		this.b_contact = b_contact;
	}

	public String getB_phone() {
		return b_phone;
	}

	public void setB_phone(String b_phone) {
		this.b_phone = b_phone;
	}

	public String getB_email() {
		return b_email;
	}

	public void setB_email(String b_email) {
		this.b_email = b_email;
	}

	public String getT_contact() {
		return t_contact;
	}

	public void setT_contact(String t_contact) {
		this.t_contact = t_contact;
	}

	public String getT_phone() {
		return t_phone;
	}

	public void setT_phone(String t_phone) {
		this.t_phone = t_phone;
	}

	public String getT_email() {
		return t_email;
	}

	public void setT_email(String t_email) {
		this.t_email = t_email;
	}

	public String getC_contact() {
		return c_contact;
	}

	public void setC_contact(String c_contact) {
		this.c_contact = c_contact;
	}

	public String getC_phone() {
		return c_phone;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

}
