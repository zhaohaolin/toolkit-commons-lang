package com.toolkit.lang;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringUtils {
	
	/**
	 * 将下划线连接的字符串替换为驼峰风格,方便JavaBean拷贝
	 * <p/>
	 * <h2>Example:</h2>
	 * <code>toCamelCasing("pic_path")</code> will return picPath
	 * 
	 * @param s
	 * @return
	 */
	public final static String toCamelCasing(String s) {
		if (s == null) {
			return s;
		}
		
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < s.length() - 1; i++) {
			char ch = s.charAt(i);
			if (ch != '_') {
				buffer.append(ch);
			} else {
				char nextChar = s.charAt(i + 1);
				if (nextChar != '_') {
					if (buffer.toString().length() < 2) {
						buffer.append(Character.toLowerCase(nextChar));
					} else {
						buffer.append(Character.toUpperCase(nextChar));
					}
					i++;
				}
			}
		}
		char lastChar = s.charAt(s.length() - 1);
		if (lastChar != '_') {
			buffer.append(lastChar);
		}
		
		return buffer.toString();
	}
	
	public final static boolean isBlank(String str) {
		int length;
		
		if ((str == null) || ((length = str.length()) == 0)) {
			return true;
		}
		
		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	public final static String rightPad(String text, int length, char c) {
		if (text == null) {
			return text;
		}
		if (text.length() >= length) {
			return text;
		}
		
		char[] array = new char[length];
		System.arraycopy(text.toCharArray(), 0, array, 0, text.length());
		Arrays.fill(array, text.length(), length, c);
		return new String(array);
	}
	
	public final static String GetString(String s) {
		try {
			return new String(s.getBytes("ISO8859_1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public final static boolean IsNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!((s.charAt(i) >= '0') && (s.charAt(i) <= '9'))) {
				return false;
			}
		}
		
		return true;
	}
	
	public final static boolean IsIpAddress(String s) {
		String strMatch = "^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$";
		Pattern ParsePattern = Pattern.compile(strMatch);
		Matcher ParseMatcher = ParsePattern.matcher(s);
		
		// boolean a = ParseMatcher.find();
		return ParseMatcher.find();
	}
	
	public final static boolean IsDomainName(String s) {
		String strMatch = "[a-zA-Z0-9]+([a-zA-Z0-9\\-\\.]+)?\\.(com|cn|org|net|mil|edu|COM|ORG|NET|MIL|EDU)";
		Pattern ParsePattern = Pattern.compile(strMatch);
		Matcher ParseMatcher = ParsePattern.matcher(s);
		
		return ParseMatcher.find();
	}
	
	public final static boolean IsEmailAddr(String s) {
		String strMatch = "([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})";
		Pattern ParsePattern = Pattern.compile(strMatch);
		Matcher ParseMatcher = ParsePattern.matcher(s);
		
		return ParseMatcher.find();
	}
	
	public final static String GetStandardDouble(double d, int pL) {
		String format = "0.";
		
		for (int i = 0; i < pL; i++)
			format += "0";
		
		return ((new DecimalFormat(format)).format(d));
	}
	
	public final static String LongTimeToString(long time, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date dtTime = new Date(time);
		
		return sdf.format(dtTime);
	}
	
	public final static String GetRandValue(int num) {
		String sRand = "";
		Random random = new Random();
		
		for (int i = 0; i < num; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
		}
		
		return sRand;
	}
	
	public final static String GetRandValue32() {
		return SecurityUtil.MD5(String.valueOf(new Date().getTime()));
	}
	
	public final static String SecToHour(int second) {
		int min = second / 60;
		int sec = second % 60;
		int hour = 0;
		
		if (min >= 60) {
			hour = min / 60;
			min = min - (hour * 60);
		}
		
		StringBuffer sb = new StringBuffer();
		
		if (hour != 0) {
			sb.append(hour);
			sb.append("��?");
		}
		
		if (min != 0) {
			sb.append(min);
			sb.append("??");
		}
		
		sb.append(sec);
		sb.append("??");
		
		return sb.toString();
	}
	
	public final static boolean isEmpty(String str) {
		return (str == null) || (str.length() == 0);
	}
	
	public final static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	public static void main(String[] args) {
		// String ip="220.192.157.0";
		// System.out.println(IsIpAddress(ip));
		// String domainName = ".www.uucall.co";
		// System.out.println(IsDomainName(domainName));
	}
}
