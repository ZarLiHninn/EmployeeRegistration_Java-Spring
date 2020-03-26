package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Employee;
import com.example.demo.dto.Genders;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	@Qualifier("work_places")
	private List<String> work_places;
	
	
	@GetMapping("/")
   public String index(Model model){
	   return "index";
   }
	
	@PostMapping("/submit_form")
	public String confirm_page(@ModelAttribute Employee employee){
		return "confirm_page";
	}
	
	
	@ModelAttribute("work_places")
    public List<String> work_places(){
  	  return work_places;
    }
	@ModelAttribute("genders")
    public Genders [] genders(){
  	  return Genders.values();
    }
	 @ModelAttribute("dto")
     public Employee emp(){
   	  return new Employee();
     }
}
