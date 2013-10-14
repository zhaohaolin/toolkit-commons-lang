package com.toolkit.lang;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class CookieUtil {
	
	/**
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public final static String getLocalInfo(HttpServletRequest request,
			String key) {
		Cookie cookies[] = request.getCookies();
		if (cookies == null)
			return null;
		
		String value = null;
		for (Cookie cookie : cookies) {
			String cname = cookie.getName();
			if (cname.equals(key)) {
				value = cookie.getValue();
			}
		}
		
		return value;
	}
	
	public final static void setLocalInfo(HttpServletResponse response,
			String domain, String key, String value, int cookieAge) {
		Cookie cookieToken = new Cookie(key, value);
		cookieToken.setDomain(domain);
		cookieToken.setPath("/");
		cookieToken.setMaxAge(cookieAge);
		
		response.addCookie(cookieToken);
	}
	
	public final static void removeLocalInfo(HttpServletResponse response,
			String domain, String key) {
		Cookie cookieToken = new Cookie(key, "");
		cookieToken.setDomain(domain);
		cookieToken.setPath("/");
		cookieToken.setMaxAge(0);
		response.addCookie(cookieToken);
	}
}
