package com.chenyu.employ.job.dto;

import com.chenyu.employ.common.utils.CommonUtils;
import com.chenyu.employ.job.model.Job;

public class JobDto extends Job {
	/**
	 * 页码
	 */
	private Integer pageNo = CommonUtils.pageNo;
	/**
	 * 分页大小
	 */
	private int pageSize = CommonUtils.pageSize;

	/**
	 * 分页开始位置
	 */
	private int offset = (pageNo - 1) * pageSize;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getOffset() {
		offset = (pageNo - 1) * pageSize;
		return offset;
	}

	public void setOffest(Integer offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
