package com.kh.nuriter.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private String bNumber;
	private String bRownum;
	private String bTitle;
	private String bContent;
	private String userNumber;
	private int bCount;
	private Date bDate;
	private String bSort;
	private String nuriNumber;
	private String nuriRegister;
	
	public Notice(){}

	public Notice(String bNumber, String bRownum, String bTitle, String bContent, String userNumber, int bCount,
			Date bDate, String bSort, String nuriNumber, String nuriRegister) {
		super();
		this.bNumber = bNumber;
		this.bRownum = bRownum;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.userNumber = userNumber;
		this.bCount = bCount;
		this.bDate = bDate;
		this.bSort = bSort;
		this.nuriNumber = nuriNumber;
		this.nuriRegister = nuriRegister;
	}

	public String getbNumber() {
		return bNumber;
	}

	public void setbNumber(String bNumber) {
		this.bNumber = bNumber;
	}

	public String getbRownum() {
		return bRownum;
	}

	public void setbRownum(String bRownum) {
		this.bRownum = bRownum;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public String getbSort() {
		return bSort;
	}

	public void setbSort(String bSort) {
		this.bSort = bSort;
	}

	public String getNuriNumber() {
		return nuriNumber;
	}

	public void setNuriNumber(String nuriNumber) {
		this.nuriNumber = nuriNumber;
	}

	public String getNuriRegister() {
		return nuriRegister;
	}

	public void setNuriRegister(String nuriRegister) {
		this.nuriRegister = nuriRegister;
	}

	@Override
	public String toString() {
		return "Notice [bNumber=" + bNumber + ", bRownum=" + bRownum + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", userNumber=" + userNumber + ", bCount=" + bCount + ", bDate=" + bDate + ", bSort=" + bSort
				+ ", nuriNumber=" + nuriNumber + ", nuriRegister=" + nuriRegister + "]";
	}

	
	
}
