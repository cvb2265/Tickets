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
	
}
