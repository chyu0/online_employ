package com.chenyu.employ.apply.dto;

import java.util.List;

import com.chenyu.employ.apply.model.Apply;
import com.chenyu.employ.job.model.Job;

public class ApplyDto extends Apply{
    /**
     * 页码
     */
    private Integer pageNo=1;
    /**
     * 分页大小
     */
    private int pageSize=10;
    
    /**
     * 分页开始位置
     */
    private int offset=(pageNo-1)*pageSize;
    
    private List<Job> jobList;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getOffset() {
    	offset=(pageNo-1)*pageSize;
        return offset;
    }
    
    public void setOffest(Integer offset){
    	this.offset=offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}

}
