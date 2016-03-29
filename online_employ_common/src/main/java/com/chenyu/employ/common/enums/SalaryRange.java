package com.chenyu.employ.common.enums;

public enum SalaryRange {
	TwoThousandBelow (0,"2000以下"),
	TwoToThreeThousand (1,"2001-3000"),
	ThreeToFiveThousand (2,"3001-5000"),
	FiveToEightThousand (3,"5001-8000"),
	EightToTenThousand (4,"8001-10000"),
	TenToFifteenThousand (5,"10001-15000"),
	FifteenToTwentyThousand (6,"15001-20000"),
	TwentyToThirtyThousand (7,"20001-30000"),
	ThirtyToFiftyThousand (8,"30001-50000"),
	MoreThanFiftyThousand (9,"50000以上");
    
    private Integer flag;
    private String title;
    
    SalaryRange(Integer flag,String title){
        this.flag=flag;
        this.title=title;
    }

    
    public Integer getFlag() {
    
        return flag;
    }
    
    public String getTitle() {
    
        return title;
    }

    public static SalaryRange getStatusByFlag(int flag){
        for(SalaryRange status:SalaryRange.values()){
            if(status.getFlag().equals(flag)){
                return status;
            }
        }
        return null;
    }
    
}
