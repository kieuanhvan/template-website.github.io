package www.mywebsite.Controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.mywebsite.Utils.SendEmailUtil;

@MultipartConfig
@WebServlet(urlPatterns = {"/update-your-profile"})
public class profileCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public profileCtrl() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("me run 1");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		boolean status = SendEmailUtil.uploadFile(request, response);
		if(status) {
			response.setStatus(201);
		}else {
			response.setStatus(400);
		}
	}
	

	

}
