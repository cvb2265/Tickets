package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Level implements Serializable {
    private static final long serialVersionUID = -1073531577986198577L;
    private Long id;
    private Integer level_num;// 当前等级
    private Integer maxexp;//当前等级升级所需经验
    private double discount;//当前等级享受的折扣

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Level() {
    }

    public Level(Long id, int level_num, int maxexp, double discount) {
        this.id = id;
        this.level_num = level_num;
        this.maxexp = maxexp;
        this.discount = discount;
    }

    public Level(int level_num, int maxexp, double discount) {
        this.level_num = level_num;
        this.maxexp = maxexp;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel_num() {
        return level_num;
    }

    public void setLevel_num(int level_num) {
        this.level_num = level_num;
    }

    public int getMaxexp() {
        return maxexp;
    }

    public void setMaxexp(int maxexp) {
        this.maxexp = maxexp;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
