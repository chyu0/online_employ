package com.chenyu.employ.user.service;

import java.util.List;

import com.chenyu.employ.user.dto.UserDetailDto;
import com.chenyu.employ.user.model.User;
import com.chenyu.employ.user.model.UserDetail;

public interface UserDetailService {
	public UserDetail getUserDetailById(Integer id);
	public List<UserDetail> getUserDetailByUserId(UserDetailDto userDetailDto);
	public void saveOrUpdate(UserDetail userDetail);
	public Integer getUserDetailCount(UserDetail userDetail);
	public UserDetail getUserDetailByUser(User user);
}
