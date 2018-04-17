package com.tickets.Tickets.service;

import java.util.List;

import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.util.Page;

public interface PlanService {
	
	
	/**
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	public List<Plan> getPlans(int pageSize, int index, Page page, String keyword, String day1, String day2,
			String location, boolean overdue, boolean isrecommend, String type, String sort_strategy);
	
	
}
