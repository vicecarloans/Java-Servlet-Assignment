package listeners;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import models.DBConnectionManager;
@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         Connection con = (Connection) sce.getServletContext().getAttribute("DBConnection");
         try {
        	 con.close();
         }
         catch(SQLException e) {
        	 e.printStackTrace();
         }
    }


    public void contextInitialized(ServletContextEvent sce) { 
    	ServletContext ctx = sce.getServletContext();
    	
    	//initialize DB Connection
    	String dbURL = ctx.getInitParameter("dbURL");
    	String user = ctx.getInitParameter("dbUser");
    	String password = ctx.getInitParameter("dbPassword");
    	
    	try {
    		DBConnectionManager connectionManager = new DBConnectionManager(dbURL, user, password);
    		ctx.setAttribute("DBConnection", connectionManager.getConnection());
    		
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
   
	
}
