package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import domain.FavoriteReport;
import domain.FavoriteUserReport;
import model.favorite;

public class FavoriteDao  extends AbstractEntityDao<favorite> {
	public FavoriteDao() {
		super(favorite.class);
	}
	public List<FavoriteUserReport> reportFavoriteUsersByVideos(String videoId){
		String jpql = "select new domain.FavoriteUserReport(f.user.username, f.user.fullname, f.user.email,f.likedate)"
				+ "from favorite f where f.video.videoid = :videoid";
		EntityManager em = JpaUtils.getEntityManager();
		
		List<FavoriteUserReport> list = null;
		try {
			TypedQuery<FavoriteUserReport> query = em.createQuery(jpql, FavoriteUserReport.class);
			query.setParameter("videoid", videoId);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
	public List<FavoriteReport> reportFavoritesByVideos(){
	String jpql = "select new domain.FavoriteReport(f.video.title, count(f), min(f.likedate), max(f.likedate))"
			+ "from favorite f group by f.video.title";
	EntityManager em = JpaUtils.getEntityManager();
	
	List<FavoriteReport> list = null;
	
	try {
		TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
		
		list = query.getResultList();
	} finally {
		em.close();
	}
	return list;
	}
	public int findByUserAndVideo(String userId, String videoId) {
		EntityManager em = JpaUtils.getEntityManager();
		Query q = em.createQuery("select DISTINCT f from Favorites f where f.user.id like :userId and f.video.id like :videoId");
		q.setParameter("userId", userId);
		q.setParameter("videoId", videoId);
		return ((favorite) q.getResultList().get(0)).getFavoriteid();
	}
}
