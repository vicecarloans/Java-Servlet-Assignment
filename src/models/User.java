package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import services.DBConnectionManager;

public class User implements UserDAO {
    static Connection con;
    static PreparedStatement ps;

    @Override
    public int insertUser(UserDTO u) {
    	int status = 0;
    	try {
    		if(!isEmailExist(u.getEmail())) {
    			DBConnectionManager dbmng = new DBConnectionManager();
        	    con = dbmng.connectDb();
        	    ps = con.prepareStatement(
        		    "insert into users (id,firstname, lastname, address,email,password, role, activate) values(?,?,?,?,?,?,?,?)");
        	    ps.setString(1, u.getUUID());
        	    ps.setString(2, u.getFirstName());
        	    ps.setString(3, u.getLastName());
        	    ps.setString(4, u.getAddress());
        	    ps.setString(5, u.getEmail());
        	    ps.setString(6, u.getPassword());
        	    ps.setString(7, "user");
        	    ps.setBoolean(8, false);
        	    status = ps.executeUpdate();
        	    dbmng.disconnectDb();
    		}
    	} catch (Exception e) {
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
    	    ps = con.prepareStatement("select firstname, lastname, address, email, password, role, activate from users where email=?");
    	    ps.setString(1, email);
    	    ResultSet rs = ps.executeQuery();
    	    while (rs.next()) {
    	    	String dbPassword = rs.getString(5);
    			if (password.equals(dbPassword)) {
    				
	    		    u.setFirstName(rs.getString(1));
	    		    u.setLastName(rs.getString(2));
	    		    u.setAddress(rs.getString(3));
	    		    u.setEmail(rs.getString(4));
	    		    u.setActivate(rs.getBoolean(7));
    			}
    	    }
    	    dbmng.disconnectDb();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	return u;
    }
    @Override
    public boolean isEmailExist(String email) {
    	boolean isExist = false;
    	try {
    		DBConnectionManager dbmng = new DBConnectionManager();
    		con = dbmng.connectDb();
    		ps = con.prepareStatement("select * from users where email=?");
    		ps.setString(1, email);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			isExist = true;
    		}
    		dbmng.disconnectDb();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return isExist;
    }
    @Override
    public UserDTO getUserById(int userID) {

		UserDTO user = new UserDTO();
		try {
			DBConnectionManager dbmng = new DBConnectionManager();
			con = dbmng.connectDb();
			ps = con.prepareStatement("select * from users where id=?");
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setAddress(rs.getString(3));
				user.setEmail(rs.getString(4));
			}
			dbmng.disconnectDb();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int activateUser(String id) {
		int status = 0;
		try {
			DBConnectionManager dbmng = new DBConnectionManager();
			con = dbmng.connectDb();
			ps = con.prepareStatement("update users set activate=true where id=?");
			ps.setString(1, id);
			status = ps.executeUpdate();
			
			dbmng.disconnectDb();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}

