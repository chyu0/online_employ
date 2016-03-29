package com.chenyu.employ.common.enums;

public enum SalaryRange {
	TwoThousandBelow (1,"2000以下"),
	TwoToThreeThousand (2,"2001-3000"),
	ThreeToFiveThousand (3,"3001-5000"),
	FiveToEightThousand (4,"5001-8000"),
	EightToTenThousand (5,"8001-10000"),
	TenToFifteenThousand (6,"10001-15000"),
	FifteenToTwentyThousand (7,"15001-20000"),
	TwentyToThirtyThousand (8,"20001-30000"),
	ThirtyToFiftyThousand (9,"30001-50000"),
	MoreThanFiftyThousand (10,"50000以上"),
	DiscussPersonally(0,"面议");
    
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

    public static SalaryRange getStatusByFlag(Integer flag){
        for(SalaryRange status:SalaryRange.values()){
            if(status.getFlag().equals(flag)){
                return status;
            }
        }
        return null;
    }
    
}
