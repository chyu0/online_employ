package com.chenyu.employ.common.enums;

public enum SexType {
	Unknown(0,"未知"),
	Male(1,"男"),
	Female(2,"女");
	
	
	private Integer flag;
    private String title;
    
    SexType(Integer flag,String title){
        this.flag=flag;
        this.title=title;
    }

    
    public Integer getFlag() {
    
        return flag;
    }
    
    public String getTitle() {
    
        return title;
    }

    public static SexType getStatusByFlag(Integer flag){
        for(SexType status:SexType.values()){
            if(status.getFlag().equals(flag)){
                return status;
            }
        }
        return null;
    }
    
}
