/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 
package com.chinaops.web.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.chinaops.cloud.auth.shared.Company;
import com.chinaops.cloud.auth.shared.DynamicPasswordCard;
import com.chinaops.cloud.auth.shared.User;
import com.chinaops.cloud.common.entity.RoleEnum;
import com.chinaops.cloud.framework.CompanyManager;
import com.chinaops.cloud.framework.DynamicPasswordCardManager;
import com.chinaops.cloud.framework.LogManager;
import com.chinaops.cloud.framework.S3Manager;
import com.chinaops.cloud.framework.UserManager;
import com.chinaops.cloud.metadata.shared.UserLog;
import com.chinaops.cloud.s3.EcloudS3Bean;
import com.chinaops.cloud.s3.S3User;
import com.chinaops.web.common.entity.EcloudUserDetails;


*//**
 *
 * @author Harley Ren  
 *//*
public class UserLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    // ========================= Constructors ===========================
    public UserLoginSuccessHandler() {
        this.loginSuccessHandlers.add(new FirstLoginHandler());
        this.loginSuccessHandlers.add(new DynamicCardHandler());
        this.loginSuccessHandlers.add(new WriteDbLogHandler());
    }

    // ======================== Public methods ==========================
     （非 Javadoc）
     * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
     
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication auth) throws IOException, ServletException {
        EcloudUserDetails user = (EcloudUserDetails) auth.getPrincipal();
        if (user.getRole().equalsIgnoreCase("CLAA")) {
            setS3Info(user, request, response);
        }

        for (LoginSuccessHandler handler : this.loginSuccessHandlers) {
            if (!handler.process(request, response, auth)) {
                return;
            }
        }

        super.onAuthenticationSuccess(request, response, auth);
    }

    // ==================== Private utility methods =====================

    *//**
     * @param request
     * @param response
     *//*
    private void setS3Info(EcloudUserDetails user, HttpServletRequest request,
            HttpServletResponse response) {
        Company company = new Company();
        company.setId(user.getCompanyId());

        //Get S3 associated with current company.
        List<EcloudS3Bean> s3List = s3Manager.getCompanyS3(company);//  s3
        if (null != s3List && s3List.size() > 0) {
            EcloudS3Bean s3 = (EcloudS3Bean) s3List.toArray()[0];
            //Get S3User.
            //  S3User s3User = s3Manager.getCompanyS3User(s3, company);  //
            List<S3User> s3UserList = s3Manager.getCompanyS3User(s3, company);
            if (s3UserList != null && s3UserList.size() > 0) {
                S3User s3User = (S3User) s3UserList.toArray()[0];
                HttpSession session = request.getSession();
                session.setAttribute(S3_SESSION_TOKEN, s3);
                session.setAttribute(S3USER_SESSION_TOKEN, s3User); ///
            }

        }

    }

    interface LoginSuccessHandler {

        *//**
         * @param request
         * @param response
         * @param auth
         * @return true 其后的handler可以继续执行;false:不执行其后的handler.
         * @throws AuthenticationException
         * @throws IOException
         *//*
        boolean process(HttpServletRequest request, HttpServletResponse response,
                Authentication auth) throws AuthenticationException, IOException;
    }

    *//**
     * 如果公司没有开启动态密码卡，且是首次登录，则需要修改密码。
     * If it is the first time company administrator logged in,She/he should change her/his password. 
     * @author Harley Ren  
     *//*
    class FirstLoginHandler implements LoginSuccessHandler {

         （非 Javadoc）
         * @see com.chinaops.web.console.remote.servlet.LoginService.LoginSuccessHandler#process(com.chinaops.cloud.auth.shared.User, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
         
        public boolean process(HttpServletRequest request, HttpServletResponse response,
                Authentication auth) throws AuthenticationException, IOException {

            Object principal = SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            EcloudUserDetails userDetail = (EcloudUserDetails) principal;
            Company company = companyManager.getCompanyById(userDetail.getCompanyId());

            if (!(userDetail.getRole().equalsIgnoreCase(RoleEnum.CompanyAdministrator.toString()) && company
                    .getIsFirstLogin() == 1)) {
                return true;
            }

            //第一次登陆需要修改密码,同时还要输入该公司的登陆者（公司管理员）绑定的动态密码卡的密码
            //1.假如公司没有启用动态密码卡，则公司管理员第一次登录的时候只用修改密码不用激活密码卡。。                 
            if (company.getEnableDynamicPasswordCard() == 0) {
                userDetail.getAuthorities().clear();
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("/update_cadmin_password.htm"));

                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                        userDetail, auth.getCredentials(), authorities);

                SecurityContextHolder.getContext().setAuthentication(authRequest);
                
                response.sendRedirect(request.getContextPath() + "/update_cadmin_password.htm");
                return false;
            } else {
                return true;
            }

        }
    }


    class WriteDbLogHandler implements LoginSuccessHandler {
		public boolean process(HttpServletRequest request,
				HttpServletResponse response, Authentication auth)
				throws AuthenticationException, IOException {
			    EcloudUserDetails userDetail = (EcloudUserDetails) auth.getPrincipal();	
			    Company company = companyManager.getCompanyById(userDetail.getCompanyId());
			    User user = new User();
	            user.setId(userDetail.getId());
	            user.setLastLoginIP("127.0.0.1");
	            user.setUsername(userDetail.getUsername());
	            user.setCompanyId(userDetail.getCompanyId());
	            user.setDepartmentId(userDetail.getDepartmentId());
	            user.setLoginId(userDetail.getUsername());
			    System.out.println(user.getId()+"-"+user.getUsername()+"-"+user.getLoginId()+"///////////");
	            try {
					userManager.loginRegiester(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	           
	            UserLog userLog = new UserLog();
	            userLog.setUserId(user.getId());
	            userLog.setLoginName(user.getLoginId());
	            userLog.setLoginIp(getIpAddr(request));
	            userLog.setOperateName("用户登录");
	            userLog.setOperateObj("易享云管理系统");
	            userLog.setCompanyId(user.getCompanyId());
	            userLog.setCompanyName(company.getName());
	            userLog.setResultSign("1");
	            userLog.setResult("");
	            logManager.writeLog(userLog);
	            return true;
		}

    }
    
    *//**
     * When dynamic card is enabled for this company,redirect to verify page if user had bound a card, 
     * go to bind page if no card bound.
     * @author Harley Ren  
     *//*
    class DynamicCardHandler implements LoginSuccessHandler {

         （非 Javadoc）
         * @see com.chinaops.web.console.remote.servlet.LoginService.LoginSuccessHandler#process(com.chinaops.cloud.auth.shared.User, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
         
        public boolean process(HttpServletRequest request, HttpServletResponse response,
                Authentication auth) throws AuthenticationException, IOException {
            HttpSession session = request.getSession();

            Object principal = auth.getPrincipal();
            EcloudUserDetails userDetail = (EcloudUserDetails) principal;

            //            //Get rid of any authorities the user currently has. 
            userDetail.getAuthorities().clear();

            Company company = companyManager.getCompanyById(userDetail.getCompanyId());

            if (company.getEnableDynamicPasswordCard() != 1) {
                return true;
            }

            User user = new User();
            user.setId(userDetail.getId());
            user.setUsername(userDetail.getUsername());
            user.setCompanyId(userDetail.getCompanyId());
            user.setDepartmentId(userDetail.getDepartmentId());
            user.setLoginId(userDetail.getUsername());

            DynamicPasswordCard card = dynamicPasswordCardManager.getUserBoundCard(user);
            //根据user查询是否绑定了密码卡。
            if (null == card) {
                if (userDetail.getRole().equalsIgnoreCase(RoleEnum.CompanyAdministrator.toString()) || userDetail.getRole().equalsIgnoreCase(RoleEnum.User.toString())) {
                    //公司管理员不是第一次登陆但是启用了密码卡,并且用户没有绑定卡，那就激活卡呗。
                    session.setAttribute("companyid", user.getCompanyId());
                    session.setAttribute("userId", user.getId());
                    session.setAttribute("username", user.getLoginId());

                    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                    authorities.add(new SimpleGrantedAuthority("/activate_card"));

                    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                            userDetail, auth.getCredentials(), authorities);

                    SecurityContextHolder.getContext().setAuthentication(authRequest);

                    response.sendRedirect(request.getContextPath() + "/activate_card.htm");
                    return false;
                } else {
                    //普通用户，没有绑定密码
                    return true;
                }
            }

            //显示密码卡卡号
            if (StringUtils.isNotEmpty(card.getCardNumber())) {
                int code_len = card.getCardNumber().length();
                String code = card.getCardNumber().substring(code_len - 6, code_len);
                request.setAttribute("CardNumber", code);
            }
            //动态卡密码错误五次
            if (card.getState() == -2 || card.getFailure() >= 5) {
                request.setAttribute("card_pwd_five_fail", "1");
                request.setAttribute("ErrorMsg", "动态密码卡已被锁定，请执行激活！");
                
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("/login/reactivate_card"));

                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                        userDetail, auth.getCredentials(), authorities);

                SecurityContextHolder.getContext().setAuthentication(authRequest);
                
                //Should redirect to reactivate page.
                response.sendRedirect(request.getContextPath() + "/login/reactivate_card.htm");
                return false;
            }
            //验证动态卡密码时，页面增加标记 设置session过期时间 by wangbin
            request.setAttribute("card_mark", "1");

            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("/login/verify-card"));

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                    userDetail, auth.getCredentials(), authorities);

            SecurityContextHolder.getContext().setAuthentication(authRequest);
            response.sendRedirect(request.getContextPath() + "/login/verify-card.htm");

            return false;
        }
    }

 
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
    
    // ========================== Attributes ============================
    public static final String         S3_SESSION_TOKEN     = "S3";
    public static final String         S3USER_SESSION_TOKEN = "S3User";

    private S3Manager                  s3Manager;
    private List<LoginSuccessHandler>  loginSuccessHandlers = new ArrayList<LoginSuccessHandler>();
    private CompanyManager             companyManager;
    private DynamicPasswordCardManager dynamicPasswordCardManager;
    private  UserManager                userManager;
    private LogManager                  logManager;
    private Log                        logger               = LogFactory.getLog(this.getClass());

    // ======================= Getters & Setters ========================

    @Autowired
    public void setS3Manager(S3Manager s3Manager) {
        this.s3Manager = s3Manager;
    }

    *//**
     * @param companyManager 要设置的 companyManager。
     *//*
    @Autowired
    public void setCompanyManager(CompanyManager companyManager) {
        this.companyManager = companyManager;
    }

    *//**
     * @param cardManager 要设置的 cardManager。
     *//*
    @Autowired
    public void setDynamicPasswordCardManager(DynamicPasswordCardManager cardManager) {
        this.dynamicPasswordCardManager = cardManager;
    }

    @Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
    
    @Autowired
	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}
    
    
    
    

}
*/