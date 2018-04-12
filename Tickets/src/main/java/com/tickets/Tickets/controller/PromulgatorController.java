package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.Promulgator;
import com.tickets.Tickets.mapper.PromulgatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

//cf
@Controller
public class PromulgatorController {
    @Autowired
    PromulgatorMapper pm;

    @RequestMapping("/pro")
    public String proIndex() {
        //  System.out.println(pm.pro(1));
        return "/promulgator/login";
    }

    @RequestMapping("/pro/register")
    public void porRegister() {

    }

    //    @RequestMapping(value = "/pro/login",method = RequestMethod.POST)
//    public void proLogin(HttpSession session, @RequestBody LoginInfo loginInfo){
//
//      //  Promulgator p = pm.pro();
//    }

    @RequestMapping(value = "/pro/login", method = RequestMethod.POST)
    public String proLogin(@ModelAttribute(value = "Promulgator") Promulgator promulgator,HttpSession httpSession) {
        System.out.println(promulgator.getName());
        System.out.println(promulgator.getPassword());
        String truePassword =pm.proByName(promulgator.getName()).getPassword();
        if(truePassword.equals(promulgator.getPassword())){
            System.out.println("密码正确");
            httpSession.setAttribute("proId",pm.proByName(promulgator.getName()).getId());
            return "/promulgator/success";
        }else{
            System.out.println("密码错误");
            return "/promulgator/false";
        }
    }


//    @RequestMapping("/pro/login")
//    public String pro(HttpSession httpSession){
//       // System.out.println(httpSession.getAttributeNames());
//        httpSession.setAttribute("promulgator","thisIsaPro");
//        return "/promulgator/success";
//    }
//
//    @RequestMapping("/pro/try")
//    public String proTry(HttpSession httpSession){
//        System.out.println(httpSession.getAttribute("promulgator"));
//        return "/pro";
//    }
}
