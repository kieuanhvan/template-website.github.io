package www.mywebsite.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import www.mywebsite.BEAN.History;
import www.mywebsite.BEAN.User;
import www.mywebsite.BEAN.Video;
import www.mywebsite.Constant.SessionAttr;
import www.mywebsite.Service.HistoryService;
import www.mywebsite.Service.VideoService;
import www.mywebsite.Service.Impl.HIstoryServiceImpl;
import www.mywebsite.Service.Impl.VideoSerciveImpl;



@WebServlet(urlPatterns = {"/index.php" , "/history" , "/favourite" , "/get-video-pageId" ,"/findVideos" , "/edit-profile"})
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private  VideoService videoDao = new VideoSerciveImpl();
   private HistoryService historyService = new HIstoryServiceImpl();
   private static final Integer VIDEO_MAX_PAGE_SIZE = 6;
    public homeController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String path = request.getServletPath();
		request.setCharacterEncoding("utf-8");
		switch (path) {
		case "/history":
			doGetHistory(request , response);
			break;
		case "/favourite":
			doGetFavourite(response , request);
			break;
		case "/get-video-pageId":
			doGetPageProduct(request , response);
			break;
		case"/findVideos":{ // http:localhost/videos?q={value}$state={open,close}findVideos
			doGetFindVideoByTitle(request , response);
			break;
		}
		case"/edit-profile":{
			request.getRequestDispatcher("/views/user/profile.jsp").forward(request, response);
			break;
		}
		default:
			forwardHome(request, response);
			break;
		}
		
	}

	
	private void doGetFindVideoByTitle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q = request.getParameter("q");
		String state = request.getParameter("state");
		
		if(q == null || state == null) {
			String title = request.getParameter("title");
			List<Video> videos = null;
			List<Video> video2=videoDao.findAll(1, 5);
			if(title != null && title.trim().length()>0) {
				videos= videoDao.findTitleVideoByTitle(title);
			}
			request.setAttribute("videosOther", video2);
			request.setAttribute("videos", videos);
			request.setAttribute("Title", title);
			request.getRequestDispatcher("/views/user/ListVideo.jsp").forward(request, response);
		}else {
//			response.setContentType("application/json;charset=UTF-8");
//			VideosFind findVideo = new VideosFind(q);
//			Thread thread= new Thread(findVideo);
//			thread.start();
//			while(thread.isAlive()) {}
//			List<String> videoTitles = findVideo.getVideos();
			List<Video> videos = videoDao.findTitleVideoByTitle(q);
			List<String> videoTitles = videoDao.getTitleVideos(videos);
			
//			ObjectMapper obj = new ObjectMapper();
//			String dataString = obj.writeValueAsString(videoTitles);
			request.setAttribute("videosTitle", videoTitles);
//			response.getWriter().write(dataString);
			request.getRequestDispatcher("/views/user/titleVideo.jsp").forward(request, response);
		}
	
	}


	private void doGetPageProduct(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String pageId = request.getParameter("pageId");
		List<Video> videos = videoDao.findAll(Integer.valueOf(pageId), VIDEO_MAX_PAGE_SIZE);
		request.setAttribute("videos", videos);
		request.setAttribute("currentPageId", Integer.valueOf(pageId));
		request.getRequestDispatcher("/views/user/listThreeProduct.jsp").forward(request, response);
	}


	private void doGetFavourite(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		User user = (User) request.getSession(false).getAttribute(SessionAttr.CURRENT_USER);
		List<History> histories = historyService.findHistoryByUserAndIsLiked(user.getUsername());
		List<Video> videos = new ArrayList<>();
		if(histories != null) {
			histories.forEach(item -> videos.add(item.getVideoId()));
		}
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/views/user/favourite.jsp").forward(request, response);
		
	}


	private void doGetHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession(false).getAttribute(SessionAttr.CURRENT_USER);
		List<History> histories = historyService.findHistoryByUser(user.getUsername());
		List<Video> videos = new ArrayList<>();
		if(histories != null) {
			histories.forEach(item -> videos.add(item.getVideoId()));
		}
		request.setAttribute("videos", videos);
		
		request.getRequestDispatcher("/views/user/history.jsp").forward(request, response);
		
	}


	private void forwardHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Video> videos = videoDao.findAll(1, 7);
		List<Video> countVideos = videoDao.findAll();
		int maxPage = (int) Math.ceil(countVideos.size() / (double) VIDEO_MAX_PAGE_SIZE);
		
		request.setAttribute("videos", videos);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("home", true);
		request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
	}

}
