/*******************************************************************************
 * CopyRight (c) 2005-2011 GLOBE Co, Ltd. All rights reserved.
 * Filename:    Identifyable.java
 * Creator:     joe
 * Create-Date: 2011-4-27 下午08:19:41
 *******************************************************************************/
package com.toolkit.lang;

import java.util.UUID;

/**
 * TODO
 * 
 * @author joe
 * @version $Id: Identifiable.java 59 2011-04-28 01:21:12Z joe $
 */
public interface Identifiable {
	
	void setIdentification(UUID id);
	
	UUID getIdentification();
	
}
