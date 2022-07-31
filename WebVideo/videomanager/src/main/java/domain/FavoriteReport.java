package domain;

import java.util.Date;

public class FavoriteReport {
	private String videoTitle;
	private long FavoriteCount;
	private Date newestdate;
	private Date oldestdate;
	
	public FavoriteReport() {
		
	}
	public FavoriteReport(String videoTitle, long favoriteCount, Date newestdate, Date oldestdate) {
		
		this.videoTitle = videoTitle;
		FavoriteCount = favoriteCount;
		this.newestdate = newestdate;
		this.oldestdate = oldestdate;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public long getFavoriteCount() {
		return FavoriteCount;
	}
	public void setFavoriteCount(long favoriteCount) {
		FavoriteCount = favoriteCount;
	}
	public Date getNewestdate() {
		return newestdate;
	}
	public void setNewestdate(Date newestdate) {
		this.newestdate = newestdate;
	}
	public Date getOldestdate() {
		return oldestdate;
	}
	public void setOldestdate(Date oldestdate) {
		this.oldestdate = oldestdate;
	}
	
}
