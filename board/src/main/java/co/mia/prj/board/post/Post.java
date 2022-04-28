package co.mia.prj.board.post;

import java.sql.Timestamp;

public class Post {
	private String writer;
	private Timestamp writeDate;
	private String title;
	private String content;
	private int postNo;
	
	public int getPostNo() {
		return postNo;
	}
	

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getWriter() {
		return writer;
	}
	
	
	public Post(String writer, Timestamp writeDate, String title, String content, int postNo) {
		super();
		this.writer = writer;
		this.writeDate = writeDate;
		this.title = title;
		this.content = content;
		this.postNo = postNo;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
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
		return "Post [writer=" + writer + ", writeDate=" + writeDate + ", title=" + title + ", content=" + content
				+ "]";
	}
	
	

}
