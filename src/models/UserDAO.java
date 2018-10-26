package models;

public interface UserDAO {
	public int insertUser(UserDTO u);
	public UserDTO getUser(String username, String password);
	public UserDTO getUserById(int userID);
}
