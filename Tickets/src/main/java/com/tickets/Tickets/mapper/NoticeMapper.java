package com.tickets.Tickets.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.tickets.Tickets.entity.Notice;
import com.tickets.Tickets.entity.User;


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
            +"    AND `read` = #{read} "
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
            +"    AND `read` = #{read} "
            +"</if>"
            + "</where>"
            + "</script>")
	public Long noticecount(Map<String, Object> params);
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年5月2日
	 * 
	 */
	@Insert(value = "INSERT INTO notice(`userid`,`time`,`title`,`content`,`read`)\n" + 
			"VALUES (#{userid}, #{time}, #{title}, #{content}, #{read})")
	public Integer save(Notice notice);
	
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年5月3日
	 * 
	 */
	@Select(value = "SELECT * FROM notice WHERE id = #{noticeid}")
	public Notice findById(@Param("noticeid")Long noticeid);
	
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年5月3日
	 * 
	 */
	@Update(value = "UPDATE notice SET userid=#{userid}, time=#{time}, \n" + 
			"title=#{title}, content=#{content}, `read`=#{read}\n" + 
			"WHERE id = #{id}")
	public Integer update(Notice notice);
	
	
	/**
	 * 批量删除notice
	 * collection处根据报错信息只能填param2，不能填noticeidlist
	 * @author tqy
	 * @date 2018年5月3日
	 * 
	 */
	@Delete("<script>"
            +"DELETE FROM notice WHERE userid=#{userid} AND id IN"
            +"<foreach collection=\"param2\" item=\"noticeid\" \n" + 
            "            open=\"(\" close=\")\" separator=\",\">\n" + 
            "            #{noticeid}\n" + 
            "</foreach>"
            + "</script>")
	public Integer del(@Param("userid")Long userid, List<Long> noticeidlist);

}
