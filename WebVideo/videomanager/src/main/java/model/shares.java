package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="shares")
@NamedQuery(name="shares.findall", query = "SELECT s from shares s")
public class shares implements Serializable{
	
	@Id
	@Column(name = "shareid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 int shareid;

	@Column(name="email")
	String email;
	@Column(name ="sharedate")
	Date sharedate;
	
	@ManyToOne
	@JoinColumn(name="username")
	 users user;
	@ManyToOne
	@JoinColumn(name="videoid")
	 videos video;
	
	public int getShareid() {
		return shareid;
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
	public void setShareid(int shareid) {
		this.shareid = shareid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getSharedate() {
		return sharedate;
	}
	public void setSharedate(Date sharedate) {
		this.sharedate = sharedate;
	}
	
	
}
