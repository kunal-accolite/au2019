package com.accolite.au.assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BatchUpdate {
	
	public static void main(String ...strings )
	{
		Connection con=null;
		PreparedStatement ps=null;
		HashMap<Integer,String> hm2= new HashMap<Integer,String>();
			
		//inserting id and name details
		hm2.put(1,"rahul");
		hm2.put(2, "vishav");
		hm2.put(3, "vansh");
		hm2.put(4, "nitika");
		hm2.put(5, "sikha");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_assignment?useSSL=false","root","root");
			String sql="update employee set name=? where id=?";
			ps=con.prepareStatement(sql);
			for(Map.Entry m: hm2.entrySet())
			{
				String s= (String) m.getValue();
				ps.setString(1, s);
				ps.setInt(2, (int) m.getKey());
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
