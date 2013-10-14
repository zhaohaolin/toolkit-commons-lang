/*******************************************************************************
 * CopyRight (c) 2005-2011 GLOBE Co, Ltd. All rights reserved.
 * Filename:    Functor.java
 * Creator:     joe
 * Create-Date: 2011-6-13 下午04:02:28
 *******************************************************************************/
package com.toolkit.lang;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 * 
 * @author joe
 * @version $Id: Functor.java 391 2011-06-15 08:48:38Z joe $
 */
public class Functor implements Closure {
	
	private static final Logger	logger	= LoggerFactory
												.getLogger(Functor.class);
	
	private Object				target	= null;
	private Method				method	= null;
	
	public Functor(Object target, String methodName) {
		this.target = target;
		if (null == this.target) {
			throw new RuntimeException(" target is null.");
		}
		
		Method[] methods = null;
		Class<?> itr = target.getClass();
		while (!itr.equals(Object.class)) {
			methods = (Method[]) ArrayUtils.addAll(itr.getDeclaredMethods(),
					methods);
			itr = itr.getSuperclass();
		}
		if (null != methods)
			for (Method methodItr : methods) {
				if (methodItr.getName().equals(methodName)) {
					methodItr.setAccessible(true);
					this.method = methodItr;
				}
			}
		if (null == this.method) {
			throw new RuntimeException("method [" + target.getClass() + "."
					+ methodName + "] !NOT! exist.");
		}
	}
	
	@Override
	public void execute(Object... args) {
		try {
			method.invoke(this.target, args);
		} catch (IllegalArgumentException e) {
			logger.error("execute", e);
		} catch (IllegalAccessException e) {
			logger.error("execute", e);
		} catch (InvocationTargetException e) {
			logger.error("execute", e);
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.target);
		sb.append(".");
		sb.append(this.method.getName());
		return sb.toString();
	}
	
}
