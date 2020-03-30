package com.example.demo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_id;

	@Column(name = "emp_name")
	private String emp_name;

	@Column(name = "emp_age")
	private int emp_age;

	@Column(name = "emp_workplace")
	private String emp_workplace;

	@Column(name = "emp_gender")
	private String emp_gender;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date entry_date;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date leave_date;

}
