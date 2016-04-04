package com.chenyu.employ.resume.dao;

import java.util.List;

import com.chenyu.employ.resume.dto.ResumeDto;
import com.chenyu.employ.resume.model.Resume;

public interface ResumeMapper {
    public List<Resume> getResumeList();
    
    public Resume getResumeByResumeId(Integer resumeId);
    
    public List<Resume> getResumePaginList(ResumeDto resumeDto);
}