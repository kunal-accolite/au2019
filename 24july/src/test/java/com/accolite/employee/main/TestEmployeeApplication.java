package com.accolite.employee.main;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accolite.employee.model.Employee;

public class TestEmployeeApplication {
	private static EmployeeApplication app=new EmployeeApplication();
	private static Employee employee=new Employee();
	private static Employee employee1=new Employee();


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		employee.setId(1);
		employee.setAge(23);
		employee.setName("kunal");
		employee.setSalary(60000);
		
		employee1.setId(2);
		employee1.setAge(22);
		employee1.setName("vansh");
		employee1.setSalary(35000);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after all the test cases");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before each test case");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after each test case");
	}

	@Test
	public void testaddEmployee() {
		assertEquals(employee, app.addEmployee(employee));
		assertNotNull(app.addEmployee(employee));
		assertNull(app.addEmployee(null));
		assertTrue(app.addEmployee(employee).getAge()==23);
		assertFalse(app.addEmployee(new Employee()).getAge()>0);
		assertEquals(employee1, app.addEmployee(employee1));
	}
	
	@Test
	public void testdeleteEmployee()
	{
		assertFalse(app.deleteEmployee(new Employee()));
		assertTrue(app.deleteEmployee(employee));
		assertTrue(app.deleteEmployee(employee1));
		assertNotNull(app.deleteEmployee(null));
	}
	
	@Test
	public void testgetAllEmployees() {
		assertEquals(app.employeelist, app.getAllEmployees());
		assertNotNull(app.getAllEmployees());
		assertFalse(app.getAllEmployees()==null);
		assertSame(app.employeelist, app.getAllEmployees());
	}
	
	@Test(expected= NullPointerException.class)
	public void testfindById()
	{
		assertEquals(employee, app.findById(1));
		assertNull(app.findById(2));
		assertNotNull(app.findById(1));
		assertTrue(app.findById(1)==employee);
		assertFalse(app.findById(2)==employee1);
	}
	
	@Test
	public void testupdateById()
	{
		assertEquals(employee, app.updateById(1));
		assertNotEquals(employee1, app.updateById(2));
		assertNotNull(app.updateById(1));
		assertNull(app.updateById(2));
		assertTrue(app.updateById(1).getSalary()==employee.getSalary());
		assertFalse(app.updateById(2)==employee1);
	}
}
