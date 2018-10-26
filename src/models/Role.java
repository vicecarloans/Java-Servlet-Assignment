package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import services.DBConnectionManager;

public class Role {
    static Connection con;
    static PreparedStatement ps;

    public int insertRole(String role) {
        	int status = 0;
        	try {
        	    DBConnectionManager dbmng = new DBConnectionManager();
        	    con = dbmng.connectDb();
        	    ps = con.prepareStatement("insert into \"roles\" (\"roleName\") values(?)");
        	    ps.setString(1, role);
        	    status = ps.executeUpdate();
        	    dbmng.disconnectDb();
        	} catch (Exception e) {
        	    e.printStackTrace();
        	}
        	return status;
    }

    public String getRole(int id) {
        	String roleName = null;
        	try {
        	    DBConnectionManager dbmng = new DBConnectionManager();
        	    con = dbmng.connectDb();
        	    ps = con.prepareStatement("select * from roles where id=?");
        	    ps.setInt(1, id);
        	    ResultSet rs = ps.executeQuery();
        	    while (rs.next()) {
        	    	roleName = rs.getString(2);
        	    }
        	} catch (Exception e) {
        	    e.printStackTrace();
        	}
        	return roleName;
    }

}
