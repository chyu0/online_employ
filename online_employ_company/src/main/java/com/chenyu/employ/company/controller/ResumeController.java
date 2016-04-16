package com.chenyu.employ.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenyu.employ.common.error.EmployAssert;
import com.chenyu.employ.common.error.ErrorType;
import com.chenyu.employ.resume.model.Resume;
import com.chenyu.employ.resume.service.ResumeService;

@Controller
@RequestMapping("/resume")
public class ResumeController {
	@Autowired
	private ResumeService resumeService;
	
	@RequestMapping("/toSeeResume")
	public String toSeeResume(HttpServletRequest request,ModelMap map,Integer resumeId){
		EmployAssert.notNull(resumeId, ErrorType.PARAM_EMPTY);
		Resume resume=resumeService.getResumeByResumeId(resumeId);
		map.addAttribute("resume",resume);
		return "/resume/resume_detail";
	}
}
