package com.tickets.Tickets.service;

import com.tickets.Tickets.entity.User;

/**
 * @author tqy
 * @date 2018年3月23日
 * 
 */
public interface UserService {
	
	//登录
	public User login(String email, String password);
	

	public boolean checkEmail(String email);

	//发送激活邮件
    public boolean sendActivationEmail(String email, String password);
	//激活账户
	public boolean activationAccount(Integer userid);
	
}
