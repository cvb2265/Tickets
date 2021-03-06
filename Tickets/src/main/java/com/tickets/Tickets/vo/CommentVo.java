package com.tickets.Tickets.vo;

import java.io.Serializable;

public class CommentVo implements Serializable {
    private static final long serialVersionUID = -3864735914838751217L;
    private Long id;
    private Long planid;// 所属演出id
    private Long userid;// 评论者id
    private Long parentid;// 母评论id（第一级评论默认设置为0）
    private String comment_time;// 评论时间,暂时用String表示事后需要改变
    private String content;//评论内容
    private Integer rate;// 星级
    private Integer comment_type;// 类型（预期为0，评论为1）
    private Integer deleteflag;// 删除标志（删除为1，未删除为0）
    private Integer passflag;//是否已经被管理员审核（是为1，未被审核为0）

    private String username;
    private String planname;

    public CommentVo() {
    }

    public CommentVo(Long planid, Long userid, Long parentid, String comment_time, String content, Integer rate, Integer comment_type, Integer deleteflag, Integer passflag, String username, String planname) {
        this.planid = planid;
        this.userid = userid;
        this.parentid = parentid;
        this.comment_time = comment_time;
        this.content = content;
        this.rate = rate;
        this.comment_type = comment_type;
        this.deleteflag = deleteflag;
        this.passflag = passflag;
        this.username = username;
        this.planname = planname;
    }

    public CommentVo(Long id, Long planid, Long userid, Long parentid, String comment_time, String content, Integer rate, Integer comment_type, Integer deleteflag, Integer passflag, String username, String planname) {
        this.id = id;
        this.planid = planid;
        this.userid = userid;
        this.parentid = parentid;
        this.comment_time = comment_time;
        this.content = content;
        this.rate = rate;
        this.comment_type = comment_type;
        this.deleteflag = deleteflag;
        this.passflag = passflag;
        this.username = username;
        this.planname = planname;
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

    public Long getPlanid() {
        return planid;
    }

    public void setPlanid(Long planid) {
        this.planid = planid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getComment_type() {
        return comment_type;
    }

    public void setComment_type(Integer comment_type) {
        this.comment_type = comment_type;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }

    public Integer getPassflag() {
        return passflag;
    }

    public void setPassflag(Integer passflag) {
        this.passflag = passflag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname;
    }
}
