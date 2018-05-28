package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.service.PlanService;
import com.tickets.Tickets.util.ResultMessage;
import com.tickets.Tickets.vo.PlanVo;
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

    //@RequestMapping("/plan/test")
//public void plantest(){
//    PageDto pageDto = new PageDto((int) planService.countAll(), 1, page_size);
//    System.out.println(planService.getPlansByState(pageDto,"pending").get(0));
//    System.out.println(planService.getPlansByState(pageDto,"pending").get(0).getName());
//    System.out.println(planService.getPlansByState(pageDto,"pending").get(0).getVenuename());
//    System.out.println(planService.getPlansByState(pageDto,"pending").get(0).getPromulgatorname());
//}
    @RequestMapping("/planlist/all/{current_page}")
    public ModelAndView getPlanList(ModelAndView mv,
                                    HttpSession session,
                                    HttpServletRequest request,
                                    Map<String, Object> map,
                                    @PathVariable("current_page") int current_page) {
        //依据state获取plan列表
        //依据plan的size以及当前页码确定跳转
        //TODO,plansize=0且currentpage=1未考虑
        String state = "all";
        if (state == "all") {
            PageDto pageDto = new PageDto((int) planService.countAll(), current_page, page_size);
//            System.out.println(pageDto.getPage_size()+"?????????????????????????????");
//            System.out.println(pageDto.getOffset_row()+"!!!!!!!!!!!!!!!!!!!!!!!!");
            List<PlanVo> planVos = planService.getAllPlans(pageDto);
            if (planVos.size() == 0) {
                mv.setViewName("redirect:/planlist/" + state + "/" + --current_page);
            }
            map.put("planVos", planVos);
            map.put("pageDto", pageDto);
            mv.setViewName("/plan/list");
        }
        return mv;
    }

    @RequestMapping("/planlist/pending/{current_page}")
    public ModelAndView getPendingPlanList(ModelAndView mv,
                                           HttpSession session,
                                           HttpServletRequest request,
                                           Map<String, Object> map,
                                           @PathVariable("current_page") int current_page) {
        String state = "pending";
        PageDto pageDto = new PageDto((int) planService.countState(state), current_page, page_size);
        List<PlanVo> planVos = planService.getPlansByState(pageDto, state);
        if (planVos.size() == 0) {
            mv.setViewName("redirect:/planlist/" + state + "/" + --current_page);
        }
        map.put("planVos", planVos);
        map.put("pageDto", pageDto);
        mv.setViewName("/plan/pendinglist");
        return mv;
    }

    @RequestMapping("/planlist/pass/{current_page}")
    public ModelAndView getPassPlanList(ModelAndView mv,
                                        HttpSession session,
                                        HttpServletRequest request,
                                        Map<String, Object> map,
                                        @PathVariable("current_page") int current_page) {
        String state = "pass";
        PageDto pageDto = new PageDto((int) planService.countState(state), current_page, page_size);
        List<PlanVo> planVos = planService.getPlansByState(pageDto, state);
        if (planVos.size() == 0) {
            mv.setViewName("redirect:/planlist/" + state + "/" + --current_page);
        }
        map.put("planVos", planVos);
        map.put("pageDto", pageDto);
        mv.setViewName("/plan/passlist");
        return mv;
    }

    @RequestMapping("/planlist/fail/{current_page}")
    public ModelAndView getFailPlanList(ModelAndView mv,
                                        HttpSession session,
                                        HttpServletRequest request,
                                        Map<String, Object> map,
                                        @PathVariable("current_page") int current_page) {
        String state = "fail";
        PageDto pageDto = new PageDto((int) planService.countState(state), current_page, page_size);
        List<PlanVo> planVos = planService.getPlansByState(pageDto, state);
        if (planVos.size() == 0) {
            mv.setViewName("redirect:/planlist/" + state + "/" + --current_page);
        }
        map.put("planVos", planVos);
        map.put("pageDto", pageDto);
        mv.setViewName("/plan/faillist");
        return mv;
    }

    @RequestMapping("/planlist/{state}/{current_page}/{planid}")
    public ModelAndView toReviewPlan(ModelAndView mv,
                                     HttpSession session,
                                     HttpServletRequest request,
                                     @PathVariable("state") String state,
                                     @PathVariable("current_page") int current_page,
                                     @PathVariable("planid") long planid,
                                     Model model) {
        PlanVo planVo = planService.getPlanVoById(planid);
        model.addAttribute("planVo", planVo);
        model.addAttribute("state", state);
        model.addAttribute("current_page", current_page);
        mv.setViewName("/plan/review");
        return mv;
    }

    @RequestMapping("/reviewPlan")
    public ModelAndView reviewPlan(ModelAndView mv,
                                   HttpSession session,
                                   HttpServletRequest request,
                                   Plan plan,
                                   Model model) {
        System.out.println(plan);
        System.out.println(plan.getPromulgatorid());
        ResultMessage rm = planService.checkPlan(plan);
        model.addAttribute("rm", rm);
        mv.setViewName("/plan/reviewresult");
        return mv;
    }

}
