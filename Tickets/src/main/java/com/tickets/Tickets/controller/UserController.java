package com.tickets.Tickets.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tickets.Tickets.entity.User;
import com.tickets.Tickets.service.UserService;

@Controller
public class UserController {
	public UserController() {
	}
	
	
	@Autowired
	private UserService userService;
	
	//打印日志
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	
	@RequestMapping(value="/user/")
	public ModelAndView index(
			 ModelAndView mv,
			 HttpSession session){
		logger.info("index方法 被调用");
		mv.setViewName("user/indexV");
		return mv;
	}
	

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
}
