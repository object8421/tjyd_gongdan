package com.chinaops.web.ydgd.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaops.web.ydgd.entity.User;
import com.chinaops.web.ydgd.service.UserService;

@Controller
public class UpdateUserPasswordController extends BaseController {

	private static final Log log = LogFactory.getLog(UpdateUserPasswordController.class);
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value = "/updateUserPassword_update_ajax.do",method=RequestMethod.POST)
	public @ResponseBody String updateUserPassword (@RequestParam int id,String password){
		try{
			User user = new User();
			user.setId(id);
			user.setPassword(password);
			userService.modifyUserPassword(user);
			return "1";
		} catch (Exception e) {
			log.error(e.getMessage());				
		}
		return "0";
	}
	
}
