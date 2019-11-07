package com.robin;

public class Blogcomments {
	private int id;
	private int blogId;
	private String content;
	private String username;
	public Blogcomments(int id, int blogId, String content, String username) {
		super();
		this.id = id;
		this.blogId = blogId;
		this.content = content;
		this.username = username;
	}
	public Blogcomments() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	
	

}
