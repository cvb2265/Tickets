package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Notice implements Serializable {
    private static final long serialVersionUID = 7910358669326408211L;
    private int id;
    private int targetid;// 接收消息的购票者id
    private int orderid;//被取消的订单id

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Notice() {
    }

    public Notice(int id, int targetid, int orderid) {
        this.id = id;
        this.targetid = targetid;
        this.orderid = orderid;
    }

    public Notice(int targetid, int orderid) {
        this.targetid = targetid;
        this.orderid = orderid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTargetid() {
        return targetid;
    }

    public void setTargetid(int targetid) {
        this.targetid = targetid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
}
