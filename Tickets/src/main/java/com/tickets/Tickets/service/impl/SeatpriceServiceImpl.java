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

import com.tickets.Tickets.entity.Seatprice;
import com.tickets.Tickets.mapper.SeatpriceMapper;
import com.tickets.Tickets.service.SeatpriceService;


@Service("seatpriceService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class SeatpriceServiceImpl implements SeatpriceService {
	@Autowired
	@Qualifier("seatpriceMapper")
	private SeatpriceMapper seatpriceMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(SeatpriceServiceImpl.class);
	
	
	
	

	/**
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Seatprice> getByPlanid(Long planid) {
		logger.info("getByPlanid方法 被调用");
		return seatpriceMapper.findByPlanid(planid);
	}





	/**
	 * @author tqy
	 * @date 2018年4月23日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public Seatprice getById(Long id) {
		logger.info("getById方法 被调用");
		return seatpriceMapper.findById(id);
	}
	
	
	
}
