package com.tickets.Tickets.util;

/**
 * @author tqy
 * @date 2018年4月17日
 * 
 */
public class Page {
	private int pageCount;	//总页数
	private int index;		//第几页
	public Page(){
		pageCount=0;
		index=0;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public String toString() {
		return "Page [pageCount=" + pageCount + ", index=" + index + "]";
	}
}
