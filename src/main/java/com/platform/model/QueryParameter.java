package com.platform.model;

public class QueryParameter extends PageBean{
	public QueryParameter(int recordCount, int pageSize, int currentPage) {
		super(recordCount, pageSize, currentPage);
	}
	private int dt;
	private int mt;
	private int sim;
	private int stype;
	private String comments;
	public int getDt() {
		return dt;
	}
	public void setDt(int dt) {
		this.dt = dt;
	}
	public int getMt() {
		return mt;
	}
	public void setMt(int mt) {
		this.mt = mt;
	}
	public int getSim() {
		return sim;
	}
	public void setSim(int sim) {
		this.sim = sim;
	}
	public int getStype() {
		return stype;
	}
	public void setStype(int stype) {
		this.stype = stype;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
