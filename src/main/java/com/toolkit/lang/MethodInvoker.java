/*******************************************************************************
 * CopyRight (c) 2005-2011 GLOBE Co, Ltd. All rights reserved.
 * Filename:    MethodInvoker.java
 * Creator:     joe
 * Create-Date: 2011-4-27 上午10:47:17
 *******************************************************************************/
package com.toolkit.lang;

import java.lang.reflect.Method;

import org.apache.commons.lang.ArrayUtils;

/**
 * TODO
 * 
 * @author joe
 * @version $Id: MethodInvoker.java 36 2011-04-27 02:40:17Z joe $
 */
public class MethodInvoker {
	
	public MethodInvoker(Object methodOwner, String methodName, Object... args)
			throws Exception {
		if (null == methodOwner) {
			throw new RuntimeException(" methodOwner is null.");
		}
		
		Method[] methods = null;
		Class<?> itr = methodOwner.getClass();
		while (!itr.equals(Object.class)) {
			methods = (Method[]) ArrayUtils.addAll(itr.getDeclaredMethods(),
					methods);
			itr = itr.getSuperclass();
		}
		
		Method method = null;
		if (null != methods)
			for (Method methodItr : methods) {
				if (methodItr.getName().equals(methodName)) {
					methodItr.setAccessible(true);
					method = methodItr;
				}
			}
		
		if (null == method) {
			throw new RuntimeException("method [" + methodOwner.getClass()
					+ "." + methodName + "] !NOT! exist.");
		}
		
		method.invoke(methodOwner, args);
	}
	
	public MethodInvoker(Object methodOwner, String methodName, Object arg1,
			Object arg2) throws Exception {
		this(methodOwner, methodName, new Object[] { arg1, arg2 });
	}
	
}
