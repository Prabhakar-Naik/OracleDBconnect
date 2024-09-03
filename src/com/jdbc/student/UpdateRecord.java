package com.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecord {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
			Statement st=con.createStatement();
			
			Scanner sc=new Scanner(System.in);
			
			while(true) {
				
			System.out.println("Enter Student Id for Update: ");
			int id=sc.nextInt();
			
			System.out.println("Enter New Student ID: ");
			int sid=sc.nextInt();
			System.out.println("Enter New Student Name: ");
			String name=sc.next();
			System.out.println("Enter New Student Class: ");
			String cla=sc.next();
			System.out.println("Enter New Student Course: ");
			String course=sc.next();
			
			int count=st.executeUpdate("update students set sname='"+name+"' where sid="+id);
			
			if(count>0)
				System.out.println(count+" Record updated successfully...");
			else
				System.out.println("No Records updated...");
			
			
			System.out.println("Do yo want to update more records....[yes/no]");
			String ch=sc.next();
			
			if(ch.equalsIgnoreCase("no")) {
				System.out.println("you choose break...");
				break;
			}
			
			}
			
			st.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}
	}
}
