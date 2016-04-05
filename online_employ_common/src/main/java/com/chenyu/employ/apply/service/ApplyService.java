package com.chenyu.employ.apply.service;

import java.util.List;

import com.chenyu.employ.apply.dto.ApplyDto;
import com.chenyu.employ.apply.model.Apply;

public interface ApplyService {
	public List<Apply> getApplyListByJobId(ApplyDto applyDto);
	public List<Apply> getApplyList();
	public Integer getApplyCount(Apply apply);
	public void changeApplyStatus(Apply apply);
}
