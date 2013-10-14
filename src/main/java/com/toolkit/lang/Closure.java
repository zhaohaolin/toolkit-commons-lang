/*******************************************************************************
 * CopyRight (c) 2005-2011 GLOBE Co, Ltd. All rights reserved.
 * Filename:    Closure.java
 * Creator:     joe
 * Create-Date: 2011-6-10 上午09:37:18
 *******************************************************************************/
package com.toolkit.lang;

/**
 * TODO
 * 
 * @author joe
 * @version $Id: Closure.java 391 2011-06-15 08:48:38Z joe $
 */
public interface Closure {
	/**
	 * Performs an action on the specified input object.
	 * 
	 * @param input
	 *            the input to execute on
	 */
	public void execute(Object... input);
	
}
