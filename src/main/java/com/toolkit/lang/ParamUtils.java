package com.toolkit.lang;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public abstract class ParamUtils {
	
	public ParamUtils() {
		//
	}
	
	public final static String getString(HttpServletRequest request, String s)
			throws Exception {
		String s1 = request.getParameter(s);
		if ((s1 != null) && !s1.equals("")) {
			return new String(s1);
		}
		return null;
	}
	
	public final static String getString(HttpServletRequest request, String s,
			String s1) throws Exception {
		String s2 = getString(request, s);
		if (s2 == null) {
			s2 = s1;
		}
		return s2;
	}
	
	public final static String getStringEncode(HttpServletRequest request,
			String s, String s1, String encode) throws Exception {
		String s2 = request.getParameter(s);
		if ((s2 != null) && !s2.equals("")) {
			s2 = new String(s2.getBytes("8859_1"), encode);
		} else {
			s2 = null;
		}
		if (s2 == null) {
			s2 = s1;
		}
		return s2;
	}
	
	public final static int getInt(HttpServletRequest request, String s)
			throws Exception {
		return Integer.parseInt(getString(request, s));
	}
	
	public final static long getLong(HttpServletRequest request, String s,
			long i) throws Exception {
		String s1 = getString(request, s);
		if (s1 == null) {
			return i;
		}
		return Long.parseLong(s1);
	}
	
	public final static int getInt(HttpServletRequest request, String s,
			int defaultValue) throws Exception {
		String s1 = getString(request, s);
		if (s1 == null) {
			return defaultValue;
		}
		return Integer.parseInt(s1);
	}
	
	public final static boolean getBoolean(HttpServletRequest request,
			String s, boolean b) throws Exception {
		String s1 = getString(request, s);
		if (s1 == null) {
			return b;
		}
		if ((s1.compareToIgnoreCase("true") == 0)
				|| (s1.compareToIgnoreCase("1") == 0)) {
			return true;
		}
		return false;
	}
	
	public final static double getDouble(HttpServletRequest request, String s,
			double d) throws Exception {
		String s1 = getString(request, s);
		if (s1 == null) {
			return d;
		}
		return Double.parseDouble(s1);
	}
	
	public final static void setErrorInfo(HttpServletRequest request, String s) {
		request.getSession().setAttribute("PARAMUTIL_ERROR_INFO", s);
	}
	
	public final static String getErrorInfo(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute("PARAMUTIL_ERROR_INFO");
		if (obj != null) {
			request.getSession().removeAttribute("PARAMUTIL_ERROR_INFO");
			return (String) obj;
		}
		return null;
	}
	
	public final static boolean hasErrorInfo(HttpServletRequest request) {
		return request.getSession().getAttribute("PARAMUTIL_ERROR_INFO") != null;
	}
	
	public final static String computeQueryString(HttpServletRequest request) {
		String queryString = "";
		Enumeration<?> paramNames = request.getParameterNames();
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
	
	public final static void setCorrectInfo(HttpServletRequest request, String s) {
		request.getSession().setAttribute("PARAMUTIL_CORRECT_INFO", s);
	}
	
	public final static String getCorrectInfo(HttpServletRequest request) {
		Object obj = request.getSession()
				.getAttribute("PARAMUTIL_CORRECT_INFO");
		if (obj != null) {
			request.getSession().removeAttribute("PARAMUTIL_CORRECT_INFO");
			return (String) obj;
		}
		return null;
	}
	
	public final static boolean hasCorrectInfo(HttpServletRequest request) {
		return request.getSession().getAttribute("PARAMUTIL_CORRECT_INFO") != null;
	}
}
