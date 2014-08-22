package com.chinaops.web.ydgd.entity;

import com.google.gwt.user.client.rpc.IsSerializable;
/**
 * 
 * @author liqiang.zhang@china-ops.com
 * 2014年8月22日
 *
 */
public class BusinessContact implements IsSerializable {
	
	private String name;
	
	private String phone;
	
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
