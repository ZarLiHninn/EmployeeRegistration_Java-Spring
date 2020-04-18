package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.EmployeeForm;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.services.DepartmentService;
import com.example.demo.services.EmployeeService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	@Qualifier("genders")
	private List<String> genders;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeForm employeeForm;

	@GetMapping("/")
	public String viewInputPage(Model model) {
		EmployeeForm employeeForm = new EmployeeForm();
		model.addAttribute("employee", employeeForm);
		List<Department> departmentList = departmentService.listAll();
		List<String> genderList = genders;
		model.addAttribute("dList", departmentList);
		model.addAttribute("gList", genderList);
		model.addAttribute("no_update", "disabled");
		return "input";
	}

	@RequestMapping(value = "/submit_form", method = RequestMethod.POST, params = "action=submit")
	public String confirm(EmployeeForm employeeForm, ModelMap map) {
		map.put("employee", employeeForm);
		return "confirm_page";
	}

	@RequestMapping(value = "/submit_form", method = RequestMethod.POST, params = "action=update")
	public String updateEmployeeSave(EmployeeForm employeeForm1, ModelMap model) {
		employeeService.updateEmployee(employeeForm1);
		System.out.println(employeeForm1.getName());
		return "redirect:/employeeList";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("employee") EmployeeForm employeeForm, Model model) {
		employeeService.save(employeeForm);
		List<EmployeeForm> listAll = employeeService.listAll();
		model.addAttribute("listAll", listAll);
		return "register";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable(name = "id") Integer id, Model model) {
		employeeForm = employeeService.getEmployeeUpdateForm(id);
		List<Department> departmentList = departmentService.listAll();
		List<String> genderList = genders;
		model.addAttribute("dList", departmentList);
		model.addAttribute("gList", genderList);
		model.addAttribute("employee", employeeForm);
		model.addAttribute("no_input", "disabled");
		return "input";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") Integer id) {
		employeeService.delete(id);
		return "redirect:/employeeList";
	}

	@GetMapping("/employeeList")
	public String employeeList(Model model) {
		List<EmployeeForm> listAll = employeeService.listAll();
		model.addAttribute("listAll", listAll);
		return "register";

	}

	@RequestMapping(value = "/search")
	public String recoverPass(@RequestParam("search_data") String search_data, Model model) {

		List<Employee> listAll = employeeService.getSearchData(search_data);
		model.addAttribute("listAll", listAll);
		return "register";

	}

	@GetMapping("/back")
	public String back() {
		return "redirect:/";
	}

}
