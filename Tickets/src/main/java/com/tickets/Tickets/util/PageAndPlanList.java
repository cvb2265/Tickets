package com.tickets.Tickets.util;

import java.util.List;

import com.tickets.Tickets.entity.Plan;

/**
 * @author tqy
 * @date 2018年4月17日
 * 
 */
public class PageAndPlanList {
	private Long recordCount;	//总记录数
	private Long pageCount;	//总页数
	private Long index;		//第几页
	List<Plan> list;
	public PageAndPlanList(){
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
	public List<Plan> getList() {
		return list;
	}
	public void setList(List<Plan> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageAndPlanList [recordCount=" + recordCount + ", pageCount=" + pageCount + ", index=" + index
				+ ", list=" + list + "]";
	}
}
