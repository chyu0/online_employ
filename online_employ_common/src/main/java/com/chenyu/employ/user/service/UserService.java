package com.chenyu.employ.user.service;

import java.util.List;

import com.chenyu.employ.user.dto.UserDto;
import com.chenyu.employ.user.model.User;

public interface UserService {
    public void register(User record);

    public User findUserById(Integer id);

    public void changeUserStatus(UserDto record);
    
    public List<User> getUserList(UserDto record);
}
