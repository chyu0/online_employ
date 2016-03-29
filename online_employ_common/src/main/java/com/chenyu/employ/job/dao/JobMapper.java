package com.chenyu.employ.job.dao;

import java.util.List;

import com.chenyu.employ.job.dto.JobDto;
import com.chenyu.employ.job.model.Job;

public interface JobMapper {
    
    public List<Job> getJobList(JobDto jobDto);
    
    public Integer getJobCount(Job job);
    
    public Job getJobByJobId(Integer jobId);
    
    public void changeJobStatus(Job job);
    
    public void deleteJob(Integer jobId);
    
    public void updateJob(Job job);
    
    public void saveJob(Job job);
    
    public void pulishAgain(Integer jobId);
}