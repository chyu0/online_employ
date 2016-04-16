package com.chenyu.employ.menu.service;

import java.util.List;


import com.chenyu.employ.menu.model.Menu;

public interface MenuService {
	public List<Menu> getMenuListByType(Integer menuType);
	public Menu getRootMenuByUri(String uri);
	public Menu getMenuByUri(String uri);
	public Menu getMenuByParent(Integer parent);
	public Menu getMenuById(Integer id);
}
