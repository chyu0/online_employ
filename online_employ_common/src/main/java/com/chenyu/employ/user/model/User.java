package com.chenyu.employ.user.model;

import java.sql.Timestamp;

public class User {
    private Integer userId;

    private String userLoginName;

    private String userPassword;

    private Integer userStatus;

    private Timestamp userCreateTime;
    
    private Timestamp userUpdateTime;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Timestamp getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(Timestamp userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public Timestamp getUserUpdateTime() {
		return userUpdateTime;
	}

	public void setUserUpdateTime(Timestamp userUpdateTime) {
		this.userUpdateTime = userUpdateTime;
	}

    
    
}