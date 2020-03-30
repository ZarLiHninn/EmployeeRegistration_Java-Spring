package com.example.demo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.form.EmployeeForm;
import com.example.demo.model.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EmployeeForm> listAll() {
		// 従業員リストを取得する
		List<Employee> employeeList = repo.findAll();

		// formに変換(へんかん)する
		List<EmployeeForm> formList = new ArrayList<>();
		for(Employee employee : employeeList) {
			EmployeeForm form = new EmployeeForm();
			form.setId(Integer.toString(employee.getId()));
			form.setName(employee.getName());
			form.setAge(Integer.toString(employee.getAge()));
			form.setWorkplace(employee.getWorkplace());
			form.setGender(employee.getGender());
			form.setEntryDate(dateToString(employee.getEntryDate()));
			form.setLeaveDate(dateToString(employee.getLeaveDate()));
			formList.add(form);
		}
		return formList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(EmployeeForm employeeForm) {
		// formからentityに変換(へんかん)する
		// Dozer、ModelMapperなどを使用(しよう)する方法(ほうほう)もある
		Employee employee = new Employee();
		employee.setName(employeeForm.getName());
		employee.setAge(Integer.parseInt(employeeForm.getAge())); //nullチェックしていないので未入力だとエラー
		employee.setWorkplace(employeeForm.getWorkplace());
		employee.setGender(employeeForm.getGender());
		employee.setEntryDate(stringToDate(employeeForm.getEntryDate()));
		employee.setLeaveDate(stringToDate(employeeForm.getLeaveDate()));

		// 従業員テーブルに登録する
		repo.save(employee);
	}

	/**
	 * 日付文字列をDate型に変換する
	 * @param str
	 * @return
	 */
	private Date stringToDate(String str) {
		// フォーマットを指定
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        // Date型変換
        try {
			Date formatDate = sdf.parse(str);
			return formatDate;
		} catch (ParseException e) {
			// エラー時の処理を決めていないので、とりあえずnullを返す
			return null;
		}
	}

	/**
	 * Date型を日付文字列に変換する
	 * @param date
	 * @return
	 */
	private String dateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.format(date);
	}

}
