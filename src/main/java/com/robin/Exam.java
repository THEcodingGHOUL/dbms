package com.robin;

public class Exam {
	
	private int examId;
	private String subjectName;
	private String examDate;
	private String time;
	private String venue;
	public Exam(int examId, String subjectName, String examDate, String time, String venue) {
		super();
		this.examId = examId;
		this.subjectName = subjectName;
		this.examDate = examDate;
		this.time = time;
		this.venue = venue;
	}
	public Exam() {
		super();
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	
	
	
	
	

}
