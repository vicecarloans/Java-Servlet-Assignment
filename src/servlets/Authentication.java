package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import models.UserDTO;

@WebServlet("/auth")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Authentication() {
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User UserManager = new User();
		UserDTO user = UserManager.getUser(email, password);
		if(user.getEmail() == null) {
			request.setAttribute("message", "Invalid username/password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			if(!user.getActivate()) {
				request.setAttribute("message", "Please activate your account via email");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user.getFirstName() + " " + user.getLastName());
				response.sendRedirect("dashboard.jsp");
			}
		}
	}


}
