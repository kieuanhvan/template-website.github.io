package www.mywebsite.BEAN;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`video`")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String href;
	
	private String posters;
	
	private Integer views;
	
	private Integer shares;

	private String descriptions;
	
	private Boolean isActive;

	
	public Video() {
		super();
	}

	public Video(Long id, String title, String href, String posters, Integer views, Integer shares, String descriptions,
			Boolean isActive) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.posters = posters;
		this.views = views;
		this.shares = shares;
		this.descriptions = descriptions;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPosters() {
		return posters;
	}

	public void setPosters(String posters) {
		this.posters = posters;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "{id:\"" + id + "\", title:\"" + title + "\", href:\"" + href + "\", posters:\"" + posters + "\", views:\"" + views
				+ "\", shares:\"" + shares + "\", descriptions:\"" + descriptions + "\", isActive:\"" + isActive + "\"}";

	}
	
	
	
	
	
}
