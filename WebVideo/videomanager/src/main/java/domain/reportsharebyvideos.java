package domain;

import java.util.Date;

public class reportsharebyvideos {
	private String fullname;
	private String emails;
	private String email;
	private Date shareDate;
	
	public reportsharebyvideos() {
		super();
	}
	public reportsharebyvideos(String fullname, String emails, String email, Date shareDate) {
		super();
		this.fullname = fullname;
		this.emails = emails;
		this.email = email;
		this.shareDate = shareDate;
	}
	
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
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
	public Date getShareDate() {
		return shareDate;
	}
	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}
	
}
