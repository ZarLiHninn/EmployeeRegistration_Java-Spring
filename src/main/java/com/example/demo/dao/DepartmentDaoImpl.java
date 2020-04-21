package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Department;

/**
 * 
 * @author Zar Li Hnin
 *
 */
@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Department> list() {
		// 部署リストを取得する
		String sql = "SELECT * FROM department";

		List<Department> departments = new ArrayList<>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map row : rows) {
			Department department = new Department();

			department.setId((int) row.get("id"));
			department.setType((String) row.get("type"));
			departments.add(department);
		}

		return departments;
	}

}
