package com.rest.os.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rest.os.bean.*;

public class UserLoginAuthentication {
	
	
	private DBConnection dbConObj;
	Connection conn = null;
	PreparedStatement preparedStatement = null;
	
	public UserLoginAuthentication(){
		dbConObj = new DBConnection();
	}
	
	public String registerUser(User user){
		
		System.out.println("inside register user method");
		String result = null;
		conn = dbConObj.getConnection();
		//String query = "insert into onlinedb.User( fname, lname, email, password) values ('"+firstName+"','"+lastName+"','"+email+"','"+password+"')";
		String query = "insert into onlinedb.User(fname, lname, email, password) values"+"(?,?,?,?)";
		try{
		String fname = user.getFirstName();
		String lname = user.getLastName();
		preparedStatement = conn.prepareStatement(query);
		preparedStatement.setString(1, fname);
		preparedStatement.setString(2, lname);
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		
		System.out.println("Statement is" + preparedStatement);
		// execute insert SQL stetement
		int rowCount = preparedStatement.executeUpdate();
		System.out.println("count is" + rowCount);
		if(rowCount >0)
			result = "Success!"+ fname +" "+ lname +"is registered"+ "UserId is";
		else
			result = "Failure"; 
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return "Error in database connection";
		}
		finally{
			
			try {
				conn.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
		return result;
		
	}
	
	public String signInUser(User user) {
		System.out.println("inside sign in method");
		String result = null;
		conn = dbConObj.getConnection();
		String query = "select * from onlinedb.User where email=?";
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, user.getEmail());
			
			System.out.println("statement is " + preparedStatement );
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				System.out.println("there is a record");
				String pw = rs.getString("password");
				
				System.out.println(pw);
				System.out.println(user.getPassword());
				System.out.println(pw == (String)user.getPassword());

				if(pw.equals(user.getPassword()))
					result = "Sucessfully Signed in" + "Welcome back "+ rs.getString("fname") ;
				else
					result = "Failure";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "Error in database connection";
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
	
	

}
