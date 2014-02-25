package com.rest.os.bean;

public class User {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
	public User(String fname, String lname, String email, String password) {
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.password = password;
	}
	
	public User( String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(){
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return new StringBuffer(" First Name : ").append(this.firstName)
				.append(" Last Name : ").append(this.lastName)
				.append(" Email : ").append(this.email).toString();
	}

	
}
