package com.tickets.Tickets.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.entity.Seatprice;
import com.tickets.Tickets.entity.User;
import com.tickets.Tickets.entity.Venue;
import com.tickets.Tickets.service.PlanService;
import com.tickets.Tickets.service.SeatpriceService;
import com.tickets.Tickets.service.UserService;
import com.tickets.Tickets.service.VenueService;
import com.tickets.Tickets.util.Page;
import com.tickets.Tickets.util.PageAndPlanList;
import com.tickets.Tickets.util.ResultMessage;

/**
 * @author tqy
 * @date 2018年3月23日
 * 
 */
@Controller
public class UserController {
	public UserController() {
	}
	

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@Autowired
	@Qualifier("planService")
	private PlanService planService;
	@Autowired
	@Qualifier("seatpriceService")
	private SeatpriceService seatpriceService;
	@Autowired
	@Qualifier("venueService")
	private VenueService venueService;
	
	//打印日志
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	

	/**********************只负责将请求转发给页面的Controller*****************************/
	@RequestMapping(value="/user/loginV")
	public ModelAndView loginV(
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/loginV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		mv.setViewName("/user/login");
		return mv;
	}
	@RequestMapping(value="/user/regV")
	public ModelAndView regV(
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/regV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		mv.setViewName("/user/reg");
		return mv;
	}
	
	
	

	
	
	/**************************包含数据处理的Controller*****************************/
	//主页
	@RequestMapping(value={"/user/", "/user/indexV"})
	public ModelAndView indexV(
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/接口 被调用，请求者的地址是"+request.getRemoteAddr());
		
		

		Page page = new Page();
		List<Plan> list = planService.getPlans(6, 1, page, "",
				"", "", "",  "false", "true", "",  "DESC");
		mv.addObject("rcmplans", list);
		List<Plan> list2 = planService.getPlans(6, 1, page, "",
				"", "", "",  "false", "true", "流行",  "DESC");
		mv.addObject("lxplans", list2);
		List<Plan> list3 = planService.getPlans(6, 1, page, "",
				"", "", "",  "false", "true", "古典",  "DESC");
		mv.addObject("gdplans", list3);
		List<Plan> list4 = planService.getPlans(6, 1, page, "",
				"", "", "",  "false", "true", "摇滚",  "DESC");
		mv.addObject("ygplans", list4);
		List<Plan> list5 = planService.getPlans(6, 1, page, "",
				"", "", "",  "false", "true", "名族",  "DESC");
		mv.addObject("mzplans", list5);
		List<Plan> list6 = planService.getPlans(6, 1, page, "",
				"", "", "",  "false", "true", "乡村",  "DESC");
		mv.addObject("xcplans", list6);
		List<Plan> list7 = planService.getPlans(6, 1, page, "",
				"", "", "",  "false", "true", "管弦乐",  "DESC");
		mv.addObject("gxyplans", list7);
		List<Plan> list8 = planService.getPlans(6, 1, page, "",
				"", "", "",  "false", "true", "其它",  "DESC");
		mv.addObject("qtplans", list8);
		
		
		mv.setViewName("/user/index");
		return mv;
	}
	
	
	/**
	 * 处理/user/login请求，而且只接受post请求
	 * */
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public ModelAndView login(
			 String email,String password,
			 ModelAndView mv,
			 HttpSession session,
			 HttpServletRequest request,
			 Model model){
		logger.info("/user/login接口 被调用，请求者的地址是"+request.getRemoteAddr());
		User user = userService.login(email, password);
		if(user != null){
			if(user.getLevel() == -1) {
				model.addAttribute("msg", "账号未激活!");//等价于 mv.addObject("msg", "账号未激活!");
				mv.setViewName("/user/login");
				return mv;
			}
			session.setAttribute("user", user);
			mv.setViewName("redirect:/user/indexV");//重定向必须重定向到 页面对应的控制器
		}else{
			model.addAttribute("msg", "登录名或密码错误，请重新输入!");//等价于 mv.addObject("msg", "登录名或密码错误，请重新输入!");
			mv.setViewName("/user/login");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/logout")
	public ModelAndView logout(
			 ModelAndView mv,
			 HttpSession session){
		session.removeAttribute("user");
		mv.setViewName("redirect:/user/indexV");
		return mv;
	}
	
	
	@RequestMapping(value="/user/checkEmail")
	@ResponseBody
	public Object checkEmail(String email,
			 HttpServletRequest request){
		logger.info("/user/checkEmail接口 被调用，请求者的地址是"+request.getRemoteAddr());
		boolean b = userService.checkEmail(email);
		if(b) {
			return -1;
		}
		return 1;
	}
	
	/**
	 * 处理/user/reg请求，而且只接受post请求
	 * */
	@RequestMapping(value="/user/reg", method=RequestMethod.POST)
	public ModelAndView reg(
			 String email,String password,
			 ModelAndView mv,
			 HttpSession session,
			 HttpServletRequest request,
			 Model model){
		logger.info("/user/reg接口 被调用，请求者的地址是"+request.getRemoteAddr());
		boolean b = userService.sendActivationEmail(email, password);
		if(b) {
			model.addAttribute("msg", "激活邮件已经发送到您的邮箱！请尽快激活！");
			mv.setViewName("user/successpage");
		}else {
			model.addAttribute("emsg", "邮箱已经被使用！");
			mv.setViewName("user/errorpage");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/activation")
	public ModelAndView activation(
			 Integer uid,
			 ModelAndView mv,
			 HttpServletRequest request,
			 Model model) {
		logger.info("/user/activation接口 被调用，请求者的地址是"+request.getRemoteAddr()+"，uid="+uid);
		boolean b = userService.activationAccount(uid);
		if(b){
			model.addAttribute("msg", "激活成功！");
			mv.setViewName("user/successpage");
		}else{
			model.addAttribute("emsg", "已经激活！");
			mv.setViewName("user/errorpage");
		}
		return mv;
	}
	

	@RequestMapping(value="/user/searchplans")
	@ResponseBody
	public Object searchplans(
			int pageSize, int index, String keyword, 
			String day1, String day2, String location, String overdue, 
			String isrecommend, String type, String sort_strategy
			 ){
		System.out.println("pageSize---"+pageSize);
		System.out.println("index---"+index);
		System.out.println("keyword---"+keyword);
		System.out.println("day1---"+day1);
		System.out.println("day2---"+day2);
		System.out.println("location---"+location);
		System.out.println("overdue---"+overdue);
		System.out.println("isrecommend---"+isrecommend);
		System.out.println("type---"+type);
		System.out.println("sort_strategy---"+sort_strategy);
		Page page = new Page();
		List<Plan> list = planService.getPlans(pageSize, index, page, keyword,
				day1, day2, location,  overdue, isrecommend, type,  sort_strategy);
		
		PageAndPlanList pageAndPlanList = new PageAndPlanList();
		pageAndPlanList.setIndex(page.getIndex());
		pageAndPlanList.setPageCount(page.getPageCount());
		pageAndPlanList.setRecordCount(page.getRecordCount());
		pageAndPlanList.setList(list);
		
		return pageAndPlanList;
	}
	

	@RequestMapping(value="/user/planlistV")
	public ModelAndView planlistV(String keyword, String type,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/planlistV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		logger.info(keyword);
		logger.info(type);
		if(!"".equals(keyword) || keyword!=null) {
			mv.addObject("keyword", keyword);
		}
		if(!"".equals(type) || type!=null) {
			mv.addObject("type", type);
		}
		mv.setViewName("/user/planlist");
		return mv;
	}
	
	@RequestMapping(value="/user/loadseat")
	public ModelAndView loadseat(
			 int planid,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/loadseat接口 被调用，请求者的地址是"+request.getRemoteAddr());
		Plan plan = planService.getById(planid);
		Venue venue = venueService.getById(plan.getVenueid());
		List<Seatprice> sps = seatpriceService.getByPlanid(planid);
		List<List<Seatprice>> lists = new ArrayList<List<Seatprice>>();
		List<Seatprice> list = new ArrayList<Seatprice>();
		int x = sps.get(0).getX();
		int len = sps.size();
		for(int i=0; i<len;i++) {
			if(sps.get(i).getX()==x) {
				list.add(sps.get(i));
				if(i==len-1) {
					lists.add(list);
				}
			}else {
				lists.add(list);
				list = null;
				list = new ArrayList<Seatprice>();
				list.add(sps.get(i));
				x = sps.get(i).getX();
			}
		}
		System.out.println(lists.size());
		System.out.println(lists.get(5).size());
		mv.addObject("plan", plan);
		mv.addObject("venue", venue);
		mv.addObject("lists", lists);
		mv.setViewName("/user/plandetail");
		return mv;
	}	
	@RequestMapping(value="/user/loadgoods")
	public ModelAndView loadgoods(
			 int planid,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/loadgoods接口 被调用，请求者的地址是"+request.getRemoteAddr());
		logger.info("planid是"+planid);
		mv.setViewName("/user/goodsdetail");
		return mv;
	}
	
	@RequestMapping(value="/user/preorder", method=RequestMethod.POST)
	public ModelAndView preorder(
			 String spids,
			 Integer points_cost,
			 ModelAndView mv,
			 HttpSession session,
			 HttpServletRequest request){
		logger.info("/user/preorder接口 被调用，请求者的地址是"+request.getRemoteAddr());
		User user = (User) session.getAttribute("user");
		ResultMessage rs = userService.createOrder(user.getUserid(), spids, points_cost);
		if(!rs.isResult()) {
			mv.addObject("emsg", rs.getMessage());
			mv.setViewName("user/errorpage");
			return mv;
		}
		mv.setViewName("user/orders_all");
		return mv;
	}
	
}
