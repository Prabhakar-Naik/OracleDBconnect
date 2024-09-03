package com.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertStudentTable {

	public static void main(String[] args) {
		
		try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
		
		PreparedStatement stmt=con.prepareStatement("insert into students values(?,?,?,?)");
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Enter Student ID:");
			int sid=sc.nextInt();
			System.out.println("Enter Student Name:");
			String name=sc.next();
			System.out.println("Enter Student Class:");
			String cla=sc.next();
			System.out.println("Enter Student Course:");
			String course=sc.next();
			
			
			stmt.setInt(1, sid);
			stmt.setString(2, name);
			stmt.setString(3, cla);
			stmt.setString(4, course);
			
			int count=stmt.executeUpdate();
			
			if(count>0)
				System.out.println(count+" Record inserted successfully.....");
			else
				System.out.println("Record not inserted...");
			
			System.out.println("Do you want to insert more records [yes/no]");
			String ch=sc.next();
			
			if(ch.equalsIgnoreCase("no")){
				System.out.println("You choosen break....");
				break;
			}
			
		}
		
		stmt.close();
		con.close();
		}
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}
		
		
	}
}
