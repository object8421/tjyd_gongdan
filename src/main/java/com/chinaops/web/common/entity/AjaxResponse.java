/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.common.entity;

/**
 *
 * @author Harley Ren  
 */
public class AjaxResponse<T> {
    // ========================== Attributes ============================
    private boolean success;
    private String message;
    private T       result;

    // ========================= Constructors ===========================

    // ======================= Getters & Setters ========================
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }   
    // ======================== Public methods ==========================

    // ==================== Private utility methods =====================

    // ========================== main method ===========================
}
