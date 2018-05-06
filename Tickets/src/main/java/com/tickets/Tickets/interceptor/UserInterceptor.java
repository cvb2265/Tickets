package com.tickets.Tickets.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tickets.Tickets.entity.User;

/**
 * @author tqy
 * @date 2018年5月6日
 * 
 */
public class UserInterceptor implements HandlerInterceptor {

	//打印日志
	private static final Log logger = LogFactory.getLog(UserInterceptor.class);
	
	/**
	 * 定义不需要拦截的URI
	 * 
	 */
	private static final String[] IGNORE_URI = {"/user/", "/user/indexV", "/user/checkEmail"
			, "/user/loginV", "/user/regV", "/user/activation"
			, "/user/login", "/user/reg"
			, "/user/searchplans", "/user/planlistV", "/error"
			};

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
	}

	
	/** 
     * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，
     * 当preHandle的返回值为false的时候整个请求就结束了。 
     * 如果preHandle的返回值为true，则会继续执行postHandle和afterCompletion。
     */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {	
		/** 默认用户没有登录 */
		boolean flag = false; 
		/** 获得请求的ServletPath */
		String uri = request.getServletPath();
		logger.info("preHandle方法 被调用，uri="+uri);
		/**  判断请求是否需要拦截 */
        for (String s : IGNORE_URI) {
            if (uri.equals(s)) {
                flag = true;
                break;
            }
        }
        /** 拦截请求 */
        if (!flag){
        	User user = (User) request.getSession().getAttribute("user");
        	if(user == null){
        		request.setAttribute("msg", "请先登录再访问网站!");
        		request.getRequestDispatcher("/user/loginV").forward(request, response);
        	}else{
        		 flag = true;
        	}
        }
        return flag;
	}
	
}
