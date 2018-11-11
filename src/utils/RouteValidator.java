/*
 * Project: Securely
 * Assignment: Assignment 1
 * Author: Huy Dam, Duc Nguyen, Allan Martinez
 * Student Number: 101085183, 101095506, 101094202
 * Date: Sunday, Oct 28th, 2018
 * Description: Validator if route is matching login, register, etc.
 * */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RouteValidator {
	private static Pattern authRoute = Pattern.compile("(auth|activate|confirmation|login|register|\\/$)+");
	private static Matcher m;
	public static boolean isAuthRoute(String route) {
		m = authRoute.matcher(route);
		return m.find();
	}
}
