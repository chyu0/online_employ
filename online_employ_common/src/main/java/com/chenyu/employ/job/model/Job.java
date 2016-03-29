package com.chenyu.employ.job.model;

import java.sql.Timestamp;

import com.chenyu.employ.company.model.CompanyDetail;

public class Job {
    private Integer jobId;

    private CompanyDetail companyDetail;

    private Integer jobField;

    private String jobName;

    private Integer experience;
    
    private String jobProvince;
    
    private String jobCity;
    
    private String jobDist;

    private String jobAddress;

    private String number;

    private Integer salary;

    private Timestamp publishTime;

    private String request;
    
    private String description;
    
    private Timestamp jobUpdateTime;

    private Integer jobStatus;
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    
    public CompanyDetail getCompanyDetail() {
		return companyDetail;
	}

	public void setCompanyDetail(CompanyDetail companyDetail) {
		this.companyDetail = companyDetail;
	}

    public Integer getJobField() {
		return jobField;
	}

	public void setJobField(Integer jobField) {
		this.jobField = jobField;
	}

	public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getJobProvince() {
		return jobProvince;
	}

	public void setJobProvince(String jobProvince) {
		this.jobProvince = jobProvince;
	}

	public String getJobCity() {
		return jobCity;
	}

	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}

	public String getJobDist() {
		return jobDist;
	}

	public void setJobDist(String jobDist) {
		this.jobDist = jobDist;
	}

	public String getJobAddress() {
		return jobAddress;
	}

	public void setJobAddress(String jobAddress) {
		this.jobAddress = jobAddress;
	}

	public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

	public Timestamp getJobUpdateTime() {
		return jobUpdateTime;
	}

	public void setJobUpdateTime(Timestamp jobUpdateTime) {
		this.jobUpdateTime = jobUpdateTime;
	}

	public Integer getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Integer jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description== null ? null : description.trim();
	}
	
	

}