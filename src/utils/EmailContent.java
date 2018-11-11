/*
 * Project: Securely
 * Assignment: Assignment 1
 * Author: Huy Dam, Duc Nguyen, Allan Martinez
 * Student Number: 101085183, 101095506, 101094202
 * Date: Sunday, Oct 28th, 2018
 * Description: Content of email to send
 * */
package utils;

public class EmailContent {
	public static String getEmailContent(String firstname, String lastname, String email, String id) {
		return String.format("<html>"
				+ "<body><div style=\"text-align:center;\">"
				+ "<h3>Hi %s %s, thanks for signing up with us with this email %s</h3>"
				+ "<p>Please click the link below to activate your account</p>"
				+ "<a href=\"http://localhost:8080/Java-Servlet-Assignment/activate/%s\">Here</a>"
				+ "</div>", firstname, lastname, email, id);
	}
}
