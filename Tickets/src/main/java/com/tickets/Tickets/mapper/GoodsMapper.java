package com.tickets.Tickets.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年4月28日
	 * 
	 */
	@Select(value = "SELECT * FROM goods WHERE id = #{id}")
	public Goods findById(@Param("id")Long id);
	

	/**
	 * 查询某一用户在某一音乐会上共预订了几个周边产品
	 * @author tqy
	 * @date 2018年4月28日
	 * 
	 */
	@Select(value = "SELECT COUNT(id) FROM goods WHERE planid=#{planid} "
			+ "AND orderid IN (SELECT orderid FROM order_ WHERE userid = #{userid});")
	public Long getGoodsCountByPlanidAndUserid(@Param("planid")Long planid, @Param("userid")Long userid);
	
	

	/**
	 * 
	 * @author tqy
	 * @date 2018年4月28日
	 * 
	 */
	@Update(value = "UPDATE goods SET goodsname=#{goodsname}, introduction=#{introduction}, \n" + 
			"			pic=#{pic}, price=#{price}, orderid=#{orderid}\n" + 
			"		WHERE id = #{id} AND planid = #{planid}")
	public void update(Goods goods);

}
