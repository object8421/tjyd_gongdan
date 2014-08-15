package com.chinaops.web.ydgd.controller;
/*package com.chinaops.web.console.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.chinaops.cloud.auth.shared.Company;
import com.chinaops.cloud.auth.shared.User;



import com.chinaops.cloud.framework.CompanyManager;

import com.chinaops.cloud.framework.UserManager;


import com.chinaops.web.common.entity.AjaxResponse;
import com.chinaops.web.common.entity.EcloudUserDetails;

@Controller
public class UpdateUserPasswordController extends BaseController {

	private static final Log log = LogFactory.getLog(UpdateUserPasswordController.class);

	private UserManager userManager;

	private CompanyManager companyManager;
	

	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Autowired
	public void setCompanyManager(CompanyManager companyManager) {
		this.companyManager = companyManager;
	}
	

	// 访问的页面：
	@RequestMapping("/updateUserPassword.htm")
	public String updateUserPassPage() {
		return "CloudConsole/updateUserPassword";
	}
	
	*//**
	 * 根据公司和角色查询用户信息(主要就是公司管理员角色CompanyAdmin)
	 * @return
	 *//*
	@RequestMapping(value="/updateUserPassword_getUserByRoleAndCom_ajax.json",method=RequestMethod.POST)
	public @ResponseBody
		AjaxResponse<User> company_checkLoginId(){
			AjaxResponse<User> ajaxResponse = new AjaxResponse<User>();
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    EcloudUserDetails user = (EcloudUserDetails) principal;	
		    log.debug(user.getCompanyId()+"////");
		    User us = userManager.getUserByCompanyIdAndRole(user.getCompanyId());
		    if(us != null ){
		    	ajaxResponse.setSuccess(true);
		        ajaxResponse.setMessage("Success");
		        ajaxResponse.setResult(us);
		        return ajaxResponse;
		    }
			return null;
		}

	
	
	@RequestMapping(value = "/updateUserPassword_update_ajax.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResponse<User> updateUser (@RequestParam int id, String username,String loginId,String password){
		     log.debug("修改密码。。。。。");
		     EcloudUserDetails user= this.getEcloudUser();
			 Company company = this.companyManager.getCompanyById(user.getCompanyId());
		     AjaxResponse<User> ajaxResponse = new AjaxResponse<User>();			
			  User us = new User();
			  us.setId(id);
			  us.setUsername(username);
			  us.setLoginId(loginId);
			  us.setPassword(password);
			  us.setRole("CompanyAdmin");
			  us.setDepartmentId(0);
			  try {
			    userManager.updateUser(us);
			    String res = "修改用户密码成功,用户名称:"+us.getUsername();
				writeLog(user, company, "修改密码", "修改密码", "1", res);
				ajaxResponse.setSuccess(true);
			    ajaxResponse.setMessage("Success");
			    ajaxResponse.setResult(us);
			    return ajaxResponse;
			} catch (Exception e) {
				writeLog(user, company, "修改密码", "修改密码", "0", "修改用户密码失败,用户名称："+us.getUsername());
				log.error(e.getMessage());				
			}
		   return null;
	}
	
}
*/