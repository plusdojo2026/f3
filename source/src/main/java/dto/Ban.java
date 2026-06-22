package dto;

import java.io.Serializable;

public class Ban implements Serializable {
	
	private String userId;//対象ユーザー
	private boolean ban;//BANされているかされていないか

	public Ban() {
	}
	//値をセットして生成するコンストラクタ
	public Ban(String userId, boolean ban) {
		this.userId = userId;
		this.ban = ban;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isBan() {
		return ban;
	}

	public void setBan(boolean ban) {
		this.ban = ban;
	}
}