package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Employee;

/**
 * 
 * @author Zar Li Hnin
 *
 */
public interface EmployeeService {

	/**
	 * すべての従業員を取得する
	 * @return 従業員リスト
	 */
	public List<Employee> listAll();

	/**
	 * 従業員を登録する
	 * @param employee入力されたデータ
	 * @return
	 */
	@Transactional(rollbackFor = { Exception.class })
	public void create(Employee employee);

	/**
	 * 更新したいデータのidをもらえる
	 * @param id
	 * @return
	 */
	public Employee getOneData(int id);

	/**
	 * 直したデータを更新する
	 * @param employee
	 */
	@Transactional(rollbackFor = { Exception.class })
	public void update(Employee employee);

	/**
	 *　削除したいデータをもらえて、削除する
	 * @param id
	 */
	public void delete(int id);

	/**
	 * 検索する
	 * @param searchData
	 * @return　検索したいデータを表示する
	 */
	public List<Employee> search(String searchData);
}
