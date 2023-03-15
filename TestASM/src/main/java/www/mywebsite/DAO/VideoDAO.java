package www.mywebsite.DAO;

import java.util.List;

import www.mywebsite.BEAN.Video;

public interface VideoDAO {
	Video findById(Long id);
	Video findByHref(String href);
	
	
	List<Video> findAll();
	List<Video> findAll(int pageNumber , int pageSize);
	List<Video> findVideosByTitle(String tile);
	Video create(Video entity);
	Video update(Video entity);
	Video delete(Video entity);
}
