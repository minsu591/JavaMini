package com.mini.board;

public class Board {
	private String writer;
	private String writeDate;
	private String title;
	private String content;
	
	public Board(String writer, String writeDate, String title, String content) {
		super();
		this.writer = writer;
		this.writeDate = writeDate;
		this.title = title;
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [writer=" + writer + ", writeDate=" + writeDate + ", title=" + title + ", content=" + content
				+ "]";
	}
	
	

}
