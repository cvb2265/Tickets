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
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(plan.getStarttime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(util.IstimeLegal(date))
			return true;
		else
			return false;
	}

	@Override
	public boolean setseatprice(Venue venue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createGoodsPlan(ArrayList<Goods> allgoods) {
		// TODO Auto-generated method stub

	}

	@Override
	public void uploadfile(String filename) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		return false;
	}

}
