package com.chenyu.employ.user.dao;

import com.chenyu.employ.user.model.UserDetail;

public interface UserDetailMapper {
    public void clearUserDetail(Integer id);

    public UserDetail getUserDetailById(Integer id);

    public void addUserDetail(UserDetail record);

    public void updateUserDetail(UserDetail record);
}