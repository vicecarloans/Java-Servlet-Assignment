/*
 * Project: Securely
 * Assignment: Assignment 1
 * Author: Huy Dam, Duc Nguyen, Allan Martinez
 * Student Number: 101085183, 101095506, 101094202
 * Date: Sunday, Oct 28th, 2018
 * Description: DAO Interface for User
 * */
package models;

public interface UserDAO {
	public int insertUser(UserDTO u);
	public UserDTO getUser(String username, String password);
	public UserDTO getUserById(int userID);
	public boolean isEmailExist(String username);
	public int activateUser(String email);
}
