package com.jdbc.EmpManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
			
			Statement st=con.createStatement();
			
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Table Name: ");
			String tname=sc.next();
			st.executeUpdate("create table "+tname+"(EmpID varchar2(20) primary key,EmpName varchar2(35),EmpSal number(20),Experience number(30))");
			System.out.println(tname+ " Table created successfully....");
			st.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}
		
	}
}
