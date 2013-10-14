package com.toolkit.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public abstract class WebClient {
	
	private static int	maxConnOut	= 100;
	private static int	currConnOut	= 0;
	
	final static public void setMaxConnOut(int maxOut) {
		synchronized (WebClient.class) {
			WebClient.maxConnOut = maxOut;
		}
	}
	
	final static public int getCurrConnOut() {
		return WebClient.currConnOut;
	}
	
	final static public int getMaxConnOut() {
		return WebClient.maxConnOut;
	}
	
	private static class UTF8PostMethod extends PostMethod {
		private String	ecode	= "UTF-8";
		
		public UTF8PostMethod(String url, String encode) {
			super(url);
			if (!StringUtils.isEmpty(encode))
				this.ecode = encode;
		}
		
		@Override
		public String getRequestCharSet() {
			// return super.getRequestCharSet();
			return ecode;
		}
	}
	
	@Deprecated
	public final static String retrieveWebInfo(String url) {
		return retrieveWebContent(url);
	}
	
	public final static boolean ifOverMaxConn() {
		if (currConnOut >= WebClient.maxConnOut) {
			System.out.println("connect out over max:" + maxConnOut);
			return true;
		}
		return false;
	}
	
	public final static String retrieveWebContent(HttpClient httpClient,
			String url, String encode) {
		synchronized (WebClient.class) {
			if (ifOverMaxConn())
				return null;
			currConnOut++;
		}
		
		GetMethod httpGet = new GetMethod(url);
		String respBody = null;
		try {
			
			httpClient.getParams().setParameter("http.protocol.cookie-policy",
					CookiePolicy.IGNORE_COOKIES);
			
			int nRetCode = httpClient.executeMethod(httpGet);
			
			if (nRetCode == 200) {
				respBody = inputStreamAsString(
						httpGet.getResponseBodyAsStream(), encode);
			} else {
				System.out.println(new Date() + " url:" + url + " returnCode:"
						+ nRetCode);
			}
			
		} catch (Exception e) {
			System.out.println(new Date() + " url:" + url + " respBody:"
					+ respBody);
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
			synchronized (WebClient.class) {
				currConnOut--;
			}
		}
		
		if (respBody != null)
			respBody = respBody.trim();
		
		return respBody;
	}
	
	public final static String retrieveWebContent(HttpClient httpClient,
			String url) {
		return retrieveWebContent(httpClient, url, "UTF-8");
	}
	
	public final static String post(String url, Map<String, String> nv,
			String encode) {
		
		synchronized (WebClient.class) {
			if (ifOverMaxConn())
				return null;
			currConnOut++;
		}
		
		HttpConnectionManager connectionManager = WebClientManager
				.getInstance().getHttpConnectionManager();
		HttpClient httpClient = new HttpClient(connectionManager);
		
		PostMethod httpPost = new UTF8PostMethod(url, encode);
		String respBody = null;
		
		try {
			NameValuePair[] vcs = new NameValuePair[nv.size()];
			int i = 0;
			for (String name : nv.keySet()) {
				vcs[i] = new NameValuePair(name, nv.get(name));
				httpPost.setParameter(name, nv.get(name));
			}
			
			// httpPost.setRequestBody(vcs);
			// httpPost.setQueryString(vcs);
			
			int nRetCode = httpClient.executeMethod(httpPost);
			
			if (nRetCode == 200) {
				respBody = inputStreamAsString(
						httpPost.getResponseBodyAsStream(), encode);
			} else {
				System.out.println(new Date() + " url:" + url + " returnCode:"
						+ nRetCode);
			}
			
		} catch (Exception e) {
			System.out.println(new Date() + " url:" + url + " respBody:"
					+ respBody);
			e.printStackTrace();
		} finally {
			httpPost.releaseConnection();
			synchronized (WebClient.class) {
				currConnOut--;
			}
		}
		
		if (respBody != null)
			respBody = respBody.trim();
		
		return respBody;
		
	}
	
	public final static String post(String url, Map<String, String> nv) {
		return post(url, nv, "UTF-8");
	}
	
	public final static String retrieveWebContent(String url) {
		HttpConnectionManager connectionManager = WebClientManager
				.getInstance().getHttpConnectionManager();
		HttpClient httpClient = new HttpClient(connectionManager);
		return retrieveWebContent(httpClient, url);
	}
	
	public final static String retrieveWebContent(String url, String encode) {
		HttpConnectionManager connectionManager = WebClientManager
				.getInstance().getHttpConnectionManager();
		HttpClient httpClient = new HttpClient(connectionManager);
		return retrieveWebContent(httpClient, url, encode);
	}
	
	private final static String inputStreamAsString(InputStream stream,
			String encode) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(stream,
				encode));
		StringBuilder sb = new StringBuilder();
		String line = null;
		
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}
		
		br.close();
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		WebClient.setMaxConnOut(2);
		String output = "";
		for (int a = 0; a < 1; a++) {
			if (a % 4 == 0)
				output = retrieveWebContent("http://www.sina.com.cn");
			else if (a % 4 == 1)
				output = retrieveWebContent("http://www.sina.com.cn");
			else
				output = retrieveWebContent("http://www.sina.com.cn");
		}
		
		System.out.println(output);
	}
}
