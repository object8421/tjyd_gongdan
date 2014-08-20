/*
 * $Id$
 *
 * All Rights Reserved 2014 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 *
 * @author hiumin_angle
 */
public class Privileges implements IsSerializable {
    
    private int id;
    
    private String name;
    
    private String token;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    private String url;
    
    private int sn;
    
    
  
    // ========================== Attributes ============================

    // ========================= Constructors ===========================

    // ======================= Getters & Setters ========================

    // ======================== Public methods ==========================

    // ==================== Private utility methods =====================

    // ========================== main method ===========================
}
