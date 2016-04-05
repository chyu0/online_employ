package com.chenyu.employ.company.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.employ.apply.model.Apply;
import com.chenyu.employ.apply.service.ApplyService;
import com.chenyu.employ.apply.utils.ApplyUtils;
import com.chenyu.employ.common.base.BaseController;
import com.chenyu.employ.common.error.EmployAssert;
import com.chenyu.employ.common.error.ErrorType;
import com.chenyu.employ.common.utils.PaginationUtil;
import com.chenyu.employ.company.dto.CompanyDetailDto;
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
	@Autowired
	private ApplyService applyService;

	@RequestMapping("/jobList")
	public String getJobList(JobDto jobDto, HttpServletRequest request, ModelMap map) {
		Company company = SessionManager.get(request);
		CompanyDetail companyDetail = new CompanyDetail();
		companyDetail.setCompany(company);
		jobDto.setCompanyDetail(companyDetail);
		List<Job> jobList = jobService.getJobList(jobDto);
		PaginationUtil<Job> page=new PaginationUtil<Job>(jobDto.getPageNo(),jobDto.getPageSize());
		page.setItems(jobList);
		page.setTotalCount(jobService.getJobCount(jobDto));
		map.addAttribute("page",page);
		map.addAttribute("requestUrl",request.getRequestURL().toString());
		map.addAttribute("company", company);
		List<Apply> applyList=applyService.getApplyList();
		Map<Integer,List<Apply>> applyMap=ApplyUtils.getApplyListByJobId(applyList);
		map.addAttribute("applyMap",applyMap);//获取申请人数
		return "/job/job_list";
	}

	@RequestMapping("/toEdit")
	public String toEdit(HttpServletRequest request, ModelMap map,Integer jobId){
		Company company = SessionManager.get(request);
		Job job=jobService.getJobByJobId(jobId);
		map.addAttribute("job",job);
		map.addAttribute("company", company);
		if(jobId==null) {
			map.addAttribute("companyDetail", companyDetailService.getCompanyDetailByCompany(company));
		}
		return "/job/job_edit";
	}
	
	@ResponseBody
	@RequestMapping("/changeJobStatus")
	public String changeJobStatus(HttpServletRequest request, ModelMap map,Job job){
		Company company = SessionManager.get(request);
		if(!StringUtils.isBlank(company.getCompanyName())){
			return jsonFailed(ErrorType.SYSTEM_FORBIDDEN);
		}
		if(job.getJobStatus()>1){
			return jsonFailed(ErrorType.SYSTEM_BUSY);
		}
		jobService.changeJobStatus(job);
		return jsonSuccess();
	}
	
	@ResponseBody
	@RequestMapping("/deleteJob")
	public String deleteJob(HttpServletRequest request, ModelMap map,Integer jobId){
		EmployAssert.notNull(jobId, ErrorType.PARAM_EMPTY);
		jobService.deleteJob(jobId);
		return jsonSuccess();
	}
	
	@RequestMapping("/saveOrUpdateJob")
	public String saveOrUpdateJob(HttpServletRequest request, ModelMap map,Job job){
		Company company = SessionManager.get(request);
		EmployAssert.notBlank(company.getCompanyName(), ErrorType.SYSTEM_FORBIDDEN);
		if(job.getJobId()==null){
			CompanyDetailDto companyDetail=new CompanyDetailDto();
			companyDetail.setCompany(company);
			job.setCompanyDetail(companyDetailService.getCompanyDetailByCompanyId(companyDetail).get(0));
		}
		jobService.saveOrUpdateJob(job);
		return "redirect:jobList.jhtml";
	}
	
	@ResponseBody
	@RequestMapping("/publishAgain")
	public String publishAgain(HttpServletRequest request, ModelMap map,Integer jobId){
		EmployAssert.notNull(jobId, ErrorType.PARAM_EMPTY);
		jobService.pulishAgain(jobId);
		return jsonSuccess();
	}
}
