package com.kh.nuriter.member.model.vo;

import java.sql.Date;

public class Member implements java.io.Serializable{
	
	private int userNumber;
	private String userEmail;
	private String password;
	private String userName;
	private String nickName;
	private String phone;
	private String address;
	private Date birthDate;
	private	String grade;
	private Date gradeDate;
	private String bankName;
	private String bankNumber;
	private String hobby;
	private Date enrollDate;
	private String accountSort;
	private String token;
	private String reportedUser;
	private String activated;
	private Date activatedDate;
	private String refundNuriterName;
	private int refundNuriterPrice;
	private Date refundNuriterDate;
	
	public Member(){}



	public Member(int userNumber, String userEmail, String password, String userName, String nickName, String phone,
			String address, Date birthDate, String grade, Date gradeDate, String bankName, String bankNumber,
			String hobby, Date enrollDate, String accountSort, String token, String reportedUser, String activated,
			Date activatedDate, String refundNuriterName, int refundNuriterPrice, Date refundNuriterDate) {
		super();
		this.userNumber = userNumber;
		this.userEmail = userEmail;
		this.password = password;
		this.userName = userName;
		this.nickName = nickName;
		this.phone = phone;
		this.address = address;
		this.birthDate = birthDate;
		this.grade = grade;
		this.gradeDate = gradeDate;
		this.bankName = bankName;
		this.bankNumber = bankNumber;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
		this.accountSort = accountSort;
		this.token = token;
		this.reportedUser = reportedUser;
		this.activated = activated;
		this.activatedDate = activatedDate;
		this.refundNuriterName = refundNuriterName;
		this.refundNuriterPrice = refundNuriterPrice;
		this.refundNuriterDate = refundNuriterDate;
	}



	public int getUserNumber() {
		return userNumber;
	}



	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public Date getGradeDate() {
		return gradeDate;
	}



	public void setGradeDate(Date gradeDate) {
		this.gradeDate = gradeDate;
	}



	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	public String getBankNumber() {
		return bankNumber;
	}



	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}



	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}



	public Date getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}



	public String getAccountSort() {
		return accountSort;
	}



	public void setAccountSort(String accountSort) {
		this.accountSort = accountSort;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public String getReportedUser() {
		return reportedUser;
	}



	public void setReportedUser(String reportedUser) {
		this.reportedUser = reportedUser;
	}



	public String getActivated() {
		return activated;
	}



	public void setActivated(String activated) {
		this.activated = activated;
	}



	public Date getActivatedDate() {
		return activatedDate;
	}



	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}

	

	public String getRefundNuriterName() {
		return refundNuriterName;
	}



	public void setRefundNuriterName(String refundNuriterName) {
		this.refundNuriterName = refundNuriterName;
	}

	

	public int getRefundNuriterPrice() {
		return refundNuriterPrice;
	}



	public void setRefundNuriterPrice(int refundNuriterPrice) {
		this.refundNuriterPrice = refundNuriterPrice;
	}

	

	public Date getRefundNuriterDate() {
		return refundNuriterDate;
	}



	public void setRefundNuriterDate(Date refundNuriterDate) {
		this.refundNuriterDate = refundNuriterDate;
	}



	@Override
	public String toString() {
		return "Member [userNumber=" + userNumber + ", userEmail=" + userEmail + ", password=" + password
				+ ", userName=" + userName + ", nickName=" + nickName + ", phone=" + phone + ", address=" + address
				+ ", birthDate=" + birthDate + ", grade=" + grade + ", gradeDate=" + gradeDate + ", bankName="
				+ bankName + ", bankNumber=" + bankNumber + ", hobby=" + hobby + ", enrollDate=" + enrollDate
				+ ", accountSort=" + accountSort + ", token=" + token + ", reportedUser=" + reportedUser
				+ ", activated=" + activated + ", activatedDate=" + activatedDate + ", refundNuriterName="
				+ refundNuriterName + ", refundNuriterPrice=" + refundNuriterPrice + ", refundNuriterDate="
				+ refundNuriterDate + "]";
	}


}
