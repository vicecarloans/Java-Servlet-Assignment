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
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			if(!username.isEmpty() && !password.isEmpty() && !db.isEmpty()) {
				Class.forName("com.mysql.jdbc.Driver");
			      // Setup the connection with the DB
			      connection = DriverManager
				          .getConnection("jdbc:mysql://localhost:3306/"+db+"?"
				              + "user="+username+"&password="+password);
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