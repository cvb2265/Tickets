package com.tickets.Tickets.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
	@Select(value = "SELECT * FROM seatprice WHERE planid = #{planid}")
	public List<Seatprice> findByPlanid(@Param("planid")Integer planid);
	
	
}
