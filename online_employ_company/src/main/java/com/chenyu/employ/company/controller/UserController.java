package com.chenyu.employ.company.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.employ.common.base.BaseController;
import com.chenyu.employ.common.error.ErrorType;
import com.chenyu.employ.common.utils.PaginationUtil;
import com.chenyu.employ.user.dto.UserDetailDto;
import com.chenyu.employ.user.model.User;
import com.chenyu.employ.user.model.UserDetail;
import com.chenyu.employ.user.service.UserDetailService;
import com.chenyu.employ.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{
    
    @Autowired
    private UserDetailService userDetailService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/userList")
    public String userList(UserDetailDto userDetailDto,HttpServletRequest request,ModelMap map){
    	List<UserDetail> userList=userDetailService.getUserDetailByUserId(userDetailDto);
    	PaginationUtil<UserDetail> page=new PaginationUtil<UserDetail>(userDetailDto.getPageNo(),userDetailDto.getPageSize());
		page.setItems(userList);
		page.setTotalCount(userDetailService.getUserDetailCount(userDetailDto));
		map.addAttribute("page",page);
		map.addAttribute("requestUrl",request.getRequestURL().toString());
        return "/user/user_list";
    }
    
    @ResponseBody
    @RequestMapping("/lockOrActiveUser")
    public String lockOrActiveUser(User user,HttpServletRequest request,ModelMap map){
    	if(user.getUserStatus()>=2){
    		return jsonFailed(ErrorType.PARAMS_ERROR);
    	}
    	userService.lockOrActiveUser(user);
    	return jsonSuccess();
    }
    
    @RequestMapping("/toEdit")
    public String toEdit(Integer userDetailId,HttpServletRequest request,ModelMap map){
    	UserDetail userInfo=userDetailService.getUserDetailById(userDetailId);
    	User user=userService.findUserById(userInfo.getUser().getUserId());
    	userInfo.setUser(user);
    	map.addAttribute("userDetail",userInfo);
    	return "/user/user_edit";
    }
}
