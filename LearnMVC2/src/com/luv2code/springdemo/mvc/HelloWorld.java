package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloWorld {
	
	@RequestMapping("/")
	public String showPage(Model theModel) {
		theModel.addAttribute("student", new Student()); 
		return "index";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {	//HttpServletRequest: this contains all the form data
		System.out.println(theStudent.getFirstName());
		System.out.println(theStudent.getLastName());
		System.out.println(theStudent.getCountry());
		System.out.println(theStudent.getFavoriteLanguage());
		System.out.println(theStudent.getOperatingSystems()[0]);
		return "processForm";
	}
}