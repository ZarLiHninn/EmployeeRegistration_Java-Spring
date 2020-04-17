package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Department;

@Repository
@Transactional
public interface DepartmentDao {

	public List<Department> list();
}
