package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Notice implements Serializable {
    private static final long serialVersionUID = 7910358669326408211L;
    private Long id;
    private Long userid;// 接收消息的用户id
    private String time;
    private String title;
    private String content;
    private boolean read;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public Notice() {
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
