package com.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectRecord {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
			Statement st=con.createStatement();
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter a student ID: ");
			int sid=sc.nextInt();
			ResultSet rs=st.executeQuery("select * from students where sid="+sid);
			
			
			while(rs.next()) {
				
				System.out.println("Student ID: "+rs.getInt(1));
				System.out.println("Student Name: "+rs.getString(2));
				System.out.println("Student Class: "+rs.getString(3));
				System.out.println("Student Course: "+rs.getString(4));
				System.out.println("================================");
				
			}
			st.close();
			rs.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}
		
	}
}
