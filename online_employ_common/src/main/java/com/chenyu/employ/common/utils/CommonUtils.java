package com.chenyu.employ.common.utils;

import java.util.ArrayList;
import java.util.List;

import com.chenyu.employ.common.enums.ApplyStatus;

public class CommonUtils {
	public static List<ApplyStatus> getAvailApplyStatus(Integer flag){
		List<ApplyStatus> applyList=new ArrayList<ApplyStatus>();
		if(ApplyStatus.wait.getFlag().equals(flag)){
			for(ApplyStatus status:ApplyStatus.values()){
				if(!ApplyStatus.wait.getFlag().equals(status.getFlag())){
					applyList.add(status);
				}
			}
		}else{
			for(ApplyStatus status:ApplyStatus.values()){
				if(!ApplyStatus.wait.getFlag().equals(status.getFlag())&&!ApplyStatus.getStatusByFlag(flag).equals(status.getFlag())){
					applyList.add(status);
				}
			}
		}
		return applyList;
	}
}
