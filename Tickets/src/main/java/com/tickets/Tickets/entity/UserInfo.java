package com.tickets.Tickets.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = -2894758874014197704L;
    private Long id;
    private Long user_id;
    private String truename; //真实姓名
    private String sex;//性别
    private String birthdate;// 生日___________________________________________________//暂时用String
    private String marital_status; //婚姻状况
    private String education; //教育情况
    private String job;//职业
    private String address;// 住址
    private Integer idnumber;// 身份证号

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UserInfo() {
    }

    public UserInfo(Long id, Long user_id, String truename, String sex, String birthdate, String marital_status, String education, String job, String address, int idnumber) {
        this.id = id;
        this.user_id = user_id;
        this.truename = truename;
        this.sex = sex;
        this.birthdate = birthdate;
        this.marital_status = marital_status;
        this.education = education;
        this.job = job;
        this.address = address;
        this.idnumber = idnumber;
    }

    public UserInfo(Long user_id, String truename, String sex, String birthdate, String marital_status, String education, String job, String address, int idnumber) {
        this.user_id = user_id;
        this.truename = truename;
        this.sex = sex;
        this.birthdate = birthdate;
        this.marital_status = marital_status;
        this.education = education;
        this.job = job;
        this.address = address;
        this.idnumber = idnumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }
}
