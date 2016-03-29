package com.chenyu.employ.job.dao;

import java.util.List;

import com.chenyu.employ.job.dto.JobDto;
import com.chenyu.employ.job.model.Job;

public interface JobMapper {
    
    public List<Job> getJobList(JobDto jobDto);
    
    int deleteByPrimaryKey(Integer jobId);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer jobId);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}