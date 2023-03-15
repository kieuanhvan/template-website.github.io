package www.mywebsite.DAO;

import java.util.List;

import www.mywebsite.BEAN.User;
import www.mywebsite.DTO.VideoLikedInfo;

public interface StatsDAO 	{
		List<VideoLikedInfo> findVideoLikedInfo();
		
}
