package com.chenyu.employ.apply.model;

import java.sql.Timestamp;

public class Apply {
    private Integer applyId;
    private Integer jobId;
    private Integer resumeId;
    private Timestamp applyTime;
    private Integer applyStatus;
    private String applyMessage;
	public Integer getApplyId() {
		return applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getResumeId() {
		return resumeId;
	}
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
	public Timestamp getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}
	public Integer getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getApplyMessage() {
		return applyMessage;
	}
	public void setApplyMessage(String applyMessage) {
		this.applyMessage = applyMessage;
	}
    
    
}