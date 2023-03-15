package www.mywebsite.BEAN;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="history")
public class History {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="userId",referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications" , "hibernateLazyInitializer"})
	private User userId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="videoId" , referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications" , "hibernateLazyInitializer"})
	private Video videoId;
	
	
	@CreationTimestamp
	private Timestamp viewDate;
	
	private Boolean isLiked;
	
	private Timestamp likeDate;

	
	public History() {
		super();
	}

	public History(Long id, User userId, Video videoId, Timestamp viewDate, Boolean isLiked, Timestamp likeDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.videoId = videoId;
		this.viewDate = viewDate;
		this.isLiked = isLiked;
		this.likeDate = likeDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Video getVideoId() {
		return videoId;
	}

	public void setVideoId(Video videoId) {
		this.videoId = videoId;
	}

	public Timestamp getViewDate() {
		return viewDate;
	}

	public void setViewDate(Timestamp viewDate) {
		this.viewDate = viewDate;
	}

	public Boolean getIsLiked() {
		return isLiked;
	}

	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}

	public Timestamp getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Timestamp likeDate) {
		this.likeDate = likeDate;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", userId=" + userId + ", videoId=" + videoId + ", viewDate=" + viewDate
				+ ", isLiked=" + isLiked + ", likeDate=" + likeDate + "]";
	}
	
	
	
}


