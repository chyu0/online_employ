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


	public Integer getJobCount(Job job) {
		return jobMapper.getJobCount(job);
	}


	public Job getJobByJobId(Integer jobId) {
		return jobMapper.getJobByJobId(jobId);
	}


	public void changeJobStatus(Job job) {
		job.setJobStatus((job.getJobStatus()+1)%2);
		jobMapper.changeJobStatus(job);
	}


	public void deleteJob(Integer jobId) {
		jobMapper.deleteJob(jobId);
	}


	public void saveOrUpdateJob(Job job) {
		if(job.getJobId()!=null){
			jobMapper.updateJob(job);
		}else{
			jobMapper.saveJob(job);
		}
	}

	public void pulishAgain(Integer jobId) {
		jobMapper.pulishAgain(jobId);
	}

	public List<Job> getList() {
		return jobMapper.getList();
	}
	
}
