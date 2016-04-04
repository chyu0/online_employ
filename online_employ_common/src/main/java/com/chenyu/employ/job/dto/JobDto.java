package com.chenyu.employ.job.dto;

import com.chenyu.employ.job.model.Job;

public class JobDto extends Job {
	/**
	 * 页码
	 */
	private Integer pageNo = 1;
	/**
	 * 分页大小
	 */
	private Integer pageSize = 10;

	/**
	 * 分页开始位置
	 */
	private Integer offset = (pageNo - 1) * pageSize;

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

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
