package com.accolite.au.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BatchInsert {
	
	public static void main(String ...strings )
	{
		Connection con=null;
		PreparedStatement ps=null;
		HashMap<Integer,Employee> hm1= new HashMap<Integer,Employee>();
			
		//inserting id and employee details into employee table
		hm1.put(1, new Employee(1,"kunal",23));
		hm1.put(2, new Employee(2,"angad",24));
		hm1.put(3, new Employee(3,"nikhil",26));
		hm1.put(4, new Employee(4,"pranali",22));
		hm1.put(5, new Employee(5,"janhavi",21));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_assignment?useSSL=false","root","root");
			String sql="insert into employee values(?,?,?)";
			ps=con.prepareStatement(sql);
			for(Map.Entry m: hm1.entrySet())
			{
				Employee e=(Employee) m.getValue();
				ps.setInt(1, e.getId());
				ps.setString(2, e.getName());
				ps.setInt(3, e.getAge());
				ps.addBatch();
			}
			ps.executeBatch();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
