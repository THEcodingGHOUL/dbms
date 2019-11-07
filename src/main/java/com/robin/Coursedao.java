package com.robin;

import java.util.List;

public interface Coursedao {
	public List<Course> getall();
	//public Course getcourseid(String coursename);
	public void addcourse(Course course);
}
