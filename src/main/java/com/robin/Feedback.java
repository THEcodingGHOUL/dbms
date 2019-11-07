package com.robin;

public class Feedback {
	private String content;
	private String date;
	private String teacher;
	public Feedback(String content, String date, String teacher) {
		super();
		this.content = content;
		this.date = date;
		this.teacher = teacher;
	}
	public Feedback() {
		super();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	
}
