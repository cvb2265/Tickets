package com.tickets.Tickets.vo;

import java.io.Serializable;

public class PlanVo implements Serializable {
    private static final long serialVersionUID = 3802655264320281396L;
    private Long id;
    private Long promulgatorid;
    private String name;
    private String starttime;
    private String endtime;
    private String introduction;
    private String cover;
    private String location;
    private Long venueid;
    private boolean overdue;
    private boolean isrecommend;
    private String type;//演唱会类型
    private String scheme;//上传的演唱会策划书路径名
    private String state;//plan状态,pending:等待审核，pass：通过审核，fail：未通过审核

    private String promulgatorname;
    private String venuename;

    public PlanVo() {
    }

    public PlanVo(Long id, Long promulgatorid, String name, String starttime, String endtime, String introduction, String cover, String location, Long venueid, boolean overdue, boolean isrecommend, String type, String scheme, String state, String promulgatorname, String venuename) {
        this.id = id;
        this.promulgatorid = promulgatorid;
        this.name = name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.introduction = introduction;
        this.cover = cover;
        this.location = location;
        this.venueid = venueid;
        this.overdue = overdue;
        this.isrecommend = isrecommend;
        this.type = type;
        this.scheme = scheme;
        this.state = state;
        this.promulgatorname = promulgatorname;
        this.venuename = venuename;
    }

    public PlanVo(Long promulgatorid, String name, String starttime, String endtime, String introduction, String cover, String location, Long venueid, boolean overdue, boolean isrecommend, String type, String scheme, String state, String promulgatorname, String venuename) {
        this.promulgatorid = promulgatorid;
        this.name = name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.introduction = introduction;
        this.cover = cover;
        this.location = location;
        this.venueid = venueid;
        this.overdue = overdue;
        this.isrecommend = isrecommend;
        this.type = type;
        this.scheme = scheme;
        this.state = state;
        this.promulgatorname = promulgatorname;
        this.venuename = venuename;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPromulgatorid() {
        return promulgatorid;
    }

    public void setPromulgatorid(Long promulgatorid) {
        this.promulgatorid = promulgatorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getVenueid() {
        return venueid;
    }

    public void setVenueid(Long venueid) {
        this.venueid = venueid;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public boolean isIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(boolean isrecommend) {
        this.isrecommend = isrecommend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPromulgatorname() {
        return promulgatorname;
    }

    public void setPromulgatorname(String promulgatorname) {
        this.promulgatorname = promulgatorname;
    }

    public String getVenuename() {
        return venuename;
    }

    public void setVenuename(String venuename) {
        this.venuename = venuename;
    }
}

