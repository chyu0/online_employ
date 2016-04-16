package com.chenyu.employ.menu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenyu.employ.menu.dao.MenuMapper;
import com.chenyu.employ.menu.model.Menu;
import com.chenyu.employ.menu.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuMapper menuMapper;
	
	public List<Menu> getMenuListByType(Integer menuType) {
		return menuMapper.getMenuListByType(menuType);
	}

	public Menu getRootMenuByUri(String uri) {
		Menu menu=menuMapper.getMenuByUri(uri);
		while(menu.getMenuType()!=0){
			menu=menuMapper.getMenuById(menu.getMenuParent());
		}
		return menu;
	}

	public Menu getMenuByUri(String uri) {
		return menuMapper.getMenuByUri(uri);
	}

	public Menu getMenuByParent(Integer parent) {
		return menuMapper.getMenuByParent(parent);
	}

	public Menu getMenuById(Integer id) {
		return menuMapper.getMenuById(id);
	}
}
