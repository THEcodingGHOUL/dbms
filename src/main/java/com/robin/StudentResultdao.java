
package com.robin;

import java.util.List;

import com.robin.*;

public interface StudentResultdao {
	public void addresult(StudentResult sresult);
	//List<StudentResult> list=srd.getexamresultbystudentid(uname);
	public List<StudentResult> getexamresultbystudentid(String uname);

}
