package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Delete_Record {

	public static void main(String[] args) {
		
try {
			
			//create class path
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//System.out.println("Driver loaded....");
			
			//Create connection
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
			//System.out.println("Database connected....");
			
			//create statement
			Statement st=con.createStatement();
			
			//Reading table name
			Scanner sc=new Scanner(System.in);
			
			while(true) {
				System.out.println("Enter emp No for deletion:");
				int eid=sc.nextInt();
				
	
				
				int count=st.executeUpdate("delete from employee where eno="+eid);
				if(count>0)
					System.out.println(count+" record deleted....");
				else
					System.out.println("no record deleted...");
				
				System.out.println("Do you want to delete more records...[yes/no]");
				
				String ch=sc.next();
				if(ch.equalsIgnoreCase("no")) {
					System.out.println("you choosing exit");
					break;
				}
				
				
			}
			
			
		}
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}

		
		
	}
}
