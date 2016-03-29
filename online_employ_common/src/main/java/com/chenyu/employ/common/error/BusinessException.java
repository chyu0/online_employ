package com.chenyu.employ.common.error;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -1107307959244683431L;
	
	private int code;
	
	public BusinessException() {
        super();
    }
 
    public BusinessException(String message) {
        super(message);
    }
 
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }
    
    public int getCode(){
    	return code;
    }
    
    public void setCode(int code){
    	this.code=code;
    }
}
