package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Update_Record {

	public static void main(String[] args) {
		
		String value; int eno; String esal;
try {
			
			//create class path
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver loaded....");
			
			//Create connection
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
		//	System.out.println("Database connected....");
			
			//create statement
			Statement st=con.createStatement();
			
			
			Scanner sc=new Scanner(System.in);
			
	
				System.out.println("Enter employye Id:");
				value=sc.next();
				eno=Integer.parseInt(value);
				
				System.out.println("Enter employye salary:");
				value=sc.next();
				
				esal=value;
				
				int count=st.executeUpdate("update employee set esal="+esal+" where eno = "+eno);
				if(count>0)
					System.out.println(count+" record updated....");
				else
					System.out.println("no record updated...");
			
				st.close();
				con.close();
			
		}
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}

		
		
	}
}
