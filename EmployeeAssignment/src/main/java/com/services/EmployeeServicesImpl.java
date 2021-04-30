package com.services;

import com.dao.IEmployeeDAO;
import com.model.Employee;

import java.util.List;

public class EmployeeServicesImpl implements IEmployeeServices{
	
	//private static HashMap<Long, Employee> employeeMap = new HashMap<Long, Employee>();
	//private static long employeeIdCounter = 1;
	//private EmployeeDAO empDao = new EmployeeDAO();
	private IEmployeeDAO empDao;
	
	public void setEmpDao(IEmployeeDAO empDao)
	{
		this.empDao = empDao;
	}
	
	public void addEmployee(Employee employee)
	{
		//long lastId = getLastEmployeeId();
		//employee.setEmpId(++lastId);
		//employeeMap.put(employeeIdCounter, employee);
		//employeeIdCounter++;
		//return employee.getEmpId();
		empDao.addEmployee(employee);
		
	}
	
	public List<Employee> getEmployee()
	{
		List<Employee> empList = empDao.getEmployee();
		
		//return empList.toString();
		return empList;
	}
	
	public Employee getEmployeeById(long empId)
	{
		/*if(employeeMap.containsKey(id))
		{
			return employeeMap.get(id);
		}
		return null;*/
		Employee emp = empDao.getEmployeeById(empId);
		return emp;
	}
	
	public void deleteEmployee(long empId)
	{
		/*if(employeeMap.containsKey(id))
		{
			employeeMap.remove(id);
			return true;
		}
		return false;*/
		empDao.deleteEmployee(empId);
	}
	
	public void updateEmployeeName(String empName, long empId)
	{
		/*if(employeeMap.containsKey(id))
		{
			employeeMap.get(id).setEmpName(name);
			return employeeMap.get(id).getEmpId();
		}
		return 0;*/
		empDao.updateEmployeeName(empName, empId);
	}
	
	public void updateEmployeeAge(int empAge, long empId)
	{
		/*if(employeeMap.containsKey(id))
		{
			employeeMap.get(id).setEmpAge(age);
			return employeeMap.get(id).getEmpId();
		}
		return 0;*/
		empDao.updateEmployeeAge(empAge, empId);
	}
	
	public void updateEmployeeAddress(String empAddress, long empId)
	{
		/*if(employeeMap.containsKey(id))
		{
			employeeMap.get(id).setEmpAddress(address);
			return employeeMap.get(id).getEmpId();
		}
		return 0;*/
		empDao.updateEmployeeAddress(empAddress, empId);
		
	}
}
