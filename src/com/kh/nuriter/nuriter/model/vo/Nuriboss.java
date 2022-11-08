package com.kh.nuriter.nuriter.model.vo;


import java.sql.Connection;
import java.sql.Date;


public class Nuriboss implements java.io.Serializable{
	private String applyNum;
	private String userNum;
	private String userName;
	private String categoryNum;
	private String bossContent;
	private String potoPath;
	private String potoName;
	private Date applyDate;
	
	public Nuriboss() {}
	
	public Nuriboss(String applyNum, String userNum, String userName, String categoryNum, String bossContent, String potoPath,
			String potoName, Date applyDate) {
		super();
		this.applyNum = applyNum;
		this.userNum = userNum;
		this.userName = userName;
		this.categoryNum = categoryNum;
		this.bossContent = bossContent;
		this.potoPath = potoPath;
		this.potoName = potoName;
		this.applyDate = applyDate;
	}

	public String getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(String categoryNum) {
		this.categoryNum = categoryNum;
	}

	public String getBossContent() {
		return bossContent;
	}

	public void setBossContent(String bossContent) {
		this.bossContent = bossContent;
	}

	public String getPotoPath() {
		return potoPath;
	}

	public void setPotoPath(String potoPath) {
		this.potoPath = potoPath;
	}

	public String getPotoName() {
		return potoName;
	}

	public void setPotoName(String potoName) {
		this.potoName = potoName;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	@Override
	public String toString() {
		return "Nuriboss [applyNum=" + applyNum + ", userNum=" + userNum + ", userName=" + userName + ", categoryNum="
				+ categoryNum + ", bossContent=" + bossContent + ", potoPath=" + potoPath + ", potoName=" + potoName
				+ ", applyDate=" + applyDate + "]";
	}

	

	
	
}
