package com.chenyu.employ.common.enums;

public enum CompanyType {
StateOwner(0,"国企"),
Foreignnterprise (1,"外企"),
Privateusiness(2,"民营企业"),
QuotedCompany(3,"上市公司"),
StartupCompany(4,"创业公司"),
Institution(5,"事业单位"),
Government(6,"政府机关"),
Other(7,"其他") ;

    
    private Integer flag;
    private String title;
    
    CompanyType(Integer flag,String title){
        this.flag=flag;
        this.title=title;
    }

    
    public Integer getFlag() {
    
        return flag;
    }
    
    public String getTitle() {
    
        return title;
    }

    public static CompanyType getStatusByFlag(Integer flag){
        for(CompanyType status:CompanyType.values()){
            if(status.getFlag().equals(flag)){
                return status;
            }
        }
        return null;
    }
    
}
