package com.jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable {

	public static void main(String[] args)throws FileNotFoundException {

		try {

			// create class path

			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Driver loaded....");

			// Create connection

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "prabhakar","prabha225");

			System.out.println("Database connectd....");

			// create statement
			Statement st = con.createStatement();

			// Reading table name
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Table name: ");
			String tname = sc.next();

			// write query
			String query = "create table " + tname + " (ACCOUNTNUMBER number(12),HOLDERNAME varchar2(25),BALANCE varchar2(8))";

			// execute query
			st.executeUpdate(query);

			// connection close
			st.close();
			con.close();

		} catch (Exception e) {
			// when exception occurs....
			System.out.println(e);
			//message(e);
		}

		
	}
	
	static void message(Exception e) {
		System.out.println("please check your connection");
	}

}