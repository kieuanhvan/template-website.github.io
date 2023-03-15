package www.mywebsite.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.mywebsite.BEAN.User;
import www.mywebsite.Constant.SessionAttr;
import www.mywebsite.Service.MailService;
import www.mywebsite.Service.UserService;
import www.mywebsite.Service.Impl.EmailServiceImpl;
import www.mywebsite.Service.Impl.UserServiceImpl;

/**
 * Servlet implementation class LoginCtrl
 */
@WebServlet(urlPatterns = { "/LoginCtrl", "/register", "/logout" ,"/dang-nhap", "/forgot-password" , "/changePassword"})
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userdao = new UserServiceImpl();
	private MailService enailDao= new EmailServiceImpl();
	public LoginCtrl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/register":
			request.setAttribute("register", true);
			request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
			break;
		case "/logout":
			request.getSession(false).removeAttribute(SessionAttr.CURRENT_USER);
			response.sendRedirect("index.php");
			break;
		case"/forgot-password":
			request.setAttribute("forgot", true);
			doGetForgotPassword(request , response);
			break;
		default:
			request.setAttribute("login", true);
			forwardLogin(request, response);
			break;
		}

	}

	private void doGetForgotPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("application/json");
		String email = request.getParameter("email");

		User user = userdao.resetPassword(email);
		if(user != null) {
			enailDao.SendGmail(getServletContext(), user 	, "forgot");
			response.setStatus(204);
		}else {
			response.setStatus(400);
		}
		request.getRequestDispatcher("/views/user/forgotPassword.jsp").forward(request, response);
		
	}

	private void forwardLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		
		switch (path) {
		case "/dang-nhap":{
			request.setAttribute("login", true);
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = userdao.login(username, password);
			if(user != null) {
				System.out.println(user.toString());
				request.getSession(true).setAttribute(SessionAttr.CURRENT_USER, user);
				if(user.getIsAdmin() == true) {
					response.sendRedirect("admin/manager-skits");
				}else {
					response.sendRedirect("index.php");
				}
				
				
			}else {
				request.setAttribute("message", "Error username or password");
				forwardLogin(request, response);
			}
		
			break;
		}
		case "/register":{
			request.setAttribute("register", true);
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			User user = userdao.create(username, password, email) ;
			if(user!= null) {
	
				enailDao.SendGmail(getServletContext(), user, "welcome");
				request.setAttribute("message", "Success");
			}else {
				request.setAttribute("message", "Error");
			}
			request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
			break;
		}
		
		case "/changePassword":{
			String currentpass = request.getParameter("currentPassword");
			String newpass = request.getParameter("newPassword");
			User user = (User) request.getSession(false).getAttribute(SessionAttr.CURRENT_USER);
				if(user != null) {
					if(currentpass.compareTo(user.getPassword()) == 0) {
						user.setPassword(newpass);
						User updatedUser = userdao.update(user);
						if(updatedUser != null) {
							request.getSession(false).setAttribute(SessionAttr.CURRENT_USER, updatedUser);
							response.setStatus(204);
						}else {
							response.setStatus(400);
						}
					}else {
						response.setStatus(400);
					}
				}else {
					response.setStatus(400);
				}
			break;
		}
		default:
			forwardLogin(request, response);
			break;
		}
		
		
	}

}
