package com.toolkit.lang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 关于日期，时间工具类
 * 
 * @author joe.zhao
 * 
 */
public abstract class DTUtil {
	
	private static SimpleDateFormat	sdf		= null;
	private static Date				dtTime	= new Date();
	
	private DTUtil() {
		//
	}
	
	/**
	 * 日期long值转换为日期字符串
	 * 
	 * @param time
	 * @param digit
	 * @param style
	 * @return
	 */
	public static String fmtLongTime(long time, String pattern) {
		sdf = new SimpleDateFormat(pattern);
		dtTime.setTime(time * 1000);
		
		return sdf.format(dtTime);
	}
	
	/**
	 * 日期字符串转换为日期long值
	 * 
	 * @param dt
	 */
	public static long fmtStrTime(String dt, String pattern) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		try {
			date = sdf.parse(dt);
		} catch (ParseException e) {
			return 0;
		}
		
		return date.getTime() / 1000;
	}
	
	public static int getCurrentYear() {
		Calendar now = Calendar.getInstance();
		
		return now.get(Calendar.YEAR);
	}
	
	public static int getOldYear(long oldLongTime) {
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(oldLongTime * 1000);
		
		return now.get(Calendar.YEAR);
	}
	
	public static int getCurrentMonth() {
		Calendar now = Calendar.getInstance();
		
		return now.get(Calendar.MONTH) + 1;
	}
	
	public static String SecToHour(long second) {
		long min = second / 60;
		long sec = second % 60;
		long hour = 0;
		
		if (min >= 60) {
			hour = min / 60;
			min = min - (hour * 60);
		}
		
		StringBuffer sb = new StringBuffer();
		
		if (hour != 0) {
			sb.append(hour);
			sb.append("小时");
		}
		
		if (min != 0) {
			sb.append(min);
			sb.append("分");
		}
		
		sb.append(sec);
		sb.append("秒");
		
		return sb.toString();
	}
	
	/**
	 * 获取今天日期字符串
	 * 
	 * @return
	 */
	public static String getTodayString() {
		long now = System.currentTimeMillis() / 1000;
		
		return fmtLongTime(now, "yyyy-MM-dd");
	}
	
	public static String getTodayString2() {
		long now = System.currentTimeMillis() / 1000;
		
		return fmtLongTime(now, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 获取从今天开始倒退一个月日期字符串
	 * 
	 * @return
	 */
	public static String getOneMonthAgoString() {
		long now = (System.currentTimeMillis() / 1000) - 2592000;
		
		return fmtLongTime(now, "yyyy-MM-dd");
	}
	
	public static int getDate(int time) {
		return (int) DateStr2LongTime(fmtLongTime(time, "yyyy-M-dd"));
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param time
	 * @param digit
	 * @param style
	 * @return
	 */
	public static String fmtLongTime(long time, int digit, int style) {
		String dtStyle = "";
		
		switch (style) {
			case 1:
				dtStyle = "yyyy-M-dd HH:mm:ss";
				
				break;
			
			case 2:
				dtStyle = "yyyy-M-dd";
				
				break;
			
			case 3:
				dtStyle = "HH:mm:ss";
				
				break;
			
			case 4:
				dtStyle = "yy-M-dd";
				
				break;
			
			case 5:
				dtStyle = "M-dd HH";
				
				break;
			
			case 6:
				dtStyle = "yyyy年M月dd日";
				
				break;
			
			case 7:
				dtStyle = "yyyy年M月dd日 HH:mm:ss";
				
				break;
			
			case 8:
				dtStyle = "yyyy-M-dd HH:mm";
				
				break;
			
			default:
				dtStyle = "yyyy年M月dd日 HH:mm:ss";
				
				break;
		}
		
		if (digit == 10) {
			time = time * 1000;
		}
		
		sdf = new SimpleDateFormat(dtStyle);
		dtTime.setTime(time);
		
		return sdf.format(dtTime);
	}
	
	/**
	 * 获取今天日期long值
	 * 
	 * @return
	 */
	public static long getTodayLongTime() {
		String dt = getTodayString();
		return DateStr2LongTime(dt);
	}
	
	/**
	 * 得到小时数
	 * 
	 * @param dt
	 */
	public static int DateStr3LongTime(String dt, int unit) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		try {
			date = sdf.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return (date.getHours() * 60 + date.getMinutes()) / (unit / 60);
	}
	
	/**
	 * 日期字符串转换为日期long值
	 * 
	 * @param dt
	 */
	public static long DateStr2LongTime(String dt) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		
		try {
			date = sdf.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date.getTime() / 1000;
	}
	
	public static void main(String[] args) {
		// System.out.println(getCurrentYear());
		// System.out.println(getCurrentMonth());
		//
		// StatTime st = createStatTime("2006-12-12");
		// System.out.println(st.getEndTime());
		// System.out.println(DTUtil.getCurrentYear());
		// System.out.println(DTUtil.getOldYear((long)481478400));
		//
		// System.out.println(fmtLongTime(1179021938, "yyyy-M-dd HH:mm:ss"));
		// System.out.println(DTUtil.DateStr2LongTime(DTUtil.fmtLongTime(System.currentTimeMillis()/1000-86400l,
		// "yyyy-MM-dd")));
		// System.out.println(DTUtil.fmtLongTime(System.currentTimeMillis()/1000-86400l,
		// "yyyy-MM-dd"));
		System.out.println(DateStr3LongTime("01:31:11", 1800));
		
	}
}
