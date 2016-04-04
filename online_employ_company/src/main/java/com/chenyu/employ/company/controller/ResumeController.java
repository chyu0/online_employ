package com.chenyu.employ.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenyu.employ.resume.dto.ResumeDto;
import com.chenyu.employ.resume.service.ResumeService;

@Controller
@RequestMapping("/resume")
public class ResumeController {
	@Autowired
	private ResumeService resumeService;
	
	public String resumeList(HttpServletRequest request,ModelMap map,ResumeDto resumeDto){
		
		return "/resume/resume_list";
	}
}
