package com.chenyu.employ.common.enums;


public enum ApplyStatus {
    
    fail(0,"审核失败"),pass(1,"审核通过"),wait(2,"待审核");
    
    private Integer flag;
    private String title;
    
    ApplyStatus(Integer flag,String title){
        this.flag=flag;
        this.title=title;
    }

    
    public Integer getFlag() {
    
        return flag;
    }
    
    public String getTitle() {
    
        return title;
    }

    public static ApplyStatus getStatusByFlag(Integer flag){
        for(ApplyStatus status:ApplyStatus.values()){
            if(status.getFlag().equals(flag)){
                return status;
            }
        }
        return null;
    }
}
