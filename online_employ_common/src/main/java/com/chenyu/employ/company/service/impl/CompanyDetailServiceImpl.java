package com.chenyu.employ.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenyu.employ.company.dao.CompanyDetailMapper;
import com.chenyu.employ.company.dto.CompanyDetailDto;
import com.chenyu.employ.company.model.CompanyDetail;
import com.chenyu.employ.company.service.CompanyDetailService;

@Service
public class CompanyDetailServiceImpl implements CompanyDetailService {

	@Resource
	private CompanyDetailMapper companyDetailMapper;
	
	public List<CompanyDetail> getCompanyDetailByCompanyId(CompanyDetailDto companyDetailDto){
		return companyDetailMapper.getCompanyDetailByCompanyId(companyDetailDto);
	}

	public CompanyDetail getCompanyDetailById(Integer id) {
		return companyDetailMapper.getCompanyDetailById(id);
	}

	public void save(CompanyDetail companyDetail) {
		companyDetailMapper.save(companyDetail);
	}

	public void update(CompanyDetail companyDetail) {
		companyDetailMapper.update(companyDetail);
	}

	public Integer getCompanyDetailCount(CompanyDetail companyDetail) {
		return companyDetailMapper.getCompanyDetailCount(companyDetail);
	}

	public void changeWeight(CompanyDetail companyDetail) {
		companyDetailMapper.changeWeight(companyDetail);
	}
	
	
}
