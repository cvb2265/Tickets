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

import com.tickets.Tickets.entity.Level;
import com.tickets.Tickets.entity.Venue;
import com.tickets.Tickets.mapper.VenueMapper;
import com.tickets.Tickets.service.LevelService;
import com.tickets.Tickets.service.VenueService;

@Service("levelService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class LevelServiceImpl implements LevelService {
	@Autowired
	private VenueMapper levelMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(LevelServiceImpl.class);
	
	



	@Override
	public List<Level> getAll() {
		return null;
	}
	
	
	
}
