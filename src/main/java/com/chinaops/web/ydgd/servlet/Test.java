/**
 * Description: Test.java
 * Copyright (c) Department of Research and Development/Beijing/china-ops.
 * All Rights Reserved.
 * @version 1.0  2013-8-21 下午12:35:24 张立强 (liqiang.zhang@china-ops.com) 创建
 */
package com.chinaops.web.ydgd.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.chinaops.web.ydgd.utils.StringHelper;

/**
 * Description: Copyright (c) Department of Research and
 * Development/Beijing/china-ops. All Rights Reserved.
 * 
 * @version 1.0 2013-8-21 下午12:35:24 张立强 (liqiang.zhang@china-ops.com) 创建
 */
public class Test {

	/**
	 * Description:
	 * 
	 * @Version 1.0 2013-8-21 下午12:35:24张立强(liqiang.zhang@china-ops.com) 创建
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HttpRequester request = new HttpRequester();
			Map<String,String> map = new HashMap<String,String>();
			map.put("pwd_card_number","2100000075787");
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////			1377079226389
//			Date date = StringHelper.longToDate(new Date().getTime(), "yyyy-MM-dd HH:mm:ss"); // long类型转成Date类型
//	 		String strTime = StringHelper.dateToString(date, "yyyy-MM-dd HH:mm:ss"); // date类型转成String
//	 		System.out.println(strTime);
	 		
			map.put("pwd_card_activation_time",new Date().getTime()+"");
			HttpRespons hr = request.sendGet("http://172.16.50.240:8081/business!autoSaveTime.action",map);
			System.out.println(hr.getUrlString());
			System.out.println(hr.getProtocol());
			System.out.println(hr.getHost());
			System.out.println(hr.getPort());
			System.out.println(hr.getContentEncoding());
			System.out.println(hr.getMethod());
			System.out.println(hr.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
