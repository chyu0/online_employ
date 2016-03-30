package com.chenyu.employ.user.service;

import com.chenyu.employ.user.model.User;

public interface UserService {
	
    public void register(User record);

    public User findUserById(Integer id);
    
    public boolean isExistLoginName(String loginName);

    public void lockOrActiveUser(User record);
    
    public void modifyPassword(User user);
    
    public User getUserByNameAndPasd(User user);
}
