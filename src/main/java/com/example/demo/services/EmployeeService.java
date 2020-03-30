package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	public List<Employee> listAll() {
		return repo.findAll();
	}

	public void save(Employee employee) {
		repo.save(employee);
	}
}
