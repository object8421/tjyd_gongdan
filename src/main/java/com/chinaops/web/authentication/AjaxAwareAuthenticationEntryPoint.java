/*
 * $Id$
 * 
 * All Rights Reserved 2013 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 *
 * @author Harley Ren  
 */
public class AjaxAwareAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    // ========================== Attributes ============================

    // ========================= Constructors ===========================
    public AjaxAwareAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    // ======================= Getters & Setters ========================

    // ======================== Public methods ==========================

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        boolean isAjax = request.getRequestURI().endsWith("_ajax.json");
        if (isAjax) {
            response.sendError(403, "Forbidden");
        } else {
            super.commence(request, response, authException);
        }
    }

    // ==================== Private utility methods =====================

    // ========================== main method ===========================
}
