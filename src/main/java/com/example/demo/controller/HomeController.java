package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
    private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	@Qualifier("genders")
	private List<String> genders;
	
	@RequestMapping("/")
	public String showNewForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		List<Department> departmentList = departmentDao.list();
		List<String> genderList = genders;
		model.addAttribute("dList", departmentList);
		model.addAttribute("gList", genderList);
		model.addAttribute("no_update", "disabled");
		return "input";
	}
	@RequestMapping(value = "/submit_form", method = RequestMethod.POST, params = "action=submit")
	public String confirm(@Valid Employee employee,BindingResult bindingResult, ModelMap map) {

		if (bindingResult.hasErrors()) {
			List<Department> departmentList = departmentDao.list();
			List<String> genderList = genders;
			map.addAttribute("dList", departmentList);
			map.addAttribute("gList", genderList);
			map.addAttribute("no_update", "disabled");
			return "input";
		}
		
		map.put("employee", employee);
		System.out.println(employee.getDepartment());
		return "confirm_page";
	}
	@RequestMapping(value = "/submit_form", method = RequestMethod.POST, params = "action=update")
	public String updateEmployeeSave(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			List<Department> departmentList = departmentDao.list();
			List<String> genderList = genders;
			model.addAttribute("dList", departmentList);
			model.addAttribute("gList", genderList);
			model.addAttribute("no_input", "disabled");
			model.addAttribute("update_text","更新しましょう！");
			return "input";
		}
		employeeDao.update(employee);
		
	        return "redirect:/employeeList";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee, Model model) {
		employeeDao.save(employee);
		List<Employee> listEmployee = employeeDao.list();
		model.addAttribute("listAll", listEmployee);
	        return "register";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable(name = "id") Integer id, ModelMap model) {
		Employee employee = employeeDao.get(id);
		List<Department> departmentList = departmentDao.list();
		List<String> genderList = genders;
		model.addAttribute("dList", departmentList);
		model.addAttribute("gList", genderList);
		model.addAttribute("employee", employee);
		model.addAttribute("no_input", "disabled");
		model.addAttribute("update_text","更新しましょう！");
		return "input";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
		employeeDao.delete(id);
		return "redirect:/employeeList";
	}
	
	@RequestMapping(value = "/search")
	public String recoverPass(@RequestParam("search_data") String search_data, Model model) {
       
		List<Employee> listAll = employeeDao.search(search_data);
		model.addAttribute("listAll", listAll);
		return "register";

	}
	
	@RequestMapping("/employeeList")
	public String viewEmployeeList(Model model) {
	    List<Employee> listEmployee = employeeDao.list();
	    model.addAttribute("listAll", listEmployee);
	    return "register";
	}
	
	@GetMapping("/back")
	public String back() {
		return "redirect:/";
	}
}
