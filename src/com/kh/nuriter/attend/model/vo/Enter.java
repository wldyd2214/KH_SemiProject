package com.kh.nuriter.attend.model.vo;

import java.sql.Date;

public class Enter {
	
	String userNumber;
	String nickName;
	String nuriNumber;
	Date enterDate;
	Date terminateDate;
	String phone;
	
	public Enter(){}

	public Enter(String userNumber, String nickName, String nuriNumber, Date enterDate, Date terminateDate, String phone) {
		super();
		this.userNumber = userNumber;
		this.nickName = nickName;
		this.nuriNumber = nuriNumber;
		this.enterDate = enterDate;
		this.terminateDate=terminateDate;
		this.phone=phone;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNuriNumber() {
		return nuriNumber;
	}

	public void setNuriNumber(String nuriNumber) {
		this.nuriNumber = nuriNumber;
	}

	public Date getEnterDate() {
		return enterDate;
	}
	
	
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	
	public Date getTerminateDate() {
		return terminateDate;
	}

	public void setTerminateDate(Date terminateDate){
		this.terminateDate = terminateDate;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Enter [userNumber=" + userNumber + ", nickName=" + nickName + ", nuriNumber=" + nuriNumber
				+ ", enterDate=" + enterDate + ", terminateDate=" + terminateDate + ", phone=" + phone +"]";
	}
	
	

}
