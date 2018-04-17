package com.tickets.Tickets.service;

import java.util.List;

import com.tickets.Tickets.entity.Plan;

public interface PlanService {
	
	
	/**
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	public List<Plan> getplans(String email, String password);
	
}
