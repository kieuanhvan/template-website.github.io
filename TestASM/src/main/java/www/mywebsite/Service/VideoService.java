package www.mywebsite.Service;

import java.util.List;

import www.mywebsite.BEAN.Video;

public interface VideoService {
	Video findById(Long id);
	Video findByHref(String href);
	
	List<Video> findAll();
	List<Video> findAll(int pageNumber , int pageSize);
	
	Video create(Video entity);
	Video update(Video entity , String href);
	Video delete(String href);
	List<Video> findTitleVideoByTitle(String tile);
	List<String> getTitleVideos(List<Video>list);
}
