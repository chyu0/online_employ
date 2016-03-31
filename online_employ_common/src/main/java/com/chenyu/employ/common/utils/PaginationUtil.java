
package com.chenyu.employ.common.utils;

import java.io.Serializable;
import java.util.List;

public class PaginationUtil<T> implements Serializable {

    private static final long serialVersionUID = 5472321653620726832L;

    // 当前页
    private int pageNo = 1;

    // 每页显示数量
    private int pageSize = 10;

    // 总条数
    private int totalCount;

    private boolean havaNextPage;

    private boolean havePrePage;

    // 存放查询结果用的list
    private List<T> items;

    public PaginationUtil() {
    }

    public PaginationUtil(int pageNo,int pageSize) {
    	this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageCount() {

        int pageCount = 0;
        if (totalCount == 0) return ++pageCount;
        if (pageSize != 0) {
            pageCount = totalCount / pageSize;
            if (totalCount % pageSize != 0) pageCount++;
        }
        return pageCount;
    }

    public int getPageNo() {

        pageNo = pageNo < getPageCount() ? pageNo : getPageCount();
        pageNo = pageNo < 1 ? 1 : pageNo;

        return pageNo;
    }

    public int getPageSize() {

        return pageSize;
    }

    public int getTotalCount() {

        return totalCount;
    }

    public boolean isHaveNextPage() {

        havaNextPage = false;
        if ((getPageCount() > 1) && (getPageCount() > getPageNo())) havaNextPage = true;
        return havaNextPage;
    }

    public boolean isHavePrePage() {

        havePrePage = false;
        if ((getPageCount() > 1) && (pageNo > 1)) havePrePage = true;
        return havePrePage;
    }

    public List<T> getItems() {

        return items;
    }

    public void setItems(List<T> items) {

        this.items = items;
    }

    public void setPageNo(int pageNo) {

        this.pageNo = pageNo;
    }

    public void setPageSize(int pageSize) {

        this.pageSize = pageSize;
    }

    public void setTotalCount(int totalCount) {

        this.totalCount = totalCount;
    }

}
