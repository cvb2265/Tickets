package com.tickets.Tickets.entity;

import java.io.Serializable;

/**
 * @author tqy
 * @date 2018年3月23日
 * 
 */
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer orderid;
	private Integer userid;
	private String time;//暂时用String
	private double money;
	private Integer points_cost;
	private double perc;
	private double rmoney;
	private String state;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Integer getPoints_cost() {
		return points_cost;
	}
	public void setPoints_cost(Integer points_cost) {
		this.points_cost = points_cost;
	}
	public double getPerc() {
		return perc;
	}
	public void setPerc(double perc) {
		this.perc = perc;
	}
	public double getRmoney() {
		return rmoney;
	}
	public void setRmoney(double rmoney) {
		this.rmoney = rmoney;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
