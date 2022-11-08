package com.kh.nuriter.attend.model.vo;

import java.sql.Date;

public class Attend {
	String attendNumber;
	String attendCodeId;
	String userNumber;
	Date attendDate;
	
	public Attend(){}

	public Attend(String attendNumber, String attendCodeId, String userNumber, Date attendDate) {
		super();
		this.attendNumber = attendNumber;
		this.attendCodeId = attendCodeId;
		this.userNumber = userNumber;
		this.attendDate = attendDate;
	}

	public String getAttendNumber() {
		return attendNumber;
	}

	public void setAttendNumber(String attendNumber) {
		this.attendNumber = attendNumber;
	}

	public String getAttendCodeId() {
		return attendCodeId;
	}

	public void setAttendCodeId(String attendCodeId) {
		this.attendCodeId = attendCodeId;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public Date getAttendDate() {
		return attendDate;
	}

	public void setAttendDate(Date attendDate) {
		this.attendDate = attendDate;
	}

	@Override
	public String toString() {
		return "Attend [attendNumber=" + attendNumber + ", attendCodeId=" + attendCodeId + ", userNumber=" + userNumber
				+ ", attendDate=" + attendDate + "]";
	}
	
	
	

}
