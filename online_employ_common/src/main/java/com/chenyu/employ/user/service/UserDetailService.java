package com.chenyu.employ.user.service;

import com.chenyu.employ.user.model.UserDetail;

public interface UserDetailService {
	public UserDetail getUserDetailById(Integer id);
	public UserDetail getUserDetailByUserId(Integer userId);
	public void saveOrUpdate(UserDetail userDetail);
	public Integer getUserDetailCount(UserDetail userDetail);
}
