package com.chenyu.employ.resume.model;

import java.sql.Timestamp;

import com.chenyu.employ.user.model.UserDetail;

public class Resume {
    private Integer resumeId;

    private UserDetail userDetail;

    private String userPicture;

    private String education;

    private String workExperience;

    private String workLife;

    private String condition;

    private String collegeExperience;

    private String language;

    private String trainExperience;
    
    private String evaluation;
    
    private Timestamp resumeUpdateTime;
    
    private Timestamp resumeCreateTime;

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience == null ? null : workExperience.trim();
    }

    public String getWorkLife() {
        return workLife;
    }

    public void setWorkLife(String workLife) {
        this.workLife = workLife == null ? null : workLife.trim();
    }

    public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public Timestamp getResumeUpdateTime() {
		return resumeUpdateTime;
	}

	public void setResumeUpdateTime(Timestamp resumeUpdateTime) {
		this.resumeUpdateTime = resumeUpdateTime;
	}

	public Timestamp getResumeCreateTime() {
		return resumeCreateTime;
	}

	public void setResumeCreateTime(Timestamp resumeCreateTime) {
		this.resumeCreateTime = resumeCreateTime;
	}

	public String getCollegeExperience() {
        return collegeExperience;
    }

    public void setCollegeExperience(String collegeExperience) {
        this.collegeExperience = collegeExperience == null ? null : collegeExperience.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getTrainExperience() {
        return trainExperience;
    }

    public void setTrainExperience(String trainExperience) {
        this.trainExperience = trainExperience == null ? null : trainExperience.trim();
    }
}