package com.chinaops.web.ydgd.service;

/**
 * China-Ops Inc. All Rights Reserved.
 * Author:liuyajuan
 * 2014/8/12
 */
import org.springframework.beans.factory.annotation.Autowired;

import com.chinaops.web.common.entity.Page;
import com.chinaops.web.ydgd.dao.Impl.CustomerDaoImpl;
import com.chinaops.web.ydgd.entity.Customer;

/**
 * Description:客户
 */
public class CustomerService {

	
	private CustomerDaoImpl customerDaoImpl;

	@Autowired
	public void setCustomerDaoImpl(CustomerDaoImpl customerDaoImpl) {
		this.customerDaoImpl = customerDaoImpl;
	}

	// 根据条件查找云桌面（模糊）
	public Page selectClientInfoByName(int pageNo, int pageSize, String fuzzySearchValue) {
		return this.customerDaoImpl.selectClientInfoByName(pageNo, pageSize, fuzzySearchValue);
	}

	public Customer selectClientBycustomerId(String customerId) {
		return this.customerDaoImpl.selectClientBycustomerId(customerId);

	}
}
