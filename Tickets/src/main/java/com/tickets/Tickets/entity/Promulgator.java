package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Promulgator implements Serializable {
    private static final long serialVersionUID = -2949672680438152783L;
    private Long id;
    private String email;
    private String password;
    private String name;
    private double money;
    private Integer power; //是否有管理员权限
    private String head;//头像

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
