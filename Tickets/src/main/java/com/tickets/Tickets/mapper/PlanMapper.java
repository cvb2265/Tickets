package com.tickets.Tickets.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.tickets.Tickets.entity.Plan;

@Mapper
@Repository("planMapper")
public interface PlanMapper {
	
	/**
	 * 根据 关键字(name和introduction字段)、时间、精确location、
	 * 精确overdue、精确type 搜索  且分页
	 * 
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	@Select("<script>"
            +"SELECT id, name, starttime, endtime, introduction, cover, "
            +"   location, venueid, overdue, isrecommend, type, scheme  FROM plan"
            + "<if test=\"location != null\">"
            + "    WHERE location = #{location} "
            + "</if>"
            + "<if test=\"overdue != null\">"
            + "    WHERE overdue = #{overdue} "
            + "</if>"
            + "<if test=\"type != null\">"
            + "    WHERE type = #{type} "
            + "</if>"
            + "ORDER BY time DESC LIMIT #{offset} , #{num}"
            + "</script>")
	public List<Plan> findByPage(Map<String, Object> params);
	

}
