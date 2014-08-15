/*
 * $Id$
 *
 * All Rights Reserved 2014 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinaops.web.ydgd.dao.UserDao;
import com.chinaops.web.ydgd.dao.Impl.TicketDaoImpl;
import com.chinaops.web.ydgd.entity.User;

/**
 *
 * @author hiumin_angle
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-dao.xml" })
public class UserTest {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Test
	public void ceshi(){
		TicketDaoImpl ticketDaoImpl=new TicketDaoImpl();
		int pageNo=1;
		int pageSize=15;
		String fuzzySearchValue="";
		String customerId="1";
		
		ticketDaoImpl.selectTicketByName(pageNo, pageSize, fuzzySearchValue, customerId);

	}
	
/*	@Test
	public void updateUser(){
		User user = new User();
		user.setId(2);
		user.setLoginname("admin");
		user.setUsername("admin");
		user.setPassword("admin");
		boolean flag = userDao.updateUser(user);
		System.out.println(flag);
	}*/
    // ========================== Attributes ============================

    // ========================= Constructors ===========================

    // ======================= Getters & Setters ========================

    // ======================== Public methods ==========================

    // ==================== Private utility methods =====================

    // ========================== main method ===========================
}
