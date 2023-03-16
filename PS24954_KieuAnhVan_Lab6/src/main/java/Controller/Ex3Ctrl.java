package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Video;
import DAO.ManagerVideoDAO;

/**
 * Servlet implementation class Ex3Ctrk
 */
@WebServlet({"/Ex3Ctrl" , "/Find-favourite-video-by-date" , "/Find-favourite-video-by-month"})
public class Ex3Ctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     ManagerVideoDAO dao = new ManagerVideoDAO(); 
    public Ex3Ctrl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		if(url.contains("Ex3Ctrl")) {
			request.getRequestDispatcher("/View/Exercises3.jsp").forward(request, response);
		} else if(url.contains("Find-favourite-video-by-date")) {
			String minDate = request.getParameter("min");
			String maxDate = request.getParameter("max");
			try {
				Date min = dateFormat.parse(minDate);
				Date max = dateFormat.parse(maxDate);
				List<Video> videos = dao.getVideoByDate(dateFormat.format(min),dateFormat.format(max));
				System.out.println(videos.size());
				if(videos == null || videos.size() == 0) {
					videos = null;
					request.setAttribute("message", "Không có video trong khoảng thời gian này");
				}else {
					request.setAttribute("videos", videos);
				}
			} catch (Exception e) {
				request.setAttribute("message", "Vui lòng kiểm tra lại định dạng ngày tháng(ngày/tháng/năm)");
			}
			request.getRequestDispatcher("/View/Ex2Components/ShowVideos.jsp").forward(request, response);
		}else if(url.contains("Find-favourite-video-by-month")) {
			try {
				String[] values = request.getParameterValues("month");
				Integer[] numIntegers = Stream.of(values).map(Integer::parseInt).toArray(Integer[]::new);
			    List<Integer> targetList = Arrays.asList(numIntegers);
			    List<Video> videos = dao.getFavouriteVideosByMonths(targetList);
			    if(videos == null || videos.size() == 0) {
			    	request.setAttribute("message", "Danh sách rỗng");
			    }else {
			    	request.setAttribute("videos", videos);
			    }
			} catch (Exception e) {
				request.setAttribute("message", "Danh sách rỗng");
			}
			request.getRequestDispatcher("/View/Ex2Components/ShowVideos.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
