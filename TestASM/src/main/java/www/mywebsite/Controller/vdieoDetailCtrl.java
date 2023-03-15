package www.mywebsite.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.mywebsite.BEAN.History;
import www.mywebsite.BEAN.User;
import www.mywebsite.BEAN.Video;
import www.mywebsite.Constant.SessionAttr;
import www.mywebsite.Service.HistoryService;
import www.mywebsite.Service.VideoService;
import www.mywebsite.Service.Impl.HIstoryServiceImpl;
import www.mywebsite.Service.Impl.VideoSerciveImpl;

@WebServlet(urlPatterns = {"/video"})
public class vdieoDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private VideoService daoService  = new VideoSerciveImpl();
     private HistoryService historyService = new HIstoryServiceImpl();
     
    public vdieoDetailCtrl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String actionParam = request.getParameter("action");
		String hrefParam = request.getParameter("id");
		
		switch (actionParam) {
		case "watch":
			doGetWatch(request , response , hrefParam);
			break;
		case "like":
			doGetLike(request , response , hrefParam);
			break;
		default:
			break;
		}
		
	}
	private void doGetWatch(HttpServletRequest request, HttpServletResponse response, String hrefParam)
			throws ServletException, IOException {
		Video video = daoService.findByHref(hrefParam);
		User currentUser = (User) request.getSession(false).getAttribute(SessionAttr.CURRENT_USER);
		if(currentUser != null) {
				History history = historyService.create(currentUser, video);
			request.setAttribute("flagLiked",  history.getIsLiked());
		}
		request.setAttribute("video", video);
		request.getRequestDispatcher("/views/user/video-detail.jsp").forward(request, response);
	}


	private void doGetLike(HttpServletRequest request, HttpServletResponse response, String hrefParam) {
		User currentUser = (User) request.getSession(false).getAttribute(SessionAttr.CURRENT_USER);
		response.setContentType("application/json");
		if(historyService.updateLikeAndUnLike(currentUser, hrefParam)) {
			response.setStatus(204);
		}else {
			response.setStatus(400);
		}
		
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
