package com.tickets.Tickets.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.tickets.Tickets.entity.Goods;
import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.entity.Venue;
import com.tickets.Tickets.mapper.PromulgatorMapper;
import com.tickets.Tickets.service.Promulgator;
import com.tickets.Tickets.util.CheckLegal;

public class PromulatorServiceImpl implements Promulgator {

	private PromulgatorMapper promulatorMapper;
	private CheckLegal util;
	@Override
	public boolean login(String email, String password) {
		if(promulatorMapper.find(email, password)!=null)
			return true;
		else
			return false;
	}

	@Override
	public ArrayList<Plan> allPlan(int id) {
		return promulatorMapper.allPlan(id);
	}

	@Override
	public Plan showdetail(int planid) {
		return promulatorMapper.findPlanByID(planid);
	}

	@Override
	public boolean createPlan(Plan plan) {
		Date startdate = new Date();
		Date enddate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			startdate = sdf.parse(plan.getStarttime());
			enddate = sdf.parse(plan.getEndtime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(util.IstimeLegal(startdate)&&util.IstimeLegal(enddate)) {
			promulatorMapper.WritePlan(plan);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean setseatprice(Venue venue) {
		//to do
		return false;
	}

	@Override
	public boolean createGoodsPlan(ArrayList<Goods> allgoods) {
		boolean isLegal = true;
		for(int i=0;i<allgoods.size();i++) {
			if(!util.IspriceIegat(allgoods.get(i).getPrice())) {
				isLegal = false;
				break;
			}
		}
		if(isLegal)
			promulatorMapper.WriteGoods(allgoods);
		return isLegal;
	}	

	@Override
	public void uploadfile(String filename) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Date startdate = new Date();
		Date enddate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			startdate = sdf.parse(plan.getStarttime());
			enddate = sdf.parse(plan.getEndtime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(util.IstimeLegal(startdate)&&util.IstimeLegal(enddate)) {
			promulatorMapper.WritePlan(plan);
			return true;
		}
		else
			return false;
	}
	

}
