package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;

/**
 * 
 * @author Zar Li Hnin
 *
 */
@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Employee emp;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Employee> list() {
		// 従業員リストを取得する
		String sql = "SELECT * FROM employee e,department d where e.department_id=d.id";

		List<Employee> employees = new ArrayList<>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map row : rows) {
			Employee emp = new Employee();

			emp.setId((int) row.get("id"));
			emp.setName((String) row.get("name"));
			emp.setAge((int) row.get("age"));
			Department department = new Department();
			department.setId((int) row.get("id"));
			department.setType((String) row.get("type"));
			emp.setDepartment(department);
			emp.setGender((String) row.get("gender"));
			emp.setEntryDate((Date) row.get("entry_date"));
			emp.setLeaveDate((Date) row.get("leave_date"));
			employees.add(emp);
		}

		return employees;
	}

	/**
	 * 
	 */
	@Override
	public int save(Employee employee) {
		// 従業員テーブルに登録する
		return jdbcTemplate.update(
				"insert into employee (id,name, age,department_id,gender,entry_date,leave_date) values(?,?,?,?,?,?,?)",
				employee.getId(), employee.getName(), employee.getAge(), employee.getDepartment().getId(),
				employee.getGender(), employee.getEntryDate(), employee.getLeaveDate());

	}

	/**
	 * 
	 */
	@Override
	public Employee get(int id) {
		//更新したいデータを取得する
		String sql = "SELECT * FROM employee e,department d where e.department_id=d.id and e.id = ?";
		Object[] args = { id };

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);

		for (Map row : rows) {
			emp = new Employee();
			emp.setId((int) row.get("id"));
			emp.setName((String) row.get("name"));
			emp.setAge((int) row.get("age"));
			Department department = new Department();
			department.setId((int) row.get("department_id"));
			emp.setDepartment(department);
			emp.setGender((String) row.get("gender"));
			emp.setEntryDate((Date) row.get("entry_date"));
			emp.setLeaveDate((Date) row.get("leave_date"));

		}
		//employee modelにセットする
		return emp;
	}

	/**
	 * 
	 */
	@Override
	public void update(Employee employee) {
		//直したデータを更新する
		String query = "update employee set id=?, name=?, age=?,department_id=?,gender=?,entry_date=?,leave_date=? where id=?";

		jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getAge(),
				employee.getDepartment().getId(), employee.getGender(), employee.getEntryDate(),
				employee.getLeaveDate(), employee.getId());

	}

	/**
	 * 
	 */
	@Override
	public void delete(int id) {
		//削除する
		String sql = "DELETE FROM employee WHERE id = ?";
		jdbcTemplate.update(sql, id);

	}

	/**
	 * 
	 */
	@Override
	public List<Employee> search(String searchData) {
		//検索したデータを表示する
		String sql = "SELECT * FROM employee e,department d where e.department_id=d.id and (e.name LIKE ? or e.age LIKE ? or d.type LIKE ? or e.gender LIKE ? )";
		Object[] args = { searchData + "%", searchData + "%", searchData + "%", searchData + "%" };
		List<Employee> employees = new ArrayList<>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, args);

		for (Map row : rows) {
			Employee emp = new Employee();

			emp.setId((int) row.get("id"));
			emp.setName((String) row.get("name"));
			emp.setAge((int) row.get("age"));
			Department department = new Department();
			department.setId((int) row.get("id"));
			department.setType((String) row.get("type"));
			emp.setDepartment(department);
			emp.setGender((String) row.get("gender"));
			emp.setEntryDate((Date) row.get("entry_date"));
			emp.setLeaveDate((Date) row.get("leave_date"));
			employees.add(emp);
		}

		return employees;

	}
}
