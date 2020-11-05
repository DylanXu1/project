package com.chains.project.util;


/**
 * 分页工具类
 * 
 * @author xdx
 *
 */
public class PageUtil {

	private int limit; // 页面容量
	private int page; // 当前页码
	private int count; // 列表内容总数
	private int pageCount; // 页面总数
	private int startItem; // 当前页开始条

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		if (limit > 0) {
			this.limit = limit;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page > 0) {
			this.page = page;
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if (count >= 0) {
			this.count = count;
			this.pageCount = this.count % this.limit == 0 ? this.count / this.limit
					: this.count / this.limit + 1;
		}
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getStartItem() {
		return (page-1)*limit;
	}

}
