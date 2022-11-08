package com.kh.nuriter.payment.model.vo;

import java.sql.Date;

public class Payment implements java.io.Serializable{
	private String pId; //결제아이디
	private String userNum;//회원번호
	private String nuriNum;//누리터 번호
	private Date terminateDate;//누리터 마지막 날짜 
	
	public Payment(){}

	public Payment(String pId, String userNum, String nuriNum ,Date terminateDate) {
		super();
		this.pId = pId;
		this.userNum = userNum;
		this.nuriNum = nuriNum;
		this.terminateDate =terminateDate;
		
	}

	public Date getTerminateDate() {
		return terminateDate;
	}

	public void setTerminateDate(Date terminateDate) {
		this.terminateDate = terminateDate;
	}

	public String getpId() {
		return pId;
	}

	//
	public String getUserNum() {
		return userNum;
	}

	public String getNuriNum() {
		return nuriNum;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public void setNuriNum(String nuriNum) {
		this.nuriNum = nuriNum;
	}

	@Override
	public String toString() {
		return "Payment [pId=" + pId + ", userNum=" + userNum + ", nuriNum=" + nuriNum + ", terminateDate="
				+ terminateDate + "]";
	}


	
	
	
	
	
	
	
	
}
