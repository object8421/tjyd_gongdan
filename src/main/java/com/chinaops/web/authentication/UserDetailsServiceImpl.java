package com.chinaops.web.authentication;


/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
 

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.chinaops.web.common.entity.SysAdminUserDetails;
import com.chinaops.web.ydgd.entity.Privileges;
import com.chinaops.web.ydgd.entity.User;
import com.chinaops.web.ydgd.service.PrivilegesService;
import com.chinaops.web.ydgd.service.UserService;

/**
 * UserDetailsService的实现，
 * @author Harley Ren  
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    // ========================== Attributes ============================
    private static Log       LOG = LogFactory.getLog(UserDetailsServiceImpl.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private PrivilegesService privilegesService;

    // ======================== Public methods ==========================

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setPrivilegesService(PrivilegesService privilegesService) {
        this.privilegesService = privilegesService;
    }

    /* （非 Javadoc）
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        SysAdminUserDetails userDetails = null;
        try {
            LOG.debug("Get user by username : " + loginName);
            User user = userService.getUserByLoginName(loginName);
            
            
            List<GrantedAuthority> authorities = getUserGrantedAuthorities(user);
            boolean accountNonExpired = true;
            boolean accountNonLocked = true;
            boolean credentialsNonExpired = true;
            boolean enabled = true;
            userDetails = new SysAdminUserDetails(user.getId(),user.getUser_name(),user.getLogin_name(),
                    user.getPassword(),user.getRole_type(), enabled, accountNonExpired, credentialsNonExpired,
                    accountNonLocked, authorities);

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        if (userDetails != null) {
            return userDetails;
        }
        throw new UsernameNotFoundException("Username:" + loginName);
    }

    // ==================== Private utility methods =====================
    /**
     * 获得指定用户的权限，并用权限Privilege的token生成一个SimpleGrantedAuthoritys 
     * @param user 
     * @return SimpleGrantedAuthority数组，每个SimpleGrantedAuthority都包含了一个Privilege的token.
     */
    private List<GrantedAuthority> getUserGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        LOG.debug("role_tyep:"+user.getRole_type());
        List<Privileges> privileges = privilegesService.getUserPrivileges(user);
        for (Privileges privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege.getToken()));
        }
        return authorities;
    }
    // ========================== main method ===========================
}
