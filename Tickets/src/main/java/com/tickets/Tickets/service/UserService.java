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

	public User getById(Long userid);
	

	public boolean checkEmail(String email);

	//发送激活邮件
    public boolean sendActivationEmail(String email, String password);
	//激活账户
	public boolean activationAccount(Long userid);
	
	//预订座位，需要同步synchronized
	public ResultMessage createSeatpriceOrder(Long userid, String spids, Integer points_cost);
	
	//预订周边产品，需要同步synchronized
	public ResultMessage createGoodsOrder(Long userid, Long goodsid);

	//支付订单
	public ResultMessage payOrder(Long userid, Long orderid);
	//取消订单
	public ResultMessage cancelOrder(Long userid, Long orderid);
	//退订订单
	public ResultMessage unsubscribeOrder(Long userid, Long orderid);
	
}
