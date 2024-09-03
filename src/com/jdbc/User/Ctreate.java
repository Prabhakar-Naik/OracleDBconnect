package com.jdbc.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Ctreate {
	
	public static void main(String[] args) {
		
		String dbDriver = "oracle.jdbc.driver.OracleDriver";
		String dbconn = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbuser = "prabhakar";
		String dbpwd = "prabha225";
		
		try
		{
			Class.forName(dbDriver);
		
			Connection con = DriverManager.getConnection(dbconn,dbuser,dbpwd);
			
			Statement st = con.createStatement();
			System.out.println("Enter Table Name: ");
			Scanner sc = new Scanner(System.in);
			String table=sc.next();
			
			String query="create table " +table+"(id number(10),name varchar(10))";
			
			st.executeUpdate(query);
			
			System.out.println("table created successfully");
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
