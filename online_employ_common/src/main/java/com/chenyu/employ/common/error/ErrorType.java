package com.chenyu.employ.common.error;

public enum ErrorType {

	// 系统级别异常
	PARAM_EMPTY(5000001, "Parameter error"), 
	PARAMS_ERROR(5000002, "Parameters cannot be empty "), 
	OBJ_IS_EMPTY(5000003, "Parameter does not exist"), 
	TOO_LONG(5000004, "Parameter too long"), 
	SYSTEM_BUSY(5000005, "The system is busy, please try again later!"),
	SYSTEM_FORBIDDEN(5000006, "You have no rights!"),
	
	// 用户模块
	SYSTEM_USER_LOGIN_NAME_INVALID(5001001, "Invalid user account"),
	SYSTEM_USER_LOGIN_PWD_INVALID(5001002, "User password error"),
	SYSTEM_USER_VALIDATE_CODE_INVALID(5001003, "Verification code is not valid"),
	SYSTEM_USER_NEWPSD_NOTEQUAL_OLDPSD(5001004,"The new password is not consistent with the old password"),
	SYSTEM_USER_STATE_LOCK(5001004, "User is locked");

	private ErrorType(Integer flag, String title) {
		this.flag = flag;
		this.title = title;
	}

	private Integer flag;

	private String title;

	public Integer getValue() {
		return flag;
	}

	public String getTitle() {
		return title;
	}

	public static ErrorType get(Integer flag) {
		for (ErrorType temp : ErrorType.values()) {
			if (temp.flag.equals(flag)) {
				return temp;
			}
		}
		return null;
	}
}
