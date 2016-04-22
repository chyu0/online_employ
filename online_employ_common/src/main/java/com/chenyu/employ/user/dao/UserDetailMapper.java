package com.chenyu.employ.user.dao;

import java.util.List;

import com.chenyu.employ.user.dto.UserDetailDto;
import com.chenyu.employ.user.model.User;
import com.chenyu.employ.user.model.UserDetail;

public interface UserDetailMapper {
    public Integer getUserDetailCount(UserDetail userDetail);

    public UserDetail getUserDetailById(Integer id);

    public void saveUserDetail(UserDetail record);

    public void updateUserDetail(UserDetail record);
    
    public List<UserDetail> getUserDetailByUserId(UserDetailDto userDetailDto);
    
    public UserDetail getUserDetailByUser(User user);
}