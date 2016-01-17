package com.platform.model;

public class PageBean {
	private int totalPage;
	private int pageSize;
	private int prePage;
	private int nextPage;
	private int currentPage;
	private int recordCount;
	private int P1;
	private int P2;
	
	public PageBean(int recordCount){
		this.recordCount = recordCount;
	}
	public PageBean(int recordCount,int pageSize,int currentPage){
		this.currentPage = currentPage;
		this.recordCount = recordCount;
		this.pageSize = pageSize;
		int size = recordCount/pageSize;
		int mod = recordCount%pageSize;
		if (mod!=0)
			size++;
		this.totalPage = (recordCount == 0 ? 0 : size);
		if(this.currentPage==1){
			this.prePage=1;
		}else{
			this.prePage=currentPage-1;
		}
		if(this.currentPage==this.totalPage){
			this.prePage=this.currentPage;
		}else{
			this.prePage=currentPage+1;
		}
		this.P1=this.pageSize*this.currentPage;
		this.P2=this.pageSize*(this.currentPage-1);
	}
	public int getP1() {
		return P1;
	}
	public void setP1(int p1) {
		P1 = p1;
	}
	public int getP2() {
		return P2;
	}
	public void setP2(int p2) {
		P2 = p2;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	@Override
	public String toString() {
		return "PageBean [totalPage=" + totalPage + ", pageSize=" + pageSize + ", prePage=" + prePage + ", nextPage="
				+ nextPage + ", currentPage=" + currentPage + ", recordCount=" + recordCount + ", P1=" + P1 + ", P2="
				+ P2 + "]";
	}
	

}
