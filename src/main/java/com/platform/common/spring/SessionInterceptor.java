package com.platform.common.spring;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.platform.model.User;

public class SessionInterceptor implements HandlerInterceptor {
	private Logger logger = Logger.getLogger(SessionInterceptor.class.getName()); 
	 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		User user=(User) request.getSession().getAttribute("user"); 
        if(user==null){ 
            logger.log(Level.INFO, "user not login"); 
            response.sendRedirect("newLogin.do"); 
            return false; 
        } 
        //System.out.println(user);
        return true; 
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
