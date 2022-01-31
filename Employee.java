package com.klef.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emps_table")
public class Employee {
@Id
@Column(name="emp_id")
 private int id;
@Column(name="emp_name")
 private String name;
@Column(name="emp_salary")
 private double salary;
@Column(name="emp_location")
 private String location;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
 
}
