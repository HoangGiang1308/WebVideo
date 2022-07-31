package domain;

public class LoginForm {
	private String username, password;
	private boolean remmerber;
	public String getUsername() {
		return username;
	}
	
	public LoginForm() {
	
	}

	public LoginForm(String username, String password, boolean remmerber) {
		this.username = username;
		this.password = password;
		this.remmerber = remmerber;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemmerber() {
		return remmerber;
	}
	public void setRemmerber(boolean remmerber) {
		this.remmerber = remmerber;
	}
	
}
