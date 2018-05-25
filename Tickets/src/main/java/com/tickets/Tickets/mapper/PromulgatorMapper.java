package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Goods;
import com.tickets.Tickets.entity.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.tickets.Tickets.entity.Promulgator;

import java.util.ArrayList;

//cf
@Mapper //可以让spring扫描并纳入spring管理  也可以在config的类上添加另一个注解完成工作  @MapperScan
@Repository("promulgatorMapper")
public interface PromulgatorMapper {
	
	@Select(value = "SElECT id FROM promulgator WHERE email = #{email} AND password = #{password}")
	public Long findProID(@Param("email")String email,@Param("password")String password);
	
	
	/**
	 * 
	 * @author tqy
	 * @date 2018年5月4日
	 * 
	 */
	@Select(value = "SELECT * FROM promulgator WHERE id = #{promulgatorid}")
	public Promulgator findById(@Param("promulgatorid")Long promulgatorid);
	/**
	 * 
	 * @author tqy
	 * @date 2018年5月4日
	 * 
	 */
	@Update(value = "UPDATE promulgator SET password=#{password}, name=#{name}, \n" + 
			"money=#{money}, power=#{power}, `head`=#{head}\n" + 
			"WHERE id = #{id}")
	public Integer update(Promulgator promulgator);

	ArrayList<Plan> allPlan(int id);

	Plan findPlanByID(int planid);

	void WritePlan(Plan plan);

	void WriteGoods(ArrayList<Goods> allgoods);

	//cf
	void addPro(Promulgator promulgator);




}
