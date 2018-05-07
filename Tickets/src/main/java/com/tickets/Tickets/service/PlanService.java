package com.tickets.Tickets.service;

import java.util.List;

import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.util.Page;
import com.tickets.Tickets.util.ResultMessage;

public interface PlanService {
	
	
	/**
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	public List<Plan> getPlans(Long pageSize, Long index, Page page, String keyword, String day1, String day2,
			String location, String overdue, String isrecommend, String type, String sort_strategy, String state);

	/**
	 * @author tqy
	 * @date 2018年4月21日
	 * 
	 */
	public Plan getById(Long planid);

	/**
	 * @author cf
	 * @date 2018年5月7日
	 *
	 */
	public List<Plan> getPendingPlans();

	/**
	 * @author cf
	 * @date 2018年5月7日
	 *
	 */
	public ResultMessage checkPlan(long planid,Plan plan);
}
