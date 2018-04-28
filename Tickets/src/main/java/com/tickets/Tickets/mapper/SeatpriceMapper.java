package com.tickets.Tickets.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.tickets.Tickets.entity.Seatprice;

@Mapper
@Repository("seatpriceMapper")
public interface SeatpriceMapper {
	
	

	
	/**
	 * 
	 * @author tqy
	 * @date 2018年4月21日
	 * 
	 */
	@Select(value = "SELECT * FROM seatprice WHERE planid = #{planid} ORDER BY x ASC, y ASC")
	public List<Seatprice> findByPlanid(@Param("planid")Long planid);
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年4月23日
	 * 
	 */
	@Select(value = "SELECT * FROM seatprice WHERE id = #{id}")
	public Seatprice findById(@Param("id")Long id);


	/**
	 * 
	 * @author tqy
	 * @date 2018年4月23日
	 * 
	 */
	@Update(value = "UPDATE seatprice SET orderid=#{orderid}, venueid=#{venueid}, \n" + 
			"			x=#{x}, y=#{y}, price=#{price}, avail=#{avail}\n" + 
			"		WHERE planid = #{planid} AND seatid = #{seatid}")
	public void update(Seatprice Seatprice);
	
	
	/**
	 * 查询某一用户在某一音乐会上共预订了几个座位
	 * @author tqy
	 * @date 2018年4月28日
	 * 
	 */
	@Select(value = "SELECT COUNT(id) FROM seatprice WHERE planid=#{planid} "
			+ "AND orderid IN (SELECT orderid FROM order_ WHERE userid = #{userid});")
	public Long getSPCountByPlanidAndUserid(@Param("planid")Long planid, @Param("userid")Long userid);
	
}
