package com.tickets.Tickets.service;

import java.util.List;

import com.tickets.Tickets.entity.Goods;
import com.tickets.Tickets.util.Page;

public interface GoodsService {
	
	
	/**
	 * @author tqy
	 * @date 2018年4月25日
	 * 
	 */
	public List<Goods> getGoodsByPlanid(Long pageSize, Long index, Page page, Long planid);


	
	
}
