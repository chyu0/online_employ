package com.chenyu.employ.apply.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenyu.employ.apply.dao.ApplyMapper;
import com.chenyu.employ.apply.dto.ApplyDto;
import com.chenyu.employ.apply.model.Apply;
import com.chenyu.employ.apply.service.ApplyService;

@Service
public class ApplyServiceImpl implements ApplyService {

	@Resource
    private ApplyMapper applyMapper;

	public List<Apply> getApplyListByJobId(ApplyDto applyDto){
		return applyMapper.getApplyListByJobId(applyDto);
	}

	public List<Apply> getApplyList() {
		return applyMapper.getApplyList();
	}

	public Integer getApplyCount(Apply apply) {
		return applyMapper.getApplyCount(apply);
	}
	
	public void changeApplyStatus(Apply apply){
		 applyMapper.changeApplyStatus(apply);  
	}
}
