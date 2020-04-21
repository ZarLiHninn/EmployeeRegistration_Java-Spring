package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

/**
 * 
 * @author Zar Li Hnin
 *
 */
@Repository
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	/**
	 * 
	 */
	@Override
	public List<Employee> listAll() {
		return employeeDao.list();
	}

	/**
	 * 
	 */
	@Override
	public void create(Employee employee) {
		employeeDao.save(employee);
	}

	/**
	 * 
	 */
	@Override
	public Employee getOneData(int id) {
		// TODO Auto-generated method stub
		return employeeDao.get(id);
	}

	/**
	 * 
	 */
	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}

	/**
	 * 
	 */
	@Override
	public void delete(int id) {
        employeeDao.delete(id);		
	}

	/**
	 * 
	 */
	@Override
	public List<Employee> search(String searchData) {
		return employeeDao.search(searchData);
	}

}
