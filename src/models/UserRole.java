package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import services.DBConnectionManager;

public class UserRole{
    static Connection con;
    static PreparedStatement ps;

    public int insertUserRole(int userID, int roleID) {
        	int status = 0;
        	try {
        	    DBConnectionManager dbmng = new DBConnectionManager();
        	    con = dbmng.connectDb();
        	    ps = con.prepareStatement(
        		    "insert into \"userroles\" (\"userID\",\"roleID\") values(?,?)");
        	    ps.setInt(1, userID);
        	    ps.setInt(2, roleID);
        	    status = ps.executeUpdate();
        	    dbmng.disconnectDb();
        	} catch (Exception e) {
        	    e.printStackTrace();
        	}
        	return status;
    }

    public List<UserDTO> getUsers(int roleID) {
        	List<UserDTO> userList = new ArrayList<UserDTO>();
        	try {
        	    DBConnectionManager dbmng = new DBConnectionManager();
        	    con = dbmng.connectDb();
        	    ps = con.prepareStatement("select * from userroles where roleID=?");
        	    ps.setInt(1, roleID);
        	    ResultSet rs = ps.executeQuery();
        	    while (rs.next()) {
        			int uID = rs.getInt(1);
        		User userManager = new User();
        		UserDTO user = userManager.getUserById(uID);
        		if (user != null) {
        		    userList.add(user);
        		}
        	    }
        
        	} catch (Exception e) {
        	    e.printStackTrace();
        	}
        	return userList;
    }
    
    
    
    
    
    
    

}
