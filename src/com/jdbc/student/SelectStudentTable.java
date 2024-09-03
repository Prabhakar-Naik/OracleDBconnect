package com.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectStudentTable {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from students");
			
			while(rs.next()) {
				
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String cla=rs.getString(3);
				String course=rs.getNString(4);
				
				
				System.out.println("Student ID: "+id);
				System.out.println("Student Name: "+name);
				System.out.println("Student Class: "+cla);
				System.out.println("Student Course: "+course);
				System.out.println("============================");
			}
			rs.close();
			st.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}
		
		
	}
}
