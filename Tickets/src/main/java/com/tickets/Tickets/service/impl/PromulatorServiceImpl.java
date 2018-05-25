package com.tickets.Tickets.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tickets.Tickets.entity.*;
import com.tickets.Tickets.service.PromulgatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tickets.Tickets.mapper.PromulgatorMapper;
import com.tickets.Tickets.util.CheckLegal;

@Service("promulatorService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class PromulatorServiceImpl implements PromulgatorService {
	@Autowired
	@Qualifier("promulgatorMapper")
	private PromulgatorMapper promulatorMapper;
	
	private CheckLegal util;
	@Override
	public boolean login(String email, String password) {
		if(promulatorMapper.findProID(email, password)!=null)
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
		if(util.IstimeLegal(startdate,enddate)) {
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
		if(util.IstimeLegal(startdate,enddate)) {
			promulatorMapper.WritePlan(plan);
			return true;
		}
		else
			return false;
	}
//cf
	@Override
	public void addPro(Promulgator promulgator) {
		promulatorMapper.addPro(promulgator);
	}

	@Override
	public Promulgator getPromulgatorDetailById(long promulgatorId) {
		return null;
	}

	@Override
	public void updatePro(Promulgator promulgator) {

	}

	@Override
	public void delPro(long promulgatorId) {

	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public List<Promulgator> ListPros(PageDto pageDto) {
		return null;
	}


}
