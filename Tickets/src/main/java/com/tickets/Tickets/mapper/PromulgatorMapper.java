package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Goods;
import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.entity.Promulgator;

import groovy.transform.PackageScope;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//cf
@Mapper //可以让spring扫描并纳入spring管理  也可以在config的类上添加另一个注解完成工作  @MapperScan
@Repository("promulgatorMapper")
public interface PromulgatorMapper {
	
	@Select(value = "SElECT id FROM Promulgator WHERE email = #{email} AND password = #{password}")
	public String findProID(@Param("email")String email,@Param("password")String password);
	
	@Select(value = "SELECT * FROM Promulgator WHERE proId = #{proId}")
    public Promulgator proById(@Param("proId")int proId);
	
	@Select(value = "SELECT * FROM Promulgator WHERE name = #{name}")
    public Promulgator proByName(@Param("name")String name);
	
	@Select(value = "SELECT * FROM Plan WHERE id = #{id} LIMIT #{offset} , #{num}")
    public ArrayList<Plan> allPlan(@Param("id")int id);
	
	@Select(value = "SELECT * FROM Plan WHERE id = #{id}")
    public Plan findPlanByID(@Param("id")int id);
	
	@Insert(value = "INSERT INTO Plan(name, starttime, endtime, introduction, cover, location, venueid, overdue, isrecommend,type,scheme)\n" + 
			"VALUES (#{name}, #{starttime}, #{endtime}, #{introduction}, #{cover}, #{location}, #{venueid}, #{overdue}, #{isrecommend},#{type},#{scheme})")
    public void WritePlan(Plan plan);
	
	@Insert(value = "INSERT INTO Goods(planid, goodsname, introduction, pic, price, orderid)\n" + 
			"VALUES (#{planid}, #{goodsname}, #{introduction}, #{pic}, #{price}, #{orderid})")
    public void WriteGoods(ArrayList<Goods> goods);
}
