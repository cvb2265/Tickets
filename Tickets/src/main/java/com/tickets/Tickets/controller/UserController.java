package com.tickets.Tickets.controller;

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

import com.tickets.Tickets.entity.User;
import com.tickets.Tickets.service.UserService;

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
	
	//打印日志
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	

	/**********************只负责将请求转发给页面的Controller*****************************/

	//主页
	@RequestMapping(value={"/user/", "/user/indexV"})
	public ModelAndView indexV(
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("indexV控制器 被调用，请求者的地址是"+request.getRemoteAddr());
		mv.setViewName("/user/index");
		return mv;
	}
	@RequestMapping(value="/user/loginV")
	public ModelAndView loginV(
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("loginV控制器 被调用，请求者的地址是"+request.getRemoteAddr());
		mv.setViewName("/user/login");
		return mv;
	}
	@RequestMapping(value="/user/regV")
	public ModelAndView regV(
			 ModelAndView mv,
			 HttpServletRequest request){
		logger.info("regV控制器 被调用，请求者的地址是"+request.getRemoteAddr());
		mv.setViewName("/user/reg");
		return mv;
	}
	
	
	

	
	
	/**************************包含数据处理的Controller*****************************/
	
	/**
	 * 处理/user/login请求，而且只接受post请求
	 * */
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public ModelAndView login(
			 String email,String password,
			 ModelAndView mv,
			 HttpSession session){
		User user = userService.login(email, password);
		logger.info(user);
		logger.info(user);
		logger.info(user);
		mv.setViewName("user/indexV");
		return mv;
	}
	
	
	@RequestMapping(value="/user/checkEmail")
	@ResponseBody
	public Object checkEmail(String email,
			 HttpServletRequest request){
		logger.info("checkEmail控制器 被调用，请求者的地址是"+request.getRemoteAddr());
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
	
}
