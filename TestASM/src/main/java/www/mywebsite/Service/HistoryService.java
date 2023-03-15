package www.mywebsite.Service;

import java.util.List;

import www.mywebsite.BEAN.History;
import www.mywebsite.BEAN.User;
import www.mywebsite.BEAN.Video;

public interface HistoryService {
	List<History> findHistoryByUser(String username);
	
	List<History> findHistoryByUserAndIsLiked(String username);
	
	History findHistoryByUserIdAndVideoId(Long userId,Long videoId);
	
	History create(User user,Video video);
	Boolean updateLikeAndUnLike(User user,String videoHref);
}
