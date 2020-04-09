package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
