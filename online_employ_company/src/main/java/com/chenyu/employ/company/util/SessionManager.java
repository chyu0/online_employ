package com.chenyu.employ.company.util;

import javax.servlet.http.HttpServletRequest;

import com.chenyu.employ.company.model.Company;


public class SessionManager {
    public static Company get(HttpServletRequest request) {
        return (Company) request.getSession().getAttribute("Company");
    }

    public static void put(Company company, HttpServletRequest request) {
        request.getSession().setAttribute("Company", company);
    }

    public static void clear(HttpServletRequest request) {
        request.getSession().removeAttribute("Company");
    }
}
