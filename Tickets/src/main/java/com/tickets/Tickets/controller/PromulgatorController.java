package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.Promulgator;
import com.tickets.Tickets.mapper.PromulgatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//cf
@Controller
public class PromulgatorController {
    @Autowired
    PromulgatorMapper pm;
    @RequestMapping("/pro")
    public String proIndex() {
        System.out.println(pm.pro(1));
        return "/promulgator/index";
    }

    @RequestMapping("/pro/register")
    public void porRegister(){

    }
    @RequestMapping("/pro/login")
    public void proLogin(){

    }
}
