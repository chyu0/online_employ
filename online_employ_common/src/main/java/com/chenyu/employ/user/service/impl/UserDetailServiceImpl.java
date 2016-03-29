package com.chenyu.employ.user.service.impl;


import org.springframework.stereotype.Service;

import com.chenyu.employ.user.dao.UserDetailMapper;
import com.chenyu.employ.user.model.UserDetail;
import com.chenyu.employ.user.service.UserDetailService;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService{

    private UserDetailMapper userDetailMapper;
    
    public void clearUserDetail(Integer id) {
        userDetailMapper.clearUserDetail(id);
    }

    public UserDetail getUserDetailById(Integer id) {
        return userDetailMapper.getUserDetailById(id);
    }

    public void addUserDetail(UserDetail record) {
        userDetailMapper.addUserDetail(record);
    }

    public void updateUserDetail(UserDetail record) {
        userDetailMapper.updateUserDetail(record);
    }

}
