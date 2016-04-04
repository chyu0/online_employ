package com.chenyu.employ.resume.service;

import java.util.List;

import com.chenyu.employ.resume.dto.ResumeDto;
import com.chenyu.employ.resume.model.Resume;

public interface ResumeService {
	public List<Resume> getResumePaginList(ResumeDto resumeDto);
	
	public Resume getResumeByResumeId(Integer resumeId);
	
	public List<Resume> getResumeList();
}
