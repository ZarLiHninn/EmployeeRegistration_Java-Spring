package com.example.demo.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeForm {

	private int id;

	private String name;

	private String age;

	private String workplace;

	private String gender;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date entryDate;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date leaveDate;

}
