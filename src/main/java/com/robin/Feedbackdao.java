package com.robin;

import java.util.List;

public interface Feedbackdao {
	public List<Feedback> getall();
	//fd.addfeedback(sr,sid);
	public void addfeedback(Feedback fd,String subjectName);

}
