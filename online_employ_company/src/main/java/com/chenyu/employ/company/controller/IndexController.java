package com.chenyu.employ.company.controller;


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
import com.chenyu.employ.company.model.Company;
import com.chenyu.employ.company.service.CompanyService;
import com.chenyu.employ.company.util.SessionManager;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("login")
	public String login(HttpServletRequest request,ModelMap map){
		if(SessionManager.get(request)!=null){
			return "redirect:/index.jhtml";
		}else{
			return "login";
		}
	}
	
	@ResponseBody
	@RequestMapping("auth")
	public String auth(Company company,HttpServletRequest request,ModelMap map){
		Company companyInfo=companyService.getCompanyByNameAndPasd(company);
		if(companyInfo==null){
			System.out.println(jsonFailed(ErrorType.SYSTEM_USER_LOGIN_PWD_INVALID));
			return jsonFailed(ErrorType.SYSTEM_USER_LOGIN_PWD_INVALID);
		}
		if(companyInfo.getStatus().equals(UserStatus.lock.getFlag())){
			return jsonFailed(ErrorType.SYSTEM_USER_STATE_LOCK);
		}
		SessionManager.put(companyInfo, request);
		return jsonSuccess();
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request,ModelMap map){
		Company company=SessionManager.get(request);
		EmployAssert.notNull(company, ErrorType.SYSTEM_BUSY);
		SessionManager.clear(request);
		return "login";
	}
}
