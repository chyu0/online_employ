package com.chenyu.employ.user.dto;

import com.chenyu.employ.user.model.UserDetail;

public class UserDetailDto extends UserDetail{
    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 分页开始位置
     */
    private int offset;

    /**
     * 分页大小
     */
    private int pageSize;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public int getOffset() {
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
