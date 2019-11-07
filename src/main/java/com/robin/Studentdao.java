package com.robin;

import java.util.List;

import com.robin.*;
import com.robin.Student;

public interface Studentdao {
	public List<Student> getall();
	public Student getbyid(String uname);
	public void updateprofile(User user,String usr);
	public void addstudent(Student student);
	public void deletestudent(String uname);
	public void editstudent(Student student);
	public List<Student> getallbyexam(int examId);
	//List<Student> list=studentdao.getallbyexam(examID);
}
