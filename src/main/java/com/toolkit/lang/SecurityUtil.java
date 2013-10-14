package com.toolkit.lang;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class SecurityUtil {
	
	private final static String[]	hexDigits	= { "0", "1", "2", "3", "4",
			"5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	public final static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	
	private final static String byteToHexString(byte b) {
		int n = b;
		
		if (n < 0) {
			n = 256 + n;
		}
		
		int d1 = n / 16;
		int d2 = n % 16;
		
		return hexDigits[d1] + hexDigits[d2];
	}
	
	public final static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		
		return b;
	}
	
	public final static String MD5(String origin) {
		String resultString = null;
		
		try {
			resultString = new String(origin);
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
			//
		}
		
		return resultString;
	}
	
	public final static String MD5(String origin, String encode) {
		String resultString = null;
		
		try {
			resultString = new String(origin);
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes(encode)));
		} catch (Exception ex) {
			//
		}
		
		return resultString;
	}
	
	public final static String SHA1(String origin) {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			
			md.update(origin.getBytes());
			
			resultString = SecurityUtil.byteArrayToHexString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return resultString;
	}
	
	public static void main(String[] args) throws Exception {
		// String a = "6johnmafei@126.com1123456";
		// a = URLEncoder.encode(a, "utf-8");
		// System.out.println(Security.SHA1(a));
		System.out.println(MD5("09876543211234567890"));
	}
}
