package DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.apache.tomcat.util.descriptor.web.LoginConfig;

import BEAN.Report;
import BEAN.ReportV2;
import BEAN.User;
import BEAN.Video;
import JpaDB.JpaUtils;

public class ManagerVideoDAO implements SystemInterface <Video,Long>{
	 EntityManager em =JpaUtils.getManagerFactory();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	@Override
	public boolean insert(Video entity) {
		return false;
	}

	@Override
	public boolean update(Video entity) {
		return false;
	}

	@Override
	public boolean delete(Video entity) {
		return false;
	}


	public   List<Video> getVideosByUserId(Long id) {
		try {
			TypedQuery<Video> query = em.createNamedQuery("Video.findVideosByIdOfUser", Video.class);
			query.setParameter("id",  id);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public  List<Video> getVideosByTitle(String title) {
		try {
			TypedQuery<Video> query = em.createNamedQuery("Video.findVideosByTitle", Video.class);
			query.setParameter("key",  "%" + title +"%");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<User> getUserLikedVideoByVideoId(Long id){
		try {
			TypedQuery<User> query= em.createNamedQuery("Video.findUserLikedVideoByVideoId", User.class);
			query.setParameter("idInput", id);
			return query.getResultList();
		} catch (Exception e) {	
			return null;
		}
	}
	
	public  List<Video>getVideosIsFavourite(Boolean status){
		String jpql=status?"Select o from Video o where o.foFavorites  is not empty":"Select o from Video o where o.foFavorites  is empty";
		try {
			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Video> getVideoByDate(String min , String max){
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				TypedQuery<Video> query = em.createNamedQuery("Video.findFavouriteVideosByDate", Video.class);
				query.setParameter("minsss", dateFormat.parse(min));
				query.setParameter("maxsss", dateFormat.parse(max));
				return query.getResultList();
			} catch (Exception e) {
				return null;
			}
	}
	
	public List<Video> getFavouriteVideosByMonths(List<Integer> months){
		try {
			TypedQuery<Video> query = em.createNamedQuery("Video.findFavouriteVideosByMonths", Video.class);
			query.setParameter("months", months);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Report> groupByVideos(){
		try {
			TypedQuery<Report> query = em.createNamedQuery("Video.orderByVideos",Report.class);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	public List<ReportV2> groupByVideosByYear(Integer year){
		try {
			StoredProcedureQuery query=em.createNamedStoredProcedureQuery("Report.orderByVideosByYearProc");
			query.setParameter("f_years", year);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
}

	
	

	public List<Video> getVideosRandom(int num){
		try {
			TypedQuery<Video> query = em.createNamedQuery("Video.showAmountVideos" , Video.class);
			query.setParameter(1, num);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<Video> getAll() {
		return null;
	}

	@Override
	public Video findById(Long key) {
		return null;
	}

}
