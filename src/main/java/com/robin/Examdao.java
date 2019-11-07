package com.robin;

import java.util.List;

public interface Examdao {
	public List<Exam> getall();
	public List<Exam> getexambystudentid(String uname);
	public void addexam(Exam exm);
	
	//List<Student> list=studentdao.getallbyexam(examID);
}
