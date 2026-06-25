package dto;

import java.time.LocalDateTime;

public class Reportlist {
	private int projectId;
	private String userId;
	private int relayId;
	private String reason;
    private String imageUrl;
    private String voiceUrl;
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
	public int getRelayId() {
		return relayId;
	}
	public void setRelayId(int relayId) {
		this.relayId = relayId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getVoiceUrl() {
		return voiceUrl;
	}
	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public LocalDateTime getReportTime() {
		return reportTime;
	}
	public void setReportTime(LocalDateTime reportTime) {
		this.reportTime = reportTime;
	}
	private String caption;
    private LocalDateTime reportTime;
	

}
