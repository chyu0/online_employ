package com.chenyu.employ.common.enums;

public enum StaffRange {
FiftyBelow(0,"50以下"),
FiftyToOneHundredFifty(1,"50-150"),
OneHundredFiftyToFiveHundred(2,"150-500"),
FiveHundredToOneThousand(3,"500-1000"),
OneThousandToFiveThousand(4,"1000-5000"),
MoreThanFiveThousand(5,"5000以上");
    
    private Integer flag;
    private String title;
    
    StaffRange(Integer flag,String title){
        this.flag=flag;
        this.title=title;
    }

    
    public Integer getFlag() {
    
        return flag;
    }
    
    public String getTitle() {
    
        return title;
    }

    public static StaffRange getStatusByFlag(int flag){
        for(StaffRange status:StaffRange.values()){
            if(status.getFlag().equals(flag)){
                return status;
            }
        }
        return null;
    }
}
