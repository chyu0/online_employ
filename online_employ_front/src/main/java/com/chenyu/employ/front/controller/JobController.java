package com.chenyu.employ.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenyu.employ.common.base.BaseController;
import com.chenyu.employ.common.utils.PaginationUtil;
import com.chenyu.employ.job.dto.JobDto;
import com.chenyu.employ.job.model.Job;
import com.chenyu.employ.job.service.JobService;

@Controller
@RequestMapping("/job")
public class JobController extends BaseController{
	@Autowired
	private JobService jobService;
	
	@RequestMapping("/jobList")
	public String jobList(HttpServletRequest request,ModelMap map,JobDto jobDto){
		List<Job> jobList = jobService.getJobList(jobDto);
		PaginationUtil<Job> page=new PaginationUtil<Job>(jobDto.getPageNo(),jobDto.getPageSize());
		page.setItems(jobList);
		page.setTotalCount(jobService.getJobCount(jobDto));
		map.addAttribute("page",page);
		map.addAttribute("requestUrl",request.getRequestURL().toString());
		map.addAttribute("jobDto", jobDto);
		return "/job/job_list";
	}
}
