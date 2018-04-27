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
	
	@Select(value = "SElECT id FROM promulgator WHERE email = #{email} AND password = #{password}")
	public Long findProID(@Param("email")String email,@Param("password")String password);
}
