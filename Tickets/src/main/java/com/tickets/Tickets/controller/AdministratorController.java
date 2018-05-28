package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.Administrator;
import com.tickets.Tickets.mapper.AdministratorMapper;
import com.tickets.Tickets.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

//cf
@Controller
public class AdministratorController {
    //    @Autowired
//    AdministratorMapper am;
    @Autowired
    AdministratorService administratorService;

    @RequestMapping("/admin")
    public String adminIndex() {
        return "/admin/login";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String adminLogin(@ModelAttribute("administrator") Administrator administrator, HttpSession httpSession, Model model) {
//        long adminId = am.adminByName(administrator.getName()).getId();
//        String truePassword = am.adminByName(administrator.getName()).getPassword();
//        if(truePassword.equals(administrator.getPassword())){
//            httpSession.setAttribute("administrator",administrator);
//            System.out.println("adminId is"+adminId);
//            return "/admin/success";
//        }else {
//            return "/admin/fail";
//        }
        if (administratorService.find(administrator.getName(), administrator.getPassword()) != null) {
            httpSession.setAttribute("administrator", administrator);
            return "/admin/success";
        } else {
            model.addAttribute("msg", "登录名或密码错误，请重新输入!");//等价于 mv.addObject("msg", "登录名或密码错误，请重新输入!");
            return "/admin/login";
        }
    }

    @RequestMapping(value = "/admin/logout")
    public ModelAndView adminLogout(ModelAndView mv, HttpSession httpSession) {
        httpSession.removeAttribute("administrator");
        mv.setViewName("redirect:/admin");
        return mv;
    }

}
