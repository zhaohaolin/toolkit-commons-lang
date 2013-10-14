/*******************************************************************************
 * CopyRight (c) 2005-2011 GLOBE Co, Ltd. All rights reserved.
 * Filename:    Propertable.java
 * Creator:     joe
 * Create-Date: 2011-4-27 下午08:26:07
 *******************************************************************************/
package com.toolkit.lang;

import java.util.Map;

/**
 * TODO
 * 
 * @author joe
 * @version $Id: Propertyable.java 57 2011-04-28 00:49:38Z joe $
 */
public interface Propertyable {
	
	Object getProperty(String key);
	
	Map<String, Object> getProperties();
	
	void setProperty(String key, Object value);
	
	void setProperties(Map<String, Object> properties);
	
}
