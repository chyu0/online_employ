package com.chenyu.employ.common.enums;


public enum ExperienceRange {
    
	Unlimited(0,"不限"),Trainee(1,"实习生"),
	OneToThreeYear(2,"1-3年"),ThreeToFiveYear(3,"3-5年"),
	FiveToEightYear(4,"5-8年"),MoreThanEightYear(5,"8年以上");
    
    private Integer flag;
    private String title;
    
    ExperienceRange(Integer flag,String title){
        this.flag=flag;
        this.title=title;
    }

    
    public Integer getFlag() {
    
        return flag;
    }
    
    public String getTitle() {
    
        return title;
    }

    public static ExperienceRange getStatusByFlag(Integer flag){
        for(ExperienceRange status:ExperienceRange.values()){
            if(status.getFlag().equals(flag)){
                return status;
            }
        }
        return null;
    }
    
    public static ExperienceRange getStatusByTitle(String title){
    	for(ExperienceRange status:ExperienceRange.values()){
            if(status.getTitle().equals(title)){
                return status;
            }
        }
        return null;
    }
}
