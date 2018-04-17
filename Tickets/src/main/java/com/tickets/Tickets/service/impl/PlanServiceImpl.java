package com.tickets.Tickets.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.mapper.UserMapper;
import com.tickets.Tickets.service.PlanService;

@Service("planService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class PlanServiceImpl implements PlanService {
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(PlanServiceImpl.class);
	
	
	
	

	/**
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Plan> getplans(String email, String password) {
		logger.info("getplans方法 被调用，用户邮箱是"+email);
		return null;
	}
	
	
	
}
