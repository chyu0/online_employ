package com.chenyu.employ.apply.service;

import java.util.List;

import com.chenyu.employ.apply.model.Apply;

public interface ApplyService {
public List<Apply> findAllApplyUser(Apply apply);
    
    int deleteByPrimaryKey(Integer id);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}
