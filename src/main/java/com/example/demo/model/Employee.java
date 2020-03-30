package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

	// 一旦、テーブルのカラム名は変更しないでおく

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_age")
	private int age;

	@Column(name = "emp_workplace")
	private String workplace;

	@Column(name = "emp_gender")
	private String gender;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date entryDate;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date leaveDate;

}
