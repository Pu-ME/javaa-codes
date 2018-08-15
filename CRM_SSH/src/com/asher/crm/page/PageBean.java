package com.asher.crm.page;

import java.util.List;

public class PageBean<T> {
	//
	private int pageNum;  //当前页
	private int pageSize; //每页数量（固定）
	private int totalRecord; //总记录数
	private int startIndex; //开始索引（计算）
	private int totalPage; //总分页数（计算）
	
	private List<T> data; //分页数据
	
	public PageBean(int pageNum, int pageSize, int totalRecord) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		//计算
		this.startIndex = (this.pageNum - 1) * this.pageSize;
		this.totalPage = (this.totalRecord + this.pageSize - 1) /this.pageSize;
		
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	
}
