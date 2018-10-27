package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
@WebServlet({ "/Activate/*", "/activate/*" })
public class Activate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Activate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getPathInfo();
		id = id.substring(1, id.length());
		User userManager = new User();
		int status = userManager.activateUser(id);
		if(status == 0) {
			throw new IOException("Oops user already activate this account");
		}else {
			response.sendRedirect("/Java-Servlet-Assignment/login.jsp");
		}
	}

}
