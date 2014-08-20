/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinaops.web.common.entity.SysAdminUserDetails;
import com.chinaops.web.ydgd.entity.Privileges;
import com.chinaops.web.ydgd.entity.User;
import com.chinaops.web.ydgd.service.PrivilegesService;


/**
 * 
 * @author Harley Ren
 */
@Controller
public class IndexController extends BaseController {
	// ========================== Attributes ============================
	

	private static final Log log = LogFactory.getLog(IndexController.class);

    @Autowired
    private PrivilegesService privilegesService;
	
	// ======================== Public methods ==========================
	public void setPrivilegesService(PrivilegesService privilegesService) {
        this.privilegesService = privilegesService;
    }


    @RequestMapping("/index.htm")
	public String index(HttpSession session) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		SysAdminUserDetails userDetails = (SysAdminUserDetails) principal;
		User user = toUser(userDetails);
		List<Privileges>  privileges = privilegesService.getUserPrivileges(user);
		Privileges p = null;
		if(privileges != null){
		    p = privileges.get(0);
		    log.debug(p.getId() + "-" + p.getName() + "-" + p.getUrl());
		}
		return "redirect:" + p.getUrl() + ""; 
	}

	
	private User toUser(SysAdminUserDetails userDetail) {
		User user = new User();
		user.setId(userDetail.getId());
		user.setUser_name(userDetail.getUsername());
		user.setLogin_name(userDetail.getLoginName());
		//user.setPassword(userDetail.getPassword());
		user.setRole_type(userDetail.getRole());
		return user;
	}
	
	
	
	// ==================== Private utility methods =====================

	// ========================== main method ===========================
	// ======================= Getters & Setters ========================
}
