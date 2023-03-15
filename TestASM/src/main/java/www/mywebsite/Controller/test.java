package www.mywebsite.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import www.mywebsite.BEAN.History;
import www.mywebsite.BEAN.Video;
import www.mywebsite.DAO.SystemDAO;
import www.mywebsite.Service.HistoryService;
import www.mywebsite.Service.VideoService;
import www.mywebsite.Service.Impl.HIstoryServiceImpl;
import www.mywebsite.Service.Impl.VideoSerciveImpl;
import www.mywebsite.Thead.VideosFind;

public class test {

	public static void main(String[] args) throws JsonProcessingException {
		String sql = "select o from Video o where o.title like in(?0) and o.isActive = 1 ";
		SystemDAO<Video>dao = new SystemDAO<>();
		List<Video> list = dao.findMany(Video.class, sql, new Object[] {"noi" ,"music"});
		System.out.println(list.size());
	}
	
	
}
