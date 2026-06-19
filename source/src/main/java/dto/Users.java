package dto;

import java.io.Serializable;

public class Users  implements Serializable {
	private String userId;
	private String userName;
	private String password;
	private String email;
	private boolean ban;
	private boolean status;
	
	//引数なしコンストラクタ
	public Users() {
		
	}
	
	//ログイン用コンストラクタ
	public Users(String userId,String password) {
		this.userId = userId;
		this.password = password;
	}
	
	
	
	public Users(String userId, String userName, String password, String email, boolean ban, boolean status) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.ban = ban;
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isBan() {
		return ban;
	}
	public void setBan(boolean ban) {
		this.ban = ban;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
