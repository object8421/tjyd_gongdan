package com.chinaops.web.ydgd.service;

/**
 * China-Ops Inc. All Rights Reserved.
 * Author:liuyajuan
 * 2014/8/12
 */
import org.springframework.beans.factory.annotation.Autowired;

import com.chinaops.web.common.entity.Page;
import com.chinaops.web.ydgd.dao.Impl.ClientDaoImpl;
import com.chinaops.web.ydgd.entity.ClientInfo;

/**
 * Description:客户
 */
public class ClientService {

	@Autowired
	private ClientDaoImpl clientDaoImpl;

	public ClientDaoImpl getClientDaoImpl() {
		return clientDaoImpl;
	}

	public void setClientDaoImpl(ClientDaoImpl clientDaoImpl) {
		this.clientDaoImpl = clientDaoImpl;
	}

	// 根据条件查找云桌面（模糊）
	public Page selectClientInfoByName(int pageNo, int pageSize, String fuzzySearchValue) {
		return this.clientDaoImpl.selectClientInfoByName(pageNo, pageSize, fuzzySearchValue);
	}

	public ClientInfo selectClientBycustomerId(String customerId) {
		return this.clientDaoImpl.selectClientBycustomerId(customerId);

	}
}
