package com.chenyu.employ.common.enums;


public enum UserStatus {
    
    lock(0,"锁定"),active(1,"激活"),check(2,"审批"),checkFailed(3,"审核失败");
    
    private Integer flag;
    private String title;
    
    UserStatus(Integer flag,String title){
        this.flag=flag;
        this.title=title;
    }

    
    public Integer getFlag() {
    
        return flag;
    }
    
    public String getTitle() {
    
        return title;
    }

    public static UserStatus getStatusByFlag(int flag){
        for(UserStatus status:UserStatus.values()){
            if(status.getFlag().equals(flag)){
                return status;
            }
        }
        return null;
    }
    
}
