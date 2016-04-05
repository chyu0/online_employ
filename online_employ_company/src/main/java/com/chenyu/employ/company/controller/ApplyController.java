package com.chenyu.employ.company.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.employ.apply.dto.ApplyDto;
import com.chenyu.employ.apply.model.Apply;
import com.chenyu.employ.apply.service.ApplyService;
import com.chenyu.employ.apply.utils.ApplyUtils;
import com.chenyu.employ.common.base.BaseController;
import com.chenyu.employ.common.utils.PaginationUtil;
import com.chenyu.employ.company.model.Company;
import com.chenyu.employ.company.service.CompanyDetailService;
import com.chenyu.employ.company.util.SessionManager;
import com.chenyu.employ.job.dto.JobDto;
import com.chenyu.employ.job.model.Job;
import com.chenyu.employ.job.service.JobService;
import com.chenyu.employ.resume.model.Resume;
import com.chenyu.employ.resume.service.ResumeService;

@Controller
@RequestMapping("/apply")
public class ApplyController extends BaseController{
	
	@Autowired
	private ApplyService applyService;
	
	@Autowired
	private ResumeService resumeService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private CompanyDetailService companyDetailService;
	
	@RequestMapping("/applyList")
	public String applyList(HttpServletRequest request,ModelMap map,ApplyDto applyDto){
		Company company = SessionManager.get(request);
		JobDto job=new JobDto();
		job.setPageSize(0);//pageSize=0不分页
		job.setCompanyDetail(companyDetailService.getCompanyDetailByCompany(company));
		List<Job> jobList = jobService.getJobList(job);//获取当前用户中的企业列表
		applyDto.setJobList(jobList);
		List<Apply> applyList=applyService.getApplyListByJobId(applyDto);//jobId必须在jobList以内
		PaginationUtil<Apply> page=new PaginationUtil<Apply>(applyDto.getPageNo(),applyDto.getPageSize());
		page.setItems(applyList);
		page.setTotalCount(applyService.getApplyCount(applyDto));
		map.addAttribute("page",page);
		map.addAttribute("requestUrl",request.getRequestURL().toString());
		List<Resume> resumeList=resumeService.getResumeList();
		Map<Integer,Resume> resumeMap=ApplyUtils.getResumeByApplyId(applyList, resumeList);
		map.addAttribute("resumeMap",resumeMap);//申请id，简历
		Map<Integer,Job> jobMap=ApplyUtils.getJobByApplyId(applyList, jobList);
		map.addAttribute("jobMap", jobMap);//申请id，工作
		return "/apply/apply_list";
	}
	
	@RequestMapping("/changeStatus")
	@ResponseBody
	public String changeStatus(HttpServletRequest request,ModelMap map,Apply apply){
		applyService.changeApplyStatus(apply);
		return jsonSuccess();
	}
}
