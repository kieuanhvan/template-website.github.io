package www.mywebsite.Thead;

import java.util.List;


import www.mywebsite.Service.VideoService;
import www.mywebsite.Service.Impl.VideoSerciveImpl;

public class VideosFind implements Runnable{
	private List<String> Titlevideos;
	private String title;
	private VideoService dao;
	public VideosFind(String title) {
		dao = new VideoSerciveImpl();
		this.title = title;
	}

	public List<String> getVideos() {
		return Titlevideos;
	}

	@Override
	public void run() {
//		Titlevideos = dao.findTitleVideoByTitle(this.title);
		System.out.println(Thread.currentThread() + " finish");
	}

}
