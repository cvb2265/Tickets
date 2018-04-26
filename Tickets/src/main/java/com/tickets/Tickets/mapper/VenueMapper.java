package com.tickets.Tickets.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.tickets.Tickets.entity.Venue;


@Mapper
@Repository("venueMapper")
public interface VenueMapper {
	
	/**
	 * @author tqy
	 * @date 2018年4月21日
	 * 
	 */
	@Select(value = "SELECT * FROM venue WHERE id = #{venueid}")
	public Venue findById(@Param("venueid")Long venueid);

}
