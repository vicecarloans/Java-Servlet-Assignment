package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.RouteValidator;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {

    }

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        	    throws IOException, ServletException {
        	HttpServletRequest req = (HttpServletRequest) request;
        	HttpServletResponse res = (HttpServletResponse) response;
        	String uri = req.getRequestURI();
        
        	HttpSession session = req.getSession(true);
        
        	if (session.getAttribute("user") == null && !RouteValidator.isAuthRoute(uri)) {
        	    System.out.println("Redirect");
        	    res.sendRedirect("login.jsp");
        	}
        	else if(session.getAttribute("user") != null && RouteValidator.isAuthRoute(uri)){
        		res.sendRedirect("dashboard.jsp");
        	}else {
        		chain.doFilter(req, res);
        	}
        	// chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }

}
