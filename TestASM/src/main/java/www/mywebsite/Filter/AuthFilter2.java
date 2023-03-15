package www.mywebsite.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.mywebsite.BEAN.User;
import www.mywebsite.Constant.SessionAttr;

@WebFilter(urlPatterns = {"/LoginCtrl"})
public class AuthFilter2 implements MyHttpFilters{

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			User user=(User) request.getSession(false).getAttribute(SessionAttr.CURRENT_USER);
			if(user != null ) {
				response.sendRedirect("index.php");
				return;
			}else {
				chain.doFilter(request, response);
			}
		
	}

}
