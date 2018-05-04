package com.tickets.Tickets.entity;

import java.io.Serializable;

/**
 * @author 磊子狗
 *
 */
public class Plan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
