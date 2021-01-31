package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.PersonRepo;
import com.example.demo.model.Person;

@Controller
public class PersonController {
	
	@Autowired  // it instantiates the object
	PersonRepo repo;

	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	// Add records to table
	@RequestMapping("/addPerson")
	public String addPerson(Person person)
	{
		repo.save(person);
		return "home.jsp";
	}
	
	@RequestMapping("/getPerson")
	public ModelAndView getPerson(@RequestParam int pid)	// with the view we need to send data ==> Model and View
	{
		ModelAndView mv = new ModelAndView("showPerson.jsp");
		Person person = repo.findById(pid).orElse(new Person()); 	// If it return null values ==> orElse() method to handle it
		
		// Customized
		System.out.println(repo.findByLang("Kannada"));
		System.out.println(repo.findByPname("Raju"));
		System.out.println((repo.findByPidGreaterThan(pid)));
		
		// Complex Query
		System.out.println(repo.findByLangSorted("English"));
		
		mv.addObject(person);
		return mv;
	}
}
