package com.chenyu.employ.user.service.impl;


import org.springframework.stereotype.Service;

import com.chenyu.employ.user.dao.UserDetailMapper;
import com.chenyu.employ.user.model.UserDetail;
import com.chenyu.employ.user.service.UserDetailService;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService{

    private UserDetailMapper userDetailMapper;

	public UserDetail getUserDetailById(Integer id) {
		return userDetailMapper.getUserDetailById(id);
	}

	public UserDetail getUserDetailByUserId(Integer userId) {
		return userDetailMapper.getUserDetailByUserId(userId);
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
    
    

}
