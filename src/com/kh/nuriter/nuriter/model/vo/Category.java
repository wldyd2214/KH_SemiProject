package com.kh.nuriter.nuriter.model.vo;


public class Category implements java.io.Serializable{
	private String cno; //카테고리 번호
	private String cname; //카테고리 이름
	private String clevel; //카테고리 레벨
	private String pno; //상위 카테고리 번호
	
	
	public Category() {}

	public Category(String cno, String cname, String clevel, String pno) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.clevel = clevel;
		this.pno = pno;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getClevel() {
		return clevel;
	}

	public void setClevel(String clevel) {
		this.clevel = clevel;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	@Override
	public String toString() {
		return "Categorie [cno=" + cno + ", cname=" + cname + ", clevel=" + clevel + ", pno=" + pno + "]";
	}
	
}
