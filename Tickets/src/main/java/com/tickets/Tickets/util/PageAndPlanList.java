package com.tickets.Tickets.util;

import java.util.List;

import com.tickets.Tickets.entity.Plan;

/**
 * @author tqy
 * @date 2018年4月17日
 * 
 */
public class PageAndPlanList {
	private int pageCount;	//总页数
	private int index;		//第几页
	List<Plan> list;
	public List<Plan> getList() {
		return list;
	}
	public void setList(List<Plan> list) {
		this.list = list;
	}
	public PageAndPlanList(){
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
		return "PageAndList [pageCount=" + pageCount + ", index=" + index + ", list=" + list + "]";
	}
}
