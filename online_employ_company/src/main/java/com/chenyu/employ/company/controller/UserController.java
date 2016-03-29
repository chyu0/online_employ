package com.chenyu.employ.company.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenyu.employ.user.dto.UserDto;
import com.chenyu.employ.user.model.User;
import com.chenyu.employ.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/userList")
    public String userList(UserDto userDto,HttpServletRequest request,ModelMap map){
    	userDto.setPageNo(0);
    	userDto.setPageSize(10);
        List<User> list=userService.getUserList(userDto);
        System.out.println(list.size());
        for(User user:list){
        	System.out.println(user.getEmail());
        }
        return "index";
    }
}
