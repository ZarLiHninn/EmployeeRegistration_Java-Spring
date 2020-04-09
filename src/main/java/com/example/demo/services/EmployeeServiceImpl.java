package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeForm;
import com.example.demo.model.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public Employee employee;

	@Autowired
	public EmployeeForm employeeForm;

	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<EmployeeForm> listAll() {
		List<Employee> employeeList = repo.findAll();
		List<EmployeeForm> formList = new ArrayList<>();
		for (Employee employee : employeeList) {
			EmployeeForm form = new EmployeeForm();
			form.setId(employee.getId());
			form.setName(employee.getName());
			form.setAge(Integer.toString(employee.getAge()));
			form.setDepartment(employee.getDepartment());
			form.setGender(employee.getGender());
			form.setEntryDate(employee.getEntryDate());
			form.setLeaveDate(employee.getLeaveDate());
			formList.add(form);
		}
		return formList;
	}

	@Override
	public void save(EmployeeForm employeeForm) {
		Employee employee = new Employee();
		employee.setName(employeeForm.getName());
		employee.setAge(Integer.parseInt(employeeForm.getAge()));
		employee.setDepartment(employeeForm.getDepartment());
		employee.setGender(employeeForm.getGender());
		employee.setEntryDate(employeeForm.getEntryDate());
		employee.setLeaveDate(employeeForm.getLeaveDate());

		repo.save(employee);
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public EmployeeForm getEmployeeUpdateForm(Integer id) {
		employee = repo.findById(id).get();
		employeeForm.setId(employee.getId());
		employeeForm.setName(employee.getName());
		employeeForm.setAge(Integer.toString(employee.getAge()));
		employeeForm.setDepartment(employee.getDepartment());
		employeeForm.setGender(employee.getGender());
		employeeForm.setEntryDate(employee.getEntryDate());
		employeeForm.setLeaveDate(employee.getLeaveDate());
		return employeeForm;
	}

	@Override
	public void updateEmployee(EmployeeForm employee_Form) {
		Employee employee1 = repo.findById(employeeForm.getId()).get();
		employee1.setName(employee_Form.getName());
		employee1.setAge(Integer.parseInt(employee_Form.getAge()));
		employee1.setDepartment(employee_Form.getDepartment());
		employee1.setGender(employee_Form.getGender());
		employee1.setEntryDate(employee_Form.getEntryDate());
		employee1.setLeaveDate(employee_Form.getLeaveDate());
		repo.save(employee1);

	}

	@Override
	public List<Employee> getSearchData(String search_data) {
		List<Employee> employee = repo.findBySearch_data(search_data);
		return employee;
	}

}
