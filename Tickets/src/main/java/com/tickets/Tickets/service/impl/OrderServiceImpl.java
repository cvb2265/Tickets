package com.tickets.Tickets.service.impl;

import com.tickets.Tickets.entity.User;
import com.tickets.Tickets.mapper.OrderMapper;
import com.tickets.Tickets.mapper.UserMapper;
import com.tickets.Tickets.service.OrderService;
import com.tickets.Tickets.service.UserService;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tqy
 * @date 2018年4月21日
 * 
 */
//加入事务管理
@Service("orderService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	@Qualifier("orderMapper")
	private OrderMapper orderMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(OrderServiceImpl.class);
	


}
