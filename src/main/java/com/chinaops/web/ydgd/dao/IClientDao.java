/**
 * China-Ops Inc. All Rights Reserved.
 * Author: ljyang
 * 2011-3-29 上午11:08:57
 */
package com.chinaops.web.ydgd.dao;

import com.chinaops.web.common.entity.Page;

/**
 * 公司持久层实接口
 * @author wb
 */
public interface IClientDao {
	/**
	 * Get all clientinfo by clientname
	 * 
	 * @return
	 */
	Page getClientInfoByName(int pageNo, int pageSize, String fuzzySearchValue);

}
