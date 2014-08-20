/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.controller;

import org.springframework.security.core.context.SecurityContextHolder;

import com.chinaops.web.common.entity.EcloudUserDetails;

/**
 *
 * @author Harley Ren  
 */
public class BaseController {
    /**
     * 
     */
    public BaseController() {
        super();
    }




    /*************************************获取当前登录用户******************************************/
    /**
     * Description: 获取当前登录用户信息
     * @Version 1.0 2013-1-17 下午05:15:34 王斌(bin.wang@china-ops.com) 创建
     */
    public EcloudUserDetails getEcloudUser() {
        return (EcloudUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    }

    /**
    * Description: 当前用户是否为公司级管理员
    * @Version 1.0 2013-2-25 下午05:01:55 王斌(bin.wang@china-ops.com) 创建
    */
  /*  public boolean isCompanyAdmin(EcloudUserDetails user) {
        if (null == user)
            return false;
        if (user.getRole().equalsIgnoreCase(RoleEnum.CompanyAdministrator.toString()))
            return true;
        return false;
    }*/
   
}