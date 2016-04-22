package com.chenyu.employ.common.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.chenyu.employ.common.enums.ApplyStatus;
import com.chenyu.employ.common.enums.DateSpace;

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
	
	public static Integer getDateSpace(Date time){
		Calendar nowCal = Calendar.getInstance();
		nowCal.set(Calendar.HOUR_OF_DAY, 0);
		nowCal.set(Calendar.MINUTE, 0);
		nowCal.set(Calendar.SECOND, 0);
        Date now = nowCal.getTime();
        if(time.after(now)){
        	return DateSpace.TheSameDay.getFlag();
        }
        
        Calendar weeklyCal = Calendar.getInstance();
        weeklyCal.add(Calendar.DAY_OF_MONTH, -7);
        Date weekly = weeklyCal.getTime();
        if(time.after(weekly)){
        	return DateSpace.weekly.getFlag();
        }
        Calendar monthCal = Calendar.getInstance();
        monthCal.add(Calendar.DAY_OF_MONTH, -30);
        return null;
	}
}
