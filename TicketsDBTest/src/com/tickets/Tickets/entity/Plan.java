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
	private int id;
	private String name;
	private String starttime;
	private String endtime;
	private String introduction;
	private String cover;
	private String location;
	private int venueid;
	private boolean overdue;
	private boolean isrecommend;
	private String type;//演唱会类型
	private String scheme;//上传的演唱会策划书路径名
	
	
	
	public Plan(int id, String name, String starttime, String endtime, String introduction, String cover,
			String location, int venueid, boolean overdue, boolean isrecommend, String scheme) {
		super();
		this.id = id;
		this.name = name;
		this.starttime = starttime;
		this.endtime = endtime;
		this.introduction = introduction;
		this.cover = cover;
		this.location = location;
		this.venueid = venueid;
		this.overdue = overdue;
		this.isrecommend = isrecommend;
		this.scheme = scheme;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getVenueid() {
		return venueid;
	}
	public void setVenueid(int venueid) {
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
