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

import com.example.demo.controller.form.EmployeeForm;
import com.example.demo.services.EmployeeService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	@Qualifier("workPlaces")
	private List<String> workPlaces;

	@Autowired
	@Qualifier("genders")
	private List<String> genders;

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 入力ページを表示する
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String viewInputPage(Model model) {
		EmployeeForm employeeForm = new EmployeeForm();
		model.addAttribute("employee", employeeForm);

		List<String> workplaceList = workPlaces;
		List<String> genderList = genders;
		model.addAttribute("wList", workplaceList);
		model.addAttribute("gList", genderList);
		return "input";
	}

	/**
	 * 確認画面を表示する
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@PostMapping("/submit_form")
	public String confirm(EmployeeForm employeeForm, Model model) {
		model.addAttribute("employee", employeeForm);
		return "confirm_page";
	}

	/**
	 * 従業員を登録する
	 * 登録後、従業員一覧を表示する
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") EmployeeForm employeeForm, Model model) {
		// 従業員を登録する
		employeeService.save(employeeForm);

		// 従業員リストを取得する
		List<EmployeeForm> listAll = employeeService.listAll();

		model.addAttribute("listAll", listAll);
		return "register";
	}

	@GetMapping("/back")
	public String back() {
		return "redirect:/";
	}
}
