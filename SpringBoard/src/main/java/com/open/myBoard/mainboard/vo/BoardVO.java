package com.open.myBoard.mainboard.vo;

public class BoardVO {

	private int seq;
	private String category;
	private String title;
	private String text;
	private String writer;
	private String password;
	private String date;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", category=" + category + ", title=" + title + ", text=" + text + ", writer="
				+ writer + ", password=" + password + ", date=" + date + "]";
	}

}
