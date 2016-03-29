package com.chenyu.employ.company.dao;

import com.chenyu.employ.company.model.Company;

public interface CompanyMapper {
	public Company isExistLoginName(String loginName);
    public Company findCompanyById(Integer id);
    public void register(Company company);
    public Company getCompanyByNameAndPasd(Company company);
    public void modifyPassword(Company company);
    public void changeStatus(Company company);
}