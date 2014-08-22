package com.chinaops.web.ydgd.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.SAXException;

import com.chinaops.web.ydgd.entity.Ticket;
import com.chinaops.web.ydgd.parser.TicketParser;
/**
 * 
 * @author 张立强 
 * @Email  liqiang.zhang@china-ops.com
 * 2014年8月22日 上午10:02:42
 */
public class PostHttpServer extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /*
     * 代码逻辑分以下三部分:
     * 1.获得请求报文
     * 2.根据请求报文的信息去做业务逻辑，然后封装返回报文
     * 3.输出相应报文
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String xml = request.getParameter("xml");
    	TicketParser ticketParser = new TicketParser();
    	Ticket ticket = new Ticket();
    	try {
    		ticket = ticketParser.parse(xml);
    	} catch (SAXException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
//        String inJson = null;// 保存HTTP客户端请求报文
//        String outJson = null;// 保存HTTP服务端输出报文
//        // 获得输人报文然后打印出来
//        inJson = getInJson(request);
//        System.out.println(xml+"\nauthor<pantp>===========服务端日志----POST方式接收HTTP请求,HTTP服务端收到的请求报文如下:==========\n");
//        System.out.println(inJson);
//        System.out.println("\nauthor<pantp>=================================================================\n");
//
//        // 以下代码部分获得请求报文,然后去做校验,转换以及其他的调用其他的业务逻辑等,这里就不管它
//        // ........................................................................
//
//        // 下面部分是输出部分的处理
//        outJson = "{\"Response\": {\"code\": \"0\",\"message\": \"成功\",\"data\": \"12345\"}}";// 输出不部分也以JSON格式的字符串输出,这里我就写死
//
//        response.setContentType("application/json; charset=UTF-8");
//        response.getWriter().print(outJson);
    }
    
    // 获得请求的报文,并作简单的校验
    public String getInJson(HttpServletRequest request) throws IOException {

        byte buffer[] = new byte[64 * 1024];
        InputStream in = request.getInputStream();// 获取输入流对象

        int len = in.read(buffer);
        // 必须对数组长度进行判断，否则在new byte[len]会报NegativeArraySizeException异常
        if (len < 0) {
            throw new IOException("请求报文为空");
        }

        String encode = request.getCharacterEncoding();// 获取请求头编码
        // 必须对编码进行校验,否则在new String(data, encode);会报空指针异常
        if (null == encode || encode.trim().length() < 0) {
            throw new IOException("请求报文未指明请求编码");
        }

        byte data[] = new byte[len];
        
        // 把buffer数组的值复制到data数组
        System.arraycopy(buffer, 0, data, 0, len);
        
        // 通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String
        String inJson = new String(data, encode);

        return inJson;
    }

    // 不提供get的处理方式
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
    }
}