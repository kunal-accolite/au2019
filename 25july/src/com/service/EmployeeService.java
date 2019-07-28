package com.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/employee-service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeService {
	private static Map<Integer,Employee> employeelist=new HashMap<Integer,Employee>();
	
	@GET
	@Path("/employees")
	public Employee[] getAllEmployees()
	{
			Set<Integer> ids = employeelist.keySet();
			Employee[] e = new Employee[ids.size()];
			int i=0;
			for(Integer id : ids){
				e[i] = employeelist.get(id);
				i++;
			}
			return e;
	}
	
	
	@POST
	@Path("/add")
	public String addEmployee(Employee e1)
	{
		if(employeelist.get(e1.getId()) != null){
			return "employee Already Exists";
		}
		
		employeelist.put(e1.getId(), e1);
		return "employee added succesfully";
	}
	
	
	@GET
	@Path("/{id}/delete")
	public String deleteEmployee(@PathParam("id") int id)
	{
		if(employeelist.isEmpty())
			return "employee not found";
		
		if(employeelist.containsKey(id))
		{
			employeelist.remove(id);
			return "employee deleted successfully";
		}
		
		return "employee not found";
	}
	
	@GET
	@Path("/{id}/search")
	public String searchEmployee(@PathParam("id") int id)
	{
		if(employeelist.isEmpty())
			return "employee not found";
		
		if(employeelist.containsKey(id))
			return employeelist.get(id).toString();
		
		return "employee not found";
	}
	
	@GET
	@Path("/{id}/modify")
	public String modifyEmployee(@PathParam("id") int id)
	{
		if(employeelist.get(id)!=null) {
			Employee e=employeelist.get(id);
			int age=e.getAge()+1;
			e.setAge(age);
			employeelist.replace(id, e);
			return "employee updated successfully";
		}
		return "employee not found";
			
	}
}
