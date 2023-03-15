package www.mywebsite.DAO.impl;

import java.util.List;

import www.mywebsite.BEAN.Video;
import www.mywebsite.DAO.SystemDAO;
import www.mywebsite.DAO.VideoDAO;

public class VideoDAOImpl extends SystemDAO<Video> implements VideoDAO{

	@Override
	public Video findById(Long id) {
		return super.findById(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		String sql = "select o from Video o where o.href = ?0";
		return super.findOne(Video.class, sql, new Object[] {href});
	}

	@Override
	public List<Video> findAll() {
		return super.FindAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return super.FindAll(Video.class, true , pageNumber , pageSize);
	}

	@Override
	public Video create(Video entity) {
		return super.create(entity);
	}

	@Override
	public Video update(Video entity) {
		return super.update(entity);
	}

	@Override
	public Video delete(Video entity) {
		return super.delete(entity);
	}

	@Override
	public List<Video> findVideosByTitle(String tilte) {
		String sql = "select o from Video o where o.title like ?0 and o.isActive = 1 ";
		return super.findMany(Video.class, sql, "%" +tilte + "%");
	}

}
