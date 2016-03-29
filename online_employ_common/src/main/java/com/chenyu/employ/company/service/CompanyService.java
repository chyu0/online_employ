package com.chenyu.employ.company.service;

import com.chenyu.employ.company.model.Company;

public interface CompanyService {
	public Company isExistLoginName(String loginName);
    public Company findCompanyById(Integer id);
    public void register(Company company);
    public Company getCompanyByNameAndPasd(Company company);
    public void modifyPassword(Company company);
    public void changeStatus(Company company);
}
