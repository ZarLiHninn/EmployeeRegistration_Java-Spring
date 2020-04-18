package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	    @Query("SELECT e FROM Employee e WHERE e.name =:search_data or e.age=:search_data or e.department.type=:search_data or e.gender=:search_data") 
	    List<Employee> findBySearch_data(@Param("search_data") String search_data);
		




}
