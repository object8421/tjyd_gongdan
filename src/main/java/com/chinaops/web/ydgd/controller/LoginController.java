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

    // ======================== Public methods ==========================
    @RequestMapping("/login.htm")
    public String loginForm() {
        return "login";
    }


    /*private void setUserAuthorities(User user) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        EcloudUserDetails userDetail = (EcloudUserDetails) principal;

        //Get rid of any authorities the user currently has. 
        userDetail.getAuthorities().clear();

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        List<Privilege> privileges = privilegeManager.getUserPrivileges(user,
                PrivilegeCategory.ElasticInstance.toString());

        for (Privilege privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege.getToken()));
        }

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                userDetail, user.getPassword(), authorities);

        SecurityContextHolder.getContext().setAuthentication(authRequest);
    }

    private User toUser(EcloudUserDetails userDetail) {
        User user = new User();
        user.setId(userDetail.getId());
        user.setUsername(userDetail.getUsername());
        user.setCompanyId(userDetail.getCompanyId());
        user.setDepartmentId(userDetail.getDepartmentId());
        user.setLoginId(userDetail.getUsername());
        return user;
    }
*/
    private Log                        logger = LogFactory.getLog(this.getClass());
  /*  private CompanyManager             companyManager;
    private DynamicPasswordCardManager dynamicPasswordCardManager;
    private PrivilegeManager           privilegeManager;
    private UserManager                userManager;
*/
  
}
