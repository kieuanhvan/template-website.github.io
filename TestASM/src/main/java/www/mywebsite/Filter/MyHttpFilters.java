package www.mywebsite.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface MyHttpFilters extends Filter {
	
	@Override
	default void destroy() {}

	@Override
	default void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest req  = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			this.doFilter(req, resp,chain);
	}
	
	void doFilter(HttpServletRequest request , HttpServletResponse response, FilterChain chain) 
			throws IOException, ServletException; 

	@Override
	default void init(FilterConfig filterConfig) throws ServletException {}
}
