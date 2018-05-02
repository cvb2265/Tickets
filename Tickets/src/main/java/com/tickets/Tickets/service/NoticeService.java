package com.tickets.Tickets.service;

import java.util.List;

import com.tickets.Tickets.entity.Notice;
import com.tickets.Tickets.util.Page;

public interface NoticeService {
	
	
	/**
	 * @author tqy
	 * @date 2018年4月26日
	 * 
	 */
	public List<Notice> getNoticeByUserid(Long pageSize, Long index, Page page, Long userid, String read);

	
	/**
	 * @author tqy
	 * @date 2018年5月2日
	 * 
	 */
	public Long getNoticeCountByUserid(Long userid, String read);


	
	
}
