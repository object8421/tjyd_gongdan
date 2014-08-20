package com.chinaops.web.ydgd.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * Description: 帮助类
 * 
 * @version 1.0 Dec 12, 2012 2:51:36 PM 王斌 (bin.wang@china-ops.com) created
 */
public class StringHelper {
	/**
	 * Description: 判断是否符合windows命名规则
	 * 
	 * @Version 1.0 Aug 20, 2012 11:49:32 AM王斌(bin.wang@china-ops.com) 创建
	 */
	public static boolean isWindowNaming(String str) {
		String exclude_chars = "\\/:\\*?\"<>|";
		if (StringUtils.isEmpty(str))
			return true;
		for (int i = 0; i < str.length(); i++) {
			if (exclude_chars.indexOf(str.charAt(i)) >= 0)
				return false;
		}
		return true;
	}

	/**
	 * Description: 向字符串前加0
	 * 
	 * @Version 1.0 Jul 26, 2012 11:46:13 AM王斌(bin.wang@china-ops.com) 创建
	 */
	public static String generateCode(int id) {
		String res = "";
		int id_len = (id + "").length();
		int len = 4;
		int surplus_len = 0;
		if (id_len < len)
			surplus_len = (len - id_len);
		for (int i = 0; i < surplus_len; i++) {
			res = "0" + res;
		}
		res += id;
		return res;
	}

	/**
	 * Description: 向页面写内容
	 * 
	 * @Version 1.0 May 31, 2012 3:43:17 PM王斌(bin.wang@china-ops.com) 创建
	 */
	public static void printf(HttpServletResponse response, String result)
			throws Exception {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * Description: 解码
	 * 
	 * @Version 1.0 May 31, 2012 5:55:59 PM王斌(bin.wang@china-ops.com) 创建
	 */
	public static String decode(String str) {
		try {
			if (StringUtils.isNotEmpty(str))
				return URLDecoder.decode(str.trim(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Description: 判断是否存在参数
	 * 
	 * @Version 1.0 2012-5-28 下午03:28:27王斌(bin.wang@china-ops.com) 创建
	 */
	public String convertStr(String str) {
		if (StringUtils.isEmpty(str))
			return "";
		return str;
	}

	/**
	 * Description: 判断文件是否以制定的文件类型
	 * 
	 * @Version 1.0 Jun 29, 2012 10:01:58 AM王斌(bin.wang@china-ops.com) 创建
	 */
	public static boolean isEndFileType(String fileName, List<String> list)
			throws Exception {
		if (StringUtils.isEmpty(fileName)) {
			return false;
		}
		for (String str : list) {
			if (fileName.endsWith(str.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Description: 根据传入的分隔符或分隔字符串解析传入的字符串转化为小写spiltStr 返回list
	 * 
	 * @Version 1.0 Jun 29, 2012 10:02:08 AM王斌(bin.wang@china-ops.com) 创建
	 */
	public static List<String> spiltStrBySeparator(String spiltStr,
			String separator) {
		if (StringUtils.isEmpty(spiltStr)) {
			return new ArrayList<String>();
		}
		List<String> list = new ArrayList<String>();
		String[] st = spiltStr.split(separator);

		if (st.length != 0) {
			for (int i = 0; i < st.length; i++) {
				list.add(st[i].toLowerCase());
			}

		}
		return list;
	}

	/**
	 * Description: 取得以.开始的文件后缀名
	 * 
	 * @Version 1.0 Jun 29, 2012 10:02:16 AM王斌(bin.wang@china-ops.com) 创建
	 */
	public static String getSuffix(String filename) {
		if (StringUtils.isNotEmpty(filename))
			return "";
		return filename.substring(filename.lastIndexOf("."), filename.length());
	}

	// date类型转换为String类型
 	// formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
 	// data Date类型的时间
 	public static String dateToString(Date data, String formatType) {
 		return new SimpleDateFormat(formatType).format(data);
 	}
 
 	// long类型转换为String类型
 	// currentTime要转换的long类型的时间
 	// formatType要转换的string类型的时间格式
 	public static String longToString(long currentTime, String formatType)
 			throws Exception {
 		Date date = longToDate(currentTime, formatType); // long类型转成Date类型
 		String strTime = dateToString(date, formatType); // date类型转成String
 		return strTime;
 	}
 
 	// string类型转换为date类型
 	// strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
 	// HH时mm分ss秒，
 	// strTime的时间格式必须要与formatType的时间格式相同
 	public static Date stringToDate(String strTime, String formatType)
 			throws Exception {
 		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
 		Date date = null;
 		date = formatter.parse(strTime);
 		return date;
 	}
 
 	// long转换为Date类型
 	// currentTime要转换的long类型的时间
 	// formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
 	public static Date longToDate(long currentTime, String formatType)
 			throws Exception {
 		Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
 		String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
 		Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
 		return date;
 	}
 
 	// string类型转换为long类型
 	// strTime要转换的String类型的时间
 	// formatType时间格式
 	// strTime的时间格式和formatType的时间格式必须相同
 	public static long stringToLong(String strTime, String formatType)
 			throws Exception {
 		Date date = stringToDate(strTime, formatType); // String类型转成date类型
 		if (date == null) {
 			return 0;
 		} else {
 			long currentTime = dateToLong(date); // date类型转成long类型
 			return currentTime;
 		}
 	}
 
 	// date类型转换为long类型
 	// date要转换的date类型的时间
 	public static long dateToLong(Date date) {
 		return date.getTime();
 	}
}
