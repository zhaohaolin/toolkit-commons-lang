package com.toolkit.lang;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class UrlUtil {
	
	private final static String[]	hex	= { "00", "01", "02", "03", "04", "05",
			"06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B",
			"1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26",
			"27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31",
			"32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C",
			"3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47",
			"48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52",
			"53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D",
			"5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68",
			"69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73",
			"74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E",
			"7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89",
			"8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94",
			"95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F",
			"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA",
			"AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5",
			"B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0",
			"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB",
			"CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6",
			"D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1",
			"E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC",
			"ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7",
			"F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF" };
	private final static byte[]		val	= { 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x00, 0x01,
			0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F };
	
	public static String escape(String s) {
		if (s == null) {
			return "";
		}
		
		StringBuffer sbuf = new StringBuffer();
		int len = s.length();
		
		for (int i = 0; i < len; i++) {
			int ch = s.charAt(i);
			
			if (('A' <= ch) && (ch <= 'Z')) { // 'A'..'Z' : as it was
				sbuf.append((char) ch);
			} else if (('a' <= ch) && (ch <= 'z')) { // 'a'..'z' : as it was
				sbuf.append((char) ch);
			} else if (('0' <= ch) && (ch <= '9')) { // '0'..'9' : as it was
				sbuf.append((char) ch);
			} else if ((ch == '-')
					|| (ch == '_') // unreserved : as it was
					|| (ch == '.') || (ch == '!') || (ch == '~') || (ch == '*')
					|| (ch == '\'') || (ch == '(') || (ch == ')')) {
				sbuf.append((char) ch);
			} else if (ch <= 0x007F) { // other ASCII : map to %XX
				sbuf.append('%');
				sbuf.append(hex[ch]);
			} else { // unicode : map to %uXXXX
				sbuf.append('%');
				sbuf.append('u');
				sbuf.append(hex[(ch >>> 8)]);
				sbuf.append(hex[(0x00FF & ch)]);
			}
		}
		
		return sbuf.toString();
	}
	
	public static String unescape(String s) {
		if (s == null) {
			return "";
		}
		
		StringBuffer sbuf = new StringBuffer();
		int i = 0;
		int len = s.length();
		
		while (i < len) {
			int ch = s.charAt(i);
			
			if (('A' <= ch) && (ch <= 'Z')) { // 'A'..'Z' : as it was
				sbuf.append((char) ch);
			} else if (('a' <= ch) && (ch <= 'z')) { // 'a'..'z' : as it was
				sbuf.append((char) ch);
			} else if (('0' <= ch) && (ch <= '9')) { // '0'..'9' : as it was
				sbuf.append((char) ch);
			} else if ((ch == '-')
					|| (ch == '_') // unreserved : as it was
					|| (ch == '.') || (ch == '!') || (ch == '~') || (ch == '*')
					|| (ch == '\'') || (ch == '(') || (ch == ')')) {
				sbuf.append((char) ch);
			} else if (ch == '%') {
				int cint = 0;
				
				if ('u' != s.charAt(i + 1)) { // %XX : map to ascii(XX)
					cint = (cint << 4) | val[s.charAt(i + 1)];
					cint = (cint << 4) | val[s.charAt(i + 2)];
					i += 2;
				} else { // %uXXXX : map to unicode(XXXX)
					cint = (cint << 4) | val[s.charAt(i + 2)];
					cint = (cint << 4) | val[s.charAt(i + 3)];
					cint = (cint << 4) | val[s.charAt(i + 4)];
					cint = (cint << 4) | val[s.charAt(i + 5)];
					i += 5;
				}
				
				sbuf.append((char) cint);
			} else {
				sbuf.append((char) ch);
			}
			
			i++;
		}
		
		return sbuf.toString();
	}
	
	public static String ISO2GB(String text) {
		String result = "";
		
		try {
			result = new String(text.getBytes("ISO-8859-1"), "GB2312");
		} catch (UnsupportedEncodingException ex) {
			result = ex.toString();
		}
		
		return result;
	}
	
	public static String GB2ISO(String text) {
		String result = "";
		
		try {
			result = new String(text.getBytes("GB2312"), "ISO-8859-1");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
	public static String Utf8URLencode(String text) {
		StringBuffer result = new StringBuffer();
		
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			
			if ((c >= 0) && (c <= 255)) {
				result.append(c);
			} else {
				byte[] b = new byte[0];
				
				try {
					b = Character.toString(c).getBytes("UTF-8");
				} catch (Exception ex) {
				}
				
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					
					if (k < 0) {
						k += 256;
					}
					
					result.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		
		return result.toString();
	}
	
	public static String Utf8URLdecode(String text) {
		String result = "";
		int p = 0;
		
		if ((text != null) && (text.length() > 0)) {
			text = text.toLowerCase();
			p = text.indexOf("%e");
			
			if (p == -1) {
				return text;
			}
			
			while (p != -1) {
				result += text.substring(0, p);
				text = text.substring(p, text.length());
				
				if ((text == "") || (text.length() < 9)) {
					return result;
				}
				
				result += CodeToWord(text.substring(0, 9));
				text = text.substring(9, text.length());
				p = text.indexOf("%e");
			}
		}
		
		return result + text;
	}
	
	private static String CodeToWord(String text) {
		String result;
		
		if (Utf8codeCheck(text)) {
			byte[] code = new byte[3];
			code[0] = (byte) (Integer.parseInt(text.substring(1, 3), 16) - 256);
			code[1] = (byte) (Integer.parseInt(text.substring(4, 6), 16) - 256);
			code[2] = (byte) (Integer.parseInt(text.substring(7, 9), 16) - 256);
			
			try {
				result = new String(code, "UTF-8");
			} catch (UnsupportedEncodingException ex) {
				result = null;
			}
		} else {
			result = text;
		}
		
		return result;
	}
	
	private static boolean Utf8codeCheck(String text) {
		String sign = "";
		
		if (text.startsWith("%e")) {
			for (int i = 0, p = 0; p != -1; i++) {
				p = text.indexOf("%", p);
				
				if (p != -1) {
					p++;
				}
				
				sign += p;
			}
		}
		
		return sign.equals("147-1");
	}
	
	public static boolean isUtf8Url(String text) {
		text = text.toLowerCase();
		
		int p = text.indexOf("%");
		
		if ((p != -1) && ((text.length() - p) > 9)) {
			text = text.substring(p, p + 9);
		}
		
		return Utf8codeCheck(text);
	}
	
	// public static String getQueryString(HttpServletRequest request) {
	// String queryString = "";
	// Enumeration paramNames = request.getParameterNames();
	// boolean first = true;
	//
	// while (paramNames.hasMoreElements()) {
	// String name = (String) paramNames.nextElement();
	//
	// if (!first)
	// queryString += "&";
	// queryString += name + "=" + request.getParameter(name);
	// first = false;
	// }
	// return queryString;
	// }
	
	public static Map getUrlParameters(String url) {
		Map<String, String> map = new HashMap<String, String>();
		int pos = url.indexOf("?");
		url = url.substring(pos + 1);
		
		String[] paras = url.split("&");
		
		for (String para : paras) {
			pos = para.indexOf("=");
			
			if (pos != -1) {
				map.put(para.substring(0, pos), para.substring(pos + 1));
			}
		}
		
		return map;
	}
	
	public static String getUrlFileName(String uri) {
		int pos = uri.indexOf("?");
		
		if (pos > 0) {
			return uri.substring(0, pos);
		}
		
		return uri;
	}
	
	public static void main(String[] args) throws Exception {
		getUrlParameters("http://sss.com.com/aa.do");
		
		String stest = "����1234 abcd[]()<+>,.~\\";
		System.out.println(stest);
		System.out.println(escape(stest));
		System.out.println(unescape(escape(stest)));
	}
}
