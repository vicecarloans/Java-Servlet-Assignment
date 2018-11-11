/*
 * Project: Securely
 * Assignment: Assignment 1
 * Author: Huy Dam, Duc Nguyen, Allan Martinez
 * Student Number: 101085183, 101095506, 101094202
 * Date: Sunday, Oct 28th, 2018
 * Description: Register Servlet
 * */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.UserDTO;
import utils.Mailer;
import utils.EmailContent;
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
    		if(status == 0) {
    			request.setAttribute("message","Email already exists");
    			request.getRequestDispatcher("register.jsp").forward(request, response);
    		}else {
    			Mailer m = new Mailer();

    			boolean isSent = m.send(u.getEmail(),"Account Confirmation",EmailContent.getEmailContent(u.getFirstName(),u.getLastName(), u.getEmail(), u.getUUID()));
    			if(isSent) {
        			response.sendRedirect("confirmation.jsp");
    			}else {
        			request.setAttribute("message","Oops something went wrong with your email. We can't send the confirmation.");
        			request.getRequestDispatcher("register.jsp").forward(request, response);
    			}
    		}
	}

}