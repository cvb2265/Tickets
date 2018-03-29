package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int planid;
	private int price;
	private int orederid;
	public Goods(int id, int planid, int price, int orederid) {
		super();
		this.id = id;
		this.planid = planid;
		this.price = price;
		this.orederid = orederid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlanid() {
		return planid;
	}
	public void setPlanid(int planid) {
		this.planid = planid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrederid() {
		return orederid;
	}
	public void setOrederid(int orederid) {
		this.orederid = orederid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
