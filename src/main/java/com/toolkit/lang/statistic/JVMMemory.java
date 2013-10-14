/*******************************************************************************
 * CopyRight (c) 2005-2011 TAOTAOSOU Co, Ltd. All rights reserved.
 * Filename:    JVMMemory.java
 * Creator:     qiaofeng
 * Create-Date: 2011-6-14 上午10:11:10
 *******************************************************************************/
package com.toolkit.lang.statistic;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * TODO
 * 
 * @author qiaofeng
 * @version $Id: JVMMemory.java 374 2011-06-14 04:41:54Z qiaofeng $
 */
public class JVMMemory {
	
	private final MemoryMXBean	memoryMXBean;
	
	public JVMMemory() {
		memoryMXBean = ManagementFactory.getMemoryMXBean();
	}
	
	public long getHeapMemoryUsed() {
		return memoryMXBean.getHeapMemoryUsage().getUsed();
	}
	
	public long getHeapMemoryMax() {
		return memoryMXBean.getHeapMemoryUsage().getMax();
	}
	
	public long getHeapMemoryCommitted() {
		return memoryMXBean.getHeapMemoryUsage().getCommitted();
	}
	
	public long getHeapMemoryInit() {
		return memoryMXBean.getHeapMemoryUsage().getInit();
	}
	
	public double getHeapMemoryUsedInMBytes() {
		return ((double) getHeapMemoryUsed() / (1024 * 1024));
	}
	
	public double getHeapMemoryMaxInMBytes() {
		return ((double) getHeapMemoryMax() / (1024 * 1024));
	}
	
	public double getHeapMemoryCommittedInMBytes() {
		return ((double) getHeapMemoryCommitted() / (1024 * 1024));
	}
	
	public double getHeapMemoryInitInMBytes() {
		return ((double) getHeapMemoryInit() / (1024 * 1024));
	}
}
