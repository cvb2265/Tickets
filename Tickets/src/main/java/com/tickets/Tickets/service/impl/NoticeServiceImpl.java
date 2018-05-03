package com.tickets.Tickets.service.impl;

import java.util.ArrayList;
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

import com.tickets.Tickets.entity.Notice;
import com.tickets.Tickets.mapper.NoticeMapper;
import com.tickets.Tickets.service.NoticeService;
import com.tickets.Tickets.util.Page;

@Service("noticeService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	@Qualifier("noticeMapper")
	private NoticeMapper noticeMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(NoticeServiceImpl.class);
	



	/**
	 * @author tqy
	 * @date 2018年4月26日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Notice> getNoticeByUserid(Long pageSize, Long index, Page page, Long userid, String read) {
		logger.info("getNoticeByUserid方法 被调用");
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		Map<String,Object> params2 = new HashMap<>();
		params.put("userid", userid);
		params2.put("userid", userid);
		if(read!=null&&!"".equals(read)) {
			if(read.equals("true")) {
				params.put("read", true);
				params2.put("read", true);
			}else {
				params.put("read", false);
				params2.put("read", false);
			}
		}
		long recordCount = noticeMapper.noticecount(params);
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
		
		List<Notice> list = noticeMapper.findNoticeByPage(params2);
		
		//由函数副作用返回page给调用者使用
		page.setIndex(index);
		page.setPageCount(pageCount);
		return list;
	}




	/**
	 * @author tqy
	 * @date 2018年5月2日
	 * 
	 */
	@Transactional(readOnly=true)
	@Override
	public Long getNoticeCountByUserid(Long userid, String read) {
		logger.info("getNoticeCountByUserid方法 被调用");
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("userid", userid);
		if(read!=null&&!"".equals(read)) {
			if(read.equals("true")) {
				params.put("read", true);
			}else {
				params.put("read", false);
			}
		}
		long recordCount = noticeMapper.noticecount(params);
		return recordCount;
	}




	/**
	 * 获取notice，并且设为已读
	 * @author tqy
	 * @date 2018年5月3日
	 * 
	 */
	@Override
	public Notice getAndReadNoticeById(Long noticeid) {
		logger.info("getById方法 被调用");
		Notice notice = noticeMapper.findById(noticeid);
		if(!notice.isRead()) {
			notice.setRead(true);
			noticeMapper.update(notice);
		}
		return notice;
	}




	/**
	 * 批量删除notice
	 * @author tqy
	 * @date 2018年5月3日
	 * 
	 */
	@Override
	public void del(Long userid, String noticeids) {
		logger.info("del方法 被调用");
		List<Long> noticeidlist = new ArrayList<Long>();
		String[] ss = noticeids.split("-");
		for(int i=0;i<ss.length;i++) {
			noticeidlist.add(Long.parseLong(ss[i]));
		}
		noticeMapper.del(userid, noticeidlist);
	}
	
	
	
}
