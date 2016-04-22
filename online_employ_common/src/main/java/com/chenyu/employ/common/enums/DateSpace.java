package com.chenyu.employ.common.enums;

public enum DateSpace {
 TheSameDay(0,"当天"),weekly(1,"一周以内"),WithInAMonth(2,"一个以内"),All(3,"所有");
    
    private Integer flag;
    private String title;
    
    DateSpace(Integer flag,String title){
        this.flag=flag;
        this.title=title;
    }

    
    public Integer getFlag() {
    
        return flag;
    }
    
    public String getTitle() {
    
        return title;
    }

    public static DateSpace getStatusByFlag(Integer flag){
        for(DateSpace status:DateSpace.values()){
            if(status.getFlag().equals(flag)){
                return status;
            }
        }
        return null;
    }
}
