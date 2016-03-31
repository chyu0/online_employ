package com.chenyu.employ.user.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.chenyu.employ.common.enums.UserStatus;
import com.chenyu.employ.user.dao.UserMapper;
import com.chenyu.employ.user.model.User;
import com.chenyu.employ.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
    private UserMapper userMapper;

	public void register(User user) {
		userMapper.register(user);
	}

	public User findUserById(Integer id) {
		return userMapper.findUserById(id);
	}

	public boolean isExistLoginName(String loginName) {
		if(userMapper.isExistLoginName(loginName)!=null){
			return true;
		}
		return false;
	}

	public void lockOrActiveUser(User user) {
		user.setUserStatus((user.getUserStatus()+1)%2);
		userMapper.changeStatus(user);
	}

	public void modifyPassword(User user) {
		userMapper.modifyPassword(user);
	}

	public User getUserByNameAndPasd(User user) {
		return userMapper.getUserByNameAndPasd(user);
	}

	
}
