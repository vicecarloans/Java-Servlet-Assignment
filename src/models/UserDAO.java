package models;

public interface UserDAO {
	public int insertUser(UserDTO u);
	public UserDTO getUser(String username, String password);
	public UserDTO getUserById(int userID);
	public boolean isEmailExist(String username);
	public int activateUser(String email);
}
