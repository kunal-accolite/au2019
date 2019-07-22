package com.accolite.au.assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BatchDelete {
	
	public static void main(String ...strings )
	{
		Connection con=null;
		PreparedStatement ps=null;
		HashMap<Integer,Integer> hm3= new HashMap<Integer,Integer>();
			
		//inserting id and age details
		hm3.put(1,22);
		hm3.put(2, 23);
		hm3.put(3, 24);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_assignment?useSSL=false","root","root");
			String sql="delete from employee where age=?";
			ps=con.prepareStatement(sql);
			for(Map.Entry m: hm3.entrySet())
			{
				ps.setInt(1, (int) m.getValue());
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
