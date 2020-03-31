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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "workplace")
	private String workplace;

	@Column(name = "gender")
	private String gender;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date entryDate;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date leaveDate;

}
