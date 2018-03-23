package com.tickets.Tickets.service;

import com.tickets.Tickets.entity.User;

public interface UserService {
	
	//登录
	public User login(String email, String password);
	
}
