package com.chenyu.employ.user.service.impl;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.chenyu.employ.common.enums.UserStatus;
import com.chenyu.employ.user.dao.UserMapper;
import com.chenyu.employ.user.dto.UserDto;
import com.chenyu.employ.user.model.User;
import com.chenyu.employ.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
    private UserMapper userMapper;
    
    public void register(User user) {
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setStatus(UserStatus.active.getFlag());
        userMapper.register(user);
    }

    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    public void changeUserStatus(UserDto user) {
        user.setStatus((user.getStatus()+1)%2);
        userMapper.changeUserStatus(user);
    }

    public List<User> getUserList(UserDto user) {
        return userMapper.getUserList(user);
    }
}
