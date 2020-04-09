package com.example.demo.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.example.demo.model.Department;

import lombok.Data;

@Component
@Data
public class EmployeeForm {

	private int id;

	private String name;

	private String age;

	private Department department;

	private String gender;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date entryDate;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date leaveDate;

}
