package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.entity.Promulgator;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

//cf
@Mapper //可以让spring扫描并纳入spring管理  也可以在config的类上添加另一个注解完成工作  @MapperScan
public interface PromulgatorMapper {
	public Promulgator find(String email,String password);
    public Promulgator proById(int proId);
    public Promulgator proByName(String name);
    public ArrayList<Plan> allPlan(int id);
    public Plan findPlanByID(int id);
}
