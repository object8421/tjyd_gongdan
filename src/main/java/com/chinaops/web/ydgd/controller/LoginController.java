/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */

package com.chinaops.web.ydgd.controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Harley Ren  
 */

@Controller
public class LoginController {
    // ========================== Attributes ============================
	@SuppressWarnings("unused")
	private Log                        logger = LogFactory.getLog(this.getClass());
	
    // ======================== Public methods ==========================
    @RequestMapping("/login.htm")
    public String loginForm() {
        return "login";
    }
    
}
