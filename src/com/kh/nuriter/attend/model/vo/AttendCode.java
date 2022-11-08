package com.kh.nuriter.attend.model.vo;

import java.sql.Date;

public class AttendCode {
	String attendCodeid;
	String nuriNumber;
	Date attendCodeDate;
	
	public AttendCode(){}
	
	public AttendCode(String attendCodeid, String nuriNumber, Date attendCodeDate) {
		super();
		this.attendCodeid = attendCodeid;
		this.nuriNumber = nuriNumber;
		this.attendCodeDate = attendCodeDate;
	}

	public String getAttendCodeid() {
		return attendCodeid;
	}

	public void setAttendCodeid(String attendCodeid) {
		this.attendCodeid = attendCodeid;
	}

	public String getNuriNumber() {
		return nuriNumber;
	}

	public void setNuriNumber(String nuriNumber) {
		this.nuriNumber = nuriNumber;
	}

	public Date getAttendCodeDate() {
		return attendCodeDate;
	}

	public void setAttendCodeDate(Date attendCodeDate) {
		this.attendCodeDate = attendCodeDate;
	}

	@Override
	public String toString() {
		return "AttendCode [attendCodeid=" + attendCodeid + ", nuriNumber=" + nuriNumber + ", attendCodeDate="
				+ attendCodeDate + "]";
	}
	
	
	
}
