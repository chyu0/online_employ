package com.chenyu.employ.apply.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chenyu.employ.apply.model.Apply;
import com.chenyu.employ.job.model.Job;
import com.chenyu.employ.resume.model.Resume;

public class ApplyUtils {
	public static Map<Integer,List<Apply>> getApplyListByJobId(List<Apply> list){
		Map<Integer,List<Apply>> applyMap=new HashMap<Integer,List<Apply>>();
		if(list==null || list.size()<=0){
			return applyMap;
		}else{
			for(Apply apply:list){
				List<Apply> applyList = applyMap.get(apply.getJobId());
				if(applyList==null){
					applyList=new ArrayList<Apply>();
				}
				applyList.add(apply);
				applyMap.put(apply.getJobId(), applyList);
			}
		}
		return applyMap;
	}
	
	public static Map<Integer,Resume> getResumeByApplyId(List<Apply> applyList,List<Resume> resumeList){
		Map<Integer,Resume> resumeMap=new HashMap<Integer,Resume>();
		if(applyList==null || applyList.size()<=0){
			return resumeMap;
		}else{
			for(Apply apply:applyList){
				for(Resume resume:resumeList){
					if(apply.getResumeId().equals(resume.getResumeId())){
						resumeMap.put(apply.getApplyId(), resume);
					}
				}
			}
		}
		return resumeMap;
	}
	
	public static Map<Integer,Job> getJobByApplyId(List<Apply> applyList,List<Job> jobList){
		Map<Integer,Job> jobMap=new HashMap<Integer,Job>();
		if(applyList==null || applyList.size()<=0){
			return jobMap;
		}else{
			for(Apply apply:applyList){
				for(Job job:jobList){
					if(apply.getJobId().equals(job.getJobId())){
						jobMap.put(apply.getApplyId(), job);
					}
				}
			}
		}
		return jobMap;
	}
}
