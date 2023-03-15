package www.mywebsite.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import www.mywebsite.BEAN.User;
import www.mywebsite.BEAN.Video;
import www.mywebsite.Constant.SessionAttr;
import www.mywebsite.DTO.UserDTO;
import www.mywebsite.DTO.VideoLikedInfo;
import www.mywebsite.Service.StatsService;
import www.mywebsite.Service.UserService;
import www.mywebsite.Service.VideoService;
import www.mywebsite.Service.Impl.StatsServiceImpl;
import www.mywebsite.Service.Impl.UserServiceImpl;
import www.mywebsite.Service.Impl.VideoSerciveImpl;


@WebServlet(urlPatterns = {"/admin" , "/admin/manager-skits" , 
		
		"/admin/manager-stats/Liked-Video",
		
		 "/admin/manager-stats/Get-user-liked-video",
		 
		"/admin/get-user-video-liked-href"} 

,name="HomeControllerOfAdmin")
public class homeControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StatsService daoService = new StatsServiceImpl();
	private VideoService daoVideo = new VideoSerciveImpl();
	private UserService userdao = new UserServiceImpl();
    public homeControllerAdmin() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		User user=(User) request.getSession(false).getAttribute(SessionAttr.CURRENT_USER);
		System.out.println(path);
	
		switch (path) {
		case "/admin/manager-skits":{
			List<Video> videos = daoVideo.findAll();
			request.setAttribute("videos", videos);
			request.getRequestDispatcher("/views/admin/home.jsp").forward(request, response);
			break;
		}
		case"/admin/manager-stats/Get-user-liked-video":{
			List<VideoLikedInfo> videoLikedInfos = daoService.findVideoLikedInfo();
			request.setAttribute("videoLikeds", videoLikedInfos);
			request.getRequestDispatcher("/views/admin/stast_User_By_Videos.jsp").forward(request, response);
			break;
		}
		case"/admin/manager-stats/Liked-Video":{
			List<VideoLikedInfo> videoLikedInfos = daoService.findVideoLikedInfo();
			request.setAttribute("videoLikeds", videoLikedInfos);
			request.getRequestDispatcher("/views/admin/stats_Skits.jsp").forward(request, response);
			break;
		}
		case "/admin/get-user-video-liked-href":{
			doGetUserLikedVideoByHref(request , response);
			break;
		}
		default:{
			request.getRequestDispatcher("/views/404Page.jsp").forward(request, response);
		}
			break;
		}
		
		
	}
	
	private void doGetUserLikedVideoByHref(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String href = request.getParameter("href");
		List<UserDTO> list = userdao.findUserByVideoHref(href);
		if(list != null || list.size() != 0) {
			response.setContentType("application/json;charset=UTF-8");
			ObjectMapper obj = new ObjectMapper();
			String dataString = obj.writeValueAsString(list);
			response.getWriter().write(dataString);
			response.getWriter().flush();
			response.setStatus(204);
		}else {
			response.setStatus(400);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
