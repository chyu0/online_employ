package com.chenyu.employ.user.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenyu.employ.user.dao.UserDetailMapper;
import com.chenyu.employ.user.dto.UserDetailDto;
import com.chenyu.employ.user.model.User;
import com.chenyu.employ.user.model.UserDetail;
import com.chenyu.employ.user.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService{

	@Resource
    private UserDetailMapper userDetailMapper;

	public UserDetail getUserDetailById(Integer id) {
		return userDetailMapper.getUserDetailById(id);
	}

	public List<UserDetail> getUserDetailByUserId(UserDetailDto userDetailDto) {
		return userDetailMapper.getUserDetailByUserId(userDetailDto);
	}

	public void saveOrUpdate(UserDetail userDetail) {
		if(userDetail.getUserDetailId()!=null){
			userDetailMapper.saveUserDetail(userDetail);
		}else{
			userDetailMapper.updateUserDetail(userDetail);
		}
	}

	public Integer getUserDetailCount(UserDetail userDetail) {
		return userDetailMapper.getUserDetailCount(userDetail);
	}

	public UserDetail getUserDetailByUser(User user) {
		return userDetailMapper.getUserDetailByUser(user);
	} 

}
