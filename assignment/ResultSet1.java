package com.accolite.au.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSet1 {
	public static void main(String ...a) throws SQLException
	{
		Connection con=null;
		ResultSet rs=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_assignment?useSSL=false","root","root");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("select * from employee");
			rs.moveToInsertRow();                                 
			rs.updateInt(1, 6);
			rs.updateString(2, "Muskan");
			rs.updateInt(3, 28);
			rs.insertRow();
			rs.moveToCurrentRow();
			rs.moveToInsertRow();
			rs.updateInt(1, 7);                     
			rs.updateString(2, "gaurav");
			rs.updateInt(3, 24);
			rs.insertRow();
			rs.moveToCurrentRow();
			rs.absolute(1);
			//String name=rs.getString(2);
			String name="adhyati";
			rs.updateString(2, name);
			rs.updateRow();
			rs.next();
			String name1="prince";
			rs.updateString(2, name1);
			rs.updateRow();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if(con!=null)
				con.close();
			if(stmt!=null)
				stmt.close();
			if(rs!=null)
				((Connection) rs).close();
		}
		
	}

}
