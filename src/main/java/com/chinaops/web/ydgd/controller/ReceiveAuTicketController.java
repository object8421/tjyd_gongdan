/**
 * 
 */
package com.chinaops.web.ydgd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 张立强 
 * @Email  liqiang.zhang@china-ops.com
 * 2014年8月22日 上午10:42:46
 */
@Controller
public class ReceiveAuTicketController {
    // ========================== Attributes ============================
	@SuppressWarnings("unused")
	private Log                        logger = LogFactory.getLog(this.getClass());
	
    // ======================== Public methods ==========================
    @RequestMapping("/receiveAuTicket.htm")
    public String reString() {
        return "receiveAuTicket";
    }
    
    @RequestMapping(value = "/receiveAuTicket.do" , method = RequestMethod.POST)
    public void reSasdftring(HttpServletRequest request, HttpServletResponse response) {
    	String xml = request.getParameter("xml");
    	System.out.println(xml);
    }
    
    
}
