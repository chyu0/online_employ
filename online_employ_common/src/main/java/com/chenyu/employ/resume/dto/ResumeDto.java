package com.chenyu.employ.resume.dto;

import com.chenyu.employ.resume.model.Resume;

public class ResumeDto extends Resume{
    /**
     * 页码
     */
    private int pageNo=1;
    /**
     * 分页大小
     */
    private int pageSize=10;
    
    /**
     * 分页开始位置
     */
    private int offset=pageSize*(pageNo-1);


    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getOffset() {
    	offset = (pageNo - 1) * pageSize;
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
