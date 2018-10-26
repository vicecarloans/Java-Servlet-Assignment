package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RouteValidator {
	private static Pattern authRoute = Pattern.compile("(confirmation|login|register|\\/$)+");
	private static Matcher m;
	public static boolean isAuthRoute(String route) {
		m = authRoute.matcher(route);
		return m.find();
	}
}
