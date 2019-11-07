package com.robin;

import java.security.Principal;
import java.util.List;

import com.robin.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class studentController {
	
	@Autowired 
	Studentdao studentdao;
	
	@Autowired
	Examdao examdao;
	
	@Autowired
	StudentResultdao srd;
	
	@Autowired
	Subjectdao subjectdao;
	
	@Autowired
	Blogdao blogdao;
	
	@Autowired
	Blogcommentsdao blogcommentsdao;
	
	@Autowired
	Feedbackdao fd;
	
	@Autowired
	Blogcommentsdao bcd;
	
	@RequestMapping(value = "/student/profile/{username}")
	public String studentprofile(@PathVariable(value="username") String uname,Model model, Principal principal) {
		
		
		 if (principal != null) {
				Student stud=studentdao.getbyid(uname);

				model.addAttribute("student",stud);
				model.addAttribute("user",uname);
				return "studentprofile";
	 
	        }
	 
	    else{   return "student";}  
		
	
		
		
	}
	
	//@RequestMapping(value = "/student/profile/{username}")
	
	
	
	
	@RequestMapping(value = "/student/exam/{user}")
	public String examsection(@PathVariable(value="user") String uname,Model model, Principal principal) {
		
		
		
		if (principal != null) {
			
			
			List<Exam> list=examdao.getexambystudentid(uname);

			model.addAttribute("exam",list);
			model.addAttribute("user",uname);
			return "studentexampage";
 
        }
 
    else{   return "student";} 
		
		

		
		
	}
	
	@RequestMapping(value = "/student/examresult/{user}")
	public String examresult(@PathVariable(value="user") String uname,Model model, Principal principal) {
		
		

if (principal != null) {
			
	List<StudentResult> list=srd.getexamresultbystudentid(uname);

	model.addAttribute("result",list);
	model.addAttribute("user",uname);
	return "studentexamresultpage";
		
 
        }
 
    else{   return "student";} 
		
		
		
	
		
	}
	
	@RequestMapping(value="/student/subject/{user}")
	public String subjectinfo(@PathVariable(value="user") String uname,Model model, Principal principal) {
		
		
		
		if (principal != null) {
			
			
			List<Subject> list=subjectdao.getsubjectsbystudentid(uname);
			model.addAttribute("subject",list);
			model.addAttribute("user",uname);
			return "studentsubjectpage";
				
		 
		        }
		 
		    else{   return "student";} 
		
		
		
		
		
		
		
		

		
		
	}
	
	@RequestMapping(value="/student/subjectinfo/{subName}")
	public String subjectpage(@PathVariable(value="subName") String sid,Model model, Principal principal) {
		
		List<Blog> list=blogdao.getallbysid(sid);
		model.addAttribute("subject",sid);
		model.addAttribute("blog",list);
		return "subjectdashboard";
		
		
	}
	
	
	@RequestMapping(value="/student/subjectinfo/{blogId}/showcomments")
	public String showcomments(@PathVariable(value="blogId") int bid,Model model, Principal principal) {
		
		List<Blogcomments> list=blogcommentsdao.getallbybid(bid);
		//model.addAttribute("subject",sid);
		model.addAttribute("blogid",bid);
		model.addAttribute("blogcomments",list);
		return "showcomments";
	}

	
	@RequestMapping(value="/student/updateprofile/{user}",method=RequestMethod.GET)
	public String updateprofile(@PathVariable(value="user") String user,Model model, Principal principal) {
		
		
		
     if (principal != null) {
			
	        model.addAttribute("sr", new User());
	        model.addAttribute("uname",user);

	
	         return "updatestudentprofile";
		 
		     }
		 
		    else{  return "student";  } 
		
		
		
		
	}	

	
	
	@RequestMapping(value="/student/updateprofile/{user}",method=RequestMethod.POST)
	public String updateprofileprocess(@PathVariable(value="user") String user,@ModelAttribute("sr") User sr,BindingResult result,Model model) {
		
		studentdao.updateprofile(sr,user);
		return "redirect:/student";
		
	}
	
	
	@RequestMapping(value="/student/subjectinfo/{subject}/addfeedback",method=RequestMethod.GET)
	public String addfeedback(@PathVariable(value="subject") String sid,Model model, Principal principal) {
		
		model.addAttribute("sr", new Feedback());
		model.addAttribute("sname",sid);

		
		return "addfeedback";
		
		
		
	}
	
	@RequestMapping(value="/student/subjectinfo/{subject}/addfeedback",method=RequestMethod.POST)
	public String addfeedbackprocess(@PathVariable(value="subject") String sid,@ModelAttribute("sr") Feedback sr,BindingResult result,Model model) {
		
		fd.addfeedback(sr,sid);
		return "redirect:/student";
	}
	
	
	@RequestMapping(value="/student/subjectinfo/{blogId}/addcomments",method=RequestMethod.GET)
	public String addcomments(@PathVariable(value="blogId") int bid,Model model, Principal principal) {
		
		model.addAttribute("sr", new Blogcomments());
		model.addAttribute("blogid",bid);

		
		return "addcomments";
	}
	
	@RequestMapping(value="/student/subjectinfo/{blogId}/addcomments",method=RequestMethod.POST)
	public String addcommentsprocess(@PathVariable(value="blogId") int bid,@ModelAttribute("sr") Blogcomments sr,BindingResult result,Model model) {
		
		

		bcd.addblogcomment(sr,bid);
		return "redirect:/student";
	}
	
	
	
	

	
	
	
	
	
	
	

}




