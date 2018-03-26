package com.tickets.Tickets.entity;

import java.io.Serializable;

//
public class venue implements Serializable {
    private static final long serialVersionUID = -8344780188907829753L;
    private int id;
    private String city;
    private String address;
    private String name;

    public venue(int id, String city, String address, String name) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.name = name;
    }

    public venue(String city, String address, String name) {
        this.city = city;
        this.address = address;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
