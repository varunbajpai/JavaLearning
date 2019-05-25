package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
public class connectiontest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbc_URL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "vbajpai";
		String pswd = "abc123";
		try {
			System.out.println("Connecting to Database");
			Connection myConn = DriverManager.getConnection(jdbc_URL,user,pswd);
			System.out.println("Connection Successfull");
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}