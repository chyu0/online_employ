package com.chenyu.employ.menu.model;

public class Menu {
	private Integer menuId;
	private Integer menuType;
	private String menuUri;
	private String menuName;
	private Integer menuParent;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	public String getMenuUri() {
		return menuUri;
	}
	public void setMenuUri(String menuUri) {
		this.menuUri = menuUri;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getMenuParent() {
		return menuParent;
	}
	public void setMenuParent(Integer menuParent) {
		this.menuParent = menuParent;
	}
	
}
