package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Seatprice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long planid;
	private Long orderid;
	private Long seatid;
	private Long venueid;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPlanid() {
		return planid;
	}
	public void setPlanid(Long planid) {
		this.planid = planid;
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public Long getSeatid() {
		return seatid;
	}
	public void setSeatid(Long seatid) {
		this.seatid = seatid;
	}
	public Long getVenueid() {
		return venueid;
	}
	public void setVenueid(Long venueid) {
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
