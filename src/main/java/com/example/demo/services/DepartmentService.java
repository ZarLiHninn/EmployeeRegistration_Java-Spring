package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Department;

@Service
public interface DepartmentService {

	public List<Department> listAll();
}
