package com.kh.nuriter.board.model.vo;

import java.sql.Date;

public class board implements java.io.Serializable {
	private String boardNum; //게시판 번호
	private String boardTitle; //게시글 제목
	private String boardContent;//게시글 내용
	private String userNum;//사용자넘버
	private int boardCount; //조회수
	private Date boardDate;//게시글 작성일시
	private String boardSort;//게시판 종류
	private String reportNum; //신고 대상자 번호
	private String nuriNum; //누리터 번호
	private String status; //게시판 상태
	
	
	 public board(){}


	public String getBoardNum() {
		return boardNum;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public String getUserNum() {
		return userNum;
	}


	public int getBoardCount() {
		return boardCount;
	}


	public Date getBoardDate() {
		return boardDate;
	}


	public String getBoardSort() {
		return boardSort;
	}


	public String getReportNum() {
		return reportNum;
	}



	public String getNuriNum() {
		return nuriNum;
	}


	public String getStatus() {
		return status;
	}



	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}


	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}


	public void setBoardSort(String boardSort) {
		this.boardSort = boardSort;
	}


	public void setReportNum(String reportNum) {
		this.reportNum = reportNum;
	}


	public void setNuriNum(String nuriNum) {
		this.nuriNum = nuriNum;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "board [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", userNum=" + userNum + ", boardCount=" + boardCount + ", boardDate=" + boardDate + ", boardSort="
				+ boardSort + ", reportNum=" + reportNum + ", nuriNum=" + nuriNum + ", status=" + status + "]";
	}
	 
	 
	
}

