package com.accolite.employee.main;

import java.util.ArrayList;

import com.accolite.employee.model.Employee;

public class EmployeeApplication {
	
	ArrayList<Employee> employeelist = new ArrayList<Employee>();
	public Employee addEmployee(Employee employee)
	{
		this.employeelist.add(employee);
		return employee;
	}
	
	public boolean deleteEmployee(Employee employee) 
	{
		if(this.employeelist.contains(employee))
			return this.employeelist.remove(employee);
		else return false;
	}
	
	public ArrayList<Employee> getAllEmployees()
	{
			return this.employeelist;
	}
	
	public Employee findById(int id)
	{
		for(Employee e:employeelist)
		{
			if(e.getId()==id)
				return e;
		}
		throw new NullPointerException();
	}
	
	public Employee updateById(int id)
	{
		for(Employee e:this.employeelist)
		{
			if(e.getId()==id)
			{
				e.setSalary(e.getSalary()+1000);
				return e;
			}
		}
		return null;
	}
}
