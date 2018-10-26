 package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import services.DBConnectionManager;
import utils.PasswordHash;
public class User implements UserDAO {
	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertUser(UserDTO u) {
		int status = 0;
		try {
			DBConnectionManager dbmng = new DBConnectionManager();
			con = dbmng.connectDb();
			ps=con.prepareStatement("insert into \"users\" (\"firstname\",\"lastname\",\"address\",\"email\",\"password\") values(?,?,?,?,?)");
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getAddress());
			ps.setString(4, u.getEmail());
			ps.setString(5, PasswordHash.getSaltedHash(u.getPassword()));
			status=ps.executeUpdate();
			dbmng.disconnectDb();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public UserDTO getUser(String email, String password) {
		UserDTO u = new UserDTO();
		try {
			DBConnectionManager dbmng = new DBConnectionManager();
			con = dbmng.connectDb();
			ps=con.prepareStatement("select * from users where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String encryptedPassword = rs.getString(5);
				if(PasswordHash.check(password, encryptedPassword)) {
					u.setFirstName(rs.getString(1));
					u.setLastName(rs.getString(2));
					u.setAddress(rs.getString(3));
					u.setEmail(rs.getString(4));
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}

}
