package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.Administrator;
import com.tickets.Tickets.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

//cf
@Controller
public class AdministratorController {
    @Autowired
    AdministratorMapper am;

    @RequestMapping("/admin")
    public String adminIndex(){
        return "/admin/login";
    }

    @RequestMapping(value="/admin/login",method = RequestMethod.POST)
    public String adminLogin(@ModelAttribute("administrator")Administrator administrator, HttpSession httpSession){
        long adminId = am.adminByName(administrator.getName()).getId();
        String truePassword = am.adminByName(administrator.getName()).getPassword();
        if(truePassword.equals(administrator.getPassword())){
            httpSession.setAttribute("adminId",adminId);
            System.out.println("adminId is"+adminId);
            return "/admin/success";
        }else {
            return "/admin/fail";
        }
    }
}
