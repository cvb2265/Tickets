package com.tickets.Tickets.service.impl;

import com.tickets.Tickets.entity.User;
import com.tickets.Tickets.mapper.UserMapper;
import com.tickets.Tickets.service.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tqy
 * @date 2018年3月23日
 * 
 */
//加入事务管理
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class UserServiceImpl implements UserService {
	@Value("${adminEmailAccount}")
	private String adminEmailAccount;
	@Value("${adminEmailPassword}")
	private String adminEmailPassword;
	@Value("${adminEmailSMTPHost}")
	private String adminEmailSMTPHost;
	
	
	@Autowired
	private UserMapper userMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	
	@Transactional(readOnly=true)
	@Override
	public User login(String email, String password) {
		logger.info("UserService的login方法 被调用，用户邮箱是"+email);
		return userMapper.find(email, password);
	}
	

}
