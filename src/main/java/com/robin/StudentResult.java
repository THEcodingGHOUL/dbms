package com.robin;

public class StudentResult {
	
	private String username;
	private int examId;
	private int totalmarks;
	private int marksObtained;
	private int percentile;
	public StudentResult(String username, int examId, int totalmarks, int marksObtained, int percentile) {
		super();
		this.username = username;
		this.examId = examId;
		this.totalmarks = totalmarks;
		this.marksObtained = marksObtained;
		this.percentile = percentile;
	}
	public StudentResult() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getTotalmarks() {
		return totalmarks;
	}
	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public int getPercentile() {
		return percentile;
	}
	public void setPercentile(int percentile) {
		this.percentile = percentile;
	}
	
	

	
	
	
	

}
