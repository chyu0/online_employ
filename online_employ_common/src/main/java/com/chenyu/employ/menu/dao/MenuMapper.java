package com.chenyu.employ.menu.dao;

import java.util.List;

import com.chenyu.employ.menu.model.Menu;

public interface MenuMapper {
	public List<Menu> getMenuListByType(Integer menuType);
	public Menu getMenuByUri(String uri);
	public Menu getMenuByParent(Integer parentId);
	public Menu getMenuById(Integer id);
}
