package com.example.demo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity
@Table(name = "employee")
@Getter @Setter
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="department_id")
	private Department department;

	@Column(name = "gender")
	private String gender;

	@Column(name="entry_date")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date entryDate;

	@Column(name="leave_date")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date leaveDate;

	

}
