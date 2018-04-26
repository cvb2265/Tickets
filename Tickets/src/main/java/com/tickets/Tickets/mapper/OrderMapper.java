package com.tickets.Tickets.mapper;

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

}
