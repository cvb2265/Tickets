package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Seat implements Serializable {
    private static final long serialVersionUID = -555631526669909845L;
    private Integer id;
    private Integer venueid;//所属场馆id
    private Integer x;//x坐标
    private Integer y;//y坐标

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Seat() {
    }

    public Seat(int id, int venueid, int x, int y) {
        this.id = id;
        this.venueid = venueid;
        this.x = x;
        this.y = y;
    }

    public Seat(int venueid, int x, int y) {
        this.venueid = venueid;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVenueid() {
        return venueid;
    }

    public void setVenueid(int venueid) {
        this.venueid = venueid;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
