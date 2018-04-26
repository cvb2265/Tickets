package com.tickets.Tickets.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tickets.Tickets.entity.Venue;
import com.tickets.Tickets.mapper.VenueMapper;
import com.tickets.Tickets.service.VenueService;

@Service("venueService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class VenueServiceImpl implements VenueService {
	@Autowired
	@Qualifier("venueMapper")
	private VenueMapper venueMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(VenueServiceImpl.class);
	
	
	

	/**
	 * @author tqy
	 * @date 2018年4月21日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public Venue getById(Long venueid) {
		logger.info("getById方法 被调用");
		return venueMapper.findById(venueid);
	}
	
	
	
}
