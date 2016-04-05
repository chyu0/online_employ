package com.chenyu.employ.common.enums;

public enum Field {
	
	Computer(1,"计算机|互联网|通信|电子"),
	Finance(2,"会计|金融|银行|保险"),
	Consume(3,"贸易|消费|制造|营运"),
	Medical(4,"制药|医疗"),
	Media(5,"广告|媒体"),
	Builder(6,"房地产|建筑"),
	Education(7,"专业服务|教育|培训"),
	Service(8,"服务业"),
	Logistics(9,"物流|运输"),
	Energy(10,"能源|原材料"),
	Government(11,"政府|非赢利机构"),
	Other(12,"其他");
	
	
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
