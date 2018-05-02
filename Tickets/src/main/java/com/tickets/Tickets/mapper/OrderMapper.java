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

import com.tickets.Tickets.entity.Order;

/**
 * @author tqy
 * @date 2018年4月21日
 * 
 */
@Mapper
@Repository("orderMapper")
public interface OrderMapper {
	
	@Insert(value = "INSERT INTO order_(userid,time,money,points_cost,perc, rmoney,state)\n" + 
			"VALUES (#{userid}, #{time}, #{money}, #{points_cost}, #{perc}, #{rmoney}, #{state})")
	public Integer save(Order order);	
	
	@Select(value = "SELECT orderid FROM order_ WHERE userid = #{userid} AND time = #{time}")
	public Long getOrderid(@Param("userid")Long userid, @Param("time")String time);

	@Select("<script>"
            +"SELECT * FROM order_ "
            +"<where>"
            +"<if test=\"userid != null\">"
            +"    userid = #{userid} "
            +"</if>"
            +"<if test=\"state != null\">"
            +"    AND state = #{state} "
            +"</if>"
            + "</where>"
            + " ORDER BY time DESC "
            + "LIMIT #{offset} , #{num}"
            + "</script>")
	public List<Order> findOrderByPage(Map<String, Object> params);
	

	@Select("<script>"
            +"SELECT COUNT(orderid) FROM order_ "
            +"<where>"
            +"<if test=\"userid != null\">"
            +"    userid = #{userid} "
            +"</if>"
            +"<if test=\"state != null\">"
            +"    AND state = #{state} "
            +"</if>"
            + "</where>"
            + "</script>")
	public Long ordercount(Map<String, Object> params);
	
	
	
	@Select(value = "SELECT * FROM order_ WHERE orderid = #{orderid}")
	public Order findByOrderid(@Param("orderid")Long orderid);

	@Delete(value = "DELETE FROM order_ WHERE orderid = #{orderid}")
	public void deleteByOrderid(@Param("orderid")Long orderid);

	@Update(value = "UPDATE order_ SET state=#{state}\n" + 
			"		WHERE orderid = #{orderid}")
	public void update(Order order);

}
