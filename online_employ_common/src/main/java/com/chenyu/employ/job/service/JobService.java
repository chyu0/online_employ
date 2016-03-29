package com.chenyu.employ.job.service;

import java.util.List;

import com.chenyu.employ.job.dto.JobDto;
import com.chenyu.employ.job.model.Job;

public interface JobService {
	public List<Job> getJobList(JobDto jobDto);
    
}
