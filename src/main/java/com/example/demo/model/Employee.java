package com.example.demo.model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotEmpty(message = "名前が必要です。")
	@Size(min = 2, max = 30, message = "名前が少なくとも二つで、せいぜい三十個です。")
	private String name;

	@Min(value = 18, message = "年齢が少なくとも１８さいです。")
	private int age;

	private Department department;

	private String gender;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date entryDate;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date leaveDate;

}
