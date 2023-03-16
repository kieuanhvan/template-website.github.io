package Controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import BEAN.Report;
import BEAN.ReportV2;
import BEAN.User;
import BEAN.Video;

public class test {

	public static void main(String[] args) {
		try {
			for(ReportV2 u:getFavouritesVideoByYear(2023)) {
				System.out.println(u.toString());
			}
		} catch (Exception e) {

		}
	}
	
	
	private static List<ReportV2> getFavouritesVideoByYear(Integer year){
			try {
				EntityManager em=createEM();
				StoredProcedureQuery query=em.createNamedStoredProcedureQuery("Report.orderByVideosByYearProc");
				query.setParameter("f_years", Integer.valueOf(2023));
				return query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	
	
	private static List<Video> getVideosNum(int num){
		EntityManager em=createEM();
		TypedQuery<Video> query = em.createNamedQuery("Video.showAmountVideos" , Video.class);
		query.setParameter(1, num);
		return query.getResultList();
	}
	
	
	private static List<Video> findVideoByMonthssss(){
		EntityManager em=createEM();
		String jpql = "select distinct o.Video from Favourite o where Month(o.LikeDate) in (:months)";
		Integer[] dataIntegers = {1,2};
	    List<Integer> targetList = Arrays.asList(dataIntegers);
		try {
			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			query.setParameter("months", targetList);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	private static List<Report> groupByVideo() {
		EntityManager em=createEM();
		try {
			TypedQuery<Report> query = em.createNamedQuery("Video.orderByVideos",Report.class);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}

	}
	 
	private static List<Video>getVideoByDate(String min , String max){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		EntityManager em=createEM();
		String jpql =  "SELECT  DISTINCT o.Video FROM  Favourite o WHERE   o.LikeDate BETWEEN   :minsss  AND   :maxsss";
		try {
			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			Date date1 = new Date();
			query.setParameter("minsss", dateFormat.parse(min));
			query.setParameter("maxsss", dateFormat.parse(max));
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	private static  EntityManager createEM() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = emf.createEntityManager();
		return em;
	}
	public static List<Video>getVideosIsFavourite(Boolean status){
		EntityManager em=createEM();
		String jpql=status?"Select o from Video o where o.foFavorites  is not empty":"Select o from Video o where o.foFavorites  is empty";
		try {
			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
		
	}
	
//	private static User getUser(){
//		EntityManager em=createEM();
//		try {
//			TypedQuery<User> query= em.createNamedQuery("User.findUserById", User.class);
//			query.setParameter("idInput", 1L);
//			return query.getSingleResult();
//		} catch (Exception e) {	NoResultException
//			e.printStackTrace();
//			return null;
//		}
		
//	}
	
	private static List<User> getAllUserByIdLikedVideo(Long id){
		EntityManager em=createEM();
		try {

			TypedQuery<User> query= em.createNamedQuery("Video.findUserLikedVideoByVideoId", User.class);
			query.setParameter("idInput", id);
			List<User> list = query.getResultList();
			return list;
		} catch (Exception e) {	
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	private static List<User> getAllUser(){
		EntityManager em=createEM();
		try {
			String jpql = "Select o from User o";
			TypedQuery<User> query= em.createQuery(jpql,User.class);
			List<User> list = query.getResultList();
			return list;
		} catch (Exception e) {	
			e.printStackTrace();
			return null;
		}
		
	}
}
