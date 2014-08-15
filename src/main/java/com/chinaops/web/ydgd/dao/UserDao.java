/*
 * $Id$
 *
 * All Rights Reserved 2014 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.dao;

import com.chinaops.web.ydgd.entity.User;

/**
 *
 * @author hiumin_angle
 */
public interface UserDao {
    
     User getUserByLoginNameAndPassword(String loginName,String password);
    
    User getUserByLoginName(String loginName);
    
    // ========================== Attributes ============================

    // ========================= Constructors ===========================

    // ======================= Getters & Setters ========================

    // ======================== Public methods ==========================

    // ==================== Private utility methods =====================

    // ========================== main method ===========================
}
