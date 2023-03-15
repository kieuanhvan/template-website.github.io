package www.mywebsite.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import www.mywebsite.DAO.StatsDAO;
import www.mywebsite.DAO.SystemDAO;
import www.mywebsite.DTO.VideoLikedInfo;

public class StatsDaoImpl extends SystemDAO<Object[]> implements StatsDAO{

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		String sql = "select v.id, v.title ,v.href ,  sum(cast(h.isLiked  as SIGNED)) as `totalLike` from history h "
				+ " inner join user u on u.id = h.userId  "
				+ "  right join video v on v.id = h.videoId  "
				+ "  where v.isActive = 1 "
				+ "  group by v.title ,v.href  "
				+ "  order by sum(cast(h.isLiked  as SIGNED)) desc;";
			List<Object[]> object = super.findManyByNativeQuery( sql);
			List<VideoLikedInfo> result  = new ArrayList<>();
			
			object.forEach(item -> {
				result.add(new VideoLikedInfo(
							Long.parseLong(String.valueOf(item[0])) , 
							String.valueOf(item[1])  , 
							String.valueOf(item[2]) , 
							Long.valueOf( item[3] == null ? String.valueOf(0): String.valueOf(item[3]) ) 
						));
			});
			
		return result;
	}

}
