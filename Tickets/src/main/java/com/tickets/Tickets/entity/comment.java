package com.tickets.Tickets.entity;

import java.io.Serializable;

public class comment implements Serializable{
    private static final long serialVersionUID = -7398187628098509372L;
    private int id;
    private int planid;// 所属演出id
    private int userid;// 评论者id
    private int parentid;// 母评论id（第一级评论默认设置为0）
    private String comment_time;// 评论时间,暂时用String表示事后需要改变
    private String content ;//评论内容
    private int rate;// 星级
    private int type;// 类型（预期为0，评论为1）
    private int deleteflag;// 删除标志（删除为1，未删除为0）

    public comment(int id, int planid, int userid, int parentid, String comment_time, String content, int rate, int type, int deleteflag) {
        this.id = id;
        this.planid = planid;
        this.userid = userid;
        this.parentid = parentid;
        this.comment_time = comment_time;
        this.content = content;
        this.rate = rate;
        this.type = type;
        this.deleteflag = deleteflag;
    }

    public comment(int planid, int userid, int parentid, String comment_time, String content, int rate, int type, int deleteflag) {
        this.planid = planid;
        this.userid = userid;
        this.parentid = parentid;
        this.comment_time = comment_time;
        this.content = content;
        this.rate = rate;
        this.type = type;
        this.deleteflag = deleteflag;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(int deleteflag) {
        this.deleteflag = deleteflag;
    }
}
