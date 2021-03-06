package com.tickets.Tickets.service;

import java.util.List;

import com.tickets.Tickets.entity.Seatprice;

public interface SeatpriceService {

	
	/**
	 * @author tqy
	 * @date 2018年4月21日
	 * 
	 */
	public List<Seatprice> getByPlanid(Long planid);
	
	/**
	 * @author tqy
	 * @date 2018年5月3日
	 * 
	 */
	public List<Seatprice> getByOrderid(Long orderid);
	
	/**
	 * @author tqy
	 * @date 2018年4月23日
	 * 
	 */
	public Seatprice getById(Long id);
	
	
}
