package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Promulgator implements Serializable {
    private static final long serialVersionUID = -2949672680438152783L;
    private Integer id;
    private String email;
    private String password;
    private String name;
    private int balance;
    private int power; //是否有管理员权限
    private String head;//头像

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Promulgator() {
    }

    public Promulgator(int id, String email, String password, String name, int balance, int power, String head) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.balance = balance;
        this.power = power;
        this.head = head;
    }

    public Promulgator(String email, String password, String name, int balance, int power, String head) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.balance = balance;
        this.power = power;
        this.head = head;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
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
