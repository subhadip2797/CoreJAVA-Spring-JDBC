package com.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Employee;

public class EmployeeModelRowMapper implements RowMapper<Employee>{
	
	public Employee mapRow(ResultSet resultSet, int arg) throws SQLException
	{
		Employee employee = new Employee();
		employee.setEmpId(resultSet.getLong("empId"));
		employee.setEmpName(resultSet.getString("empName"));
		employee.setEmpAge(resultSet.getInt("empAge"));
		employee.setEmpAddress(resultSet.getString("empAddress"));
		
		return employee;
	}

}
