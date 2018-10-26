package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.UserDTO;

@WebServlet({ "/Register", "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		String firstName = request.getParameter("firstName");
    		String lastName = request.getParameter("lastName");
    		String address = request.getParameter("address");
    		String email = request.getParameter("email");
    		String password = request.getParameter("password");
    		UserDTO u = new UserDTO();
    		u.setFirstName(firstName);
    		u.setLastName(lastName);
    		u.setAddress(address);
    		u.setEmail(email);
    		u.setPassword(password);	
    		User userManager = new User();
    		int status = userManager.insertUser(u);
    		System.out.print(status);
    		response.sendRedirect("confirmation.jsp");
	}

}