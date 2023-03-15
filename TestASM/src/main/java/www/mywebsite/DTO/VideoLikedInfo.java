package www.mywebsite.DTO;

public class VideoLikedInfo {
	
	private  Long videoId;
	
	private String title;
	
	private String href;
	
	private Long totalLike;
	
	public VideoLikedInfo() {
		super();
	}
	
	public VideoLikedInfo(Long videoId, String title, String href, Long totalLike) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.href = href;
		this.totalLike = totalLike;
	}
	
	public Long getVideoId() {
		return videoId;
	}
	
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Long getTotalLike() {
		return totalLike;
	}
	public void setTotalLike(Long totalLike) {
		this.totalLike = totalLike;
	}
	
}
