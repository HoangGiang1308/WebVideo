package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="videos")
@NamedQuery(name="videos.findall", query = "SELECT v from videos v")
public class videos implements Serializable{
	
	@Id
	@Column(name = "videoid")
	String videoid;
	@Column(name ="title")
	String title;
	@Column(name = "poster")
	String poster;
	@Column(name ="views")
	int views;
	@Column(name="decription")
	String decription;
	@Column(name = "active")
	boolean active;
	@OneToMany(mappedBy = "video")
	private List<favorite> favorites;
	@OneToMany(mappedBy = "video")
	private List<shares> shares;
	
	public String getVideoid() {
		return videoid;
	}
	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public boolean getActive() {
		return this.active;
	}
	public void setAcitve(boolean acitve) {
		this.active = acitve;
	}
	public List<favorite> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<favorite> favorites) {
		this.favorites = favorites;
	}
	public List<shares> getShares() {
		return shares;
	}
	public void setShares(List<shares> shares) {
		this.shares = shares;
	}
	
	
}
