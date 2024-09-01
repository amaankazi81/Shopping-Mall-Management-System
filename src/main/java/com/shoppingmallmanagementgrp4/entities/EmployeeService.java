package com.shoppingmallmanagementgrp4.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeeservice")
public class EmployeeService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private LocalDate dob;
	private float salary;
	private String address;
	private String designation;
	
//	@ManyToOne
//	@JoinColumn(name="shop_id")
//	private Shop shop;
	
	public EmployeeService() {
		super();
	}

	public EmployeeService(Integer id, String name, LocalDate dob, float salary, String address, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.address = address;
		this.designation = designation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "EmployeeService [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", address="
				+ address + ", designation=" + designation + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getDob()=" + getDob() + ", getSalary()=" + getSalary() + ", getAddress()=" + getAddress()
				+ ", getDesignation()=" + getDesignation() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
