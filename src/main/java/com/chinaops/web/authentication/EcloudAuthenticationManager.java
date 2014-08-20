/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.authentication;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.chinaops.web.ydgd.utils.CURDException;

/**
 *
 * @author Harley Ren  
 */
public class EcloudAuthenticationManager implements AuthenticationManager {

    /* （非 Javadoc）
     * @see org.springframework.security.authentication.AuthenticationManager#authenticate(org.springframework.security.core.Authentication)
     */
    public Authentication authenticate(Authentication arg0) throws AuthenticationException {
        // TODO 自动生成方法存根
        return null;
    }


    // ========================== Attributes ============================
 //   private UserManager userManager;

    /* （非 Javadoc）
     * @see org.springframework.security.authentication.AuthenticationManager#authenticate(org.springframework.security.core.Authentication)
     */
  /*  
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String password = (String) authentication.getCredentials();
        if (!StringUtils.isEmpty(authentication.getName()) && password != null
                && !StringUtils.isEmpty(password)) {
            try {
                User user = userManager.getUserByLoginId(authentication.getName());
                if (user == null) {
                    throw new BadCredentialsException("无效的用户名或密码.");
                }

                List<GrantedAuthority> grantedAuthories = new ArrayList<GrantedAuthority>();
//                grantedAuthories.add(new SimpleGrantedAuthority(user.getRole()));
                grantedAuthories.add(new SimpleGrantedAuthority("ROLE_USER"));
                
                return new UsernamePasswordAuthenticationToken(authentication.getName(),
                        authentication.getCredentials(), grantedAuthories);
            } catch (CURDException e) {
                throw new BadCredentialsException(e.getMessage());
            }
        }
        throw new BadCredentialsException("无效的用户名或密码.");
    }

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }*/

}
