package com.chenyu.employ.job.service;

import java.util.List;

import com.chenyu.employ.job.dto.JobDto;
import com.chenyu.employ.job.model.Job;

public interface JobService {
	public List<Job> getJobList(JobDto jobDto);
	
	public Integer getJobCount(Job job);
	
	public Job getJobByJobId(Integer jobId);
	
	public void changeJobStatus(Job job);
	
	public void deleteJob(Integer jobId);
    
	public void saveOrUpdateJob(Job job);
	
	public void pulishAgain(Integer id);
}
