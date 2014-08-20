/*
 * $Id$
 *
 * All Rights Reserved 2014 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.service;

import java.util.List;

import com.chinaops.web.ydgd.dao.Impl.PrivilegesDaoImpl;
import com.chinaops.web.ydgd.entity.Privileges;
import com.chinaops.web.ydgd.entity.User;

/**
 *
 * @author hiumin_angle
 */
public class PrivilegesService {
   private PrivilegesDaoImpl privilegesDaoImpl;

    public PrivilegesDaoImpl getPrivilegesDaoImpl() {
        return privilegesDaoImpl;
    }
    
    public void setPrivilegesDaoImpl(PrivilegesDaoImpl privilegesDaoImpl) {
        this.privilegesDaoImpl = privilegesDaoImpl;
    }
    
    /**
     * 得到用户的权限。
     * @param user
     * @return
     */
    public List<Privileges> getUserPrivileges(User user){
        List<Privileges> list=  privilegesDaoImpl.getUserPrivileges(user);
        if(list != null){
            return list;
        }
        return null;
        
    }
   
}
