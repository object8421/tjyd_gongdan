/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.authorization;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

/**
 *
 * @author Harley Ren  
 */
public class EcloudAccessDecisionManager implements AccessDecisionManager {
    // ========================== Attributes ============================
    private Log logger = LogFactory.getLog(this.getClass());

    // ========================= Constructors ===========================

    // ======================= Getters & Setters ========================

    // ======================== Public methods ==========================
    /* （非 Javadoc）
     * @see org.springframework.security.access.AccessDecisionManager#decide(org.springframework.security.core.Authentication, java.lang.Object, java.util.Collection)
     */
    public void decide(Authentication authentication, Object object,
            Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
            InsufficientAuthenticationException {
        if( (authentication instanceof AnonymousAuthenticationToken)  || !authentication.isAuthenticated() ) {
            throw new InsufficientAuthenticationException("用户未鉴权!");
        }
        
        if(object instanceof FilterInvocation) {
            FilterInvocation filterInvocation = (FilterInvocation) object;            
            logger.debug("Reuqest RUL " + filterInvocation.getRequestUrl() );
            doDecision(authentication,filterInvocation);
        } else {
            throw new AccessDeniedException("");
        }
        
        logger.debug("Secure object " + object.toString());
    }

    /* （非 Javadoc）
     * @see org.springframework.security.access.AccessDecisionManager#supports(org.springframework.security.access.ConfigAttribute)
     */
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    /* （非 Javadoc）
     * @see org.springframework.security.access.AccessDecisionManager#supports(java.lang.Class)
     */
    public boolean supports(Class<?> clazz) {
        return true;
    }
    // ==================== Private utility methods =====================
    /**
     * @param authentication
     * @param filterInvocation
     */
    private void doDecision(Authentication authentication, FilterInvocation filterInvocation) {
        if(authentication.getAuthorities().size() < 1) {
            throw new AccessDeniedException("");
        }
        for(GrantedAuthority authority : authentication.getAuthorities()) {
            logger.debug("Authority: " + authority.getAuthority());
            if(filterInvocation.getRequestUrl().trim().startsWith(authority.getAuthority())) {
                //用户可以访问此URL
                return;
            }
        }
        throw new AccessDeniedException("");
    }
    // ========================== main method ===========================
}
