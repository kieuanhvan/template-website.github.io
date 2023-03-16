package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Report;
import BEAN.User;
import BEAN.Video;
import DAO.ManagerUserDAO;
import DAO.ManagerVideoDAO;


@WebServlet({"/Ex2Ctrl" , "/VideoOfUser" , "/VideoByTitle" , "/FindUserLikedVideoByVideoId" , "/FindVideosIsLike" , "/get-report-videos"})
public class Ex2Ctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 ManagerUserDAO dao = new ManagerUserDAO();
 ManagerVideoDAO daoVideo = new ManagerVideoDAO();
    public Ex2Ctrl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		if(url.contains("Ex2Ctrl")) {
			request.getRequestDispatcher("/View/Exercises2.jsp").forward(request, response);
		}else if(url.contains("VideoOfUser")) {
				VideoOfUser(request , response);
		}else if(url.contains("VideoByTitle")) {
			String title = request.getParameter("title");
			List<Video> videos =daoVideo.getVideosByTitle(title);
			if( videos == null || videos.size() == 0 ) {
				videos = null;
			}
			request.setAttribute("videos",videos);
			request.getRequestDispatcher("/View/Ex2Components/FavouritesVideo.jsp").forward(request, response);
		} else if(url.contains("FindUserLikedVideoByVideoId")) {
			Long id = Long.valueOf(request.getParameter("id"));
			List<User> users = daoVideo.getUserLikedVideoByVideoId(id);
			if(users == null || users.size() == 0) {
				request.setAttribute("message", "Danh sách rỗng");
			}else {
				request.setAttribute("users", users);
			}
			request.getRequestDispatcher("/View/Ex2Components/UserLikedVideo.jsp").forward(request, response);
		}else if(url.contains("FindVideosIsLike")) {
			Boolean status = Boolean.valueOf(request.getParameter("status"));
			List<Video>videos = daoVideo.getVideosIsFavourite(status);
			if(videos == null || videos.size() == 0) {
				request.setAttribute("message", "Danh sách rỗng");
			}else {
				request.setAttribute("videos", videos);
			}
			request.getRequestDispatcher("/View/Ex2Components/ShowVideos.jsp").forward(request, response);
		}else if(url.contains("get-report-videos")) {
			getReportVideos(request,response);
		}

	}

	
	private void getReportVideos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Report> reportVideos = daoVideo.groupByVideos();
		if(reportVideos == null || reportVideos.size() == 0) {
			request.setAttribute("message", "Danh sách rỗng");
		}else {
			request.setAttribute("reportVideos", reportVideos);
		}
		request.getRequestDispatcher("/View/Ex2Components/reportVideos.jsp").forward(request, response);
	}


	private void VideoOfUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Long id = Long.valueOf(request.getParameter("data"));
			User user = dao.findById(id);
			if(user != null) {
				request.setAttribute("user",user);
				request.setAttribute("status",true);
				List<Video> videos = daoVideo.getVideosByUserId(id);
				if(videos != null && videos.size() != 0) {
					request.setAttribute("videos",videos);
				}else {
					request.setAttribute("message","Người này chưa thích video nào !");
				}
			}else {
				request.setAttribute("status",false);
				request.setAttribute("message","Không tồn tại user này");
			}
		} catch (NumberFormatException e) {
			request.setAttribute("message","Vui lòng nhập vào id là con số bro");
			request.setAttribute("status",false);
		}
		request.getRequestDispatcher("/View/Ex2Components/VideosOfUser.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
