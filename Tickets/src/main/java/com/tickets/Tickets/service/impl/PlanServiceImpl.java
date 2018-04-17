package com.tickets.Tickets.service.impl;

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

import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.mapper.PlanMapper;
import com.tickets.Tickets.service.PlanService;
import com.tickets.Tickets.util.Page;

@Service("planService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class PlanServiceImpl implements PlanService {
	@Autowired
	@Qualifier("planMapper")
	private PlanMapper planMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(PlanServiceImpl.class);
	
	
	
	

	/**
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Plan> getPlans(int pageSize, int index, Page page, String keyword, String day1,
			String day2, String location, boolean overdue, boolean isrecommend, String type, String sort_strategy) {
		logger.info("getplans方法 被调用，aaaaaaaaaaaaaaaaaaaaaa");
		
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		int recordCount = planMapper.plancount(params);
		logger.info("getplans方法 被调用，aaaaaaaaaaaaaaaaaaaaaa"+recordCount);
		int pageCount = recordCount/pageSize;
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
		

		Map<String,Object> params2 = new HashMap<>();

		int offset=(index-1)*pageSize;
		params2.put("offset", offset);
		
		int num=pageSize;
		if(index==pageCount){//最后一页
			num=recordCount-(pageCount-1)*pageSize;
		}
		params2.put("num", num);

		if(keyword!=null&&!"".equals(keyword)) {params2.put("keyword", keyword);}
		if(day1!=null&&!"".equals(day1)) {params2.put("day1", day1);params2.put("day2", day2);}
		if(location!=null&&!"".equals(location)) {params2.put("location", location);}
		params2.put("overdue", overdue);
		params2.put("isrecommend", isrecommend);
		if(type!=null&&!"".equals(type)) {params2.put("type", type);}
		params2.put("sort_strategy", sort_strategy);
		
		
		List<Plan> list = planMapper.findByPage(params2);
		
		//由函数副作用返回page给调用者使用
		page.setIndex(index);
		page.setPageCount(pageCount);
		return list;
	}
	
	
	
}
