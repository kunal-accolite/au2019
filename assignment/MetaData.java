package com.accolite.au.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.jdbc.DatabaseMetaData;

public class MetaData {
	
	public static void main(String ...strings )
	{
		Connection con=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/WorldCup?useSSL=false","root","root");
			DatabaseMetaData dbmd=(DatabaseMetaData) con.getMetaData();
			String [] table = {"TABLE"};
			rs=dbmd.getTables(null, null, null, table);
			while(rs.next())
			{
				System.out.println(rs.getString(3));
				String name=rs.getString(3);
				String sql="select * from "+name;
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs1=ps.executeQuery();
				ResultSetMetaData rsmd=rs1.getMetaData();
				System.out.println("	Total columns in " +rs.getString(3)+":" +rsmd.getColumnCount());  
				for(int i=1;i<=rsmd.getColumnCount();i++)
				{
					System.out.println("	Column Name of "+i+"th column: "+rsmd.getColumnName(i));  
					System.out.println("	Column Type Name of "+i+"th column: "+rsmd.getColumnTypeName(i));  
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		
	


