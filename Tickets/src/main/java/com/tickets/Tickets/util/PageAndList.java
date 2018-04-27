package com.tickets.Tickets.util;

import java.util.List;

/**
 * 泛型类，成员list可以装多个未知类型T的对象
 * @author tqy
 * @date 2018年4月17日
 * 
 */
public class PageAndList<T> {
	private Long recordCount;	//总记录数
	private Long pageCount;	//总页数
	private Long index;		//第几页
	List<T> list;
	public PageAndList(){
		recordCount=0L;
		pageCount=0L;
		index=0L;
	}
	public Long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}
	public Long getPageCount() {
		return pageCount;
	}
	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}
	public Long getIndex() {
		return index;
	}
	public void setIndex(Long index) {
		this.index = index;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageAndPlanList [recordCount=" + recordCount + ", pageCount=" + pageCount + ", index=" + index
				+ ", list=" + list + "]";
	}
}
