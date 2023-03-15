package www.mywebsite.DAO.impl;

import java.util.List;

import www.mywebsite.BEAN.History;
import www.mywebsite.DAO.HistoryDAO;
import www.mywebsite.DAO.SystemDAO;

public class HistoryDAOImpl extends SystemDAO<History> implements HistoryDAO{

	@Override
	public List<History> findHistoryByUser(String username) {
		String sql = "select o from History o where o.userId.username = ?0 and o.videoId.isActive = 1 "
				+ "  order by o.viewDate desc";
		return super.findMany(History.class, sql, username);
	}

	@Override
	public List<History> findHistoryByUserAndIsLiked(String username) {
		String sql = "select o from History o where o.userId.username = ?0   and o.isLiked = 1"
				+ "  and o.videoId.isActive = 1 "
				+ "  order by o.viewDate desc";
		return super.findMany(History.class, sql, new Object[] {username});
	}
	
	

	@Override
	public History findHistoryByUserIdAndVideoId(Long userId, Long videoId) {
		String sql = "select o from History o where o.userId.id = ?0 and o.videoId.id = ?1 and o.videoId.isActive = 1 ";
			
		return super.findOne(History.class, sql, new Object[] {userId,videoId});

	}

	@Override
	public History create(History entity) {
		return super.create(entity);
	}

	@Override
	public History update(History entity) {
		return super.update(entity);
	}

	@Override
	public History delete(History entity) {
		return super.delete(entity);
	}

}
