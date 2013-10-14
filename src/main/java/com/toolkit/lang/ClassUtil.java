/*******************************************************************************
 * CopyRight (c) 2005-2011 GLOBE Co, Ltd. All rights reserved.
 * Filename:    ClassUtil.java
 * Creator:     joe
 * Create-Date: 2011-6-29 下午01:14:50
 *******************************************************************************/
package com.toolkit.lang;

import java.lang.reflect.Method;

import org.apache.commons.lang.ArrayUtils;

/**
 * TODO
 * 
 * @author joe
 * @version $Id: ClassUtil.java 490 2011-06-29 05:12:48Z joe $
 */
public class ClassUtil {
	
	public static Method[] getAllMethodOf(final Class<?> courseClass) {
		Method[] methods = null;
		
		Class<?> itr = courseClass;
		while (!itr.equals(Object.class)) {
			methods = (Method[]) ArrayUtils.addAll(itr.getDeclaredMethods(),
					methods);
			itr = itr.getSuperclass();
		}
		
		return methods;
	}
}
