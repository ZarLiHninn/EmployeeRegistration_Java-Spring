package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class Employee {
  private String name;
  private int age;
  private List<String> work_place;
  private Genders gender;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date entry_date;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date leave_date;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public List<String> getWork_place() {
	return work_place;
}
public void setWork_place(List<String> work_place) {
	this.work_place = work_place;
}
public Genders getGender() {
	return gender;
}
public void setGender(Genders gender) {
	this.gender = gender;
}
public Date getEntry_date() {
	return entry_date;
}
public void setEntry_date(Date entry_date) {
	this.entry_date = entry_date;
}
public Date getLeave_date() {
	return leave_date;
}
public void setLeave_date(Date leave_date) {
	this.leave_date = leave_date;
}


  
}
