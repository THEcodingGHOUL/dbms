package com.robin;

import java.util.List;

public interface Subjectdao {
	public List<Subject> getall();
	public List<Subject> getsubjectsbystudentid(String uname);
	
	
	
	public void addsubject(Subject sub);
	public Subject getbyteacher(String user);

	
	
}
