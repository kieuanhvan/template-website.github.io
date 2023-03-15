package www.mywebsite.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.mywebsite.BEAN.User;
import www.mywebsite.Constant.SessionAttr;
@WebFilter(urlPatterns = {"/admin" , "/admin/manager-skits" , 
		
		"/admin/manager-stats/Liked-Video",
		
		 "/admin/manager-stats/Get-user-liked-video",
		 
		"/admin/get-user-video-liked-href",
	"/admin/video"})
public class AuthFiler implements MyHttpFilters {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		User user=(User) request.getSession(false).getAttribute(SessionAttr.CURRENT_USER);
		if(user == null || !user.getIsAdmin()) {
			response.sendRedirect("/TestASM/views/404Page.jsp");
			return;
		}else {
			chain.doFilter(request, response);
		}
	}

}
