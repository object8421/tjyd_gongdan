/*
 * $Id$
 *
 * All Rights Reserved 2014 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.dao;

import java.util.List;

import com.chinaops.web.ydgd.entity.Privileges;
import com.chinaops.web.ydgd.entity.User;

/**
 *
 * @author hiumin_angle
 */
public interface PrivilegesDao {
    List<Privileges> getUserPrivileges(User user);
    
}
