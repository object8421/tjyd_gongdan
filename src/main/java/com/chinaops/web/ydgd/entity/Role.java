/*
 * $Id$
 *
 * All Rights Reserved 2014 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 *
 * @author liqiang.zhang@china-ops.com
 */
public class Role implements IsSerializable {
    
    private int id;
    
    private String roleName;
    
    private RoleEnum roleType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleEnum getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleEnum roleType) {
		this.roleType = roleType;
	}

}
