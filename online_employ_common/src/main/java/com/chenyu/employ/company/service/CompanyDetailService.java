package com.chenyu.employ.company.service;

import java.util.List;

import com.chenyu.employ.company.dto.CompanyDetailDto;
import com.chenyu.employ.company.model.Company;
import com.chenyu.employ.company.model.CompanyDetail;

public interface CompanyDetailService {
	public List<CompanyDetail> getCompanyDetailByCompanyId(CompanyDetailDto dto);
	public CompanyDetail getCompanyDetailById(Integer id);
	public void save(CompanyDetail companyDetail);
    public void update(CompanyDetail companyDetail);
    public Integer getCompanyDetailCount(CompanyDetail companyDetail);
    public void changeWeight(CompanyDetail companyDetail);
    public CompanyDetail getCompanyDetailByCompany(Company company);
}
