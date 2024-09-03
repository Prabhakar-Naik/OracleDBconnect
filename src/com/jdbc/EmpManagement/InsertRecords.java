package com.jdbc.EmpManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertRecords {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
			//create statement
			PreparedStatement st=con.prepareStatement("insert into EmpManagement values(?,?,?,?)");
			
			//Reading table name
			Scanner sc=new Scanner(System.in);
			
			while(true) {
				System.out.println("Enter Emp ID:");
				String ID=sc.next();
				System.out.println("Enter Emp Name:");
				String name=sc.next();
				System.out.println("Enter Emp Salary: ");
				double sal=sc.nextDouble();
				System.out.println("Enter Emp Experience: ");
				int ex=sc.nextInt();
				
				st.setString(1, ID);
				st.setString(2, name);
				st.setDouble(3, sal);
				st.setInt(4, ex);
				
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
			System.out.println("Connection Closed.....");
			st.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println("Exception : "+e);
		}
		
	}
}
