package com.rest.os.dao;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnection{

	private Connection con = null;

	public DBConnection() {

	}

	public Connection getConnection()
	{
		String connectionURL = "jdbc:mysql://localhost/onlinedb";
		String userId = "root";
		String pwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(connectionURL,userId, pwd);
			if(con!= null && !con.isClosed())
			System.out.println("Successfully connected to MySQL server using TCP/IP...");
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}

		return con;
	}

}
