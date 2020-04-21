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

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;

/**
 * このclassはデータとページを管理する
 * @author Zar Li Hnin
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
    private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	@Qualifier("genders")
	private List<String> genders;
	
	/**
	 * 入力ページを表示する
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String showNewForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		List<Department> departmentList = departmentService.listAll();
		List<String> genderList = genders;
		model.addAttribute("dList", departmentList);
		model.addAttribute("gList", genderList);
		model.addAttribute("no_update", "disabled");
		return "input";
	}
	/**
	 * 確認ページを表示する
	 * @param employee入力されたemployeeのデータをもらえる
	 * @param bindingResult　
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/submit_form", method = RequestMethod.POST, params = "action=submit")
	public String confirm(@Valid Employee employee,BindingResult bindingResult, ModelMap map) {

		if (bindingResult.hasErrors()) {
			List<Department> departmentList = departmentService.listAll();
			List<String> genderList = genders;
			map.addAttribute("dList", departmentList);
			map.addAttribute("gList", genderList);
			map.addAttribute("no_update", "disabled");
			return "input";
		}
		
		map.put("employee", employee);
		return "confirm_page";
	}
	/**
	 * 直したemployeeのデータを更新する
	 * @param employee
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/submit_form", method = RequestMethod.POST, params = "action=update")
	public String updateEmployeeSave(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			List<Department> departmentList = departmentService.listAll();
			List<String> genderList = genders;
			model.addAttribute("dList", departmentList);
			model.addAttribute("gList", genderList);
			model.addAttribute("no_input", "disabled");
			model.addAttribute("update_text","更新しましょう！");
			return "input";
		}
		employeeService.update(employee);
		
	        return "redirect:/employeeList";
	}
	
	/**
	 * 従業員を登録する
	 * 登録後、従業員一覧を表示する
	 * @param employee 入力されたデータをもらえる
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee, Model model) {
		employeeService.create(employee);
		List<Employee> listEmployee = employeeService.listAll();
		model.addAttribute("listAll", listEmployee);
	        return "register";
	}
	
	/**
	 * 更新するために入力ページに返す
	 * @param id更新したいデータのidをもらえる
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable(name = "id") Integer id, ModelMap model) {
		Employee employee = employeeService.getOneData(id);
		List<Department> departmentList = departmentService.listAll();
		List<String> genderList = genders;
		model.addAttribute("dList", departmentList);
		model.addAttribute("gList", genderList);
		model.addAttribute("employee", employee);
		model.addAttribute("no_input", "disabled");
		model.addAttribute("update_text","更新しましょう！");
		return "input";
	}
	
	/**
	 * 削除後、従業員一覧を表示する
	 * @param id 削除したいデータのidをもらえる
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
		employeeService.delete(id);
		return "redirect:/employeeList";
	}
	
	/**
	 * 検査したいデータを表示する
	 * @param search_data検索したいデータをもらえる
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search")
	public String recoverPass(@RequestParam("search_data") String search_data, Model model) {
       
		List<Employee> listAll = employeeService.search(search_data);
		model.addAttribute("listAll", listAll);
		return "register";

	}
	
	/**
	 * すべてのデータを表示する
	 * @param model
	 * @return
	 */
	@RequestMapping("/employeeList")
	public String viewEmployeeList(Model model) {
	    List<Employee> listEmployee = employeeService.listAll();
	    model.addAttribute("listAll", listEmployee);
	    return "register";
	}
	
	/**
	 * 入力ページに戻る
	 * @return
	 */
	@GetMapping("/back")
	public String back() {
		return "redirect:/";
	}
}
