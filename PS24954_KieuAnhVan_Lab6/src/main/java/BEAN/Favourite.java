package BEAN;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="Favorites" , uniqueConstraints = {
		@UniqueConstraint(columnNames = {"VideoId" , "UserId"})
})
public class Favourite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne @JoinColumn(name="VideoId")
	private Video Video;
	
	@ManyToOne @JoinColumn(name="UserId")
	private User User;
	
	@Temporal(TemporalType.DATE)
	private Date LikeDate = new Date();
	
	public Favourite() {
		super();
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Video getVideo() {
		return Video;
	}
	public void setVideo(Video video) {
		Video = video;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public Date getLikeDate() {
		return LikeDate;
	}
	public void setLikeDate(Date likeDate) {
		LikeDate = likeDate;
	}
	@Override
	public String toString() {
		return "Favorite [Id=" + Id + ", Video=" + Video + ", User=" + User + ", LikeDate=" + LikeDate + "]";
	}
}
