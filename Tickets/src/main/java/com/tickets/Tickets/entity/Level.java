package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Level implements Serializable {
    private static final long serialVersionUID = -1073531577986198577L;
    private int id;
    private int level;// 当前等级
    private int maxxp ;//当前等级升级所需经验
    private double discount ;//当前等级享受的折扣

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Level(int id, int level, int maxxp, double discount) {
        this.id = id;
        this.level = level;
        this.maxxp = maxxp;
        this.discount = discount;
    }

    public Level(int level, int maxxp, double discount) {
        this.level = level;
        this.maxxp = maxxp;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxxp() {
        return maxxp;
    }

    public void setMaxxp(int maxxp) {
        this.maxxp = maxxp;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
