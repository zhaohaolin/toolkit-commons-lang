package com.toolkit.lang;

public abstract class EncryptUtil {
	
	public final static String getEncryptToken(String logToken,
			String userPwdMD5) {
		String encryptToken = SecurityUtil.MD5(logToken.toUpperCase()
				+ userPwdMD5.toUpperCase());
		return encryptToken;
	}
	
	public final static String getMD5Data(String... data) {
		StringBuilder sb = new StringBuilder();
		for (String str : data) {
			sb.append(str.toUpperCase());
		}
		String mac = SecurityUtil.MD5(sb.toString());
		return mac;
	}
}
