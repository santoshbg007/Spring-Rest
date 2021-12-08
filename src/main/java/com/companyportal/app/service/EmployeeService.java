package com.companyportal.app.service;

import java.util.List;

import com.companyportal.app.entity.Employee;

public interface EmployeeService {

	public void saveOrUpdateEmployeeData(Employee employee);

	public List<Employee> getEmployeesData();

	public void deleteEmployee(Employee employee);

	public Employee getEmployeeById(int employeeId);

	public List<Employee> searchEmployeebyName(String employeeName);
}
