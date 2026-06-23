package dto;

import java.io.Serializable;

public class Curse implements Serializable {

	// 呪いID
	private int curseId;

	// プロジェクトID
	private int projectId;

	// 対象ユーザーID
	private String userId;

	// 未加工画像URL
	private String rawImageUrl;

	// コンストラクタ
	public Curse() {
	}

	public Curse(int curseId,
				 int projectId,
				 String userId,
				 String rawImageUrl) {

		this.curseId = curseId;
		this.projectId = projectId;
		this.userId = userId;
		this.rawImageUrl = rawImageUrl;
	}

	public int getCurseId() {
		return curseId;
	}

	public void setCurseId(int curseId) {
		this.curseId = curseId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRawImageUrl() {
		return rawImageUrl;
	}

	public void setRawImageUrl(String rawImageUrl) {
		this.rawImageUrl = rawImageUrl;
	}
}