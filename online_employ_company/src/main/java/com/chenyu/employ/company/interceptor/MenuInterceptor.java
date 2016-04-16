package com.chenyu.employ.company.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.chenyu.employ.menu.model.Menu;
import com.chenyu.employ.menu.service.MenuService;
import com.chenyu.employ.menu.utils.MenuUtils;

public class MenuInterceptor implements HandlerInterceptor{
	
	@Autowired
	private MenuService menuService;
	
	private static final String[] IGNORE_URI = {"login.jhtml", "logout.jhtml", "auth.jhtml"};

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String uri=request.getRequestURI();
		for (String s : IGNORE_URI) {
            if (uri.contains(s)) {
                return ;
            }
        }
		Menu menu = menuService.getMenuByUri(uri);
		if(menu.getMenuType()==3&&menu.getMenuParent()!=0){
			menu=menuService.getMenuById(menu.getMenuParent());
		}
		modelAndView.addObject("menu", menu);
		Menu rootMenu = menuService.getRootMenuByUri(uri);
		modelAndView.addObject("rootMenu", rootMenu);
		List<Menu> rootMenuList=menuService.getMenuListByType(0);
		List<Menu> childMenuList=menuService.getMenuListByType(1);
		Map<Menu,List<Menu>> menuMap=MenuUtils.getMenuMap(rootMenuList, childMenuList);
		modelAndView.addObject("menuMap", menuMap);
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
