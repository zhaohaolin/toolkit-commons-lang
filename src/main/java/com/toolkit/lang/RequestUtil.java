package com.toolkit.lang;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestUtil {
	
	RequestUtil() {
	}
	
	private static String stringEncode(String value)
			throws UnsupportedEncodingException {
		if (value != null) {
			return new String(value.getBytes("8859_1"), "gb2312");
		} else {
			return null;
		}
	}
	
	private static String getDefaultValue(String value, String d) {
		if (value == null)
			return d;
		return value;
	}
	
	private static int getDefaultValue(String value, int d) {
		if (value == null)
			return d;
		else
			return Integer.parseInt(value);
	}
	
	private static long getDefaultValue(String value, long d) {
		if (value == null)
			return d;
		else
			return Long.parseLong(value);
	}
	
	private static boolean getDefaultValue(String value, boolean d) {
		if (value == null)
			return d;
		if ((value.compareToIgnoreCase("true") == 0)
				|| (value.compareToIgnoreCase("1") == 0))
			return true;
		return false;
	}
	
	private static double getDefaultValue(String value, double d) {
		if (value == null)
			return d;
		return Double.parseDouble(value);
	}
	
	public static String getParaString(HttpServletRequest request, String name)
			throws UnsupportedEncodingException {
		String value = request.getParameter(name);
		return stringEncode(value);
	}
	
	public static String getParaString(HttpServletRequest request, String name,
			String d) throws UnsupportedEncodingException {
		String value = getParaString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static int getParaInt(HttpServletRequest request, String name)
			throws NumberFormatException, UnsupportedEncodingException {
		return Integer.parseInt(getParaString(request, name));
	}
	
	public static int getParaInt(HttpServletRequest request, String name, int d)
			throws UnsupportedEncodingException {
		String value = getParaString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static long getParaLong(HttpServletRequest request, String name,
			long d) throws UnsupportedEncodingException {
		String value = getParaString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static boolean getParaBoolean(HttpServletRequest request,
			String name, boolean d) throws UnsupportedEncodingException {
		String value = getParaString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static double getParaDouble(HttpServletRequest request, String name,
			double d) throws Exception {
		String value = getParaString(request, name);
		return getDefaultValue(value, d);
	}
	
	// attribute
	
	public static String getAttrString(HttpServletRequest request, String name)
			throws UnsupportedEncodingException {
		Object value = request.getAttribute(name);
		if (value == null)
			return null;
		return stringEncode((String) value);
	}
	
	public static String getAttrString(HttpServletRequest request, String name,
			String d) throws UnsupportedEncodingException {
		String value = getAttrString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static void setAttrString(HttpServletRequest request, String name,
			String value) {
		request.setAttribute(name, value);
	}
	
	public static int getAttrInt(HttpServletRequest request, String name)
			throws NumberFormatException, UnsupportedEncodingException {
		return Integer.parseInt(getParaString(request, name));
	}
	
	public static int getAttrInt(HttpServletRequest request, String name, int d)
			throws UnsupportedEncodingException {
		String value = getAttrString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static void setAttrInt(HttpServletRequest request, String name,
			int value) {
		setAttrString(request, name, String.valueOf(value));
	}
	
	public static long getAttrLong(HttpServletRequest request, String name,
			long d) throws UnsupportedEncodingException {
		String value = getAttrString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static void setAttrLong(HttpServletRequest request, String name,
			long value) {
		setAttrString(request, name, String.valueOf(value));
	}
	
	public static boolean getAttrBoolean(HttpServletRequest request,
			String name, boolean d) throws UnsupportedEncodingException {
		String value = getAttrString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static void setAttrBoolean(HttpServletRequest request, String name,
			boolean value) {
		setAttrString(request, name, String.valueOf(value));
	}
	
	public static double getAttrDouble(HttpServletRequest request, String name,
			double d) throws Exception {
		String value = getParaString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static void setAttrDouble(HttpServletRequest request, String name,
			double value) {
		setAttrString(request, name, String.valueOf(value));
	}
	
	// cookie
	
	public static String getCookieString(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (name.equals(cookie.getName()))
				return (cookie.getValue());
		}
		return null;
	}
	
	public static String getCookieString(HttpServletRequest request,
			String name, String d) {
		String value = getCookieString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static void setCookieString(HttpServletResponse response,
			String name, String value) {
		Cookie cookie = new Cookie(name, value);
		response.addCookie(cookie);
	}
	
	public static int getCookieInt(HttpServletRequest request, String name)
			throws NumberFormatException, UnsupportedEncodingException {
		return Integer.parseInt(getParaString(request, name));
	}
	
	public static int getCookieInt(HttpServletRequest request, String name,
			int d) throws UnsupportedEncodingException {
		String value = getAttrString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static void setCookieInt(HttpServletResponse response, String name,
			int value) {
		setCookieString(response, name, String.valueOf(value));
	}
	
	public static long getCookieLong(HttpServletRequest request, String name,
			long d) throws UnsupportedEncodingException {
		String value = getAttrString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static void setCookieLong(HttpServletResponse response, String name,
			long value) {
		setCookieString(response, name, String.valueOf(value));
	}
	
	public static boolean getCookieBoolean(HttpServletRequest request,
			String name, boolean d) throws UnsupportedEncodingException {
		String value = getAttrString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static void setCookieBoolean(HttpServletResponse response,
			String name, boolean value) {
		setCookieString(response, name, String.valueOf(value));
	}
	
	public static double getCookieDouble(HttpServletRequest request,
			String name, double d) throws Exception {
		String value = getParaString(request, name);
		return getDefaultValue(value, d);
	}
	
	public static void setCookieDouble(HttpServletResponse response,
			String name, double value) {
		setCookieString(response, name, String.valueOf(value));
	}
	
	public static void setErrorInfo(HttpServletRequest request, String s) {
		request.getSession().setAttribute("PARAMUTIL_ERROR_INFO", s);
	}
	
	public static String getErrorInfo(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute("PARAMUTIL_ERROR_INFO");
		
		if (obj != null) {
			request.getSession().removeAttribute("PARAMUTIL_ERROR_INFO");
			
			return (String) obj;
		}
		
		return null;
	}
	
	public static boolean hasErrorInfo(HttpServletRequest request) {
		return request.getSession().getAttribute("PARAMUTIL_ERROR_INFO") != null;
	}
	
	public static String computeQueryString(HttpServletRequest request) {
		String queryString = "";
		Enumeration paramNames = request.getParameterNames();
		boolean first = true;
		
		while (paramNames.hasMoreElements()) {
			String name = (String) paramNames.nextElement();
			
			if (!first)
				queryString += "&";
			queryString += name + "=" + request.getParameter(name);
			first = false;
		}
		return queryString;
	}
}
