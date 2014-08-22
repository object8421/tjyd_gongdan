package com.chinaops.web.ydgd.servlet;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.springframework.http.HttpStatus;

public class PostHttpClient {

    /**
     * 发送post请求,客户端采用二进制流发送,服务端采用二进制流介绍
     * @param json  入参的json格式的报文
     * @param url    http服务器的地址
     * @return  返回响应信息
     */
    public static String postHttpReq(String json,String url) {
        HttpClient httpClient = new HttpClient();
        
        byte b[] = json.getBytes();//把字符串转换为二进制数据
        RequestEntity requestEntity = new ByteArrayRequestEntity(b);

        EntityEnclosingMethod postMethod = new PostMethod();
        postMethod.setRequestEntity(requestEntity);// 设置数据
        postMethod.setPath(url);// 设置服务的url
        postMethod.setRequestHeader("Content-Type", "text/html;charset=UTF-8");// 设置请求头编码

        // 设置连接超时
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5 * 1000);
        // 设置读取超时
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(20 * 1000);

        String responseMsg = "";
        int statusCode = 0;
        try {
            statusCode = httpClient.executeMethod(postMethod);// 发送请求
            responseMsg = postMethod.getResponseBodyAsString();// 获取返回值
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            postMethod.releaseConnection();// 释放连接
        }

        if (statusCode != HttpStatus.OK.value()) {
            System.out.println("HTTP服务异常" + statusCode);
        }
        return responseMsg;
    }
}