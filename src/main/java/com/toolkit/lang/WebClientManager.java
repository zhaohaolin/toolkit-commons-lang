package com.toolkit.lang;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

/**
 * HTTPClient
 * 
 * @author joe.zhao
 * 
 */
public class WebClientManager {
	
	private static WebClientManager				webClientManager	= null;
	private MultiThreadedHttpConnectionManager	connectionManager	= null;
	
	private WebClientManager() {
		HttpConnectionManagerParams managerParams = new HttpConnectionManagerParams();
		managerParams.setMaxConnectionsPerHost(
				HostConfiguration.ANY_HOST_CONFIGURATION, 10000);
		managerParams.setConnectionTimeout(10 * 1000);
		managerParams.setMaxTotalConnections(99999999);
		
		connectionManager = new MultiThreadedHttpConnectionManager();
		connectionManager.setParams(managerParams);
	}
	
	public static WebClientManager getInstance() {
		if (webClientManager == null) {
			webClientManager = new WebClientManager();
		}
		return webClientManager;
	}
	
	public HttpConnectionManager getHttpConnectionManager() {
		return connectionManager;
	}
	
}
