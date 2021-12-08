package com.companyportal.app.dao;

import java.util.List;

import com.companyportal.app.entity.Employee;

public interface EmployeeDao {

	void saveOrUpdateEmployeeData(Employee employee);

	List<Employee> getEmployeesData();

	void deleteEmployeeData(Employee employee);

	Employee getEmployeeById(int employeeId);

	List<Employee> searchEmployeeByName(String employeeName);

}
