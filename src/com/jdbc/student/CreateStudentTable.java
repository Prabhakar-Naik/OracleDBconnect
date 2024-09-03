package com.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateStudentTable {

	public static void main(String[] args) throws SQLException {
		
		
		Connection con =null;
		
		try 
		{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prabhakar","prabha225");
		
		Statement st=con.createStatement();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter table name: ");
		String tname=sc.next();
		
		
		int count=st.executeUpdate("create table "+tname+" (SID number(10) primary key, SNAME varchar2(20), SCLASS varchar2(20),SCOURSE varchar2(15))");
		//st.executeUpdate("create table "+tname+" (AccNo number(10), AccName varchar2(20), Account varchar2(20),AccBalance number(15))");
		
		
			System.out.println(tname+" Successfully created...");
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			con.close();
		}
	}
}
