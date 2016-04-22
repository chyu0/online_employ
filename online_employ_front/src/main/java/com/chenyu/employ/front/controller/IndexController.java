package com.chenyu.employ.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.employ.common.base.BaseController;
import com.chenyu.employ.common.enums.UserStatus;
import com.chenyu.employ.common.error.EmployAssert;
import com.chenyu.employ.common.error.ErrorType;
import com.chenyu.employ.company.dto.CompanyDetailDto;
import com.chenyu.employ.company.model.CompanyDetail;
import com.chenyu.employ.company.service.CompanyDetailService;
import com.chenyu.employ.front.utils.SessionManager;
import com.chenyu.employ.job.dto.JobDto;
import com.chenyu.employ.job.model.Job;
import com.chenyu.employ.job.service.JobService;
import com.chenyu.employ.user.model.User;
import com.chenyu.employ.user.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyDetailService companyDetailService;
	@Autowired
	private JobService jobService;
	
	@RequestMapping("index")
	public String index(JobDto jobDto,HttpServletRequest request,ModelMap map){
		User user=SessionManager.get(request);
		if(user!=null){
			map.addAttribute("user", user);
		}
		CompanyDetailDto companyDetailDto=new CompanyDetailDto();
		companyDetailDto.setPageSize(5);
		List<CompanyDetail> companyDetailList=companyDetailService.getCompanyDetailList(companyDetailDto);
		map.addAttribute("companyDetailList", companyDetailList);
		List<Job> jobList = jobService.getJobList(jobDto);
		map.addAttribute("jobList",jobList);
		return "index";
	}
	
	
	
	@RequestMapping("login")
	public String login(HttpServletRequest request,ModelMap map){
		User user=SessionManager.get(request);
		if(user!=null){
			return "redirect:/index.jhtml";
		}else{
			return "login";
		}
	}
	
	@ResponseBody
	@RequestMapping("auth")
	public String auth(User user,HttpServletRequest request,ModelMap map){
		User loginUser=userService.getUserByNameAndPasd(user);
		if(loginUser==null){
			System.out.println(jsonFailed(ErrorType.SYSTEM_USER_LOGIN_PWD_INVALID));
			return jsonFailed(ErrorType.SYSTEM_USER_LOGIN_PWD_INVALID);
		}
		if(loginUser.getUserStatus().equals(UserStatus.lock.getFlag())){
			return jsonFailed(ErrorType.SYSTEM_USER_STATE_LOCK);
		}
		SessionManager.put(loginUser, request);
		return jsonSuccess();
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request,ModelMap map){
		User user=SessionManager.get(request);
		EmployAssert.notNull(user, ErrorType.SYSTEM_BUSY);
		SessionManager.clear(request);
		return "login";
	}
}
