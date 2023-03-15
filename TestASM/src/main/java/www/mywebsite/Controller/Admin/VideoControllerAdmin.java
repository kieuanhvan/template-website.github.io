package www.mywebsite.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import www.mywebsite.BEAN.Video;
import www.mywebsite.DTO.UserDTO;
import www.mywebsite.Service.UserService;
import www.mywebsite.Service.VideoService;
import www.mywebsite.Service.Impl.UserServiceImpl;
import www.mywebsite.Service.Impl.VideoSerciveImpl;
import www.mywebsite.Utils.GetEnityByBeanUtils;

@WebServlet(urlPatterns = { "/admin/video" })
public class VideoControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VideoService dao = new VideoSerciveImpl();

	public VideoControllerAdmin() {
		super();

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "add": {
			doGetAdd(response , request);
		}
			break;
		case "update": {
			doGetUpdate(request, response);
		}
			break;
		case "delete": {
			doGetDelete(request , response);
		}
			break;
		default:
			request.getRequestDispatcher("/views/404Page.jsp").forward(request, response);
			break;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	private void doGetUpdate(HttpServletRequest request, HttpServletResponse response) {
		Video video = GetEnityByBeanUtils.getEntity(Video.class, request);
		String currentHref = request.getParameter("currentHref");
		dao.update(video, currentHref);
		response.setStatus(204);
		
	}

	private void doGetDelete(HttpServletRequest request, HttpServletResponse response) {
		Video video = GetEnityByBeanUtils.getEntity(Video.class, request);
		Video check = dao.delete(video.getHref());
		if(check != null) {
			response.setStatus(204);
		}else {
			response.setStatus(400);
		}
	}

	private void doGetAdd(HttpServletResponse response, HttpServletRequest request) 
			throws  ServletException, IOException {
		Video video = GetEnityByBeanUtils.getEntity(Video.class, request);
		System.out.println(video.toString());
		Video check = dao.create(video);
		if(check != null) {
			List<Video> videos = dao.findAll();
//			response.setContentType("application/json;charset=UTF-8");
//			ObjectMapper obj = new ObjectMapper();
//			String dataString = obj.writeValueAsString(videos);
//			response.getWriter().write(dataString);
//			response.getWriter().flush();
//			response.setStatus(204);
			request.setAttribute("videos", videos);
		}
		request.getRequestDispatcher("/views/admin/stat_user_Table.jsp").forward(request, response);
	}

}
