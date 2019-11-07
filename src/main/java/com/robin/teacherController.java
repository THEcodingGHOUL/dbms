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


@Controller
public class teacherController {
	
	
	@Autowired
	Blogdao blogdao;
	
	@Autowired
	Blogcommentsdao blogcommentsdao;
	

	
	@RequestMapping(value = "/teacher/addnot/{subjectName}")
	public String addnotifications(@PathVariable(value="subjectName") String sid,Model model) {
		
		
		model.addAttribute("subjectId",sid);
		
		model.addAttribute("sr", new Blog());

		
		return "subjectnotifications";
		
		
		
	}
	
	@RequestMapping(value = "/teacher/addnot/{subjectName}", method = RequestMethod.POST)
	public String addnotificationprocess(@PathVariable(value="subjectName") String sid,@ModelAttribute("sr") Blog sr,BindingResult result,Model model) {

		blogdao.addblog(sr,sid);
		return "redirect:/teacher";
		
		

	}
	
	@RequestMapping(value="/teacher/{blogId}/showcomments")
	public String showcommentsteacher(@PathVariable(value="blogId") int bid,Model model, Principal principal) {
		
		List<Blogcomments> list=blogcommentsdao.getallbybid(bid);
		//model.addAttribute("subject",sid);
		model.addAttribute("blogid",bid);
		model.addAttribute("blogcomments",list);
		return "showcomments-teacher";
	}
	
	

	
	@RequestMapping(value="/teacher/{blogId}/addcomments",method=RequestMethod.GET)
	public String addcommentsteacher(@PathVariable(value="blogId") int bid,Model model, Principal principal) {
		
		model.addAttribute("sr", new Blogcomments());
		model.addAttribute("blogid",bid);

		
		return "addcomments-teacher";
	}
	
	@RequestMapping(value="/teacher/{blogId}/addcomments",method=RequestMethod.POST)
	public String addcommentsteacherprocess(@PathVariable(value="blogId") int bid,@ModelAttribute("sr") Blogcomments sr,BindingResult result,Model model) {
		
		

		blogcommentsdao.addblogcomment(sr,bid);
		return "redirect:/teacher";
	}
	
	
	

}


