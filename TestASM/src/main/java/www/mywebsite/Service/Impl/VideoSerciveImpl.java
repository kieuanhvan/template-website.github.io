package www.mywebsite.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import www.mywebsite.BEAN.Video;
import www.mywebsite.DAO.VideoDAO;
import www.mywebsite.DAO.impl.VideoDAOImpl;
import www.mywebsite.Service.VideoService;

public class VideoSerciveImpl implements VideoService{

	private VideoDAO dao;
	public VideoSerciveImpl() {
		dao = new VideoDAOImpl();
	}
	@Override
	public Video findById(Long id) {

		return dao.findById(id);
	}

	@Override
	public Video findByHref(String href) {
		return dao.findByHref(href);
	}

	@Override
	public List<Video> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
	
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public Video create(Video entity) {
		entity.setPosters("https://img.youtube.com/vi/" + entity.getHref()+"/maxresdefault.jpg");
		entity.setIsActive(Boolean.TRUE);
		entity.setViews(0);
		entity.setShares(0);
		Video video = dao.findByHref(entity.getHref());
		if(video == null) {
			return dao.create(entity);
		}
		return null;
	}

	@Override
	public Video update(Video entity , String href) {
		Video video = this.findByHref(href);
		video.setTitle(entity.getTitle());
		video.setHref(entity.getHref());
		video.setDescriptions(entity.getDescriptions());
		return dao.update(video);
	}

	@Override
	public Video delete(String href) {
		Video entity = this.findByHref(href);
		if(entity != null) {
			entity.setIsActive(Boolean.FALSE);
			return dao.update(entity);
		}
		return entity;
		
	}
	@Override
	public List<Video> findTitleVideoByTitle(String tile) {
		return dao.findVideosByTitle(tile.trim());
		
	}
	@Override
	public List<String> getTitleVideos(List<Video> list){
		List<String> titles =  new ArrayList<>();
		if(list!=null) {
			list.forEach(item ->{
				titles.add(item.getTitle());
			});
			return titles; 
		}
		return null;
	}
	
}
