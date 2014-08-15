/*
 * $Id$
 *
 * All Rights Reserved 2014 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chinaops.web.common.entity.Page;
import com.chinaops.web.ydgd.entity.User;
import com.chinaops.web.ydgd.utils.JDBCUtils;

/**
 *
 * @author hiumin_angle
 */
public class UserDaoImpl{

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    
    /* （非 Javadoc）
     * @see com.chinaops.web.ydgd.dao.UserDao#getUserByLoginIdAndPassword(java.lang.String, java.lang.String)
     */
    public User getUserByLoginNameAndPassword(String loginName, String password) {
       try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user where login_name='"+ loginName+"' and password = '"+password+"'";
            rs = stmt.executeQuery(sql);
            User user = new User();
            while (rs.next()) {                
                user.setId(rs.getInt("id"));
                user.setLogin_name(rs.getString("login_name"));
                user.setUser_name(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setRole_type(rs.getString("role_type"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }finally {
            JDBCUtils.closeResource(conn, stmt, rs);
        }
    }
    
    
    public User getUserByLoginName(String loginName) {
        try {
             conn = JDBCUtils.getConnection();
             stmt = conn.createStatement();
             String sql = "select * from user where login_name='"+ loginName+"'";
             rs = stmt.executeQuery(sql);
             User user = new User();
             while (rs.next()) {                
                 user.setId(rs.getInt("id"));
                 user.setLogin_name(rs.getString("login_name"));
                 user.setUser_name(rs.getString("user_name"));
                 user.setPassword(rs.getString("password"));
                 user.setRole_type(rs.getString("role_type"));
             }
             return user;
         } catch (SQLException e) {
             throw new RuntimeException(e.getMessage(), e);
         }finally {
             JDBCUtils.closeResource(conn, stmt, rs);
         }
     }
 /**
  * 得到所有用户信息：支持根据用户名称模糊查询
  * @param pageNo
  * @param pageSize
  * @param filterName
  * @return
  */
    public Page getAllUserInfo(int pageNo, int pageSize, String filterName,String roleType){
      Page page = new Page();
      int total = 0;
      int  currentPage = (pageNo - 1) * pageSize;
      List<User> list = new ArrayList<User>();    
          try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "";
            String countSql = "";
            sql = "select * from user ";
            if(!filterName.equals("") && filterName != null){
            	sql += "where user_name like '%" + filterName + "%' " ;
            	if(!roleType.equals("") && roleType != ""){
            		sql += " and role_type='"+roleType+"' ";
            		countSql += "select count(*) from user where user_name like '%" + filterName + "%'   and role_type='"+roleType+"';";
            	}else {
            		countSql += "select count(*) from user where user_name like '%" + filterName + "%'  ;";
				}
            }else {
            	if(!roleType.equals("") && roleType != ""){
            		sql += " where role_type='"+roleType+"' ";
            		countSql += "select count(*) from user  where role_type='"+roleType+"';";
            	}else {
            		countSql += "select count(*) from user;";
				}
			}
            sql += " order by id desc limit " + (currentPage) + "," + pageSize + ";";

            System.out.println("countSql="+countSql+" \n sql="+sql);
            rs = stmt.executeQuery(countSql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUser_name(rs.getString("user_name"));
                user.setLogin_name(rs.getString("login_name"));
                user.setPassword(rs.getString("password"));
                user.setRole_type(rs.getString("role_type"));
                user.setCreate_time(rs.getString("create_time"));
                list.add(user);
            }// 总记录数
            page.setTotalNumber(total);
            // 当前页
            page.setCurrentPage(pageNo);
            // 分页的数据
            page.setList(list);
            // 总页数
            page.setTotalPage(page.getTotalNumber() % pageSize == 0 ? page.getTotalNumber() / pageSize : page.getTotalNumber() / pageSize + 1);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            JDBCUtils.closeResource(conn, stmt, rs);
        }
        return page;
    }
    
    /**
     * 根据用户ID查询：
     * 
     * @param id
     * @return
     */
    public User getUserById(int id ){
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user where id='"+ id+"'";
            rs = stmt.executeQuery(sql);
            User user = new User();
            while (rs.next()) {                
                user.setId(rs.getInt("id"));
                user.setLogin_name(rs.getString("login_name"));
                user.setUser_name(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setRole_type(rs.getString("role_type"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }finally {
            JDBCUtils.closeResource(conn, stmt, rs);
        }
    }
    
  
    /**
     * 添加新用户
     * @param user
     */
    public void addUser(User user){
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into user(user_name,login_name,password,role_type,create_time) values('");
            sql.append(user.getUser_name()+"','");
            sql.append(user.getLogin_name()+"','");
            sql.append(user.getPassword()+"','");
            sql.append(user.getRole_type()+"',");
            sql.append("sysdate()");
            sql.append(")");
            stmt.execute(sql.toString());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            JDBCUtils.closeResource(conn, stmt, rs);
        }
    }
    
    public void updateUser(User user){
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            StringBuilder sql = new StringBuilder();
            sql.append("update user set ");
            sql.append("user_name='");
            sql.append(user.getUser_name());
            sql.append("',password='");
            sql.append(user.getPassword());
            sql.append("',role_type='");
            sql.append(user.getRole_type());
            sql.append("' where id=");
            sql.append(user.getId());
            stmt.execute(sql.toString());            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            JDBCUtils.closeResource(conn, stmt, rs);
        }
    }
    /**
     * 根据Id删除用户
     * @param id
     */
    public void deleteUser(int id){
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from user where id='"+ id+"'";
            stmt.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            JDBCUtils.closeResource(conn, stmt, rs);
        }
    }
    
    public int checkLoginName(String loginName){
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select count(*) from user where login_name='"+loginName+"'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            JDBCUtils.closeResource(conn, stmt, rs);
        }
    }
}
