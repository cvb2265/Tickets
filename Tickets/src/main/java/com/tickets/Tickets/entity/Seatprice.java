package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Seatprice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer planid;
	private Integer orderid;
	private Integer seatid;
	private Integer venueid;
    private Integer x;//x坐标
    private Integer y;//y坐标
	private double price;
	private boolean avail;
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
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
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getSeatid() {
		return seatid;
	}
	public void setSeatid(Integer seatid) {
		this.seatid = seatid;
	}
	public Integer getVenueid() {
		return venueid;
	}
	public void setVenueid(Integer venueid) {
		this.venueid = venueid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvail() {
		return avail;
	}
	public void setAvail(boolean avail) {
		this.avail = avail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
