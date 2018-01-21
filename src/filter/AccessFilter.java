package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccessFilter implements Filter {
	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, 
            FilterChain filterChain) throws IOException, ServletException { 
        HttpServletRequest request = (HttpServletRequest)arg0; 
        HttpServletResponse response = (HttpServletResponse)arg1; 
        HttpSession session = request.getSession(); 
       if(
    		   session.getAttribute("student")== null 
    		   &&session.getAttribute("admin")== null
    		   &&session.getAttribute("teacher")== null
    		   && request.getRequestURI().indexOf("login.jsp")==-1 ){ 
            response.sendRedirect("/graduation/login.jsp"); 
           return ; 
        } 
       System.out.println("filter has executed");
        filterChain.doFilter(arg0, arg1); 

    } 
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		config=arg0;
	}

}
