package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;

/**
 * 
 * @author Zar Li Hnin
 *
 */
public interface DepartmentService {
	
	/**
	 * 全ての部署を取得する
	 * @return 部署リスト
	 */
    public List<Department> listAll();
}
