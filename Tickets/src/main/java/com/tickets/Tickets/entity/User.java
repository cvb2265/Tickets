package com.tickets.Tickets.entity;

import java.io.Serializable;

/**
 * @author tqy
 * @date 2018年3月23日
 * 
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userid;
	private String email;
	private String password;
	private String nickename;
	private String interest;
	private String face;
	private Integer level;
	private Integer exp;
	private Integer points;
	private double money;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickename() {
		return nickename;
	}
	public void setNickename(String nickename) {
		this.nickename = nickename;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getExp() {
		return exp;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
