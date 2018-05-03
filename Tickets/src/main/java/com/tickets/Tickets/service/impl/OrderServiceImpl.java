package com.tickets.Tickets.service.impl;

import com.tickets.Tickets.entity.Order;
import com.tickets.Tickets.mapper.OrderMapper;
import com.tickets.Tickets.service.OrderService;
import com.tickets.Tickets.util.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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


	@Transactional(readOnly=true)
	@Override
	public List<Order> getOrderByUserid(Long pageSize, Long index, Page page, Long userid, String state) {
		logger.info("getGoodsByPlanid方法 被调用");
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		Map<String,Object> params2 = new HashMap<>();
		params.put("userid", userid);
		params2.put("userid", userid);
		if(state!=null&&!"".equals(state)) {params.put("state", state);params2.put("state", state);}
		long recordCount = orderMapper.ordercount(params);
		page.setRecordCount(recordCount);
		long pageCount = recordCount/pageSize;
		if(recordCount==0){
			return null;
		}else{
			if(recordCount%pageSize!=0){
				pageCount++;
			}
		}
		if(index<1||index>pageCount){
			return null;
		}
		
		
		

		long offset=(index-1)*pageSize;
		params2.put("offset", offset);
		
		long num=pageSize;
		if(index==pageCount){//最后一页
			num=recordCount-(pageCount-1)*pageSize;
		}
		params2.put("num", num);
		
		List<Order> list = orderMapper.findOrderByPage(params2);
		
		//由函数副作用返回page给调用者使用
		page.setIndex(index);
		page.setPageCount(pageCount);
		return list;
	}

	@Transactional(readOnly=true)
	@Override
	public Order getById(Long orderid) {
		logger.info("getById方法 被调用");
		return orderMapper.findByOrderid(orderid);
	}
	


}
