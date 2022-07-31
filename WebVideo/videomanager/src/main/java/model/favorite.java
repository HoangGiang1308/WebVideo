package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="favorite")
@NamedQuery(name="favorite.findall", query = "SELECT f from favorite f")
public class favorite implements Serializable{
	
	@Id
	@Column(name = "favoriteid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int favoriteid;
	@Column(name ="likedate")
	Date likedate;
	@OneToMany(mappedBy = "video")
	@ManyToOne
	@JoinColumn(name = "username")
	users user;
	
	@ManyToOne
	@JoinColumn(name="videoid")
	videos video;


	public int getFavoriteid() {
		return favoriteid;
	}

	public void setFavoriteid(int favoriteid) {
		this.favoriteid = favoriteid;
	}

	public users getUser() {
		return user;
	}

	public void setUser(users user) {
		this.user = user;
	}

	public videos getVideo() {
		return video;
	}

	public void setVideo(videos video) {
		this.video = video;
	}

	public Date getLikedate() {
		return likedate;
	}

	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}
	
	
}
