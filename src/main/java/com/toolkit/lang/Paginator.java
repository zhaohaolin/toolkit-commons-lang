/*******************************************************************************
 * CopyRight (c) 2005-2011 GLOBE Co, Ltd. All rights reserved.
 * Filename:    Paginator.java
 * Creator:     joe
 * Create-Date: 2011-4-30 下午07:43:25
 *******************************************************************************/
package com.toolkit.lang;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 分页器
 * 
 * @author joe
 * @version $Id: Paginator.java 238 2011-05-25 06:06:18Z joe $
 */
public class Paginator implements Serializable, Cloneable {
	/**
     * 
     */
	private static final long	serialVersionUID		= -7029079889853156238L;
	
	/**
	 * 默认每页20条
	 */
	public static final int		DEFAULT_ITEMS_PER_PAGE	= 20;
	
	public static final int		UNKNOWN_ITEMS			= Integer.MAX_VALUE;
	
	/**
	 * 当前页码，从0开始
	 */
	private int					page;												// 0-based
																					
	/**
	 * 总记录数
	 */
	private int					items;
	
	/**
	 * 总页数
	 */
	private int					pageCount;
	
	/**
	 * 每页记录条数
	 */
	private int					itemsPerPage;
	
	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	/**
	 * 当前页码从0开始，总条数为无限大，每页20条
	 */
	public Paginator() {
		this(DEFAULT_ITEMS_PER_PAGE);
	}
	
	/**
	 * 当前页码从0开始，总条数为无限大，每页<code>itemsPerPage</code>条
	 * 
	 * @param itemsPerPage
	 *            每页记录条数
	 */
	public Paginator(int itemsPerPage) {
		this(itemsPerPage, UNKNOWN_ITEMS);
	}
	
	/**
	 * 当前页码从0开始，总条数为<code>items</code>，每页<code>itemsPerPage</code>条
	 * 
	 * @param itemsPerPage
	 *            每页记录条数
	 * @param items
	 *            总记录数
	 */
	public Paginator(int itemsPerPage, int items) {
		this.items = (items >= 0) ? items : 0;
		this.itemsPerPage = (itemsPerPage > 0) ? itemsPerPage
				: DEFAULT_ITEMS_PER_PAGE;
		this.page = calcPage(0);
	}
	
	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getPages() {
		return (int) Math.ceil((double) items / itemsPerPage);
	}
	
	/**
	 * 获取当前页
	 * 
	 * @return
	 */
	public int getPage() {
		return page;
	}
	
	/**
	 * 设置当前页
	 * 
	 * @param page
	 *            当前页码
	 * @return
	 */
	public int setPage(int page) {
		return (this.page = calcPage(page));
	}
	
	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getItems() {
		return items;
	}
	
	/**
	 * 设置总记录数，并重新计算当前页码以确保其不超过总页数
	 * 
	 * @param items
	 *            总记录数
	 * @return
	 */
	public int setItems(int items) {
		this.items = (items >= 0) ? items : 0;
		setPage(page);
		setPageCount(getPages());
		return this.items;
	}
	
	/**
	 * 获取每页记录数
	 * 
	 * @return
	 */
	public int getItemsPerPage() {
		return itemsPerPage;
	}
	
	/**
	 * 设置每页记录数，并重新计算当前页码
	 * 
	 * @param itemsPerPage
	 *            每页记录数
	 * @return
	 */
	public int setItemsPerPage(int itemsPerPage) {
		int tmp = this.itemsPerPage;
		
		this.itemsPerPage = (itemsPerPage > 0) ? itemsPerPage
				: DEFAULT_ITEMS_PER_PAGE;
		
		if (page > 0) {
			setPage((int) (((double) (page - 1) * tmp) / this.itemsPerPage) + 1);
		}
		
		return this.itemsPerPage;
	}
	
	/**
	 * 获取开始索引，从0开始
	 * 
	 * @return
	 */
	public int getBeginIndex() {
		if (page >= 0) {
			return itemsPerPage * page;
		} else {
			return 0;
		}
	}
	
	/**
	 * 获取结束索引
	 * 
	 * @return
	 */
	public int getEndIndex() {
		if (page >= 0) {
			return Math.min(itemsPerPage * (page + 1) - 1, items);
		} else {
			return 0;
		}
	}
	
	/**
	 * 获取第一页
	 * 
	 * @return
	 */
	public int getFirstPage() {
		return calcPage(0);
	}
	
	/**
	 * 获取最后一页
	 * 
	 * @return
	 */
	public int getLastPage() {
		return calcPage(getPages() - 1);
	}
	
	/**
	 * 获取前一页
	 * 
	 * @return
	 */
	public int getPreviousPage() {
		return calcPage(page - 1);
	}
	
	/**
	 * 获取前<code>n</code>页
	 * 
	 * @param n
	 * @return
	 */
	public int getPreviousPage(int n) {
		return calcPage(page - n);
	}
	
	/**
	 * 获取后一页
	 * 
	 * @return
	 */
	public int getNextPage() {
		return calcPage(page + 1);
	}
	
	/**
	 * 获取后<code>n</code>页
	 * 
	 * @param n
	 * @return
	 */
	public int getNextPage(int n) {
		return calcPage(page + n);
	}
	
	/**
	 * 确保给定的页码不小于0，不超过总页码
	 * 
	 * @param page
	 * @return
	 */
	protected int calcPage(int page) {
		int pages = getPages();
		
		if (pages > 0) {
			return (page < 0) ? 0 : ((page >= pages) ? (pages - 1) : page);
		}
		
		return 0;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
