package com.tickets.Tickets.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tickets.Tickets.entity.Level;
import com.tickets.Tickets.mapper.LevelMapper;
import com.tickets.Tickets.service.LevelService;

@Service("levelService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class LevelServiceImpl implements LevelService {
	@Autowired
	private LevelMapper levelMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(LevelServiceImpl.class);
	
	


	

	/**
	 * @author tqy
	 * @date 2018年4月28日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public Level getByLevel_num(Integer level_num) {
		logger.info("getByLevel_num方法 被调用");
		return levelMapper.findByLevel_num(level_num);
	}
	
	
	
}
