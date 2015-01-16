package com.mygudou.app.Util;

import java.util.List;

/**
 * @author gold105 分页工具类
 */
public class PageUtil<T> {
	private int pageSize;// 每页显示的条数
	private int recordCount;// 总共的条数
	private int currentPage;// 当前页面
	private List<T> list;

	public PageUtil(int pageSize, int recordCount, int currentPage, List<T> list) {
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.list = list;
		setCurrentPage(currentPage);
	}

	public PageUtil(int pageSize, int recordCount, List<T> list) {
		this(pageSize, recordCount, 1, list);
	}

	public void setCurrentPage(int currentPage) {// 设置当前页
		int validPage = currentPage <= 0 ? 1 : currentPage;
		validPage = validPage > getPageCount() ? getPageCount() : validPage;
		this.currentPage = validPage;
	}

	public int getPageCount() {// 总页数
		return (recordCount + (pageSize - 1)) / pageSize;
	}

	public int getFromIndex() { // 包含，起始索引为1
		return (currentPage - 1) * pageSize + 1;
	}

	public int getToIndex() {// 包含
		return Math.min(recordCount, currentPage * pageSize);
	}

	public int getCurrentPage() {// 得到当前页
		return currentPage;
	}

	public int getPageSize() {// 得到每页显示的条数
		return pageSize;
	}

	public void setPageSize(int pageSize) {// 设置每页显示的条数
		this.pageSize = pageSize;
	}

	public int getRecordCount() {// 得到总共的条数
		return recordCount;
	}

	public void setRecordCount(int recordCount) {// 设置总共的条数
		this.recordCount = recordCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
