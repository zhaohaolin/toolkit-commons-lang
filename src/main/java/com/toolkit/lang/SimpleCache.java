/*******************************************************************************
 * CopyRight (c) 2005-2011 GLOBE Co, Ltd. All rights reserved.
 * Filename:    SimpleCache.java
 * Creator:     Archibald.Wang
 * Create-Date: 2011-4-27 上午11:23:42
 *******************************************************************************/
package com.toolkit.lang;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 * 
 * @author Archibald.Wang
 * @version $Id: SimpleCache.java 34 2011-04-27 02:34:33Z joe $
 */
public class SimpleCache<K, V> {
	
	private ConcurrentHashMap<K, V>	map	= new ConcurrentHashMap<K, V>();
	
	public V get(K key, Callable<V> ifAbsent) {
		V value = map.get(key);
		if (value == null) {
			try {
				value = ifAbsent.call();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			map.putIfAbsent(key, value);
		}
		return value;
	}
	
}
