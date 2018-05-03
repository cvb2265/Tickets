package com.tickets.Tickets.service;

import java.util.List;

import com.tickets.Tickets.entity.Order;
import com.tickets.Tickets.util.Page;

/**
 * @author tqy
 * @date 2018年4月21日
 * 
 */
public interface OrderService {

	/**
	 * @author tqy
	 * @date 2018年4月21日
	 * 
	 */
	public List<Order> getOrderByUserid(Long pageSize, Long index, Page page, Long userid, String state);
	
	public Order getById(Long orderid);
	
}
