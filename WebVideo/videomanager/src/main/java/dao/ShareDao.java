package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domain.FavoriteUserReport;
import domain.reportsharebyvideos;
import model.shares;

public class ShareDao extends AbstractEntityDao<shares> {
	public ShareDao() {
		super(shares.class);
	}
	public List<reportsharebyvideos> reportsharebyvideos(String videoId){
		String jpql = "select new domain.reportsharebyvideos(s.user.fullname, s.user.email, s.email,s.sharedate)"
				+ "from shares s where s.video.videoid = :videoid";
		EntityManager em = JpaUtils.getEntityManager();
		
		List<reportsharebyvideos> list = null;
		try {
			TypedQuery<reportsharebyvideos> query = em.createQuery(jpql, reportsharebyvideos.class);
			query.setParameter("videoid", videoId);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
}
