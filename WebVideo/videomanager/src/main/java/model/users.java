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
@Table(name="users")
@NamedQuery(name="users.findall", query = "SELECT u from users u")
public class users implements Serializable{
	
	@Id
	@Column(name = "username")
	String username;
	@Column(name ="password")
	String password;
	@Column(name = "fullname")
	String fullname;
	@Column(name="email")
	String email;	
	@Column(name ="admin")
	boolean admin;
	@OneToMany(mappedBy = "user")
	private List<favorite> favorites;
	@OneToMany(mappedBy = "user")
	private List<shares> shares;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getadmin() {
		return this.admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
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
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
