package com.dao;

//import java.sql.*;
//import com.connectionUtil.*;

import com.dao.rowmapper.EmployeeModelRowMapper;
import com.model.Employee;
import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class EmployeeDAO {
	
	/*private static ConnectionUtil conUtil = new ConnectionUtil();	
	private static Connection con = conUtil.getConnection();*/
	
	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public void addEmployee(Employee emp)
	{
		final String INSERT_SQL = "insert into employeedetails(empName,empAge,empAddress) values(:empName, :empAge, :empAddress)";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empName",emp.getEmpName());
		parameters.put("empAge",emp.getEmpAge());
		parameters.put("empAddress",emp.getEmpAddress());
		namedParameterJdbcTemplate.update(INSERT_SQL, parameters);
	}
	
	public List<Employee> getEmployee()
	{
		final String SQL_GET_ALL_EMPLOYEE = "select * from EmployeeDetails";
		List<Employee> result = jdbcTemplate.query(SQL_GET_ALL_EMPLOYEE, new EmployeeModelRowMapper());
		return result;
	}
	
	public Employee getEmployeeById(long empId)
	{
		final String SQL_GET_EMPLOYEE_BY_ID = "select * from EmployeeDetails where empId = :empId";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empId", empId);
		List<Employee> result = namedParameterJdbcTemplate.query(SQL_GET_EMPLOYEE_BY_ID, parameters, new EmployeeModelRowMapper());
		if(result!=null && !result.isEmpty())
		{
			return result.get(0);
		}
		return null;
	}
	
	public void deleteEmployee(long empId)
	{
		final String DELETE_EMPLOYEE_SQL = "delete from EmployeeDetails where empId = :empId";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empId", empId);
		namedParameterJdbcTemplate.update(DELETE_EMPLOYEE_SQL, parameters);
	}
	
	public void updateEmployeeName(String empName, long empId)
	{
		final String UPDATE_EMPLOYEE_NAME_SQL = "update EmployeeDetails set empName = :empName where empId = :empId";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empName", empName);
		parameters.put("empId", empId);
		namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_NAME_SQL, parameters);
	}
	
	public void updateEmployeeAge(int empAge, long empId)
	{
		final String UPDATE_EMPLOYEE_AGE_SQL = "update EmployeeDetails set empAge = :empAge where empId = :empId";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empAge", empAge);
		parameters.put("empId", empId);
		namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_AGE_SQL, parameters);
	}
	
	public void updateEmployeeAddress(String empAddress, long empId)
	{
		final String UPDATE_EMPLOYEE_ADDRESS_SQL = "update EmployeeDetails set empAddress = :empAddress where empId = :empId";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empAddress", empAddress);
		parameters.put("empId", empId);
		namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_ADDRESS_SQL, parameters);
	}
	
	
}
