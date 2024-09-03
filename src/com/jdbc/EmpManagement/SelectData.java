package com.jdbc.EmpManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectData {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
			
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from EmpManagement");
			
			while(rs.next()) {
				
//				String id=rs.getString(1);
//				String name=rs.getString(2);
//				double sal=rs.getDouble(3);
//				int ex=rs.getInt(4);
				
				System.out.println("Employee ID: "+rs.getString(1));
				System.out.println("Employee Name: "+rs.getString(2));
				System.out.println("Employee Salary: "+rs.getDouble(3));
				System.out.println("Employee Experience: "+rs.getInt(4));
				System.out.println("======================================");
			}
			System.out.println("connection closed...");
			st.close();
			rs.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("Exception : "+e);
		}
	}
}
