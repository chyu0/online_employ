package com.chenyu.employ.user.dao;

import com.chenyu.employ.user.model.UserDetail;

public interface UserDetailMapper {
    public Integer getUserDetailCount(UserDetail userDetail);

    public UserDetail getUserDetailById(Integer id);

    public void saveUserDetail(UserDetail record);

    public void updateUserDetail(UserDetail record);
    
    public UserDetail getUserDetailByUserId(Integer userId);
}