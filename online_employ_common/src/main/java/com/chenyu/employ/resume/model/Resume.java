package com.chenyu.employ.resume.model;

public class Resume {
    private Integer resumeId;

    private Integer userId;

    private String individualInfo;

    private String education;

    private String workExperience;

    private String workLife;

    private String field;

    private String collegeExperience;

    private String language;

    private String trainExperience;

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIndividualInfo() {
        return individualInfo;
    }

    public void setIndividualInfo(String individualInfo) {
        this.individualInfo = individualInfo == null ? null : individualInfo.trim();
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
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