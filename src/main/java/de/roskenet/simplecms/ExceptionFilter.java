package de.roskenet.simplecms;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.stereotype.Component;
import org.springframework.web.util.NestedServletException;

@Component
@WebFilter(filterName="exceptionFilter",urlPatterns={"/page/*"})
public class ExceptionFilter implements Filter{

	@Override
	public void destroy() {
	//	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
	
		try {
	        filterChain.doFilter(request, response);
	    } catch (NestedServletException ex) {
	    	// Do a fine grained exception handling here!
	    	//	    	if(ex.getCause())
	        RequestDispatcher error = request.getRequestDispatcher("/err");
	        error.forward(request,response);
	    }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	//	
	}

}
