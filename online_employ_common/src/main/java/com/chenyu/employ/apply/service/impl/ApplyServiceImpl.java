package com.chenyu.employ.apply.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chenyu.employ.apply.dao.ApplyMapper;
import com.chenyu.employ.apply.model.Apply;
import com.chenyu.employ.apply.service.ApplyService;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    private ApplyMapper applyMapper;

    public List<Apply> findAllApplyUser(Apply apply) {

        // TODO Auto-generated method stub
        return null;
    }

    public int deleteByPrimaryKey(Integer id) {

        // TODO Auto-generated method stub
        return 0;
    }

    public int insert(Apply record) {

        // TODO Auto-generated method stub
        return 0;
    }

    public int insertSelective(Apply record) {

        // TODO Auto-generated method stub
        return 0;
    }

    public Apply selectByPrimaryKey(Integer id) {

        // TODO Auto-generated method stub
        return null;
    }

    public int updateByPrimaryKeySelective(Apply record) {

        // TODO Auto-generated method stub
        return 0;
    }

    public int updateByPrimaryKey(Apply record) {

        // TODO Auto-generated method stub
        return 0;
    }
    
    
}
