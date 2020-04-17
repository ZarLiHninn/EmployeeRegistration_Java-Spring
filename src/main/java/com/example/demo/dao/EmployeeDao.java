package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Employee;

@Repository
@Transactional
public interface EmployeeDao {

	public List<Employee> list();

	@Transactional(rollbackFor = { Exception.class })
	public int save(Employee employee);

	public Employee get(int id);

	@Transactional(rollbackFor = { Exception.class })
	public void update(Employee employee);

	public void delete(int id);

	public List<Employee> search(String searchData);

}
