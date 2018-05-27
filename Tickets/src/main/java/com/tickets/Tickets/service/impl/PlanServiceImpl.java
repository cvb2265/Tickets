package com.tickets.Tickets.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.mapper.NoticeMapper;
import com.tickets.Tickets.util.ResultMessage;
import com.tickets.Tickets.vo.PlanVo;
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

	@Autowired
	@Qualifier("noticeMapper")
	private NoticeMapper noticeMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(PlanServiceImpl.class);
	
	
	
	

	/**
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Plan> getPlans(Long pageSize, Long index, Page page, String keyword, String day1,
			String day2, String location, String overdue, String isrecommend, String type, String sort_strategy, String state) {
		logger.info("getplans方法 被调用");
		
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		Map<String,Object> params2 = new HashMap<>();
		if(state!=null&&!"".equals(state)) {params.put("state", state);params2.put("state", state);}
		if(keyword!=null&&!"".equals(keyword)) {params.put("keyword", keyword);params2.put("keyword", keyword);}
		if(day1!=null&&!"".equals(day1)) {params.put("day1", day1);params.put("day2", day2);params2.put("day1", day1);params2.put("day2", day2);}
		if(location!=null&&!"".equals(location)) {params.put("location", location);params2.put("location", location);}
		//是否过期可以选择全部
		if(overdue!=null&&!"".equals(overdue)) {
			if(overdue.equals("true")) {
				params.put("overdue", true);
				params2.put("overdue", true);
			}else {
				params.put("overdue", false);
				params2.put("overdue", false);
			}
		}
		//是否推荐可以选择全部
		if(isrecommend!=null&&!"".equals(isrecommend)) {
			if(isrecommend.equals("true")) {
				params.put("isrecommend", true);
				params2.put("isrecommend", true);
			}else {
				params.put("isrecommend", false);
				params2.put("isrecommend", false);
			}
		}
		if(type!=null&&!"".equals(type)) {params.put("type", type);params2.put("type", type);}
		
		
		
		long recordCount = planMapper.plancount(params);
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
		params2.put("sort_strategy", sort_strategy);
		
		
		List<Plan> list = planMapper.findByPage(params2);
		
		//由函数副作用返回page给调用者使用
		page.setIndex(index);
		page.setPageCount(pageCount);
		return list;
	}





	/**
	 * @author tqy
	 * @date 2018年4月21日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public Plan getById(Long planid) {
		logger.info("getById方法 被调用");
		return planMapper.findById(planid);
	}

	@Override
	public PlanVo getPlanVoById(Long planid) {
		return planMapper.PlanVoById(planid);
	}


	/**
	 * @author cf
	 * @date 2018年5月7日
	 *
	 */

	@Override
	public ResultMessage checkPlan(long planid,Plan plan) {
		logger.info("checkPlan方法 被调用");
		ResultMessage rm =new ResultMessage();
		//审核订单
		planMapper.updateState(plan);
		rm.setResult(true);
		rm.setMessage("审核完成，审核结果已经被记录");
		//将结果发送通知给后台用户
		//TODO
		return rm;
	}
	@Transactional(readOnly=true)
	@Override
	public Integer countAll() {
		return planMapper.countAll();
	}
	@Transactional(readOnly=true)
	@Override
	public Integer countState(String state) {
		return planMapper.countState(state);
	}
	@Transactional(readOnly=true)
	@Override
	public List<PlanVo> getPlansByState(PageDto pageDto, String state) {
		return planMapper.findPlansByState(pageDto,state);
	}
	@Transactional(readOnly=true)
	@Override
	public List<PlanVo> getAllPlans(PageDto pageDto) {
		return planMapper.getAllPlans(pageDto);
	}
}
