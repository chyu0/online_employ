package com.chenyu.employ.user.dao;

import com.chenyu.employ.user.model.User;

public interface UserMapper {
    public void register(User user);

    public User findUserById(Integer id);

    public void changeStatus(User user);
    
    public User isExistLoginName(String loginName);
    
    public User getUserByNameAndPasd(User user);
    
    public void modifyPassword(User user);
    
}