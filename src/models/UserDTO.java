/*
 * Project: Securely
 * Assignment: Assignment 1
 * Author: Huy Dam, Duc Nguyen, Allan Martinez
 * Student Number: 101085183, 101095506, 101094202
 * Date: Sunday, Oct 28th, 2018
 * Description: DTO defines object representation between server and front-end. In this case, it's USERS table
 * */
package models;
import java.util.UUID;

public class UserDTO {
	private UUID uuid = UUID.randomUUID();
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String password;
	private boolean isActivated; 
	
	public String getUUID() {
		return uuid.toString();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	public void setActivate(boolean isActive) {
		this.isActivated = isActive;
	}
	public boolean getActivate() {
		return this.isActivated;
	}


}
