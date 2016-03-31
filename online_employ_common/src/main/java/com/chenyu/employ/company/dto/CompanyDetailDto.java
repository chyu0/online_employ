package com.chenyu.employ.company.dto;

import com.chenyu.employ.company.model.CompanyDetail;

public class CompanyDetailDto extends CompanyDetail{
    /**
     * 页码
     */
    private Integer pageNo=1;
    /**
     * 分页大小
     */
    private int pageSize=10;
    
    /**
     * 分页开始位置
     */
    private int offset=(pageNo-1)*pageSize;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getOffset() {
    	offset=(pageNo-1)*pageSize;
        return offset;
    }
    
    public void setOffest(Integer offset){
    	this.offset=offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
