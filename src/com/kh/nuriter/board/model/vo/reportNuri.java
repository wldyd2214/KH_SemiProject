package com.kh.nuriter.board.model.vo;

import java.sql.Date;

public class reportNuri implements java.io.Serializable {
	private String boardNum; //게시판 넘버
	private String boardTitle; //게시글 제목
	private String boardContent;//게시글 내용
	private int userNum;//사용자넘버
	private Date boardDate;//게시글 날짜
	private String boardSort;//게시글 종류
	private String nuriNum; //누리터 넘버
	private String nuriRegi;//신고 여부
	private String n_ownerNum;// 누리장번호 
	private String ownerNickname;//누리장 닉네임
	private String nuriNickname;//누리원 닉네임
	
	
	public reportNuri(){}


	public reportNuri(String boardNum, String boardTitle, String boardContent, int userNum, Date boardDate,
			String boardSort, String nuriNum, String nuriRegi, String n_ownerNum , String ownerNickname ,String nuriNickname) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.userNum = userNum;
		this.boardDate = boardDate;
		this.boardSort = boardSort;
		this.nuriNum = nuriNum;
		this.nuriRegi = nuriRegi;
		this.n_ownerNum = n_ownerNum;
		this.ownerNickname= ownerNickname;
		this.nuriNickname = nuriNickname;
		
	}

	
	
	public String getOwnerNickname() {
		return ownerNickname;
	}


	public String getNuriNickname() {
		return nuriNickname;
	}


	public void setOwnerNickname(String ownerNickname) {
		this.ownerNickname = ownerNickname;
	}


	public void setNuriNickname(String nuriNickname) {
		this.nuriNickname = nuriNickname;
	}


	public String getN_ownerNum() {
		return n_ownerNum;
	}


	public void setN_ownerNum(String n_ownerNum) {
		this.n_ownerNum = n_ownerNum;
	}


	public String getBoardNum() {
		return boardNum;
	}


	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public int getUserNum() {
		return userNum;
	}


	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}


	public Date getBoardDate() {
		return boardDate;
	}


	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}


	public String getBoardSort() {
		return boardSort;
	}


	public void setBoardSort(String boardSort) {
		this.boardSort = boardSort;
	}


	public String getNuriNum() {
		return nuriNum;
	}


	public void setNuriNum(String nuriNum) {
		this.nuriNum = nuriNum;
	}


	public String getNuriRegi() {
		return nuriRegi;
	}


	public void setNuriRegi(String nuriRegi) {
		this.nuriRegi = nuriRegi;
	}


	@Override
	public String toString() {
		return "reportNuri [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", userNum=" + userNum + ", boardDate=" + boardDate + ", boardSort=" + boardSort + ", nuriNum="
				+ nuriNum + ", nuriRegi=" + nuriRegi + ", n_ownerNum=" + n_ownerNum + ", ownerNickname=" + ownerNickname
				+ ", nuriNickname=" + nuriNickname + "]";
	}


	

	
	
	
	
}
