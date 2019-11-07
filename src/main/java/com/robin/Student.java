package com.robin;

public class Student {
	
	private String username;
	private String password;
	private String name;
	private String phone;
	private int age;
	private String email;
	private String address;
	
	private String guardianname;
	private String relation;
	private String contactInfo;
	private String courseName;
	private String batchYear;
	private String admissionDate;
	public Student() {
		super();
	}
	public Student(String username, String password, String name, String phone, int age, String email, String address,
			String guardianname, String relation, String contactInfo, String courseName, String batchYear,
			String admissionDate) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.email = email;
		this.address = address;
		this.guardianname = guardianname;
		this.relation = relation;
		this.contactInfo = contactInfo;
		this.courseName = courseName;
		this.batchYear = batchYear;
		this.admissionDate = admissionDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGuardianname() {
		return guardianname;
	}
	public void setGuardianname(String guardianname) {
		this.guardianname = guardianname;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
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
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	
	
	

}
