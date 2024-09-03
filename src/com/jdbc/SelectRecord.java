package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRecord {

	public static void main(String[] args) {
		
		
		try {
			
//create class path
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver loaded....");
			
			//Create connection
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
			System.out.println("Database connectd....");
			
			//create statement
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from employee where eno =1");
			
			
			while(rs.next()) {
				
				int eno=rs.getInt(1);
				String ename=rs.getString(2);
				String esal=rs.getString(3);
				
				System.out.println("Employee Id: "+eno);
				System.out.println("Employee Name: "+ename);
				System.out.println("Employee Salary: "+esal);
				
				System.out.println("==============");
				
			}
		
		}
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}
	}
}
