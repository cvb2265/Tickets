package com.tickets.Tickets.service;

import java.util.ArrayList;

import com.tickets.Tickets.entity.Goods;
import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.entity.Venue;

public interface Promulgator {
	//发布者登陆
	public boolean login(String email,String password );
	//往期音乐会清单
	public ArrayList<Plan> allPlan(int id);
	//查看一场音乐会详细内容
	public Plan showdetail(int planid);
	//制定音乐会策划
	public boolean createPlan(Plan plan);
	//设置场馆座位信息
	public boolean setseatprice(Venue venue);
	//制定周边产品策划
	public void createGoodsPlan(ArrayList<Goods> allgoods);
	//上传策划文档
	public void uploadfile(String filename);
	//修改未通过的音乐会信息
	public boolean updatePlan(Plan plan);
}
