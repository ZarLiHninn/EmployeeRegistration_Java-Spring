package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeForm;
import com.example.demo.model.Employee;

@Service
public interface EmployeeService {

	public List<EmployeeForm> listAll();

	public void save(EmployeeForm employeeForm);
	
	public void delete(Integer id);
	
	public EmployeeForm getEmployeeUpdateForm(Integer id);

	public void updateEmployee(EmployeeForm employeeForm);

	public List<Employee> getSearchData(String search_data);
	
}
