package com.crud.dao;

import java.util.List;

import com.crud.pojo.Employee;

public interface EmployeeDao {
	
	public int save(Employee e);
	public int update(Employee e);
	public int delete(int id);
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployee();

}
