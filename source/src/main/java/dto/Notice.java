// JavaBeans形式のデータの入れ物
package dto;

import java.io.Serializable;

public class Notice implements Serializable {
	
	private int noticeId;
	private String userId;
	private String content;
	private boolean cursedAlert;
	
	// 引数のあるコンストラクタ 
	public Notice(int noticeId, String userId, String content, boolean cursedAlert) {
		this.noticeId = noticeId;
		this.userId = userId;
		this.content = content;
		this.cursedAlert = cursedAlert;
	}
	
	
	// 引数のないコンストラクタ
	public Notice() {
	}
	
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean getCursedAlert() {
		return cursedAlert;
	}
	public void setCursedAlert(boolean cursedAlert) {
		this.cursedAlert = cursedAlert;
	}
	

}
