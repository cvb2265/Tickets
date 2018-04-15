package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer planid;
	private double price;
	private Integer orederid;
	public Goods(int id, int planid, int price, int orederid) {
		super();
		this.id = id;
		this.planid = planid;
		this.price = price;
		this.orederid = orederid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPlanid() {
		return planid;
	}
	public void setPlanid(Integer planid) {
		this.planid = planid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getOrederid() {
		return orederid;
	}
	public void setOrederid(Integer orederid) {
		this.orederid = orederid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
