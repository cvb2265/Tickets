package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.Administrator;
import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.entity.Promulgator;
import com.tickets.Tickets.mapper.PromulgatorMapper;
import com.tickets.Tickets.service.PromulgatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//cf
@Controller
public class PromulgatorController {
    //@Autowired
    // PromulgatorMapper pm;
    @Autowired
    PromulgatorService ps;

    @Value("${page_size}")
    private int page_size;

    @RequestMapping("/pro")
    public String proIndex() {
        //  System.out.println(pm.pro(1));
        return "/promulgator/login";
    }
    @RequestMapping(value = "/pro/login", method = RequestMethod.POST)
    public String adminLogin(@ModelAttribute("promulgator") Promulgator promulgator, HttpSession httpSession, Model model) {
        if (ps.find(promulgator.getEmail(), promulgator.getPassword()) != null) {
            httpSession.setAttribute("promulgator", promulgator);
            return "/promulgator/success";
        } else {
            model.addAttribute("msg", "登录名或密码错误，请重新输入!");//等价于 mv.addObject("msg", "登录名或密码错误，请重新输入!");
            return "/promulgator/login";
        }
    }
    @RequestMapping("/promulgator/add")
    public String addPro(Promulgator promulgator, HttpSession httpSession) {
        //System.out.println(promulgator);
        ps.addPro(promulgator);
        return "redirect:/promulgator/1";
    }

    @RequestMapping("/promulgator/addpage")
    public String toProAddPage(HttpSession httpSession) {
        return "/Promulgator/add";
    }

    @RequestMapping("/promulgator/{current_page}/{promulgator_id}")
    public String detailPro(@PathVariable("current_page") int current_page, @PathVariable("promulgator_id") long promulgatorId, Model model, HttpSession httpSession) {
        Promulgator promulgator = ps.getPromulgatorDetailById(promulgatorId);
        model.addAttribute("promulgator", promulgator);
        model.addAttribute("current_page", current_page);
        return "promulgator/edit";
    }

    @RequestMapping(path = {"/promulgator/update/{current_page}"}, method = {RequestMethod.POST})
    public String edit(@PathVariable("current_page") int current_page, Promulgator promulgator, HttpSession httpSession) {
        ps.updatePro(promulgator);
        return "redirect:/promulgator/" + current_page;
    }

    @RequestMapping("/promulgator/{current_page}/{promulgator_id}/delete")
    public String deletePro(@PathVariable("current_page") int current_page, @PathVariable("promulgator_id") long promulgatorId, HttpSession httpSession) {
        ps.delPro(promulgatorId);
        return "redirect:/promulgator/" + current_page;
    }

    @RequestMapping("/promulgator/{current_page}")
    public String proList(@PathVariable("current_page") int current_page, Map<String, Object> map, HttpSession httpSession) {
        PageDto pageDto = new PageDto((int) ps.count(), current_page, page_size);
        List<Promulgator> promulgators = ps.ListPros(pageDto);
        if (promulgators.size() == 0) {
            return "redirect:/promulgator/" + --current_page;
        }
        map.put("promulgators", promulgators);
        map.put("pageDto", pageDto);
        return "/promulgator/list";
    }

    @RequestMapping("/promulgatorpicture")
    public String toPromulgatorPicturePage(HttpSession httpSession){
        return "/promulgator/picture";
    }

    //    @RequestMapping(value = "/pro/login",method = RequestMethod.POST)
//    public void proLogin(HttpSession session, @RequestBody LoginInfo loginInfo){
//
//      //  Promulgator p = pm.pro();
//    }

//    @RequestMapping(value = "/pro/login", method = RequestMethod.POST)
//    public String proLogin(@ModelAttribute(value = "promulgator") Promulgator promulgator,HttpSession httpSession) {
//        System.out.println(promulgator.getName());
//        System.out.println(promulgator.getPassword());
//        String truePassword =pm.proByName(promulgator.getName()).getPassword();
//        if(truePassword.equals(promulgator.getPassword())){
//            System.out.println("密码正确");
//            httpSession.setAttribute("proId",pm.proByName(promulgator.getName()).getId());
//            return "/promulgator/success";
//        }else{
//            System.out.println("密码错误");
//            return "/promulgator/false";
//        }
//    }


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
    @RequestMapping("/promulgatorchangelist")
    public String toChangeList(HttpSession httpSession){
        return "/promulgator/changelist";
    }
}
