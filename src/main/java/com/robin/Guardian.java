package com.robin;

public class Guardian {
	private String guardianname;
	private String relation;
	private String contactInfo;
	public Guardian() {
		
	}
	public Guardian(String guardianname, String relation, String contactInfo) {
		
		this.guardianname = guardianname;
		this.relation = relation;
		this.contactInfo = contactInfo;
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
	
	
}
