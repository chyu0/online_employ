package com.chenyu.employ.company.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenyu.employ.company.dao.CompanyMapper;
import com.chenyu.employ.company.model.Company;
import com.chenyu.employ.company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Resource
	private CompanyMapper companyMapper;

	public void register(Company company) {
		companyMapper.register(company);
	}

	public Company getCompanyByNameAndPasd(Company company) {
		return companyMapper.getCompanyByNameAndPasd(company);
	}

	public Company findCompanyById(Integer id) {
		return companyMapper.findCompanyById(id);
	}

	public void modifyPassword(Company company) {
		companyMapper.modifyPassword(company);
	}

	public Company isExistLoginName(String loginName) {
		return companyMapper.isExistLoginName(loginName);
	}

	public void changeStatus(Company company) {
		companyMapper.changeStatus(company);
	}

}
