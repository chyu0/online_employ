package com.chenyu.employ.company.dao;

import java.util.List;

import com.chenyu.employ.company.dto.CompanyDetailDto;
import com.chenyu.employ.company.model.CompanyDetail;

public interface CompanyDetailMapper {
    public List<CompanyDetail> getCompanyDetailByCompanyId(CompanyDetailDto dto);
    public CompanyDetail getCompanyDetailById(Integer id);
    public void save(CompanyDetail companyDetail);
    public void update(CompanyDetail companyDetail);
    public Integer getCompanyDetailCount(CompanyDetail detail);
    public void changeWeight(CompanyDetail companyDetail);
}