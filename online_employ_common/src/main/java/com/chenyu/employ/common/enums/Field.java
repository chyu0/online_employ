package com.chenyu.employ.common.enums;

public enum Field {
	
	Computer(0,"计算机|互联网|通信|电子"),
	Finance(1,"会计|金融|银行|保险"),
	Consume(2,"贸易|消费|制造|营运"),
	Medical(3,"制药|医疗"),
	Media(4,"广告|媒体"),
	Builder(5,"房地产|建筑"),
	Education(6,"专业服务|教育|培训"),
	Service(7,"服务业"),
	Logistics(8,"物流|运输"),
	Energy(9,"能源|原材料"),
	Government(10,"政府|非赢利机构"),
	Other(11,"其他");
	
	
	private Integer flag;
    private String title;
    
    Field(Integer flag,String title){
        this.flag=flag;
        this.title=title;
    }

    
    public Integer getFlag() {
    
        return flag;
    }
    
    public String getTitle() {
    
        return title;
    }

    public static Field getStatusByFlag(Integer flag){
        for(Field status:Field.values()){
            if(status.getFlag().equals(flag)){
                return status;
            }
        }
        return null;
    }
    
}
