package com.chinaops.web.ydgd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaops.web.common.entity.Page;
import com.chinaops.web.ydgd.entity.User;
import com.chinaops.web.ydgd.service.UserService;

/**
*
* @author hiumin_angle
*/
@Controller
public class UserController{
    @Autowired
    private UserService userService;
    
    public UserService getUserService() {
        return userService;
    }

    @RequestMapping("/user.htm")
    public String clientPageShow( HttpServletRequest request, HttpServletResponse response){
        return "user/user";
    }
    
    // 查询:得到所有用户信息，支持根据用户真实名称模糊查询
    @RequestMapping(value = "/user_list.do", method = RequestMethod.POST)
    public @ResponseBody Page userList(@RequestParam String pageNum,@RequestParam String pageSize,String filterName,String roleType,HttpServletRequest request) {
        int pageNo = Integer.parseInt(pageNum);
        int pageSizes = Integer.parseInt(pageSize);
        if (pageNo <= 1) {
           pageNo = 1;
        }
        Page pages = userService.getAllUserInfor(pageNo,pageSizes,filterName,roleType);
       return pages;
      }
      //新增用户信息：
    @RequestMapping(value = "/user_add.do", method = RequestMethod.POST)
    public @ResponseBody String addUser(@RequestParam String userName,String loginName,String password,String roleType) {
        String result="";
        User user = new User();
        user.setUser_name(userName);
        user.setLogin_name(loginName);
        user.setPassword(password);
        user.setRole_type(roleType);
        if(userService.addUser(user)){
            result = "1";
        }
        return result;
      } 
    
    //修改之前根据用户ID查询
    @RequestMapping(value = "/user_beforeUpdate.do", method = RequestMethod.POST)
    public @ResponseBody User modifyUserPre(@RequestParam int id) {
        User user = userService.getUserById(id);
        return user;

    }
    
    //修改
    @RequestMapping(value = "/user_update.do", method = RequestMethod.POST)
    public @ResponseBody String modifyUser(@RequestParam int id,String userName,String password,String roleType) {
        String result = "";
        User user = new User();
        user.setId(id);
        user.setUser_name(userName);
        user.setPassword(password);
        user.setRole_type(roleType);
       if(userService.updateUser(user)){
           result = "1";
       }
       return result;
    }
    
     //删除用户信息：
    @RequestMapping(value = "/user_delete.do", method = RequestMethod.POST)
    public @ResponseBody String deleteUser(@RequestParam int id) {
        String result = "";
       if(userService.deleteUser(id)){
           result = "1";
       }
       return result;
    }
    
}
