package com.example.demo.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeForm;

@Service
public interface EmployeeService {

	public List<EmployeeForm> listAll();

	public void save(EmployeeForm employeeForm);
}
