package com.kh.nuriter.payment.model.vo;

public class PaymentDetail {
	private String pDetailId; //결제상세아이디
	private String pid;//결제아이디
	private String pstate;//결제상태
	private String cardNum;//카드넘버
	private String payDiv; //결제 방법
	private String fundNum;//환불번호
	
	public PaymentDetail(){}
	
	public PaymentDetail(String pDetailId, String pid, String pstate, String cardNum, String payDiv, String fundNum) {
		super();
		this.pDetailId = pDetailId;
		this.pid = pid;
		this.pstate = pstate;
		this.cardNum = cardNum;
		this.payDiv = payDiv;
		this.fundNum = fundNum;
	}

	public String getpDetailId() {
		
		return pDetailId;
	}

	public void setpDetailId(String pDetailId) {
		this.pDetailId = pDetailId;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPstate() {
		return pstate;
	}

	public void setPstate(String pstate) {
		this.pstate = pstate;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getPayDiv() {
		return payDiv;
	}

	public void setPayDiv(String payDiv) {
		this.payDiv = payDiv;
	}

	public String getFundNum() {
		return fundNum;
	}

	public void setFundNum(String fundNum) {
		this.fundNum = fundNum;
	}



	@Override
	public String toString() {
		return "PaymentDetail [pDetailId=" + pDetailId + ", pid=" + pid + ", pstate=" + pstate + ", cardNum=" + cardNum
				+ ", payDiv=" + payDiv + ", fundNum=" + fundNum + "]";
	}
	
}
