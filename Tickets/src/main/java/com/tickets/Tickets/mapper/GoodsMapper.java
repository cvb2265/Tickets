package com.tickets.Tickets.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.tickets.Tickets.entity.Goods;

@Mapper
@Repository("goodsMapper")
public interface GoodsMapper {
	
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年4月25日
	 * 
	 */
	@Select(value = "SELECT * FROM goods "
            +"WHERE planid = #{planid} LIMIT #{offset} , #{num}")
	public List<Goods> findGoodsByPage(Map<String, Object> params);
	
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年4月25日
	 * 
	 */
	@Select(value = "SELECT COUNT(id) FROM goods WHERE planid = #{planid}")
	public Long goodscount(Map<String, Object> params);

}
