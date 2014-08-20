/*
 * $Id$
 *
 * All Rights Reserved 2014 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.entity;

/**
 *
 * @author hiumin_angle
 */
public enum RoleEnum {
    SysAdmin("sys"),Cfm("cfm"), User("user");
    //角色类别
  
    private String roleName;

    private RoleEnum(String roleName) {
        this.roleName = roleName;
    }
    
    public String toString() {
        return roleName;
    }
}
