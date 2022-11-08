package com.kh.nuriter.attend.model.vo;

import java.sql.Date;

public class Attendprint {
	
	String attendCodeId;
	String nickName;
	String nuriNumber;
	Date attendDate;
	
	public Attendprint(){}

	public Attendprint(String attendCodeId, String nickName, String nuriNumber, Date attendDate) {
		super();
		this.attendCodeId = attendCodeId;
		this.nickName = nickName;
		this.nuriNumber = nuriNumber;
		this.attendDate = attendDate;
	}

	public String getAttendCodeId() {
		return attendCodeId;
	}

	public void setAttendCodeId(String attendCodeId) {
		this.attendCodeId = attendCodeId;
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

	public Date getAttendDate() {
		return attendDate;
	}

	public void setAttendDate(Date attendDate) {
		this.attendDate = attendDate;
	}

	@Override
	public String toString() {
		return "Attendprint [attendCodeId=" + attendCodeId + ", nickName=" + nickName + ", nuriNumber=" + nuriNumber
				+ ", attendDate=" + attendDate + "]";
	}
	
	
	

}
