package com.robin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	
	@Autowired
	Subjectdao sdao;
	
	@Autowired
	Blogdao blogdao;
	
	@Autowired
	Blogcommentsdao blogcommentsdao;

	
	@RequestMapping(value = {"/home","/"})
	public String welcome(Model model) {
		model.addAttribute("name", "Home Page");
		model.addAttribute("description", "Page yet to be completed!");
		return "home";
	}

	@RequestMapping("/admin")
	public String admin(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security Custom Login Demo");
		model.addAttribute("description", "Protected page !");
		return "admin";
	}
	@RequestMapping("/student")
	public String user(Model model, Principal principal) {
		
		

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		//model.addAttribute("name", "Spring Security USER Custom Login Demo");
		model.addAttribute("description", "Protected page for user !");
		return "student";
	}
	
	
	@RequestMapping("/teacher")
	public String teacher(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		System.out.println(loggedInUserName);
		model.addAttribute("user", loggedInUserName);
		
		
		return "teacherhome";
	}
	
	
	@RequestMapping("/teacher/{user}")
	public String teacher(@PathVariable(value="user") String user, Model model, Principal principal) {

		
		 if (principal != null) {
			 model.addAttribute("user",user);
				Subject sub = sdao.getbyteacher(user);
				//System.out.println(sub.getSubjectId());
				model.addAttribute("subjectname",sub.getSubjectName());
				
				List<Blog> list=blogdao.getallbysid(sub.getSubjectName());
				//model.addAttribute("subject",sid);
				model.addAttribute("blog",list);
				//return "subjectdashboard";
				
				return "teacher";
	 
	        }
	 
		 else
		 {
			 return "teacherhome";
		 }
		

	}
	
	
	

	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
//		model.addAttribute("message",
//				"You have successfully logged off from application !");
		return "login";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";

	}
	
	
}
