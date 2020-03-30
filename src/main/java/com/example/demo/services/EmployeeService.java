package com.example.demo.services;

import java.util.List;

import com.example.demo.controller.form.EmployeeForm;

public interface  EmployeeService {

	/**
	 * すべての従業員を取得する
	 * @return 従業員リスト
	 */
	public List<EmployeeForm> listAll();

	/**
	 * 従業員を登録する
	 * @param employee
	 */
	public void save(EmployeeForm employeeForm);
}
