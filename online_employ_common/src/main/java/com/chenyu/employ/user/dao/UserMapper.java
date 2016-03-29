package com.chenyu.employ.user.dao;

import java.util.List;

import com.chenyu.employ.user.dto.UserDto;
import com.chenyu.employ.user.model.User;

public interface UserMapper {
    public void register(User user);

    public User findUserById(Integer id);

    public void changeUserStatus(UserDto user);
    
    public List<User> getUserList(UserDto user);
}