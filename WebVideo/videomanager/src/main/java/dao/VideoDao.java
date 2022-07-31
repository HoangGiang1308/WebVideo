package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import model.videos;

public class VideoDao  extends AbstractEntityDao<videos> {
	public VideoDao() {
		super(videos.class);
	}
	public List<videos> findAll(String n, int firstResult, int maxResult){
		EntityManager em = JpaUtils.getEntityManager();
		Query q = em.createQuery("select o from videos o where (o.title like :n or o.id like :n)");
		q.setParameter("n", "%"+n+"%");
		q.setFirstResult(firstResult - 1);
		q.setMaxResults(maxResult);
		return q.getResultList();	
		
	}
	
	public List<videos> findByTitle(String title){
		EntityManager em = JpaUtils.getEntityManager();
		Query q = em.createQuery("select v from videos v where v.videoid like :videoid");
		q.setParameter("videoid", "%"+title+"%");
		return q.getResultList();
	}
	public List<videos> findByTitleOrId(String keyword){
    	EntityManager em = JpaUtils.getEntityManager();
    	Query query = em.createQuery("Select v from videos v where title like :keyword or videoid like :keyword ",videos.class);
    	query.setParameter("keyword","%"+ keyword + "%");
    	List<videos> list = query.getResultList();
    	return list;
    }
	public List<videos> favoriteVideo(String id, int firstResult, int maxResult){
		EntityManager em = JpaUtils.getEntityManager();
		Query q = em.createQuery("select f.video from Favorites f where f.user.id like :id");
		q.setParameter("id", id);
		q.setFirstResult(firstResult - 1);
		q.setMaxResults(maxResult);
		return q.getResultList();
	}
}
