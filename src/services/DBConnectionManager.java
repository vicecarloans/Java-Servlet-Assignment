/*
 * Project: Securely
 * Assignment: Assignment 1
 * Author: Huy Dam, Duc Nguyen, Allan Martinez
 * Student Number: 101085183, 101095506, 101094202
 * Date: Sunday, Oct 28th, 2018
 * Description: Connection Manager to Database MySQL
 * */
package services;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class DBConnectionManager {
	private Connection connection;
	static Properties prop = new Properties();
	static InputStream input;
	public Connection connectDb() throws Exception {
		
		try {
			input = this.getClass().getClassLoader().getResourceAsStream ("/config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("dbUser"));
			System.out.println("********");
			String username = prop.getProperty("dbUser");
			String password = prop.getProperty("dbPassword");
			String db = prop.getProperty("db");
			// Setup the connection with the DB
			if(!username.isEmpty() && !password.isEmpty() && !db.isEmpty()) {
			      // Setup the connection with the DB
				 Class.forName("com.mysql.jdbc.Driver");
			      connection = DriverManager
				          .getConnection("jdbc:mysql://localhost:3306/"+db+"?"
				              + "user="+username+"&password="+password+"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
			      return connection;
			}
			else {
				throw new IOException("Invalid username or password");
			}
		} catch (Exception e) {
		  throw e;
		}
	}
	public void disconnectDb() {
		try {
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}