package com.tickets.Tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//cf
@Controller
public class PromulgatorController {

    @RequestMapping("/pro")
    public String proIndex() {
        return "/promulgator/index";
    }
}
