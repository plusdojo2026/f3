// JavaBeans形式のデータの入れ物
package dto;

import java.io.Serializable;

public class Notice implements Serializable {
	
	private String noticeId;
	private String userId;
	private String content;
	private String cursedAlert;
	
	// 引数のあるコンストラクタ 
	/*public Notice(String noticeId, String userId, String content, String cursedAlert) {
		this.noticeId = noticeId;
		this.userId = userId;
		this.content = content;
		this.cursedAlert = cursedAlert;*/
		
	}
	// 引数のないコンストラクタ
	public Notice() {
	}
	
	public String getNoticeId(String noticeId) {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getUserId(String userId) {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent(String content) {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCursedAlert(String cursedAlert) {
		return cursedAlert;
	}
	public void setCursedAlert(String cursedAlert) {
		this.cursedAlert = cursedAlert;
	}
	

}
