package com.chenyu.employ.job.service.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.chenyu.employ.job.dao.JobMapper;
import com.chenyu.employ.job.dto.JobDto;
import com.chenyu.employ.job.model.Job;
import com.chenyu.employ.job.service.JobService;

@Service
public class JobServiceImpl implements JobService{

	@Resource
    private JobMapper jobMapper;
    

	public List<Job> getJobList(JobDto jobDto){
		return jobMapper.getJobList(jobDto);
	}
	
}
