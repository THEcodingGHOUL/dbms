package com.robin;

public class Course {

	private String courseName;
	private String batchYear;
	public Course() {
		super();
	}
	public Course(String courseName, String batchYear) {
		super();
		this.courseName = courseName;
		this.batchYear = batchYear;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getBatchYear() {
		return batchYear;
	}
	public void setBatchYear(String batchYear) {
		this.batchYear = batchYear;
	}
	
	

}
