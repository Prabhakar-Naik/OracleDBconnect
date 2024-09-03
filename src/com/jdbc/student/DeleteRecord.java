package com.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecord {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
			Statement st=con.createStatement();
			
			Scanner sc=new Scanner(System.in);
			
			while(true) {
			System.out.println("Enter Student Id: for Deletion :");
			int sid=sc.nextInt();
			
			int count=st.executeUpdate("delete from students where sid="+sid);
			
			if(count>0)
				System.out.println(count+" Record deleted successfully....");
			else
				System.out.println("No records deleted....");
			System.out.println("Do you want to delete mote records....[yes/no]");
			String ch=sc.next();
			if(ch.equalsIgnoreCase("no")) {
				System.out.println("you choosing break...");
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
