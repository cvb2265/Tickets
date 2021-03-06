package com.tickets.Tickets.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tickets.Tickets.entity.*;
import com.tickets.Tickets.service.*;
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

import com.tickets.Tickets.util.Page;
import com.tickets.Tickets.util.PageAndList;
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
	@Qualifier("orderService")
	private OrderService orderService;
	@Autowired
	@Qualifier("planService")
	private PlanService planService;
	@Autowired
	@Qualifier("seatpriceService")
	private SeatpriceService seatpriceService;
	@Autowired
	@Qualifier("venueService")
	private VenueService venueService;
	@Autowired
	@Qualifier("goodsService")
	private GoodsService goodsService;
	@Autowired
	@Qualifier("noticeService")
	private NoticeService noticeService;
	@Autowired
	@Qualifier("levelService")
	private LevelService levelService;
	@Autowired
	@Qualifier("userInfoService")
	private UserInfoService userInfoService;
	
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
	@RequestMapping(value="/user/rechargeV")
	public ModelAndView rechargeV(
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/rechargeV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		mv.setViewName("/user/recharge");
		return mv;
	}
	@RequestMapping(value="/user/recharge", method=RequestMethod.POST)
	public ModelAndView recharge(
			Integer money,
			 ModelAndView mv,
			 HttpSession session,
			 HttpServletRequest request){
		logger.info("/user/recharge接口 被调用，请求者的地址是"+request.getRemoteAddr());
		User user = (User) session.getAttribute("user");
		ResultMessage rs = userService.recharge(user.getUserid(), money);
		if(!rs.isResult()) {
			mv.addObject("emsg", rs.getMessage());
			mv.setViewName("user/errorpage");
			return mv;
		}
		//更新user信息
		User u = userService.getById(user.getUserid());
		session.setAttribute("user", u);
		mv.addObject("emsg", "充值成功！");
		mv.setViewName("user/errorpage");
		return mv;
	}
	@RequestMapping(value="/user/userinfoV")
	public ModelAndView userinfoV(
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/userinfoV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		mv.setViewName("/user/userinfo");
		return mv;
	}
	@RequestMapping(value="/user/securitymngV")
	public ModelAndView securitymngV(
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/securitymngV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		mv.setViewName("/user/securitymng");
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
		List<Plan> list = planService.getPlans(6L, 1L, page, "",
				"", "", "",  "false", "true", "",  "DESC", "pass");
		mv.addObject("rcmplans", list);
		List<Plan> list2 = planService.getPlans(6L, 1L, page, "",
				"", "", "",  "false", "true", "流行",  "DESC", "pass");
		mv.addObject("lxplans", list2);
		List<Plan> list3 = planService.getPlans(6L, 1L, page, "",
				"", "", "",  "false", "true", "古典",  "DESC", "pass");
		mv.addObject("gdplans", list3);
		List<Plan> list4 = planService.getPlans(6L, 1L, page, "",
				"", "", "",  "false", "true", "摇滚",  "DESC", "pass");
		mv.addObject("ygplans", list4);
		List<Plan> list5 = planService.getPlans(6L, 1L, page, "",
				"", "", "",  "false", "true", "名族",  "DESC", "pass");
		mv.addObject("mzplans", list5);
		List<Plan> list6 = planService.getPlans(6L, 1L, page, "",
				"", "", "",  "false", "true", "乡村",  "DESC", "pass");
		mv.addObject("xcplans", list6);
		List<Plan> list7 = planService.getPlans(6L, 1L, page, "",
				"", "", "",  "false", "true", "管弦乐",  "DESC", "pass");
		mv.addObject("gxyplans", list7);
		List<Plan> list8 = planService.getPlans(6L, 1L, page, "",
				"", "", "",  "false", "true", "其它",  "DESC", "pass");
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
			 Long uid,
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
			Long pageSize, Long index, String keyword, 
			String day1, String day2, String location, String overdue, 
			String isrecommend, String type, String sort_strategy,
			 HttpServletRequest request
			 ){
		logger.info("/user/searchgoods接口 被调用，请求者的地址是"+request.getRemoteAddr());
		
		Page page = new Page();
		List<Plan> list = planService.getPlans(pageSize, index, page, keyword,
				day1, day2, location,  overdue, isrecommend, type,  sort_strategy, "pass");
		
		PageAndList<Plan> pageAndList = new PageAndList<Plan>();
		pageAndList.setIndex(page.getIndex());
		pageAndList.setPageCount(page.getPageCount());
		pageAndList.setRecordCount(page.getRecordCount());
		pageAndList.setList(list);
		
		return pageAndList;
	}
	

	@RequestMapping(value="/user/planlistV")
	public ModelAndView planlistV(String keyword, String type,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/planlistV接口 被调用，请求者的地址是"+request.getRemoteAddr());
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
			 Long planid,
			 ModelAndView mv,
			 HttpSession session,
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
		mv.addObject("plan", plan);
		mv.addObject("venue", venue);
		mv.addObject("lists", lists);
		
		User user = (User) session.getAttribute("user");
		Level le = levelService.getByLevel_num(user.getLevel());
		mv.addObject("lperc", le.getDiscount());
		mv.setViewName("/user/plandetail");
		return mv;
	}	
	@RequestMapping(value="/user/loadgoods")
	public ModelAndView loadgoods(
			Long planid,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/loadgoods接口 被调用，请求者的地址是"+request.getRemoteAddr());
		mv.addObject("planid", planid);
		mv.setViewName("/user/goodslist");
		return mv;
	}

	@RequestMapping(value="/user/searchgoods")
	@ResponseBody
	public Object searchgoods(
			Long pageSize, Long index,
			Long planid,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/searchgoods接口 被调用，请求者的地址是"+request.getRemoteAddr());
		
		Page page = new Page();
		List<Goods> list = goodsService.getGoodsByPlanid(pageSize, index, page, planid);
		
		PageAndList<Goods> pageAndList = new PageAndList<Goods>();
		pageAndList.setIndex(page.getIndex());
		pageAndList.setPageCount(page.getPageCount());
		pageAndList.setRecordCount(page.getRecordCount());
		pageAndList.setList(list);
		
		return pageAndList;
	}
	
	
	
	
	@RequestMapping(value="/user/preordersp", method=RequestMethod.POST)
	public ModelAndView preordersp(
			 String spids,
			 Integer points_cost,
			 ModelAndView mv,
			 HttpSession session,
			 HttpServletRequest request){
		logger.info("/user/preordersp接口 被调用，请求者的地址是"+request.getRemoteAddr());
		User user = (User) session.getAttribute("user");
		ResultMessage rs = userService.createSeatpriceOrder(user.getUserid(), spids, points_cost);
		if(!rs.isResult()) {
			mv.addObject("emsg", rs.getMessage());
			mv.setViewName("user/errorpage");
			return mv;
		}
		//更新user信息
		User u = userService.getById(user.getUserid());
		session.setAttribute("user", u);
		mv.addObject("order_state", "unpaid");
		mv.setViewName("/user/myorders");
		return mv;
	}	
	@RequestMapping(value="/user/preordergoods")
	public ModelAndView preordergoods(
			Long goodsid,
			 ModelAndView mv,
			 HttpSession session,
			 HttpServletRequest request){
		logger.info("/user/preordergoods接口 被调用，请求者的地址是"+request.getRemoteAddr());
		if(goodsid==null) {
			mv.addObject("emsg", "参数无效！");
			mv.setViewName("user/errorpage");
			return mv;
		}
		User user = (User) session.getAttribute("user");
		ResultMessage rs = userService.createGoodsOrder(user.getUserid(), goodsid);
		if(!rs.isResult()) {
			mv.addObject("emsg", rs.getMessage());
			mv.setViewName("user/errorpage");
			return mv;
		}
		mv.addObject("order_state", "unpaid");
		mv.setViewName("/user/myorders");
		return mv;
	}
	

	//
	@RequestMapping(value="/user/myordersV")
	public ModelAndView myordersV(
			 String order_state,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/myordersV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		if(!"unpaid".equals(order_state) && !"paid".equals(order_state) && !"finished".equals(order_state) ) {
			order_state = "all";
		}
		mv.addObject("order_state", order_state);
		mv.setViewName("/user/myorders");
		return mv;
	}

	@RequestMapping(value="/user/mynoticesV")
	public ModelAndView mynoticesV(
			 String read_state,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/mynoticesV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		if(!"false".equals(read_state) && !"true".equals(read_state) ) {
			read_state = "all";
		}
		mv.addObject("read_state", read_state);
		mv.setViewName("/user/mynotices");
		return mv;
	}

	@RequestMapping(value="/user/searchorders")
	@ResponseBody
	public Object searchorders(
			Long pageSize, Long index,
			 String order_state,
			 HttpSession session,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/searchorders接口 被调用，请求者的地址是"+request.getRemoteAddr());

		if(!"unpaid".equals(order_state) && !"paid".equals(order_state) && !"finished".equals(order_state) ) {
			order_state = "";
		}
		
		Page page = new Page();
		User user = (User) session.getAttribute("user");
		List<Order> list = orderService.getOrderByUserid(pageSize, index, page, user.getUserid(), order_state);
		
		PageAndList<Order> pageAndList = new PageAndList<Order>();
		pageAndList.setIndex(page.getIndex());
		pageAndList.setPageCount(page.getPageCount());
		pageAndList.setRecordCount(page.getRecordCount());
		pageAndList.setList(list);
		
		return pageAndList;
	}
	@RequestMapping(value="/user/searchnotices")
	@ResponseBody
	public Object searchnotices(
			Long pageSize, Long index,
			 String read_state,
			 HttpSession session,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/searchnotices接口 被调用，请求者的地址是"+request.getRemoteAddr());

		if(!"false".equals(read_state) && !"true".equals(read_state) ) {
			read_state = "";
		}
		
		Page page = new Page();
		User user = (User) session.getAttribute("user");
		List<Notice> list = noticeService.getNoticeByUserid(pageSize, index, page, user.getUserid(), read_state);
		
		PageAndList<Notice> pageAndList = new PageAndList<Notice>();
		pageAndList.setIndex(page.getIndex());
		pageAndList.setPageCount(page.getPageCount());
		pageAndList.setRecordCount(page.getRecordCount());
		pageAndList.setList(list);
		
		return pageAndList;
	}
	
	@RequestMapping(value="/user/noticescount")
	@ResponseBody
	public Object noticescount(
			 String read_state,
			 HttpSession session,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/noticescount接口 被调用，请求者的地址是"+request.getRemoteAddr());

		if(!"false".equals(read_state) && !"true".equals(read_state) ) {
			read_state = "";
		}
		
		User user = (User) session.getAttribute("user");
		Long c = noticeService.getNoticeCountByUserid(user.getUserid(), read_state);

		
		return c;
	}
	
	
	
	@RequestMapping(value="/user/payorder")
	public ModelAndView payorder(
			 Long orderid,
			 HttpSession session,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/payorder接口 被调用，请求者的地址是"+request.getRemoteAddr());
		User user = (User) session.getAttribute("user");
		ResultMessage rs = userService.payOrder(user.getUserid(), orderid);
		if(!rs.isResult()) {
			mv.addObject("emsg", rs.getMessage());
			mv.setViewName("user/errorpage");
			return mv;
		}
		//更新user信息
		User u = userService.getById(user.getUserid());
		session.setAttribute("user", u);
		mv.addObject("order_state", "paid");
		mv.setViewName("/user/myorders");
		return mv;
	}	
	@RequestMapping(value="/user/cancelorder")
	public ModelAndView cancelorder(
			 Long orderid,
			 HttpSession session,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/cancelorder接口 被调用，请求者的地址是"+request.getRemoteAddr());
		User user = (User) session.getAttribute("user");
		ResultMessage rs = userService.cancelOrder(user.getUserid(), orderid);
		if(!rs.isResult()) {
			mv.addObject("emsg", rs.getMessage());
			mv.setViewName("user/errorpage");
			return mv;
		}
		//更新user信息
		User u = userService.getById(user.getUserid());
		session.setAttribute("user", u);
		mv.addObject("order_state", "all");
		mv.setViewName("/user/myorders");
		return mv;
	}	
	@RequestMapping(value="/user/unsubscribeorder")
	public ModelAndView unsubscribeorder(
			 Long orderid,
			 HttpSession session,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/unsubscribeorder接口 被调用，请求者的地址是"+request.getRemoteAddr());
		User user = (User) session.getAttribute("user");
		ResultMessage rs = userService.unsubscribeOrder(user.getUserid(), orderid);
		//更新user信息
		User u = userService.getById(user.getUserid());
		session.setAttribute("user", u);
		mv.addObject("emsg", rs.getMessage());
		mv.setViewName("user/errorpage");
		return mv;
	}
	
	
	
	@RequestMapping(value="/user/orderdetailV")
	public ModelAndView orderdetailV(
			 Long orderid,
			 HttpSession session,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/orderdetailV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		Order order = orderService.getById(orderid);
		List<Seatprice> sps = seatpriceService.getByOrderid(orderid);
		Long planid;
		Goods goods = null;
		if(sps.size()!=0) {//证明买的是seatprice
			planid = sps.get(0).getPlanid();
			goods = new Goods();
		}else {//证明买的是goods
			goods = goodsService.getByOrderid(orderid);
			planid = goods.getPlanid();
		}
		Plan plan = planService.getById(planid);
		Venue venue = venueService.getById(plan.getVenueid());
		mv.addObject("order", order);
		mv.addObject("plan", plan);
		mv.addObject("venue", venue);
		mv.addObject("sps", sps);
		mv.addObject("goods", goods);
		
		mv.setViewName("/user/orderdetail");
		return mv;
	}
	
	@RequestMapping(value="/user/noticedetailV")
	public ModelAndView noticedetailV(
			 Long noticeid,
			 HttpSession session,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/noticedetailV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		Notice notice = noticeService.getAndReadNoticeById(noticeid);
		mv.addObject("notice", notice);
		
		mv.setViewName("/user/noticedetail");
		return mv;
	}
	
	@RequestMapping(value="/user/delnotice")
	public ModelAndView delnotice(
			 String noticeids,
			 HttpSession session,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/delnotice接口 被调用，请求者的地址是"+request.getRemoteAddr());
		User user = (User) session.getAttribute("user");
		noticeService.del(user.getUserid(), noticeids);
		
		mv.addObject("read_state", "all");
		mv.setViewName("/user/mynotices");
		return mv;
	}
	
	
	@RequestMapping(value="/user/evaluateorderV")
	public ModelAndView evaluateorderV(
			 Long orderid,
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("/user/evaluateorderV接口 被调用，请求者的地址是"+request.getRemoteAddr());
		mv.addObject("orderid", orderid);
		mv.setViewName("user/evaluateorder");
		return mv;
	}
	
	//下面是cf编写的有关用户私人信息的接口
	//2018-05-07
	@RequestMapping("/user/userPrivateInfoV")
	public ModelAndView userPrivateInfo(HttpSession session, ModelAndView mv, HttpServletRequest request, Model model){
		//暂时默认有用户就有用户个人信息，其实需要考虑一下，需要和tqy商量一下最初的这些信息从哪获得
		User user =(User)session.getAttribute("user");
		UserInfo userInfo = userInfoService.getUserInfoByUserId(user.getUserid());
		System.out.println(userInfo.getId());
		System.out.println(userInfo.getEducation());
		model.addAttribute("userInfo", userInfo);
		//session.setAttribute("userInfo", userInfo);
		mv.setViewName("user/userprivateinfo");
		return mv;
	}

	@RequestMapping("/user/updatePrivateInfoV")
	public ModelAndView updatePrivateInfo(HttpSession session, ModelAndView mv, HttpServletRequest request,UserInfo userInfo,Model model){
		//也需要考虑一下原来是否存在的问题，以及result的作用
		System.out.println("controller数据展示_____");
		System.out.println(userInfo.getId());
		System.out.println(userInfo.getUser_id());
		System.out.println(userInfo.getBirthdate());
		System.out.println(userInfo.getEducation());
		System.out.println(userInfo.getJob());
		boolean result = userInfoService.updateUserInfo(userInfo);
		model.addAttribute("userInfo", userInfo);
		//session.setAttribute("userInfo", userInfo);
		mv.setViewName("user/userprivateinfo");
		return mv;
	}
}
