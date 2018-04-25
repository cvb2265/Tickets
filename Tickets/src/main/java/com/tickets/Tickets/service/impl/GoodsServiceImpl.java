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

import com.tickets.Tickets.entity.Goods;
import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.mapper.GoodsMapper;
import com.tickets.Tickets.mapper.PlanMapper;
import com.tickets.Tickets.service.GoodsService;
import com.tickets.Tickets.service.PlanService;
import com.tickets.Tickets.util.Page;

@Service("goodsService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	@Qualifier("goodsMapper")
	private GoodsMapper goodsMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(GoodsServiceImpl.class);
	



	/**
	 * @author tqy
	 * @date 2018年4月25日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Goods> getGoodsByPlanid(int pageSize, int index, Page page, int planid) {
		logger.info("getGoodsByPlanid方法 被调用");
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("planid", planid);
		int recordCount = goodsMapper.goodscount(params);
		page.setRecordCount(recordCount);
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
		params2.put("planid", planid);
		
		List<Goods> list = goodsMapper.findGoodsByPage(params2);
		
		//由函数副作用返回page给调用者使用
		page.setIndex(index);
		page.setPageCount(pageCount);
		return list;
	}
	
	
	
}
