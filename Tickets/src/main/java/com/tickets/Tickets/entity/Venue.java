package com.tickets.Tickets.entity;

import java.io.Serializable;
import java.util.ArrayList;

//
public class Venue implements Serializable {
    private static final long serialVersionUID = -8344780188907829753L;
    private Integer id;
    private String city;
    private String address;
    private String name;
    private ArrayList<Seat> seats;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Venue() {
    }

    public Venue(int id, String city, String address, String name,ArrayList<Seat> seats) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.name = name;
        this.seats = seats;
    }

    public Venue(String city, String address, String name,ArrayList<Seat> seats) {
        this.city = city;
        this.address = address;
        this.name = name;
        this.seats = seats;
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
    
    public ArrayList<Seat> getSeats(){
    	return seats;
    }
    
    public void setSeats(ArrayList<Seat> seats) {
    	this.seats = seats;
    }
}
