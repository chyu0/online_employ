package com.chenyu.employ.company.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenyu.employ.common.base.BaseController;
import com.chenyu.employ.company.model.Company;
import com.chenyu.employ.company.model.CompanyDetail;
import com.chenyu.employ.company.service.CompanyDetailService;
import com.chenyu.employ.company.util.SessionManager;
import com.chenyu.employ.job.dto.JobDto;
import com.chenyu.employ.job.model.Job;
import com.chenyu.employ.job.service.JobService;

@Controller
@RequestMapping("/job")
public class JobController extends BaseController {
	@Autowired
	private JobService jobService;
	@Autowired
	private CompanyDetailService companyDetailService;

	@RequestMapping("/jobList")
	public String getJobList(JobDto jobDto, HttpServletRequest request,
			ModelMap map) {
		Company company = SessionManager.get(request);
		CompanyDetail companyDetail = new CompanyDetail();
		companyDetail.setCompany(company);
		jobDto.setCompanyDetail(companyDetail);
		List<Job> jobList = jobService.getJobList(jobDto);
		map.addAttribute("jobList", jobList);
		return "jobList";
	}

}
