package com.tickets.Tickets.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.tickets.Tickets.entity.Plan;

@Mapper
@Repository("planMapper")
public interface PlanMapper {
	
	
	
	
	/**
	 * 根据 关键字(name和introduction字段)、时间、精确location、
	 * 精确overdue、精确isrecommend、精确type 动态查询记录总数
	 * SELECT COUNT(*) FROM plan
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	@Select(value = "SELECT COUNT(id) FROM plan")
	public Integer plancount(Map<String, Object> params);
	
	
	/**
	 * 根据 关键字(name和introduction字段)、时间、精确location、
	 * 精确overdue、精确isrecommend、精确type 搜索  且分页
	 * 
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	@Select("<script>"
            +"SELECT id, name, starttime, endtime, introduction, cover, location, venueid, overdue, isrecommend, type, scheme  FROM plan "
            +"WHERE overdue = #{overdue} AND isrecommend = #{isrecommend}"
            +"<if test=\"location != null\">"
            +"    AND location = #{location} "
            +"</if>"
            + "<if test=\"type != null\">"
            + "    AND type = #{type} "
            + "</if>"
            + "<if test=\"day1 != null\">"
            + "    AND starttime BETWEEN #{day1} AND #{day2} "
            + "</if>"
            + "<choose>"
            + "    <when test=\"sort_strategy != null and 'DESC' == sort_strategy\">"
            + "        ORDER BY starttime DESC "
            + "    </when>"
            + "    <otherwise>"
            + "        ORDER BY starttime ASC "
            + "    </otherwise>"
            + "</choose>"
            + "LIMIT #{offset} , #{num}"
            + "</script>")
	//@Select(value = "SELECT id, name, starttime, endtime, introduction, cover, location, venueid, overdue, isrecommend, type, scheme  FROM plan")
	public List<Plan> findByPage(Map<String, Object> params);
	//还差keyword   day1  day2

}
