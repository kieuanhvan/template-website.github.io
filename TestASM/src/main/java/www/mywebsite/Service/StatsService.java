package www.mywebsite.Service;

import java.util.List;

import www.mywebsite.DTO.VideoLikedInfo;

public interface StatsService {
	List<VideoLikedInfo> findVideoLikedInfo();
}
