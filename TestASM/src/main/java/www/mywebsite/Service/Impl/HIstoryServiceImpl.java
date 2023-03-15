package www.mywebsite.Service.Impl;

import java.sql.Timestamp;
import java.util.List;

import www.mywebsite.BEAN.History;
import www.mywebsite.BEAN.User;
import www.mywebsite.BEAN.Video;
import www.mywebsite.DAO.HistoryDAO;
import www.mywebsite.DAO.impl.HistoryDAOImpl;
import www.mywebsite.Service.HistoryService;
import www.mywebsite.Service.VideoService;

public class HIstoryServiceImpl  implements HistoryService{
	private HistoryDAO dao;
	private VideoService videoService;
	public  HIstoryServiceImpl() {
		dao = new HistoryDAOImpl();
		videoService = new VideoSerciveImpl();
	}
	@Override
	public List<History> findHistoryByUser(String username) {

		return dao.findHistoryByUser(username);
	}

	@Override
	public List<History> findHistoryByUserAndIsLiked(String username) {

		return dao.findHistoryByUserAndIsLiked(username);
	}

	@Override
	public History findHistoryByUserIdAndVideoId(Long userId, Long videoId) {
		// TODO Auto-generated method stub
		return dao.findHistoryByUserIdAndVideoId(userId, videoId);
	}

	@Override
	public History create(User user, Video video) {
		History history = dao.findHistoryByUserIdAndVideoId(user.getId(), video.getId());
		if(history == null) {
			history= new History();
			history.setUserId(user);
			history.setVideoId(video);
			history.setIsLiked(Boolean.FALSE);
			history.setViewDate(new Timestamp(System.currentTimeMillis()));
			return dao.create(history);
		}
		return history;
	}

	@Override
	public Boolean updateLikeAndUnLike(User user, String videoHref) {
		Video video = videoService.findByHref(videoHref);
		History history = dao.findHistoryByUserIdAndVideoId(user.getId(), video.getId());
		
		if(history.getIsLiked() == Boolean.FALSE) {
			history.setIsLiked(Boolean.TRUE);
			history.setLikeDate(new Timestamp(System.currentTimeMillis()));
		}else {
			history.setIsLiked(Boolean.FALSE);
			history.setLikeDate(null);
		}
		return dao.update(history) != null;
	}

}
