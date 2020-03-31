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
	private EmployeeRepository repo;

	@Override
	public List<EmployeeForm> listAll() {
		List<Employee> employeeList = repo.findAll();
		List<EmployeeForm> formList = new ArrayList<>();
		for(Employee employee : employeeList) {
			EmployeeForm form = new EmployeeForm();
			form.setId(employee.getId());
			form.setName(employee.getName());
			form.setAge(Integer.toString(employee.getAge()));
			form.setWorkplace(employee.getWorkplace());
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
		employee.setWorkplace(employeeForm.getWorkplace());
		employee.setGender(employeeForm.getGender());
		employee.setEntryDate(employeeForm.getEntryDate());
		employee.setLeaveDate(employeeForm.getLeaveDate());

		repo.save(employee);
	}
}
