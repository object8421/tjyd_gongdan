/*
 * $Id$
 *
 * All Rights Reserved 2014 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.chinaops.web.common.entity.Page;
import com.chinaops.web.ydgd.dao.Impl.UserDaoImpl;
import com.chinaops.web.ydgd.entity.User;

/**
 *
 * @author hiumin_angle
 */
public class UserService {
    
    @Autowired
    private UserDaoImpl userDaoImpl;
    
    public UserDaoImpl getUserDaoImpl() {
        return userDaoImpl;
    }

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }
    
    public User getUserByLoginNameAndPassWord(String loginName,String password){
        return this.userDaoImpl.getUserByLoginNameAndPassword(loginName, password);
        
    }
    
    public User getUserByLoginName(String loginName){
        return this.userDaoImpl.getUserByLoginName(loginName);        
    }
    
    public Page getAllUserInfor(int pageNo,int pageSize,String filterName,String roleType){
        return userDaoImpl.getAllUserInfo(pageNo, pageSize, filterName,roleType);
        
    }
    
    public User getUserById(int id){
         User user = this.userDaoImpl.getUserById(id);
         if(user != null){
             return user;
         }
         return null;
    }
    
    public boolean addUser(User user){
        this.userDaoImpl.addUser(user);
        return true;
    }
    
    public boolean updateUser(User user){
        this.userDaoImpl.updateUser(user);
        return true;
    }
    
    public boolean deleteUser(int id){
        this.userDaoImpl.deleteUser(id);
        return true;
        
    }
    
    public boolean modifyUserPassword(User user){
    	return userDaoImpl.modifyUserPassword(user);
    }
}
