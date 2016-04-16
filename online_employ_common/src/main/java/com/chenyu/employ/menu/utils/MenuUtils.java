package com.chenyu.employ.menu.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.chenyu.employ.menu.model.Menu;

public class MenuUtils {
	public static Map<Menu,List<Menu>> getMenuMap(List<Menu> menuParent,List<Menu> menuChild){
		Map<Menu,List<Menu>> menuMap=new LinkedHashMap<Menu,List<Menu>>();
		for(Menu menuP:menuParent){
			for(Menu menuC:menuChild){
				List<Menu> list=menuMap.get(menuP);
				if(list==null){
					list=new ArrayList<Menu>();
				}
				if(menuP.getMenuId().equals(menuC.getMenuParent())){
					list.add(menuC);
				}
				menuMap.put(menuP, list);
			}
		}
		return menuMap;
	}
}
