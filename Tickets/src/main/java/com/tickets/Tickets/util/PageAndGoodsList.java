package com.tickets.Tickets.util;

import java.util.List;

import com.tickets.Tickets.entity.Goods;

/**
 * @author tqy
 * @date 2018年4月25日
 * 
 */
public class PageAndGoodsList {
	private Long recordCount;	//总记录数
	private Long pageCount;	//总页数
	private Long index;		//第几页
	List<Goods> list;
	public PageAndGoodsList(){
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
	public List<Goods> getList() {
		return list;
	}
	public void setList(List<Goods> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageAndPlanList [recordCount=" + recordCount + ", pageCount=" + pageCount + ", index=" + index
				+ ", list=" + list + "]";
	}
}
