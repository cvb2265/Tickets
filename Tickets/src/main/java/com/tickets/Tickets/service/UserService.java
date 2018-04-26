package com.tickets.Tickets.service;

import com.tickets.Tickets.entity.User;
import com.tickets.Tickets.util.ResultMessage;

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
	public boolean activationAccount(Long userid);
	
	//预订座位，需要同步synchronized
	public ResultMessage createOrder(Long userid, String spids, Integer points_cost);
	
}
