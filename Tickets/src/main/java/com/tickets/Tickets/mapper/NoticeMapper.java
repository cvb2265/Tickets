package com.tickets.Tickets.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.tickets.Tickets.entity.Notice;


@Mapper
@Repository("noticeMapper")
public interface NoticeMapper {
	
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年4月26日
	 * 
	 */
	@Select("<script>"
            +"SELECT * FROM notice "
            +"<where>"
            +"<if test=\"userid != null\">"
            +"    userid = #{userid} "
            +"</if>"
            +"<if test=\"read != null\">"
            +"    AND read = #{read} "
            +"</if>"
            + "</where>"
            + " ORDER BY time DESC "
            + "LIMIT #{offset} , #{num}"
            + "</script>")
	public List<Notice> findNoticeByPage(Map<String, Object> params);
	
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年4月26日
	 * 
	 */
	@Select("<script>"
            +"SELECT COUNT(id) FROM notice "
            +"<where>"
            +"<if test=\"userid != null\">"
            +"    userid = #{userid} "
            +"</if>"
            +"<if test=\"read != null\">"
            +"    AND read = #{read} "
            +"</if>"
            + "</where>"
            + "</script>")
	public Long noticecount(Map<String, Object> params);

}
