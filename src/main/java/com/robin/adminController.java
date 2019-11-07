package com.robin;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robin.Studentdao;
import com.robin.Student;
import com.robin.Teacherdao;
import com.robin.Teacher;
import com.robin.Exam;
import com.robin.Examdao;
import com.robin.StudentResult;





@Controller
public class adminController {
	
	
	@Autowired 
	Studentdao studentdao;
	
	@Autowired
	Teacherdao teacherdao;
	
	@Autowired
	Examdao examdao;
	
	@Autowired
	StudentResultdao srd;
	
	@Autowired
	Coursedao coursedao;
	
	@Autowired
	Subjectdao subjectdao;
	
	@Autowired
	Feedbackdao feedbackdao;
	
	
	
	@RequestMapping(value = "/admin/studentsinfo")
	public String showstudents(Model model) {
		
		List<Student> list=studentdao.getall();
		
		/*for(User l : list) {
            System.out.println(l.getName());
        }*/
		
		
		model.addAttribute("student",list);
		return "adminstudents";
		
		
	}

	@RequestMapping("/admin/teachersinfo")
	public String showteachers(Model model, Principal principal) {
		
		
		List<Teacher> list=teacherdao.getall();
		
		model.addAttribute("teacher",list);
		return "adminteachers";

	}
	@RequestMapping("/admin/examsinfo")
	public String showexams(Model model, Principal principal) {

		List<Exam> list =examdao.getall();
		
		model.addAttribute("exam",list);
		return "adminexams";
		
	}
	
	

	
	@RequestMapping("/admin/examsinfo/addresult/{examId}")
	public String addexamresult(@PathVariable(value="examId") int examId,Model model, Principal principal) {

		
		List<Student> list=studentdao.getallbyexam(examId);

		model.addAttribute("student",list);
		model.addAttribute("idexam",examId);

		return "addexamresult";
		
	}
	
	
	@RequestMapping(value="/admin/examsinfo/addresult/{examId}/{username}",method=RequestMethod.GET)
	public String addexamresult2(@PathVariable(value="examId") int examId,@PathVariable(value="username") String username,Model model) {

		
		
		model.addAttribute("sr", new StudentResult());
		model.addAttribute("examId",examId);
		model.addAttribute("uname",username);

		return "addresultform";
		
	}
	
	@RequestMapping(value="/admin/examsinfo/addresult/{examId}/{username}",method=RequestMethod.POST)
	public String addresultprocess(@PathVariable(value="examId") int examId,@PathVariable(value="username") String username,@ModelAttribute("sr") StudentResult sr,BindingResult result,Model model) {
		srd.addresult(sr);
		return "redirect:/admin/examsinfo/addresult/" + examId;
	}
	
	
	@RequestMapping(value = "/admin/subjectsinfo")
	public String showsubjectsandClasses(Model model) {
		
		List<Course> list1=coursedao.getall();
		List<Subject> list2 = subjectdao.getall();
		
		/*for(User l : list) {
            System.out.println(l.getName());;
        }*/
		
		
		model.addAttribute("subject",list2);
		model.addAttribute("course",list1);
		return "subjectandcourse";
		
		
	}
	
	


	@RequestMapping(value = "/admin/feedbacks", method = RequestMethod.GET)
	public String showfeedbacks(ModelMap model) {

		List<Feedback> list =feedbackdao.getall();
		
		model.addAttribute("feedback",list);
		return "feedback";

	}
	
	@RequestMapping(value = "/admin/studentsinfo/addstudent", method = RequestMethod.GET)
	public String addstudent(ModelMap model) {

		model.addAttribute("sr", new Student());

		
		return "addstudent";

	}
	
	
	@RequestMapping(value = "/admin/studentsinfo/addstudent", method = RequestMethod.POST)
	public String addstudentprocess(@ModelAttribute("sr") Student sr,BindingResult result,Model model) {

		studentdao.addstudent(sr);
		return "redirect:/admin/studentsinfo";
		
		

	}
	
	
	@RequestMapping(value = "/admin/teachersinfo/addteacher", method = RequestMethod.GET)
	public String addteacher(ModelMap model) {

		model.addAttribute("sr", new Teacher());

		
		return "addteacher";

	}
	
	@RequestMapping(value = "/admin/teachersinfo/addteacher", method = RequestMethod.POST)
	public String addteacherprocess(@ModelAttribute("sr") Teacher sr,BindingResult result,Model model) {

		teacherdao.addteacher(sr);
		return "redirect:/admin/teachersinfo";
		
		

	}
	
	
	

	
	
	@RequestMapping(value = "/admin/examsinfo/addexam", method = RequestMethod.GET)
	public String addexam(ModelMap model) {

		model.addAttribute("sr", new Exam());

		
		return "addexam";

	}
	
	@RequestMapping(value = "/admin/examsinfo/addexam", method = RequestMethod.POST)
	public String addexamprocess(@ModelAttribute("sr") Exam sr,BindingResult result,Model model) {

		examdao.addexam(sr);
		return "redirect:/admin/examsinfo";
		
		

	}
	
	//admin/subjectsinfo/addsubject
	
	
	@RequestMapping(value = "/admin/subjectsinfo/addcourse", method = RequestMethod.GET)
	public String addcourse(ModelMap model) {

		model.addAttribute("sr", new Course());

		
		return "addcourse";

	}
	
	@RequestMapping(value = "/admin/subjectsinfo/addcourse", method = RequestMethod.POST)
	public String addcourseprocess(@ModelAttribute("sr") Course sr,BindingResult result,Model model) {

		coursedao.addcourse(sr);
		return "redirect:/admin/subjectsinfo";
		
		

	}
	
	
	@RequestMapping(value = "/admin/subjectsinfo/addsubject", method = RequestMethod.GET)
	public String addsubject(ModelMap model) {

		model.addAttribute("sr", new Subject());

		
		return "addsubject";

	}
	
	@RequestMapping(value = "/admin/subjectsinfo/addsubject", method = RequestMethod.POST)
	public String addsubjectprocess(@ModelAttribute("sr") Subject sr,BindingResult result,Model model) {

		subjectdao.addsubject(sr);
		return "redirect:/admin/subjectsinfo";
		
		

	}
	
	
	
	
	
	

	
	/*@RequestMapping(value="/admin/studentsinfo/deletestudent/{username}")
	public String deletestudent(@PathVariable(value="username") String uname,HttpServletRequest request)
	{
//		String uid=request.getUserPrincipal().getName();
		studentdao.deletestudent(uname);
		return "redirect:/admin/studentsinfo";
	}
	
	
	@RequestMapping(value = "/admin/studentsinfo/editstudent/{username}")
	public String editstudent(@PathVariable(value="username") String uname,Model model) {

		//studentdao.addstudent(sr);
		Student student = studentdao.getbyid(uname);
		model.addAttribute("student",student);
		model.addAttribute("uname",uname);
		//model.addAttribute("id",itemId);
		return "editstudent";
		//return "redirect:/admin/studentsinfo";
		
		

	}
	
	@RequestMapping(value="/admin/studentsinfo/editstudent/{username}",method=RequestMethod.POST)
	public String editstudentprocess(@ModelAttribute("student") Student student,@PathVariable(value="username") String uname,Model model) {
		studentdao.editstudent(student);

		return "redirect:/admin/studentsinfo";
	}*/
	
	
	
	
	
	


}
