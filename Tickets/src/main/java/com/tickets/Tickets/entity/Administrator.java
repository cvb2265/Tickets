package com.tickets.Tickets.entity;

import java.io.Serializable;

public class Administrator implements Serializable {
    private static final long serialVersionUID = 4878032331962414748L;
    private Long id;
    private String name;
    private String password;
    private String head;

    public Administrator() {
    }

    public Administrator(Long id, String name, String password, String head) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.head = head;
    }

    public Administrator(String name, String password, String head) {
        this.name = name;
        this.password = password;
        this.head = head;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
