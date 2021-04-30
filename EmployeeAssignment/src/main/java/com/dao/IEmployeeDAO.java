package com.dao;

import java.util.List;

import com.model.Employee;

public interface IEmployeeDAO {
	
	void addEmployee(Employee emp);
	
	List<Employee> getEmployee();
	
	Employee getEmployeeById(long empId);
	
	void deleteEmployee(long empId);
	
	void updateEmployeeName(String empName, long empId);
	
	void updateEmployeeAge(int empAge, long empId);
	
	void updateEmployeeAddress(String empAddress, long empId);

}
