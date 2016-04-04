package com.chenyu.employ.resume.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenyu.employ.resume.dao.ResumeMapper;
import com.chenyu.employ.resume.dto.ResumeDto;
import com.chenyu.employ.resume.model.Resume;
import com.chenyu.employ.resume.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {
	
	@Resource
	private ResumeMapper resumeMapper;
	
	public List<Resume> getResumePaginList(ResumeDto resumeDto) {
		return resumeMapper.getResumePaginList(resumeDto);
	}

	public Resume getResumeByResumeId(Integer resumeId) {
		return resumeMapper.getResumeByResumeId(resumeId);
	}

	public List<Resume> getResumeList(){
		return resumeMapper.getResumeList();
	}
}
