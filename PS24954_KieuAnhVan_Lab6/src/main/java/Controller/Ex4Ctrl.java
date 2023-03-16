package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.ReportV2;
import BEAN.Video;
import DAO.ManagerVideoDAO;

@WebServlet({"/Ex4Ctrl" , "/Show-Amount-Video", "/Show-info-favourite-video-by-year"})
public class Ex4Ctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ManagerVideoDAO dao =new ManagerVideoDAO();

    public Ex4Ctrl() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		if(url.contains("Ex4Ctrl")) {
			request.getRequestDispatcher("/View/Exercises4.jsp").forward(request, response);
		} else if(url.contains("Show-Amount-Video")) {
			try {
				int amount = Integer.parseInt(request.getParameter("amount"));
				List<Video> videos = dao.getVideosRandom(amount);
				if(videos == null || videos.size() == 0) {
					request.setAttribute("message", "Danh sách rỗng");
				}else {
					request.setAttribute("videos",videos);
				}
			} catch (Exception e) {
				request.setAttribute("message", "Lỗi định dạng số !");
			}
			request.getRequestDispatcher("/View/Ex2Components/ShowVideos.jsp").forward(request, response);
		}else if(url.contains("Show-info-favourite-video-by-year")) {
			try {
				Integer year = Integer.valueOf(request.getParameter("year"));
				List<ReportV2> reportVideos = dao.groupByVideosByYear(year);
				if(reportVideos == null || reportVideos.size() == 0) {
					request.setAttribute("message", "Không có video nào ở năm: "+year);
				}else {
					request.setAttribute("reportVideos", reportVideos);
				}
			} catch (Exception e) {
				request.setAttribute("message", "Vui lòng chọn năm nhé!");
			}
			request.getRequestDispatcher("/View/Ex2Components/reportVideos.jsp").forward(request, response);
		}
		
	}

}
