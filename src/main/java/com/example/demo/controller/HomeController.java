package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.dto.EmployeeForm;
import com.example.demo.services.EmployeeService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	@Qualifier("work_places")
	private List<String> work_places;

	@Autowired
	@Qualifier("genders")
	private List<String> genders;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String viewInputPage(Model model) {
		EmployeeForm employeeForm = new EmployeeForm();
		model.addAttribute("employee", employeeForm);
		List<String> workplaceList = work_places;
		List<String> genderList = genders;
		model.addAttribute("wList", workplaceList);
		model.addAttribute("gList", genderList);
		return "input";
	}

	@PostMapping("/submit_form")
	public String confirm(EmployeeForm employeeForm, ModelMap map) {
		map.put("employee", employeeForm);
        return "confirm_page";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("employee") EmployeeForm employeeForm, Model model) {
		employeeService.save(employeeForm);
		List<EmployeeForm> listAll = employeeService.listAll();
		model.addAttribute("listAll", listAll);
		return "register";
	}

	@GetMapping("/back")
	public String back() {
		return "redirect:/";
	}
}
