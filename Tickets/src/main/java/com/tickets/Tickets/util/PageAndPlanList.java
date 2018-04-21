package com.tickets.Tickets.util;

import java.util.List;

import com.tickets.Tickets.entity.Plan;

/**
 * @author tqy
 * @date 2018年4月17日
 * 
 */
public class PageAndPlanList {
	private int recordCount;	//总记录数
	private int pageCount;	//总页数
	private int index;		//第几页
	List<Plan> list;
	public PageAndPlanList(){
		recordCount=0;
		pageCount=0;
		index=0;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
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
