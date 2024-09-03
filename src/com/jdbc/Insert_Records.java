package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert_Records {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			
			//create class path
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver loaded....");
			
			//Create connection
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
			System.out.println("Database connected....");
			
			//create statement
			PreparedStatement st=con.prepareStatement("insert into employee values(?,?,?)");
			
			//Reading table name
			Scanner sc=new Scanner(System.in);
			
			while(true) {
				System.out.println("Enter Emp No:");
				int id=sc.nextInt();
				System.out.println("Enter Emp Name:");
				String name=sc.next();
				System.out.println("Enter Emp Salary: ");
				String sal=sc.next();
				
				
				st.setInt(1, id);
				st.setString(2, name);
				st.setString(3, sal);
				
				int count=st.executeUpdate();
				if(count>0)
					System.out.println(count+" record inserted....");
				else
					System.out.println("no record inserted...");
				
				System.out.println("Do you want to insert more records...");
				
				String ch=sc.next();
				if(ch.equalsIgnoreCase("no"))
					break;
				
			}
			
			
		}
		catch(Exception e) {
			
			System.out.println("Exception: "+e);
		}
		finally {
			System.out.println("Connection closed... Thank you for the insertion...");
			con.close();
		}
		
	}
}
