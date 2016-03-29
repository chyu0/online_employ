package com.chenyu.employ.resume.dao;

import com.chenyu.employ.resume.model.Resume;

public interface ResumeMapper {
    int deleteByPrimaryKey(Integer resumeId);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(Integer resumeId);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);
}