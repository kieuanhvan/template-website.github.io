package www.mywebsite.Service.Impl;

import java.util.List;

import www.mywebsite.DAO.StatsDAO;
import www.mywebsite.DAO.impl.StatsDaoImpl;
import www.mywebsite.DTO.VideoLikedInfo;
import www.mywebsite.Service.StatsService;

public class StatsServiceImpl implements StatsService{

	private StatsDAO dao;
	
	public StatsServiceImpl() {
		dao = new StatsDaoImpl();
	}
	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		return dao.findVideoLikedInfo();
	}

}
