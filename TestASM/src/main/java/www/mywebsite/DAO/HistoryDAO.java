package www.mywebsite.DAO;

import java.util.List;

import www.mywebsite.BEAN.History;


public interface HistoryDAO {
	
	List<History> findHistoryByUser(String username);
	
	List<History> findHistoryByUserAndIsLiked(String username);
	
	History findHistoryByUserIdAndVideoId(Long userId,Long videoId);
	
	History create(History entity);
	History update(History entity);
	History delete(History entity);
	
}
