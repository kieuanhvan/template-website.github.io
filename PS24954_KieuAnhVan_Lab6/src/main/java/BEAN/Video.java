package BEAN;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.StoredProcedureParameter;

@NamedQueries({
	@NamedQuery(name="Video.findVideosByIdOfUser" , query = "Select o.Video from Favourite o where o.User.Id=:id"),
	@NamedQuery(name="Video.findVideosByTitle" , query = "Select o.Video from Favourite o where o.Video.Title like :key"),
	@NamedQuery(name="Video.findUserLikedVideoByVideoId" , query = "Select o.User from Favourite o where o.Video.id =:idInput"),
	
	@NamedQuery(name="Video.orderByVideos" , query = "select new Report(o.Video.Title , count(o) , max(o.LikeDate) , min(o.LikeDate)) "
			+ " from Favourite o Group By o.Video.Title"),
	
	@NamedQuery(name="Video.findFavouriteVideosByDate" , query = "SELECT  DISTINCT o.Video FROM  Favourite o WHERE"
			+ "   o.LikeDate BETWEEN   :minsss  AND   :maxsss"),
	
	@NamedQuery(name="Video.findFavouriteVideosByMonths" , query = "select distinct o.Video from Favourite o where"
			+ " Month(o.LikeDate) in (:months)")

})

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Report.orderByVideosByYearProc" ,
			procedureName = "findVideosByYear",
			resultClasses = {ReportV2.class},
			parameters = {@StoredProcedureParameter(name="f_years" , type=Integer.class)}
			)
})




@NamedNativeQueries({
	@NamedNativeQuery(name="Video.showAmountVideos" , query="select * from Videos ORDER BY RAND() LIMIT ?",resultClass = Video.class)
})
@Entity
@Table(name = "Videos")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id; 
	private String Title;
	private String Poster; 
	private String Description; 
	private boolean Active; 
	private Integer Views;
	@OneToMany(mappedBy = "Video")
	List<Favourite> foFavorites;
	public Video() {
		super();
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	public Integer getViews() {
		return Views;
	}
	public void setViews(Integer views) {
		Views = views;
	}
	
	
	public List<Favourite> getFoFavorites() {
		return foFavorites;
	}

	public void setFoFavorites(List<Favourite> foFavorites) {
		this.foFavorites = foFavorites;
	}

	@Override
	public String toString() {
		return "Video [Id=" + Id + ", Title=" + Title + ", Poster=" + Poster + ", Description=" + Description
				+ ", Active=" + Active + ", Views=" + Views + "]";
	} 
	
	
	
}
