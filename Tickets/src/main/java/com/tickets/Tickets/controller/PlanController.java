package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.service.PlanService;
import com.tickets.Tickets.util.ResultMessage;
import org.apache.ibatis.mapping.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//cf
@Controller
public class PlanController {
    @Autowired
    @Qualifier("planService")
    private PlanService planService;

    @Value("${page_size}")
    private int page_size;

    @RequestMapping("/planlist/{state}/{current_page}")
    public ModelAndView getPlanList(ModelAndView mv,
                                    HttpSession session,
                                    HttpServletRequest request,
                                    Map<String,Object> map,
                                    @PathVariable("state") String state,
                                    @PathVariable("current_page") int current_page){
        //依据state获取plan列表
        //依据plan的size以及当前页码确定跳转
        //TODO,plansize=0且currentpage=1未考虑
        if(state=="all"){
            PageDto pageDto = new PageDto((int) planService.countAll(), current_page, page_size);
            List<Plan> plans= planService.getAllPlans(pageDto);
            if (plans.size() == 0) {
                mv.setViewName("redirect:/planlist/"+state+"/" + --current_page);
            }
            map.put("plans",plans);
            map.put("pageDto",pageDto);
            mv.setViewName("/plan/list");

        }if((state=="pending")||(state=="pass")||(state=="fail")){
            PageDto pageDto = new PageDto((int) planService.countState(state), current_page, page_size);
            List<Plan> plans =planService.getPlansByState(pageDto,state);
            if (plans.size() == 0) {
                mv.setViewName("redirect:/planlist/"+state+"/" + --current_page);
            }
            map.put("plans",plans);
            map.put("pageDto",pageDto);
            mv.setViewName("/plan/list");
        }
//        else{//若state未设置，先当成all来处理
//            PageDto pageDto = new PageDto((int) planService.countAll(), current_page, page_size);
//            List<Plan> plans= planService.getAllPlans(pageDto);
//            if (plans.size() == 0) {
//                mv.setViewName("redirect:/planlist/"+state+"/" + --current_page);
//            }
//            map.put("plans",plans);
//            map.put("pageDto",pageDto);
//            mv.setViewName("/plan/list");
//        }
        return mv;
    }

    @RequestMapping("/planlist/{state}/{current_page}/{planid}")
    public ModelAndView toReviewPlan(ModelAndView mv,
                                     HttpSession session,
                                     HttpServletRequest request,
                                     @PathVariable("state") String state,
                                     @PathVariable("current_page") int current_page,
                                     @PathVariable("planid")long planid,
                                      Model model){
        Plan plan =planService.getById(planid);
        model.addAttribute("plan", plan);
        model.addAttribute("state",state);
        model.addAttribute("current_page", current_page);
        mv.setViewName("/plan/review");
        return mv;
    }

    @RequestMapping("/reviewPlan/{planid}")
    public ModelAndView reviewPlan(ModelAndView mv,
                                    HttpSession session,
                                    HttpServletRequest request,
                                    @PathVariable("planid")long planid,
                                    Plan plan,
                                    Model model){
        ResultMessage rm =planService.checkPlan(planid,plan);
        model.addAttribute("rm",rm);
        mv.setViewName("/plan/reviewresult");
        return mv;
}

}
