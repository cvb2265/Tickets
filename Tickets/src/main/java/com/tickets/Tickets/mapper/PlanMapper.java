package com.tickets.Tickets.mapper;

import java.util.List;
import java.util.Map;

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
	 * 精确overdue、精确isrecommend、精确type、精确state 动态查询记录总数
	 * SELECT COUNT(*) FROM plan
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	@Select("<script>"
            +"SELECT COUNT(id) FROM plan "
            +"<where>"
            +"<if test=\"overdue != null\">"
            +"    overdue = #{overdue} "
            +"</if>"
            +"<if test=\"isrecommend != null\">"
            +"    AND isrecommend = #{isrecommend} "
            +"</if>"
            +"<if test=\"location != null\">"
            +"    AND location = #{location} "
            +"</if>"
            + "<if test=\"type != null\">"
            + "    AND type = #{type} "
            + "</if>"
            + "<if test=\"state != null\">"
            + "    AND state = #{state} "
            + "</if>"
            + "<if test=\"day1 != null\">"
            + "    AND starttime BETWEEN #{day1} AND #{day2} "
            + "</if>"
            + "<if test=\"keyword != null\">"
            + "    AND name LIKE CONCAT('%',#{keyword},'%') "
            + "</if>"
            + "</where>"
            + "</script>")
	public Long plancount(Map<String, Object> params);
	
	
	/**
	 * 根据 关键字(name和introduction字段)、时间、精确location、
	 * 精确overdue、精确isrecommend、精确type、精确state 搜索  且分页
	 * 
	 * @author tqy
	 * @date 2018年4月17日
	 * 
	 */
	@Select("<script>"
            +"SELECT id, name, starttime, endtime, introduction, cover, location, venueid, overdue, isrecommend, type, scheme  FROM plan "
            +"<where>"
            +"<if test=\"overdue != null\">"
            +"    overdue = #{overdue} "
            +"</if>"
            +"<if test=\"isrecommend != null\">"
            +"    AND isrecommend = #{isrecommend} "
            +"</if>"
            +"<if test=\"location != null\">"
            +"    AND location = #{location} "
            +"</if>"
            + "<if test=\"type != null\">"
            + "    AND type = #{type} "
            + "</if>"
            + "<if test=\"state != null\">"
            + "    AND state = #{state} "
            + "</if>"
            + "<if test=\"day1 != null\">"
            + "    AND starttime BETWEEN #{day1} AND #{day2} "
            + "</if>"
            + "<if test=\"keyword != null\">"
            + "    AND name LIKE CONCAT('%',#{keyword},'%') "
            + "</if>"
            + "</where>"
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
	public List<Plan> findByPage(Map<String, Object> params);
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年4月21日
	 * 
	 */
	@Select(value = "SELECT * FROM plan WHERE id = #{planid}")
	public Plan findById(@Param("planid")Long planid);
	
	
	/**
	 * 寻找未过期的plan
	 * @author tqy
	 * @date 2018年5月5日
	 * 
	 */
	@Select(value = "SELECT * FROM plan WHERE endtime < #{time} AND overdue=0 AND state='pass'")
	public List<Plan> findBeforeAndNotOerdueAndPass(@Param("time")String time);
	
	/**
	 * 设置plan是否过期
	 * @author tqy
	 * @date 2018年5月5日
	 * 
	 */
	@Update(value = "UPDATE plan SET overdue=#{overdue} WHERE id = #{id}")
	public Integer updateOverdue(Plan plan);

	/**
	 * 寻找所有未通过审核的plan，（暂时不管是否过期）
 	* @author cf
 	* @date 2018年5月7日
 	*
 	*/
	 List<Plan> findAllPendingPlans();
	/**
	 * 设置某一个plan的审核状态
	 * @author cf
	 * @date 2018年5月7日
	 *
	 */
	void updateState(Plan plan);
}
