package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Department;

/**
 * 
 * @author Zar Li Hnin
 *
 */
public interface DepartmentDao {
	/**
	 * 全ての部署を取得する
	 * @return 部署リスト
	 */
	public List<Department> list();
}