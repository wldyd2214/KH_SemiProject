package com.kh.nuriter.nuriter.model.vo;

import java.sql.Date;



public class Attachment implements java.io.Serializable{
	private String pid;
	private String nuriNum;
	private String origin;
	private String change;
	private String path;
	private Date upDate;
	private String level;
	private String count;
	private String status;
	
	public Attachment() {}

	public Attachment(String pid, String nuriNum, String origin, String change, String path, Date upDate, String level,
			String count, String status) {
		super();
		this.pid = pid;
		this.nuriNum = nuriNum;
		this.origin = origin;
		this.change = change;
		this.path = path;
		this.upDate = upDate;
		this.level = level;
		this.count = count;
		this.status = status;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getNuriNum() {
		return nuriNum;
	}

	public void setNuriNum(String nuriNum) {
		this.nuriNum = nuriNum;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getUpDate() {
		return upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Nuripoto [pid=" + pid + ", nuriNum=" + nuriNum + ", origin=" + origin + ", change=" + change + ", path="
				+ path + ", upDate=" + upDate + ", level=" + level + ", count=" + count + ", status=" + status + "]";
	}
	
}
