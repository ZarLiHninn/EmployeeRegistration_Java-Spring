package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.model.Department;

/**
 * 
 * @author Zar Li Hnin
 *
 */
@Repository
@Transactional
public class DeparmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	/**
	 * 
	 */
	@Override
	public List<Department> listAll() {
		return departmentDao.list();
		
	}

}
