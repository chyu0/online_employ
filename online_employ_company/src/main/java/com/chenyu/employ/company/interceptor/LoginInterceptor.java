package com.chenyu.employ.company.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.chenyu.employ.company.model.Company;
import com.chenyu.employ.company.util.SessionManager;

public class LoginInterceptor implements HandlerInterceptor {

	private static final String[] IGNORE_URI = {"/login.jhtml", "/logout.jhtml", "/auth.jhtml"};
	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handle, Exception e)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handle, ModelAndView model) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handle) throws Exception {
        String url = request.getRequestURL().toString();
        
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                return true;
            }
        }
        //非登陆和登出的url，就获取session 
        Company company = SessionManager.get(request);
        if (company != null) {
           return true;
        }
            
        response.sendRedirect("/login.jhtml");
        return false;
	}

}
