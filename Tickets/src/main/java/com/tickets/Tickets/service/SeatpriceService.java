package com.tickets.Tickets.service;

import java.util.List;

import com.tickets.Tickets.entity.Seatprice;

public interface SeatpriceService {

	
	/**
	 * @author tqy
	 * @date 2018年4月21日
	 * 
	 */
	public List<Seatprice> getByPlanid(int planid);
	
	/**
	 * @author tqy
	 * @date 2018年4月23日
	 * 
	 */
	public Seatprice getById(int id);
	
	
}
