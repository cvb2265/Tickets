package com.tickets.Tickets.service;

import com.tickets.Tickets.entity.tqy.User;

/**
 * @author tqy
 * @date 2018年3月23日
 * 
 */
public interface UserService {
	
	//登录
	public User login(String email, String password);
	
	
	public boolean checkEmail(String email);
	
}
