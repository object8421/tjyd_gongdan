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

import com.chinaops.web.ydgd.entity.Privileges;
import com.chinaops.web.ydgd.entity.User;
import com.chinaops.web.ydgd.utils.JDBCUtils;

/**
 *
 * @author hiumin_angle
 */
public class PrivilegesDaoImpl{
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    /* （非 Javadoc）
     * @see com.chinaops.web.ydgd.dao.PrivilegesDao#getUserPrivileges(com.chinaops.web.ydgd.entity.User, java.lang.String)
     */
    /**
     * 根据用户 查询其权限列表
     */
    public List<Privileges> getUserPrivileges(User user) {
        List<Privileges>  list = new ArrayList<Privileges>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select p.id,p.name,p.token,p.url,p.sn from privileges p,role_privileges rp "
                    + " where p.id = rp.priv_id and role_type = '"+user.getRole_type()+"' order by p.sn";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Privileges p = new Privileges();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setToken(rs.getString("token"));
                p.setUrl(rs.getString("url"));
                p.setSn(rs.getInt("sn"));
                list.add(p);
            }
          return list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }finally {
            JDBCUtils.closeResource(conn, stmt, rs);
        }
    }
    // ========================== Attributes ============================

    // ========================= Constructors ===========================

    // ======================= Getters & Setters ========================

    // ======================== Public methods ==========================

    // ==================== Private utility methods =====================

    // ========================== main method ===========================
}
